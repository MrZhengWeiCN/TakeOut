package edu.zhwei.comment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.comment.pojo.Comment;
import edu.zhwei.comment.service.CommentService;

@Controller
public class CommentController {
	
	@Autowired
	private CommentService commentService;

	@RequestMapping("/find")
	@ResponseBody
	public List<Comment> all(Integer menuId,Integer userId){
		List<Comment> comments = commentService.findAll(menuId,userId);
		return comments;
	}
}
