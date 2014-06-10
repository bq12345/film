package org.bq.model;

/**
 * @author 白强
 * @version 1.0
 */
public class User {
	private int id;
	private String username;
	private String password;
	private int age;
	private String love;
	private String email;

	public User() {
	}

	public User(String username, String password, int age, String love,
			String email) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.love = love;
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLove() {
		return love;
	}

	public void setLove(String love) {
		this.love = love;
	}

	public User(int id, String username, String password, int age, String love,
			String email) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.love = love;
		this.email = email;
	}

	
}
