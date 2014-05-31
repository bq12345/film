/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.dao;

import java.util.List;

import org.bq.model.Film;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 * @author 白强
 * @version 1.0
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
		String sql = "select film_id,filmUrl,name,description from film where name like ?  limit 8";
		System.out.println("Query SQL---" + sql);
		Object[] params = new Object[] { "%" + name + "%" };
		List<Film> list = this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Film.class),
				params);
		return list;
	}

	/**
	 * 得到某个电影的具体信息
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
	 * 得到bean
	 * 
	 * @param ctx
	 * @return
	 */
	public static FilmDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FilmDAO) ctx.getBean("filmDAO");
	}
}
