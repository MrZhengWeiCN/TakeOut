package edu.zhwei.service;

import java.util.List;

import edu.zhwei.common.BookResult;
import edu.zhwei.pojo.Comment;

public interface CommentService {

	BookResult makeComment(Comment comment);
	
	List<Comment> findComments(Integer menuId,Integer userId);

	BookResult delComment(Integer commentId, Integer userId);

	BookResult manDelComment(Integer commentId);
}
