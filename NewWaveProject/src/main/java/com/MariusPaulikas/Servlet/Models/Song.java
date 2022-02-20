package com.MariusPaulikas.Servlet.Models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="song_title")

public class Song {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	private String song_title;
	
	private String a;
	
	private String chart_notes;
	
	private String song_albumname;
	


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="song_album_id")
	private Album album;
	
	@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(
		name = "songs_users",
		joinColumns = @JoinColumn(name = "song_title_song_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private List<User> users;
	
	
	
	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

		

	public void setSong_title(String song_title) {
		this.song_title = song_title;
	}

	public void setChart_notes(String chart_notes) {
		this.chart_notes = chart_notes;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSong_title() {
		return song_title;
	}

	
	public String getChart_notes() {
		return chart_notes;
	}


	public String getSong_albumname() {
		return song_albumname;
	}

	public void setSong_albumname(String song_albumname) {
		this.song_albumname = song_albumname;
	}

	
	
	
}
