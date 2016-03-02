package com.savelichev.music.model;

public class Artist {

	private int artistId;

	private String artistName;

	private String artistRole;

	private int bandId;

	public Artist() {

	}

	public Artist(int artistId, String artistName, String artistRole, int bandId) {

		this.artistId = artistId;
		this.artistName = artistName;
		this.artistRole = artistRole;
		this.bandId = bandId;
	}

	public int getArtistId() {
		return artistId;
	}

	public void setArtistId(int artistId) {
		this.artistId = artistId;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public String getArtistRole() {
		return artistRole;
	}

	public void setArtistRole(String artistRole) {
		this.artistRole = artistRole;
	}

	public int getBandId() {
		return bandId;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

}
