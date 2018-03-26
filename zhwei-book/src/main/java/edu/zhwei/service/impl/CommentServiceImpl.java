package edu.zhwei.service.impl;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.HttpClientUtil;
import edu.zhwei.common.JsonUtils;
import edu.zhwei.pojo.Comment;
import edu.zhwei.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	// 发表评论
	@Override
	public BookResult makeComment(Comment comment) {
		comment.setCommentDate(new Date());
		String commentJson = JsonUtils.objectToJson(comment);
		/* commentJson = URLEncoder.encode(commentJson, "utf-8"); */
		String doPostResult = HttpClientUtil.doPostJson(
				"http://localhost:8082/makeComment", commentJson);
		BookResult result = JsonUtils
				.jsonToPojo(doPostResult, BookResult.class);
		return result;
	}

	// 查找评论
	@Override
	public List<Comment> findComments(Integer menuId, Integer userId) {
		Map<String, String> param = new HashMap<String, String>();
		if (menuId != null)
			param.put("menuId", menuId.toString());
		if (userId != null)
			param.put("userId", userId.toString());
		String commentsJson = HttpClientUtil.doGet(
				"http://localhost:8082/find", param);
		List<Comment> comments = JsonUtils.jsonToList(commentsJson,
				Comment.class);
		return comments;
	}

	// 删除评论
	@Override
	public BookResult delComment(Integer menuId, Integer userId) {
		Map<String, String> param = new HashMap<>();
		param.put("menuId", menuId.toString());
		param.put("userId", userId.toString());
		String resultJson = HttpClientUtil.doPost(
				"http://localhost:8082/delComment", param);
		BookResult result = JsonUtils.jsonToPojo(resultJson, BookResult.class);
		return result;
	}

	@Override
	public BookResult manDelComment(Integer commentId) {
		Map<String, String> param = new HashMap<>();
		param.put("commentId", commentId.toString());
		String resultJson = HttpClientUtil.doPost(
				"http://localhost:8082/manDelComment", param);
		BookResult result = JsonUtils.jsonToPojo(resultJson, BookResult.class);
		return result;
	}
}
