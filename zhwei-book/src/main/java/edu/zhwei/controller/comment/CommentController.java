package edu.zhwei.controller.comment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.zhwei.common.BookResult;
import edu.zhwei.common.PageOpt;
import edu.zhwei.pojo.Comment;
import edu.zhwei.pojo.User;
import edu.zhwei.service.CommentService;

@Controller
public class CommentController {

	@Autowired
	private CommentService commentService;

	@RequestMapping("/makeComment")
	@ResponseBody
	public BookResult makeComment(Comment comment) {
		BookResult result = commentService.makeComment(comment);
		return result;
	}

	@RequestMapping("/page/{page}")
	public String back(@PathVariable String page) {
		return "comment/" + page;
	}

	@RequestMapping("/delComment")
	@ResponseBody
	public BookResult delComment(Integer menuId, Integer userId) {
		BookResult result = commentService.delComment(menuId, userId);
		return result;
	}

	@RequestMapping("/manDelComment")
	@ResponseBody
	public BookResult manDelComment(Integer commentId) {
		BookResult result = commentService.manDelComment(commentId);
		return result;
	}

	@RequestMapping("/manCommentPageEnter")
	public String manComment(Model model, Integer userId, Integer menuId,
			@RequestParam(value = "page", defaultValue = "1") Integer page) {
		
		List<Comment> comments = commentService.findComments(menuId, userId);

		int endPage = PageOpt.pageRecord(comments, 10);
		comments = PageOpt.pageList(comments, page, 10);

		model.addAttribute("endPage", endPage);
		model.addAttribute("startPage", 1);
		model.addAttribute("currPage", page);
		model.addAttribute("comments", comments);
		return "manager/man_comment";
	}
}
