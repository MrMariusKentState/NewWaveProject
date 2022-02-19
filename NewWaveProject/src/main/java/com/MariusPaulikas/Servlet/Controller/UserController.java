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
	
//Below I have two routes where it was my intention to create a page where a user can modify his/her registration information.
//While I was successful in the modification aspect, the validators were not correctly connecting in the modification process.
//This would result in the program crashing, rather than successfully rendering the error messages if the input criteria for each field were not met.
//This may be an aspect of the project I may go back and work on again at a later time.
	
//	@RequestMapping("/police45/edit/{id}")
//	public String editIdeaPage(@PathVariable("id") Long id, @ModelAttribute("edituser") User user, HttpSession session, Model model) {
//		if (session.getAttribute("userId") == null) {
//			return "redirect:/police45";
//		}
//		
//		Long userid = (Long)session.getAttribute("userId");
//		User u = userservice.findUserById(userid);
//		model.addAttribute("user", u);
//		return "UserEdit.jsp";
//	}
	
	
	
//	@RequestMapping(value = "/police45/update/{id}", method=RequestMethod.POST)
//	public String UpdateUser(@Valid @ModelAttribute("edituser") User user, @PathVariable("id") Long id, BindingResult result, HttpSession session,  RedirectAttributes redirectattributes) {	
//		
//		
//		
//		if (session.getAttribute("userId") == null) {
//			return "redirect:/police45";
//		}
//		
//		
//		uservalidator.validate(user, result);	
//		if(result.hasErrors()) {
//			 return "UserEdit.jsp";
//		}
//		
//		
//		else {
//		userservice.updateUser(id, user.getEmail(), user.getFirstname(), user.getLastname(), user.getPassword());
//		
//		redirectattributes.addFlashAttribute("success", "Your registration info has been successfully updated!");
//		return "redirect:/police45/edit/{id}";
//		}
//	
//	}
//	
	
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
		
		List<Song> allsongs = listener.getSongs();
		model.addAttribute("allsongs", allsongs);
		
		return "playlist.jsp";
	}
	
	

	@RequestMapping ("/police45/albums")
	public String Albums (HttpSession session, Model model) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/police45";
		}
		
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
		model.addAttribute("person", user);
		
		List<Album> allalbums = albumservice.allAlbums();
		model.addAttribute("allalbums", allalbums);
		
		return "albums.jsp";
		
	}
	
	
	@RequestMapping ("/police45/albums/{id}")
	public String Songlist (@PathVariable("id") Long id, HttpSession session, Model model) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/police45";
		}
		
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
	
	
	@RequestMapping("/song/like/{album_id}/{song_id}")
	public String LikeSong (@PathVariable("album_id") Long albumid, @PathVariable("song_id") Long songid, HttpSession session, RedirectAttributes redirectattributes) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/police45";
		}
		
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
				
		userservice.AddSong(user, songservice.findSongs(songid));
		Song song = songservice.findSongs(songid);
		
		String title = song.getSong_title();
		
		redirectattributes.addFlashAttribute("success", "'" + title + "' has been added to your playlist!");
		
		return "redirect:/police45/albums/{album_id}";
		
	}

	
	
	
	@RequestMapping("/song/unlike/{album_id}/{song_id}")
	public String UnlikeSong (@PathVariable("album_id") Long albumid, @PathVariable("song_id") Long songid, HttpSession session, RedirectAttributes redirectattributes) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/police45";
		}
		
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
		
		userservice.RemoveSong(user, songservice.findSongs(songid));

		Song song = songservice.findSongs(songid);
		String title = song.getSong_title();
		redirectattributes.addFlashAttribute("remove", "'" + title + "' has been removed from your playlist.");
		
		return "redirect:/police45/albums/{album_id}";
		
	}
	
	
	@RequestMapping("/song/unlike/{song_id}")
	public String RemoveSong (@PathVariable("song_id") Long songid, HttpSession session) {
		
		if (session.getAttribute("userId") == null) {
			return "redirect:/police45";
		}
		
		Long l = (Long)session.getAttribute("userId");
		User user = userservice.findUserById(l);
		
		userservice.RemoveSong(user, songservice.findSongs(songid));

		return "redirect:/police45/playlist";
	
		
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/police45";
	}
	
	
	
}
