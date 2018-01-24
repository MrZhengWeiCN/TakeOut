package edu.zhwei.comment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.comment.common.BookResult;
import edu.zhwei.comment.common.JsonUtils;
import edu.zhwei.comment.component.JedisClient;
import edu.zhwei.comment.mapper.CommentMapper;
import edu.zhwei.comment.pojo.Comment;
import edu.zhwei.comment.pojo.CommentExample;
import edu.zhwei.comment.pojo.CommentExample.Criteria;

/**
 * redis中关于评论：某一个菜单的评论，和所有评论。
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>github: </p>
 * @date 2018-1-24 下午7:23:45
 * @author Zhwei
 */
@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private JedisClient jedisClient;
	
	
	//查询，这里需要用到redis了
	@Override
	public List<Comment> findAll(Integer menuId, Integer userId) {
		//menuId不为空&&userId=null表示是菜单的评论
		//反过来就是表示个人的评论
		//如果都为空就是管理员查询所有的评论
		//如果都不为空？还不存在这种情况
		if(menuId!=null&&userId==null)
			return findByMenuId(menuId);
		else if(menuId==null&&userId!=null)
			return findByUserId(userId);
		//都是空的
		//这里没必要做缓存，因为所有的评论实时性比较高，经常改变
		CommentExample example = new CommentExample();
		List<Comment> comments = commentMapper.selectByExampleWithBLOBs(example );
		return comments;
	}
	
	
	//这里也不用加缓存，因为没人看
	private List<Comment> findByUserId(Integer userId) {
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(userId);
		List<Comment> comments = commentMapper.selectByExampleWithBLOBs(example);
		return comments;
	}



	private List<Comment> findByMenuId(Integer menuId) {
		String commentsJson = jedisClient.get("MenuComment:id="+menuId);
		List<Comment> comments;
		if(commentsJson!=null){
			comments = JsonUtils.jsonToList(commentsJson, Comment.class);
			return comments;
		}else {
			CommentExample example = new CommentExample();
			Criteria criteria = example.createCriteria();
			criteria.andMenuIdEqualTo(menuId);
			comments = commentMapper.selectByExampleWithBLOBs(example );
			commentsJson = JsonUtils.objectToJson(comments);
			jedisClient.set("MenuComment:id="+menuId, commentsJson);
		}
		return comments;
	}



	//增，清空有影响的redis内容
	@Override
	public BookResult add(Comment comment) {
		//只需要补充,父id默认为0
		comment.setCommentParentid(0);
		//不能重复发表评论
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserIdEqualTo(comment.getUserId());
		criteria.andMenuIdEqualTo(comment.getMenuId());
		List<Comment> comments = commentMapper.selectByExampleWithBLOBs(example);
		if(comments!=null&&comments.size()>0)
			return BookResult.build(400, "请勿重复评论！");
		try {
			commentMapper.insert(comment);
			jedisClient.del("MenuComment:id="+comment.getMenuId());
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "评论发表失败！");
		}
	}

	//改，清空有影响的redis内容
	@Override
	public BookResult edit(Comment comment) {
		//重新设置时间
		try {
			comment.setCommentDate(new Date());
			commentMapper.updateByPrimaryKeyWithBLOBs(comment);
			jedisClient.del("MenuComment:id="+comment.getMenuId());
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "编辑失败！");
		}
	}

	//删除，清空有影响的redis内容
	@Override
	public BookResult delete(Integer commentId) {
		try {
			Comment comment = commentMapper.selectByPrimaryKey(commentId);
			commentMapper.deleteByPrimaryKey(commentId);
			jedisClient.del("MenuComment:id="+comment.getMenuId());
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "删除失败！");
		}
	}

	//用户在菜单上看到自己删除的
	@Override
	public BookResult delete(Integer menuId, Integer userId) {
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		criteria.andMenuIdEqualTo(menuId);
		criteria.andUserIdEqualTo(userId);
		try {
			commentMapper.deleteByExample(example);
			jedisClient.del("MenuComment:id="+menuId);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "删除失败！");
		}
	}
	
}
