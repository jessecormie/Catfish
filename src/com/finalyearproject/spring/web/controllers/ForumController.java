package com.finalyearproject.spring.web.controllers;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalyearproject.spring.web.dao.FormValidationGroup;
import com.finalyearproject.spring.web.entity.Comment;
import com.finalyearproject.spring.web.entity.Forum;
import com.finalyearproject.spring.web.entity.Rating;
import com.finalyearproject.spring.web.entity.User;
import com.finalyearproject.spring.web.service.ForumService;
import com.finalyearproject.spring.web.service.UserService;

@Controller
public class ForumController {

	private ForumService forumService;
	private UserService userService;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@RequestMapping(value = "/addForumLike/{forumId}")
	public String addForumLike(@PathVariable int forumId, Model model, Principal principal)
			throws UnsupportedEncodingException {

		User user = userService.getUser(principal.getName());
		Forum forum = forumService.getOneForum(forumId);
		Rating rating = new Rating();
		List<User> usersLiked = new ArrayList<User>();
		try {
			rating = forum.getRating();
			usersLiked = rating.getUserRatings();
		} catch (Exception e) {
			// TODO: handle exception

		}
		boolean alreadyLiked = false;
		try {

			for (User u : usersLiked) {
				if (u.getUsername().equals(user.getUsername())) {
					alreadyLiked = true;
				}
			}

		} catch (Exception e) {

		}
		if (!alreadyLiked) {
			forum.setCount(forum.getCount() + 1);
			usersLiked.add(user);
			rating.setUserRatings(usersLiked);
			forum.setRating(rating);
			forumService.saveOrUpdate(forum);
		}

		List<Comment> listOfComments = forum.getComments();
		Collections.reverse(listOfComments);
		forum.setComments(listOfComments);
		List<Forum> forumList = new ArrayList<Forum>();
		forumList.add(forum);
		for (Forum f : forumList) {
			try {
				byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
				String base64Encoded;
				base64Encoded = new String(encodeBase64, "UTF-8");

				f.getUser().setEncodedImage(base64Encoded);
			} catch (Exception e) {

			}
		}

		model.addAttribute("forumList", forumList);

		return "singleforum";
	}

	@RequestMapping(value = "/addForumUnlike/{forumId}")
	public String addForumUnlike(@PathVariable int forumId, Model model, Principal principal)
			throws UnsupportedEncodingException {

		User user = userService.getUser(principal.getName());
		Forum forum = forumService.getOneForum(forumId);
		Rating rating = new Rating();
		List<User> usersLiked = new ArrayList<User>();
		try {
			rating = forum.getRating();
			System.out.println("rating " + rating.toString());
			usersLiked = rating.getUserRatings();
			System.out.println("usersliked: " + usersLiked);
		} catch (Exception e) {
			// TODO: handle exception
		}
		boolean alreadyLiked = false;
		try {

			for (User u : usersLiked) {
				System.out.println(u.toString());
				if (u.getUsername().equals(user.getUsername())) {
					System.out.println("in the if " + user.getUsername());
					alreadyLiked = true;
				}
			}

		} catch (Exception e) {

		}
		if (!alreadyLiked) {
			forum.setCount(forum.getCount() - 1);
			System.out.println(forum.getCount() + " count");
			usersLiked.add(user);
			rating.setUserRatings(usersLiked);
			forum.setRating(rating);
			forumService.saveOrUpdate(forum);
		}

		List<Comment> listOfComments = forum.getComments();
		Collections.reverse(listOfComments);
		forum.setComments(listOfComments);
		List<Forum> forumList = new ArrayList<Forum>();
		forumList.add(forum);
		for (Forum f : forumList) {
			try {
				byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
				String base64Encoded;
				base64Encoded = new String(encodeBase64, "UTF-8");

				f.getUser().setEncodedImage(base64Encoded);
			} catch (Exception e) {

			}
		}

		model.addAttribute("forumList", forumList);

		return "singleforum";
	}

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String showTest(Model model, @RequestParam("id") String id) { // HttpSession
																			// session

		return "home";
	}

	@RequestMapping("/forum")
	public String showForum(Model model) throws UnsupportedEncodingException { // HttpSession
																				// session
		List<Forum> forum = forumService.getCurrent();
		for (Forum f : forum) {
			try {
				byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
				String base64Encoded;
				base64Encoded = new String(encodeBase64, "UTF-8");

				f.getUser().setEncodedImage(base64Encoded);
			} catch (Exception e) {

			}
		}

		// puts in order of date
		Collections.reverse(forum);
		model.addAttribute("forum", forum);

		return "forum";
	}

	@RequestMapping("/forum/{id}")
	public String showSingleForum(Model model, @PathVariable int id) throws UnsupportedEncodingException { // HttpSession
																											// session
		Forum forum = forumService.getOneForum(id);
		List<Comment> listOfComments = forum.getComments();
		Collections.reverse(listOfComments);
		forum.setComments(listOfComments);
		List<Forum> forumList = new ArrayList<Forum>();
		forumList.add(forum);
		for (Forum f : forumList) {
			try {
				byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
				String base64Encoded;
				base64Encoded = new String(encodeBase64, "UTF-8");

				f.getUser().setEncodedImage(base64Encoded);
			} catch (Exception e) {

			}
		}

		model.addAttribute("forumList", forumList);
		return "singleforum";
	}

	@RequestMapping("/createforum")
	public String createForum(Model model, Principal principal) { // HttpSession
																	// session

		model.addAttribute("forum", new Forum());

		return "createforum";
	}

	@RequestMapping(value = "/docreate", method = RequestMethod.POST)
	public String doCreate(Model model, @Validated(value = FormValidationGroup.class) Forum forum, BindingResult result,
			Principal principal) throws UnsupportedEncodingException {

		if (result.hasErrors()) {
			return "createforum";
		}

		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		String currentdate = dateFormat.format(date);
		List<Comment> comments = new ArrayList<>();
		Rating rating = new Rating();
		User user = userService.getUser(principal.getName()); // gets current
																// users
																// username

		Forum forum2 = new Forum(forum.getForumTitle(), forum.getForumContent(), currentdate, user, comments, rating);

		System.out.println(user.toString());

		try {
			forum.getUser().getImage();
			byte[] encodeBase64 = Base64.encode(forum.getUser().getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");
			model.addAttribute("userImage", base64Encoded);
		} catch (Exception e) {
			System.out.println(e);
		}

		forumService.create(forum2);

		List<Forum> forum3 = forumService.getCurrent();
		for (Forum f : forum3) {
			try{
			byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			f.getUser().setEncodedImage(base64Encoded);
			}catch(Exception e){
				
			}
		}

		// puts in order of date
		Collections.reverse(forum3);
		model.addAttribute("forum", forum3);

		return "forum";
	}

	@RequestMapping(value = "/likes")
	public String arrangeByLikes(Model model, Principal principal) throws UnsupportedEncodingException {

		List<Forum> forum = forumService.getCurrent();
		for (Forum f : forum) {
			try {
				byte[] encodeBase64 = Base64.encode(f.getUser().getImage());
				String base64Encoded;
				base64Encoded = new String(encodeBase64, "UTF-8");

				f.getUser().setEncodedImage(base64Encoded);
			} catch (Exception e) {

			}
		}
		
		

		// puts in order of date
		Collections.sort(forum);
		model.addAttribute("forum", forum);

		return "forum";
	}

}
