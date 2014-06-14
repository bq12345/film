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
	 * Query user by name
	 * 
	 * @param name
	 * @return if name has used is true
	 */
	public boolean existName(String name) {
		String sql = "select id,username,password,age,love,email from user where username = ?";
		System.out.println("Query SQL---" + sql);
		Object[] params = new Object[] { name };
		List<User> list = this.getJdbcTemplate().query(sql,
				ParameterizedBeanPropertyRowMapper.newInstance(User.class),
				params);
		return list.size() > 0;
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
	 * Query user by id
	 */
	public User getUser(int id) {
		String sql = "select id,username,password,age,love,email from user where id=?";
		if (jdbcTemplate.queryForRowSet(sql, id).next()) {
			return jdbcTemplate.queryForObject(sql,
					ParameterizedBeanPropertyRowMapper.newInstance(User.class),
					id);
		}
		return null;
	}

	/**
	 * Add a user
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

	/**
	 * Update a user
	 * 
	 * @param i
	 * @param user
	 */
	public void updateUser(final User user) {
		String sql = "update user set username=?,password=MD5(?),age=?,love=?,email=? where id=?";
		System.out.println("Update sql---" + sql);
		jdbcTemplate.update(
				sql,
				new Object[] { user.getUsername(), user.getPassword(),
						user.getAge(), user.getLove(), user.getEmail(),
						user.getId() });
	}

}
