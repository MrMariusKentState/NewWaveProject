package com.MariusPaulikas.Servlet.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.Servlet.Models.Song;



@Repository
public interface SongRepository extends CrudRepository<Song, Long>{
	
	List<Song> findAll();

}
