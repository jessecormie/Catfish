package com.finalyearproject.spring.web.controllers;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalyearproject.spring.web.entity.Comment;
import com.finalyearproject.spring.web.entity.Forum;
import com.finalyearproject.spring.web.entity.Rating;
import com.finalyearproject.spring.web.entity.Reply;
import com.finalyearproject.spring.web.entity.User;
import com.finalyearproject.spring.web.service.CommentService;
import com.finalyearproject.spring.web.service.ForumService;
import com.finalyearproject.spring.web.service.UserService;

@Controller
public class CommentController {

	private ForumService forumService;
	private UserService userService;
	private CommentService commentService;

	@Autowired
	public void setCommentService(CommentService commentService) {
		this.commentService = commentService;
	}

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@RequestMapping(value = "/docreateComment/{id}", method = RequestMethod.POST)
	public String doCreate(@PathVariable int id, Model model, Principal principal,
			@PathParam(value = "comment") String comment) throws UnsupportedEncodingException {

		Forum forum = forumService.getOneForum(id);
		User user = userService.getUser(principal.getName());
		List<Reply> replies = new ArrayList<>();

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String currentdate = dateFormat.format(date);
		Rating rating = new Rating();
		Comment commentObj = new Comment(comment, currentdate, 0, replies, rating, user);

		List<Comment> listOfComments = forum.getComments();
		listOfComments.add(commentObj);
		Collections.reverse(listOfComments);
		forum.setComments(listOfComments);

		forumService.saveOrUpdate(forum);

		List<Forum> forumList = new ArrayList<Forum>();
		forumList.add(forum);
		
		for (Forum f : forumList) {

			try{
			byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			f.getUser().setEncodedImage(base64Encoded);
			}catch(Exception e){
				
			}
		}

	
		model.addAttribute("forumList", forumList);
		return "singleforum";
	}

	@RequestMapping(value = "/addLike/{commentId}/{forumId}")
	public String addLike(@PathVariable int commentId, @PathVariable int forumId, Model model, Principal principal)
			throws UnsupportedEncodingException {

		User user = userService.getUser(principal.getName());
		Comment comment = commentService.getComment(commentId);
		Rating rating = new Rating();
		List<User> usersLiked = new ArrayList<User>();
		try {
			rating = comment.getRating();
			System.out.println("rating "+rating.toString());
			usersLiked= rating.getUserRatings();
			System.out.println("usersliked: "+ usersLiked);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean alreadyLiked = false;
		try {
			
			for(User u:usersLiked){
				System.out.println(u.toString());
				if(u.getUsername().equals(user.getUsername())){
					System.out.println("in the if "+user.getUsername());
					alreadyLiked=true;
				}
			}
			
		} catch (Exception e) {
			
		}
		if (!alreadyLiked) {
			comment.setCount(comment.getCount() + 1);
			System.out.println(comment.getCount()+" count");
			usersLiked.add(user);
			rating.setUserRatings(usersLiked);
			comment.setRating(rating);
			commentService.update(comment);
		}

		Forum forum = forumService.getOneForum(forumId);
		List<Comment> listOfComments = forum.getComments();
		Collections.reverse(listOfComments);
		forum.setComments(listOfComments);	
		List<Forum> forumList = new ArrayList<Forum>();
		forumList.add(forum);
		for (Forum f : forumList) {
			try{
			byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			f.getUser().setEncodedImage(base64Encoded);
			}catch(Exception e){
				
			}
		}

		model.addAttribute("forumList", forumList);

		return "singleforum";
	}

	@RequestMapping(value = "/addUnlike/{commentId}/{forumId}")
	public String addUnlike(@PathVariable int commentId, @PathVariable int forumId, Model model, Principal principal)
			throws UnsupportedEncodingException {

		User user = userService.getUser(principal.getName());
		Comment comment = commentService.getComment(commentId);
		Rating rating = new Rating();
		List<User> usersLiked = new ArrayList<User>();
		try {
			rating = comment.getRating();
			System.out.println("rating "+rating.toString());
			usersLiked= rating.getUserRatings();
			System.out.println("usersliked: "+ usersLiked);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean alreadyLiked = false;
		try {
			
			for(User u:usersLiked){
				System.out.println(u.toString());
				if(u.getUsername().equals(user.getUsername())){
					System.out.println("in the if "+user.getUsername());
					alreadyLiked=true;
				}
			}
			
		} catch (Exception e) {
			
		}
		if (!alreadyLiked) {
			comment.setCount(comment.getCount() - 1);
			System.out.println(comment.getCount()+" count");
			usersLiked.add(user);
			rating.setUserRatings(usersLiked);
			comment.setRating(rating);
			commentService.update(comment);
		}

		Forum forum = forumService.getOneForum(forumId);
		List<Forum> forumList = new ArrayList<Forum>();
		List<Comment> listOfComments = forum.getComments();
		Collections.reverse(listOfComments);
		forum.setComments(listOfComments);	
		forumList.add(forum);
		for (Forum f : forumList) {
			try{
			byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			f.getUser().setEncodedImage(base64Encoded);
			}catch(Exception e){
				
			}
		}

		model.addAttribute("forumList", forumList);

		return "singleforum";
	}
	
	@RequestMapping(value = "/likes/{forumId}")
	public String arrangeByLikes(@PathVariable int forumId, Model model, Principal principal) throws UnsupportedEncodingException{
		Forum forum = forumService.getOneForum(forumId);
		List<Comment> comments = forum.getComments();
		Collections.sort(comments);
		forum.setComments(comments);
		
		List<Forum> forumList = new ArrayList<Forum>();
		forumList.add(forum);
		
		for (Forum f : forumList) {
			try{
			byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			f.getUser().setEncodedImage(base64Encoded);
			}catch(Exception e){
				
			}
		}
		model.addAttribute("forumList", forumList);
		
		return "singleforum";
	}

}