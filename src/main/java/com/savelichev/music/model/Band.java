package com.savelichev.music.model;

public class Band {

	private int bandId;

	private String bandName;

	public Band() {

	}

	public Band(int bandId, String bandName) {

		this.bandId = bandId;
		this.bandName = bandName;
	}

	public int getBandId() {
		return bandId;
	}

	public void setBandId(int bandId) {
		this.bandId = bandId;
	}

	public String getBandName() {
		return bandName;
	}

	public void setBandName(String bandName) {
		this.bandName = bandName;
	}

}
