/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author 白强
 */
public class AdminDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Query admin by name and password
	 */
	public List<String> queryByName(String name, String password) {
		String sql = "select username from admin where username = ? and password =MD5(?)";
		System.out.println("Query SQL---" + sql);
		Object[] params = new Object[] { name, password };
		List<String> list = this.getJdbcTemplate().queryForList(sql,
				String.class, params);
		return list;
	}
}
