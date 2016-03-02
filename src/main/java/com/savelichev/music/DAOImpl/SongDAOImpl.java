package com.savelichev.music.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.savelichev.music.DAOInterfaces.SongDAO;
import com.savelichev.music.model.Song;

public class SongDAOImpl implements SongDAO {

	private JdbcTemplate jdbcTemplate;

	public SongDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * UPDATE row if song has ID else INSERT new row
	 */
	@Override
	public void saveOrUpdate(Song song) {
		if (song.getSongId() > 0) {
			// update
			String sql = "UPDATE songs SET song_title=?, artist_id=? WHERE song_id=?";
			jdbcTemplate.update(sql, song.getSongTitle(), song.getArtistId(), song.getSongId());
		} else {
			// insert
			String sql = "INSERT INTO songs(song_title, artist_id) values (?,?)";
			jdbcTemplate.update(sql, song.getSongTitle(), song.getArtistId());
		}

	}

	@Override
	public void delete(int songId) {
		String sql = "DELETE FROM songs WHERE song_id=?";
		jdbcTemplate.update(sql, songId);

	}

	@Override
	public Song getSingleSong(int songId) {

		String sql = "SELECT * FROM songs WHERE song_id=" + songId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Song>() {

			@Override
			public Song extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					Song song = new Song();
					song.setSongId(rs.getInt("song_id"));
					song.setSongTitle(rs.getString("song_title"));
					song.setArtistId(rs.getInt("artist_id"));
					return song;
				} else
					return null;

			}

		});

	}

	@Override
	public List<Song> list() {
		String sql = "SELECT * FROM songs";
		List<Song> listSong = jdbcTemplate.query(sql, new RowMapper<Song>() {

			@Override
			public Song mapRow(ResultSet rs, int rowNum) throws SQLException {

				Song aSong = new Song();

				aSong.setSongId(rs.getInt("song_id"));
				aSong.setSongTitle(rs.getString("song_title"));
				aSong.setArtistId(rs.getInt("artist_id"));

				return aSong;
			}

		});

		return listSong;
	}

	public List<Song> listSongArtist() {
		String sql = "SELECT * FROM songs, artists, bands WHERE (songs.artist_id=artists.artist_id AND artists.band_id=bands.band_id)";
		List<Song> listSong = jdbcTemplate.query(sql, new RowMapper<Song>() {

			@Override
			public Song mapRow(ResultSet rs, int rowNum) throws SQLException {

				Song aSong = new Song();

				aSong.setSongId(rs.getInt("song_id"));
				aSong.setSongTitle(rs.getString("song_title"));
				aSong.setArtistId(rs.getInt("artist_id"));

				return aSong;
			}

		});

		return listSong;
	}

}
