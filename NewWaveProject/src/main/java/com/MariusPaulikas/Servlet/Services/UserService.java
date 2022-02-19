package com.MariusPaulikas.Servlet.Services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.MariusPaulikas.Servlet.Models.Song;
import com.MariusPaulikas.Servlet.Models.User;
import com.MariusPaulikas.Servlet.Repositories.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userrepository;
	
	public UserService(UserRepository userrepository) {
		this.userrepository = userrepository;
	}
	
	public List<User> allUsers() {
		return userrepository.findAll();
	}
	
	public User createUser (User u) {
		return userrepository.save(u);
	}

	
	public User findUsers(Long id) {
		Optional<User> optionalUsers = userrepository.findById(id);
		if(optionalUsers.isPresent()) {
			return optionalUsers.get();
		} else {
			return null;
		}
		
	}
	
	
	 public User registerUser(User user) {
	        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
	        user.setPassword(hashed);
	        return userrepository.save(user);
	    }
	
	 
	 public User updateUser(Long id, String email, String firstname, String lastname, String password) {
	 	User user = this.findUserById(id);
	 	String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setEmail(email);
	 	user.setFirstname(firstname);
	 	user.setLastname(lastname);
	 	user.setPassword(hashed);
	 	return userrepository.save(user);
	 	
	 }

	 

	public User findByEmail(String email) {
	        return userrepository.findByEmail(email);
	    }
	 
	
	 public User findUserById(Long id) {
	    	Optional<User> u = userrepository.findById(id);
	    	
	    	if(u.isPresent()) {
	            return u.get();
	    	} else {
	    	    return null;
	    	}
	    }
	
	 public boolean authenticateUser(String email, String password) {
	        // first find the user by email
	        User user = userrepository.findByEmail(email);
	        // if we can't find it by email, return false
	        if(user == null) {
	            return false;
	        } else {
	            // if the passwords match, return true, else, return false
	            if(BCrypt.checkpw(password, user.getPassword())) {
	                return true;
	            } else {
	                return false;
	            }
	        }
	    }
	 
	 

	 

	 public User AddSong (User u, Song s) {
		 List<Song> mysongs = u.getSongs();
		 mysongs.add(s);
		 return userrepository.save(u);
	 }
	
	 
	 public User RemoveSong (User u, Song s) {
		 List<Song> mysongs = u.getSongs();
		 mysongs.remove(s);
		 return userrepository.save(u);
	 }
	
	 
	 
	
}
