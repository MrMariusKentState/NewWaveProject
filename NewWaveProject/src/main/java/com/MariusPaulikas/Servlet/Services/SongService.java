package com.MariusPaulikas.Servlet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.Servlet.Models.Song;
import com.MariusPaulikas.Servlet.Models.User;
import com.MariusPaulikas.Servlet.Repositories.SongRepository;


@Service
public class SongService {
	
	private final SongRepository songrepository;
	
	public SongService(SongRepository songrepository) {
		this.songrepository = songrepository;
	}
	
	public List<Song> allSongs () {
		return songrepository.findAll();
	}
	
	
	public Song findSongs (Long id) {
		Optional<Song> onesong = songrepository.findById(id);
		if(onesong.isPresent()) {
			return onesong.get();
		}
		else {
			return null;
		}
	}
	
	
	
	

}
