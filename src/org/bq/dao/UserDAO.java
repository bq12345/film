/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.dao;

import java.sql.SQLException;
import java.util.List;

import org.bq.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;

/**
 * @author 白强
 */
public class UserDAO {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * Query user by name and password
	 */
	public List<User> queryByName(String name, String password) {
		String sql = "select id,username,password,age,love,email from user where username = ? and password =MD5(?)";
		System.out.println("Query SQL---" + sql);
		Object[] params = new Object[] { name, password };
		List<User> list = this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				params);
		return list;
	}

	/**
	 * Query user by name and password
	 */
	public int addUser(final User user) {
		System.out.println(user.toString());
		String sql = "insert into user(username,password,age,love,email) values (?,MD5(?),?,?,?)";
		System.out.println("Insert into sql---" + sql);
		int i = jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(java.sql.PreparedStatement ps)
					throws SQLException {
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setInt(3, user.getAge());
				ps.setString(4, user.getLove());
				ps.setString(5, user.getEmail());
			}
		});
		return i;
	}

}
