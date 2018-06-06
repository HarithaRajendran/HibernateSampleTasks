package com.asahi.thrillio.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.asahi.thrillio.entity.User;
import com.asahi.thrillio.service.UserService;

@Controller
@Scope("session")
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/success")
	public String afterRegister(@ModelAttribute("theUser") User theUser) {
	
		userService.createUser(theUser);
		
		return "register-success";
	}

	@GetMapping("/register")
	public String registerPage(Model model) {
		User user = new User();
		
		model.addAttribute("theUser",user);
		return "register";
	}

	@GetMapping("/login")
	public String showLoginPage(Model model) {

		User user = new User();

		model.addAttribute("theUser", user);

		return "login";
	}

	@PostMapping("/home")
	public String confirm(@ModelAttribute("theUser") User theUser, HttpServletRequest request) {
		
		User theCurrentUser = userService.getUser(theUser.getEmail(),theUser.getPassword());
	
		
		if(theCurrentUser == null) {
			
			return "login";
		}else {
			
			request.getSession().setAttribute("sessionUser",theCurrentUser);
			
			return "Home";
		}
		
		
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();  
		
		return "redirect:/login";
	}

}
