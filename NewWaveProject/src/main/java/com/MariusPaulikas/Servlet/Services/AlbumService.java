package com.MariusPaulikas.Servlet.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.MariusPaulikas.Servlet.Models.Album;
import com.MariusPaulikas.Servlet.Repositories.AlbumRepository;

@Service
public class AlbumService {
	
	private final AlbumRepository albumrepository;
	
	public AlbumService(AlbumRepository albumrepository) {
		this.albumrepository = albumrepository;
	}
	
	public List<Album> allAlbums() {
		return albumrepository.findAll();
	}
	
	
//	public Album getOneAlbum (Long id) {
//		return albumrepository.findById(id);
//	}
//	
	
	public Album findAlbums (Long id) {
		Optional<Album> onealbum = albumrepository.findById(id);
			if(onealbum.isPresent()) {
				return onealbum.get();
			}
			else {
				return null;
			}
	}

}
