package com.MariusPaulikas.Servlet.Repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.MariusPaulikas.Servlet.Models.Album;


@Repository
public interface AlbumRepository extends CrudRepository<Album, Long>{
	
	List<Album> findAll();

}
