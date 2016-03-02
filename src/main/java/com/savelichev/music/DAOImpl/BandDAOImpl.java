package com.savelichev.music.DAOImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import com.savelichev.music.DAOInterfaces.BandDAO;
import com.savelichev.music.model.Band;

public class BandDAOImpl implements BandDAO {

	private JdbcTemplate jdbcTemplate;

	public BandDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Band band) {
		if (band.getBandId() > 0) {
			// update if band has ID
			String sqlUpdateRow = "UPDATE bands SET band_name=? WHERE band_id=?";
			jdbcTemplate.update(sqlUpdateRow, band.getBandName(), band.getBandId());
		} else {
			// insert new Band
			String sqlInserRow = "INSERT INTO bands(band_name) VALUES(?)";
			jdbcTemplate.update(sqlInserRow, band.getBandName());
		}

	}

	@Override
	public void delete(int bandId) {
		String sqlDelete = "DELETE FROM bands WHERE band_id=?";
		jdbcTemplate.update(sqlDelete, bandId);

	}

	@Override
	public Band getSingleBand(int bandId) {

		String sqlGetSingleBand = "SELECT * FROM bands WHERE band_id=" + bandId;
		return jdbcTemplate.query(sqlGetSingleBand, new ResultSetExtractor<Band>() {

			@Override
			public Band extractData(ResultSet rs) throws SQLException, DataAccessException {

				if (rs.next()) {
					Band band = new Band();
					band.setBandId(rs.getInt("band_id"));
					band.setBandName(rs.getString("band_name"));
					return band;
				}

				return null;
			}

		});
	}

	@Override
	public List<Band> list() {
		String sqlGetAll = "SELECT * FROM bands";
		List<Band> listBand = jdbcTemplate.query(sqlGetAll, new RowMapper<Band>() {

			@Override
			public Band mapRow(ResultSet rs, int rowNum) throws SQLException {

				Band aBand = new Band();

				aBand.setBandId(rs.getInt("band_id"));
				aBand.setBandName(rs.getString("band_name"));

				return aBand;
			}

		});

		return listBand;
	}

}
