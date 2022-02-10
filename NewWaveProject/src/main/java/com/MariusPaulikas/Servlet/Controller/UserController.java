package com.MariusPaulikas.Servlet.Controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.MariusPaulikas.Servlet.Models.User;
import com.MariusPaulikas.Servlet.Services.UserService;
import com.MariusPaulikas.Servlet.Validator.UserValidator;


@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired
	private final UserValidator uservalidator;
	

	public UserController (UserService userservice, UserValidator uservalidator) {
		this.userservice = userservice;
		this.uservalidator = uservalidator;
	}
	
	
	
	@RequestMapping("/police45")
	public String HomePage(@ModelAttribute("newuser") User user )  {
		return "LoginRegister.jsp";
	}
	
	
	@RequestMapping("/returnpolice45")
	public String ReturnHome() {
		return "redirect:/police45";
	}
	
	
	
	@RequestMapping("/police45/biography")
	public String Biography() {
		return "bio.jsp";
	}
	
	
	@RequestMapping(value="/registration/submit", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("newuser") User user, BindingResult result, HttpSession session) {
		 uservalidator.validate(user, result);
		 if(result.hasErrors()) {
			 return "LoginRegister.jsp";
		 }
		 
		 else {
			 User newuser = userservice.registerUser(user);
			 session.setAttribute("userId", newuser.getId());
			 return "redirect:/police45/playlist";
			 
		 }
		 
	 }
	
	
	@RequestMapping (value="/login", method=RequestMethod.POST) 
	public String loginUser (@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session, RedirectAttributes redirectattributes) {
		 if(userservice.authenticateUser(email, password)) {
			User client = userservice.findByEmail(email);
			session.setAttribute("userId", client.getId());
			return "redirect:/police45/playlist";
		 }
		 
		 else {
			 redirectattributes.addFlashAttribute("error", "Your email or password is not correct. Please try again.");
			 return "redirect:/police45";
		 }
	    
	 }
	
	
	@RequestMapping ("/police45/playlist")
	public String playlistPage()  {
		return "playlist.jsp";
	}
	
	
	
}
