/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.dao;

import java.sql.SQLException;
import java.util.List;

import org.bq.model.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 * @author 白强
 */
public class FilmDAO {
	public static final int pageSize = 8;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Query all films
	 */
	public List<Film> query(int p) {
		if (p < 1) {
			return null;
		}
		String sql = "select film_id,filmUrl,name,description from film limit "
				+ (p - 1) * pageSize + "," + p * pageSize;
		System.out.println("Query SQL---" + sql);
		List<Film> list = this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Film.class),
				new Object[] {});
		return list;
	}

	/**
	 * Query all films by name
	 */
	public List<Film> queryByName(String name) {
		String sql = "select film_id,filmUrl,name,description,director,view_link,showtime,photo_link,runtime,nickname,rate from film where name like ?  limit 8";
		System.out.println("Query SQL---" + sql);
		Object[] params = new Object[] { "%" + name + "%" };
		List<Film> list = this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Film.class),
				params);
		return list;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Film getFilm(int id) {
		String sql = "select film_id,name,filmUrl ,description ,director ,showtime ,runtime,"
				+ "language,nickname,rate,hot_grade,poster_link,photo_link,view_link`  from film where id=?";
		if (jdbcTemplate.queryForRowSet(sql, id).next()) {
			return jdbcTemplate.queryForObject(sql,
					ParameterizedBeanPropertyRowMapper.newInstance(Film.class),
					id);
		}
		return null;
	}

	/**
	 * Add a film
	 * 
	 * @param film
	 */
	public int addFilm(final Film film) {
		String sql = "insert into film(name,filmUrl,description ,director,showtime,view_link) values(?,?,?,?,?,?)";
		int i = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps)
					throws SQLException {
				ps.setString(1, film.getName());
				ps.setString(2, film.getFilmUrl());
				ps.setString(3, film.getDescription());
				ps.setString(4, film.getDirector());
				ps.setString(5, film.getShowtime());
				ps.setString(6, film.getView_link());
			}
		});
		return i;
	}

	/**
	 * Get bean
	 * 
	 * @param ctx
	 * @return
	 */
	public static FilmDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FilmDAO) ctx.getBean("filmDAO");
	}

}
