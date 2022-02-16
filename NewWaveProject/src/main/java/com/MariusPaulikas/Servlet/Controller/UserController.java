package com.MariusPaulikas.Servlet.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.MariusPaulikas.Servlet.Models.Album;
import com.MariusPaulikas.Servlet.Models.Song;
import com.MariusPaulikas.Servlet.Models.User;
import com.MariusPaulikas.Servlet.Services.AlbumService;
import com.MariusPaulikas.Servlet.Services.SongService;
import com.MariusPaulikas.Servlet.Services.UserService;
import com.MariusPaulikas.Servlet.Validator.UserValidator;


@Controller
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired 
	private SongService songservice;
	
	@Autowired
	private final AlbumService albumservice;
	
	@Autowired
	private final UserValidator uservalidator;
	

	public UserController (UserService userservice, SongService songservice, AlbumService albumservice, UserValidator uservalidator) {
		this.userservice = userservice;
		this.songservice = songservice;
		this.albumservice = albumservice;
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
	

	@RequestMapping("/police45/edit/{id}")
	public String editIdeaPage(@PathVariable("id") Long id, @ModelAttribute("edituser") User user, HttpSession session, Model model) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/police45";
		}
		
		Long userid = (Long)session.getAttribute("userId");
		User u = userservice.findUserById(userid);
		model.addAttribute("user", u);
		return "UserEdit.jsp";
	}
	
	
	
	@RequestMapping(value = "/police45/update/{id}", method=RequestMethod.POST)
	public String UpdateUser(@Valid @ModelAttribute("edituser") User user, @PathVariable("id") Long id, BindingResult result, HttpSession session,  RedirectAttributes redirectattributes) {	
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/police45";
		}
		
		
		uservalidator.validate(user, result);	
		if(result.hasErrors()) {
			 return "UserEdit.jsp";
		}
		
		
		else {
		userservice.updateUser(id, user.getEmail(), user.getFirstname(), user.getLastname(), user.getPassword());
		
		redirectattributes.addFlashAttribute("success", "Your registration info has been successfully updated!");
		return "redirect:/police45/edit/{id}";
		}
	
	}
	
	
	@RequestMapping (value="/login", method=RequestMethod.POST) 
	public String loginUser (@RequestParam("email") String email, @RequestParam("password") String password, HttpSession session, Model model, RedirectAttributes redirectattributes) {
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
	public String playlistPage(HttpSession session, Model model)  {
		if (session.getAttribute("userId") == null) {
			return "redirect:/police45";
		}
	
		Long l = (Long)session.getAttribute("userId");
		User listener = userservice.findUserById(l);
		model.addAttribute("person", listener);
		
		return "playlist.jsp";
	}
	
	

	@RequestMapping ("/police45/albums")
	public String Albums (HttpSession session, Model model) {
		
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
		model.addAttribute("person", user);
		
		List<Album> allalbums = albumservice.allAlbums();
		model.addAttribute("allalbums", allalbums);
		
		return "albums.jsp";
		
	}
	
	
	@RequestMapping ("/police45/albums/{id}")
	public String Songlist (@PathVariable("id") Long id, HttpSession session, Model model) {
		
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
		model.addAttribute("person", user);
		
		Album album = albumservice.findAlbums(id);
		model.addAttribute("album",album);
		
		List<Song> mysongs = album.getSongs();
		model.addAttribute("mysongs", mysongs);
		
		return "albumsongs.jsp";
	}
	
	

	@RequestMapping("{chart_notes}")
	public String spotify(@PathVariable("chart_notes") String chart_notes){
		return (chart_notes);
	}
	
	
	@RequestMapping("/song/unlike/{id}")
	public String UnlikeSong (@PathVariable("id") Long id, HttpSession session) {
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
		
		Song song = songservice.findSongs(id);
		userservice.AddSong(song, user);
		return "redirect:/police45/albums/{id}";
		
	}
	
	@RequestMapping("/song/like/{id}")
	public String LikeSong (@PathVariable("id") Long id, HttpSession session) {
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
		
		Song song = songservice.findSongs(id);
		userservice.RemoveSong(song, user);
		return "redirect:/police45/albums/{id}";
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/police45";
	}
	
	
	
}
