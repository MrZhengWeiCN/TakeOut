package edu.zhwei.comment.service;

import java.util.List;

import edu.zhwei.comment.common.BookResult;
import edu.zhwei.comment.pojo.Comment;

public interface CommentService {

	List<Comment> findAll(Integer menuId, Integer userId);

	BookResult add(Comment comment);
	
	BookResult edit(Comment comment);
	
	BookResult delete(Integer commentId);

	BookResult delete(Integer commentId, Integer userId);
}
