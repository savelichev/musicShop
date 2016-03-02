package com.savelichev.music.DAOInterfaces;

import java.util.List;

import com.savelichev.music.model.Artist;

public interface ArtistDAO {

	public void saveOrUpdate(Artist artist);

	public void delete(int artistId);

	public Artist getSingleArtist(int artistId);

	public List<Artist> list();
}
