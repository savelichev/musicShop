package com.savelichev.music.DAOInterfaces;

import java.util.List;

import com.savelichev.music.model.Band;

public interface BandDAO {

	public void saveOrUpdate(Band band);

	public void delete(int bandId);

	public Band getSingleBand(int bandId);

	public List<Band> list();
}
