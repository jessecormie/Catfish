package com.finalyearproject.spring.web.controllers;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.finalyearproject.spring.web.entity.Comment;
import com.finalyearproject.spring.web.entity.Forum;
import com.finalyearproject.spring.web.entity.User;
import com.finalyearproject.spring.web.service.CommentService;
import com.finalyearproject.spring.web.service.ForumService;
import com.finalyearproject.spring.web.service.UserService;

@Controller
public class AdminController {

	private ForumService forumService;
	private CommentService commentService;
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Autowired
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}
	
	@RequestMapping("/admin")
	public String showAdmin(Model model) {

		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);

		return "admin";
	}

	@RequestMapping(value = "/disableUser/{username}")
	public String disableUser(@PathVariable String username, Model model) {

		User user = userService.getUser(username + ".com");
		System.out.println("test " + username);
		System.out.println("test2 " + user.toString());
		System.out.println("testing: " + user.getGender() + user.getFirstName());

		user.setEnabled(false);
		System.out.println("testing2: " + user.isEnabled());
		userService.updateUser(user);
		
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "admin";

	}

	@RequestMapping(value = "/enableUser/{username}")
	public String enableUser(@PathVariable String username, Model model) {

		User user = userService.getUser(username + ".com");
		System.out.println("test " + username);
		System.out.println("test2 " + user.toString());
		System.out.println("testing: " + user.getGender() + user.getFirstName());

		user.setEnabled(true);
		System.out.println("testing2: " + user.isEnabled());
		userService.updateUser(user);
		
		List<User> users = userService.getAllUsers();
		model.addAttribute("users", users);
		
		return "admin";

	}
	
	@RequestMapping(value = "/deleteComment/{commentId}/{forumId}")
	public String doCreate(@PathVariable int commentId, @PathVariable int forumId, Model model, Principal principal)
			throws UnsupportedEncodingException {

		// forumService.removeComment(commentId);
		Comment commentObj = commentService.getComment(commentId);
		commentService.delete(commentObj);

		Forum forum = forumService.getOneForum(forumId);
		List<Forum> forumList = new ArrayList<Forum>();
		forumList.add(forum);

		for (Forum f : forumList) {
			try{
			byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			f.getUser().setEncodedImage(base64Encoded);
			}
			catch(Exception e){
				
			}
		}

		model.addAttribute("forumList", forumList);
		return "singleforum";

	}

}
