package com.savelichev.music.model;

public class Song {

	private int songId;

	private String songTitle;

	private int artistId;

	public Song() {

	}

	public Song(int songId, String songTitle, int artistId) {
		super();
		this.songId = songId;
		this.songTitle = songTitle;
		this.artistId = artistId;
	}

	public int getSongId() {
		return songId;
	}

	public void setSongId(int songId) {
		this.songId = songId;
	}

	public String getSongTitle() {
		return songTitle;
	}

	public void setSongTitle(String songTitle) {
		this.songTitle = songTitle;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

}
