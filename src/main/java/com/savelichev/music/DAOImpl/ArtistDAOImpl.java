package com.savelichev.music.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.savelichev.music.DAOInterfaces.ArtistDAO;
import com.savelichev.music.model.Artist;

public class ArtistDAOImpl implements ArtistDAO {

	private JdbcTemplate jdbcTemplate;

	public ArtistDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Artist artist) {
		if (artist.getArtistId() > 0) {
			// update Artist
			String sqlUpdateRow = "UPDATE artists SET artist_name=?, artist_role=?, band_id=? WHERE artist_id=?";
			jdbcTemplate.update(sqlUpdateRow, artist.getArtistName(), artist.getArtistRole(), artist.getBandId(), artist.getArtistId());
		} else {
			// insert new Artist
			String sqlInsertNewRow = "INSERT INTO artists(artist_name, artist_role, band_id) VALUES (?,?,?)";
			jdbcTemplate.update(sqlInsertNewRow, artist.getArtistName(), artist.getArtistRole(), artist.getBandId());
		}

	}

	@Override
	public void delete(int artistId) {
		String sqlDeleteRow = "DELETE FROM artists WHERE artist_id=?";
		jdbcTemplate.update(sqlDeleteRow, artistId);

	}

	@Override
	public Artist getSingleArtist(int artistId) {

		String sqlSelectSingleArtist = "SELECT * FROM artists WHERE artist_id=" + artistId;
		return jdbcTemplate.query(sqlSelectSingleArtist, new ResultSetExtractor<Artist>() {

			@Override
			public Artist extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					Artist artist = new Artist();
					artist.setArtistId(rs.getInt("artist_id"));
					artist.setArtistName(rs.getString("artist_name"));
					artist.setArtistRole(rs.getString("artist_role"));
					artist.setBandId(rs.getInt("band_id"));
					return artist;
				} else
					return null;
			}

		});

	}

	@Override
	public List<Artist> list() {
		String getListArtist = "SELECT * FROM artists";
		List<Artist> listArtist = jdbcTemplate.query(getListArtist, new RowMapper<Artist>() {

			@Override
			public Artist mapRow(ResultSet rs, int rowNum) throws SQLException {
				Artist aArtist = new Artist();

				aArtist.setArtistId(rs.getInt("artist_id"));
				aArtist.setArtistName(rs.getString("artist_name"));
				aArtist.setArtistRole(rs.getString("artist_role"));
				aArtist.setBandId(rs.getInt("band_id"));

				return aArtist;
			}

		});
		return listArtist;
	}

}
