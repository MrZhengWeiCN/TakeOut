package edu.zhwei.comment.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.zhwei.comment.common.BookResult;
import edu.zhwei.comment.mapper.CommentMapper;
import edu.zhwei.comment.pojo.Comment;
import edu.zhwei.comment.pojo.CommentExample;
import edu.zhwei.comment.pojo.CommentExample.Criteria;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;
	
	//查询，这里需要用到redis了
	@Override
	public List<Comment> findAll(Integer menuId, Integer userId) {
		//menuId不为空&&userId=null表示是菜单的评论
		//反过来就是表示个人的评论
		//如果都为空就是管理员查询所有的评论
		//如果都不为空？还不存在这种情况
		CommentExample example = new CommentExample();
		Criteria criteria = example.createCriteria();
		if(menuId!=null&&userId==null)
			criteria.andMenuIdEqualTo(menuId);
		else if(menuId==null&&userId!=null)
			criteria.andUserIdEqualTo(userId);
		List<Comment> comments = commentMapper.selectByExampleWithBLOBs(example );
		return comments;
	}

	//增，清空有影响的redis内容
	@Override
	public BookResult add(Comment comment) {
		//只需要补充评论时间即可,父id默认为0
		comment.setCommentDate(new Date());
		comment.setCommentParentid(0);
		try {
			commentMapper.insert(comment);
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
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "编辑失败！");
		}
	}

	//删除，清空有影响的redis内容
	@Override
	public BookResult delete(Integer commentId) {
		try {
			commentMapper.deleteByPrimaryKey(commentId);
			return BookResult.ok();
		} catch (Exception e) {
			return BookResult.build(400, "删除失败！");
		}
	}
	
	
}
