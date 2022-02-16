package com.MariusPaulikas.Servlet.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="album_name")

public class Album {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String album_name;
	
	private String US_chart;
	
	private String UK_chart;
	
	private String year_released;
	
	
	
	@OneToMany(mappedBy="album", fetch = FetchType.LAZY)
	private List<Song> songs;

	public List<Song> getSongs() {
		return songs;
	}

	public void setSongs(List<Song> songs) {
		this.songs = songs;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlbum_name() {
		return album_name;
	}

	

	public String getUS_chart() {
		return US_chart;
	}

	

	public String getUK_chart() {
		return UK_chart;
	}

	

	public String getYear_released() {
		return year_released;
	}

	
	
	
}
