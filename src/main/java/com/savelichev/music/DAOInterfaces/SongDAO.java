package com.savelichev.music.DAOInterfaces;

import java.util.List;

import com.savelichev.music.model.Song;

public interface SongDAO {

	public void saveOrUpdate(Song song);

	public void delete(int songId);

	public Song getSingleSong(int songId);

	public List<Song> list();
}
