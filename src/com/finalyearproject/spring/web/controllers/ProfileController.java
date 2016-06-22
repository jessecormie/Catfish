package com.finalyearproject.spring.web.controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.finalyearproject.spring.web.entity.Forum;
import com.finalyearproject.spring.web.entity.User;
import com.finalyearproject.spring.web.service.ForumService;
import com.finalyearproject.spring.web.service.UserService;

@Controller
public class ProfileController {

	private UserService userService;
	private ForumService forumService;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Autowired
	public void setForumService(ForumService forumService) {
		this.forumService = forumService;
	}

	@RequestMapping("/profile")
	public String createForum(Model model, Principal principal) throws UnsupportedEncodingException {

		User user = userService.getUser(principal.getName());

		try {
			byte[] encodeBase64 = Base64.encode(user.getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			user.setEncodedImage(base64Encoded);
		} catch (Exception e) {

		}
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);
		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/updateProfilePic", headers = "content-type=multipart/*")
	public String updateProfilePic(Model model, Principal principal,
			@RequestParam(value = "image", required = false) MultipartFile file) throws UnsupportedEncodingException { // HttpSession

		System.out.println("Here");
		System.out.println("File name: " + file.getName());
		User user = userService.getUser(principal.getName());

		try {
			File tmpFile = new File(System.getProperty("java.io.tmpdir") + System.getProperty("file.separator")
					+ file.getOriginalFilename());
			System.out.println("File: " + tmpFile);
			file.transferTo(tmpFile);
			byte[] byteFile = new byte[(int) tmpFile.length()];
			FileInputStream fs = new FileInputStream(tmpFile);
			fs.read(byteFile);
			fs.close();

			BufferedImage theImage = ImageIO.read(new ByteArrayInputStream(byteFile));
			System.out.println("Buffered Image: " + theImage);
			user.setImage(byteFile);
		} catch (IllegalStateException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);

		userService.updateUser(user);

		byte[] encodeBase64 = Base64.encode(user.getImage());
		String base64Encoded;
		base64Encoded = new String(encodeBase64, "UTF-8");

		user.setEncodedImage(base64Encoded);

		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/updateFirstName")
	public String updateFirstName(Model model, Principal principal, @RequestParam(value = "firstName") String firstName)
			throws UnsupportedEncodingException { // HttpSession

		User user = userService.getUser(principal.getName());
		user.setFirstName(firstName);
		userService.updateUser(user);
		try {
			byte[] encodeBase64 = Base64.encode(user.getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			user.setEncodedImage(base64Encoded);
		} catch (Exception e) {

		}
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);
		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/updateLastName")
	public String updateLastName(Model model, Principal principal, @RequestParam(value = "lastName") String lastName)
			throws UnsupportedEncodingException { // HttpSession

		User user = userService.getUser(principal.getName());
		user.setLastName(lastName);
		userService.updateUser(user);
		try {
			byte[] encodeBase64 = Base64.encode(user.getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			user.setEncodedImage(base64Encoded);
		} catch (Exception e) {

		}
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);
		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/updateDob")
	public String updateDob(Model model, Principal principal, @RequestParam(value = "dateOfBirth") String dateOfBirth)
			throws UnsupportedEncodingException { // HttpSession

		User user = userService.getUser(principal.getName());
		user.setDateOfBirth(dateOfBirth);
		userService.updateUser(user);

		try {
			byte[] encodeBase64 = Base64.encode(user.getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			user.setEncodedImage(base64Encoded);
		} catch (Exception e) {

		}
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);
		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/updateGender")
	public String updateGender(Model model, Principal principal, @RequestParam(value = "gender") String gender)
			throws UnsupportedEncodingException { // HttpSession

		User user = userService.getUser(principal.getName());
		user.setGender(gender);
		userService.updateUser(user);
		try {
			byte[] encodeBase64 = Base64.encode(user.getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			user.setEncodedImage(base64Encoded);
		} catch (Exception e) {

		}
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);
		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/updateAbout")
	public String updateAbout(Model model, Principal principal, @RequestParam(value = "about") String about)
			throws UnsupportedEncodingException { // HttpSession

		User user = userService.getUser(principal.getName());
		user.setAbout(about);
		userService.updateUser(user);
		try {
			byte[] encodeBase64 = Base64.encode(user.getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			user.setEncodedImage(base64Encoded);
		} catch (Exception e) {

		}
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);
		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/updatePassword")
	public String updatePassword(Model model, Principal principal, @RequestParam(value = "password") String password)
			throws UnsupportedEncodingException { // HttpSession

		User user = userService.getUser(principal.getName());
		user.setPassword(passwordEncoder.encode(password));
		userService.updateUser(user);
		try {
			byte[] encodeBase64 = Base64.encode(user.getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			user.setEncodedImage(base64Encoded);
		} catch (Exception e) {

		}
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);
		model.addAttribute("user", user);

		return "profile";
	}

	@RequestMapping(value = "/userprofile/{username}")
	public String userProfile(Model model, Principal principal, @PathVariable String username)
			throws UnsupportedEncodingException { // HttpSession

		User user = userService.getUser(username + ".com");
		System.out.println(username);
		System.out.println(user.toString());

		try {
			byte[] encodeBase64 = Base64.encode(user.getImage());
			String base64Encoded;
			base64Encoded = new String(encodeBase64, "UTF-8");

			user.setEncodedImage(base64Encoded);
		} catch (Exception e) {

		}
		
		List<Forum> usersForums = new ArrayList<Forum>();
		try {
			List<Forum> forums = forumService.getCurrent();

			for (Forum forum : forums) {
				if (forum.getUser().equals(user)) {
					usersForums.add(forum);
				}
			}
		} catch (Exception e) {

		}

		model.addAttribute("forum", usersForums);
		model.addAttribute("user", user);
	
		return "userprofile";
	}

}
