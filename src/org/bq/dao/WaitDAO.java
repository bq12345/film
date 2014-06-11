/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.dao;

import java.sql.SQLException;
import java.util.List;

import org.bq.model.User;
import org.bq.model.Wait;
import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 * @author 白强
 */
public class WaitDAO {
	public static final int pageSize = 8;
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Query all waits
	 */
	public List<Wait> query(int p, int id) {
		if (p < 1) {
			p = 1;
		}
		String sql = "select id,name,description,date,watch,url,director from wait where sender=? limit "
				+ (p - 1) * pageSize + "," + p * pageSize;
		System.out.println("Query SQL---" + sql);
		List<Wait> list = this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(Wait.class),
				new Object[] { id });
		return list;
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	public Wait getWait(int id) {
		String sql = "select id,name,description,date,watch,url,director from wait where id=?";
		if (jdbcTemplate.queryForRowSet(sql, id).next()) {
			return jdbcTemplate.queryForObject(sql,
					ParameterizedBeanPropertyRowMapper.newInstance(Wait.class),
					id);
		}
		return null;
	}

	/**
	 * Delete a wait film
	 * 
	 * @param id
	 * @return
	 */
	public void deleteWait(int id) {
		String sql = "delete from wait where id=?";
		jdbcTemplate.update(sql, new Object[] { id });
	}

	/**
	 * Add a wait
	 */
	public int addWait(final Wait wait, final int id) {
		String sql = "insert into wait (name,description,date,watch,url,director,sender) values (?,?,?,?,?,?,?)";
		int i = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps)
					throws SQLException {
				ps.setString(1, wait.getName());
				ps.setString(2, wait.getDescription());
				ps.setString(3, wait.getDate());
				ps.setString(4, wait.getWatch());
				ps.setString(5, wait.getUrl());
				ps.setString(6, wait.getDirector());
				ps.setInt(7, id);
			}
		});
		return i;
	}

	/**
	 * Update a wait
	 * 
	 * @param i
	 * @param wait
	 */
	public void updateUser(final Wait wait, final int id) {
		String sql = "update wait set name=?,description=?,date=?,watch=?,director=?,url=?,sender=? where id=?";
		jdbcTemplate.update(
				sql,
				new Object[] { wait.getName(), wait.getDescription(),
						wait.getDate(), wait.getWatch(), wait.getDirector(),
						wait.getUrl(), id, wait.getId() });
	}

	/**
	 * Get bean
	 * 
	 * @param ctx
	 * @return
	 */
	public static WaitDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WaitDAO) ctx.getBean("waitDAO");
	}
}
