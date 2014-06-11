/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.model;

/**
 * @author 白强
 * @version 1.0
 */
public class Wait {

	private int id;
	private String name;
	private String url;
	private String description;
	private String director;
	private String date;
	private String watch;

	public Wait() {
	}

	public Wait(String name, String url, String description, String director,
			String date, String watch) {
		super();
		this.name = name;
		this.url = url;
		this.description = description;
		this.director = director;
		this.date = date;
		this.watch = watch;
	}

	@Override
	public String toString() {
		return "Wait [id=" + id + ", name=" + name + ", url=" + url
				+ ", description=" + description + ", director=" + director
				+ ", date=" + date + ", watch=" + watch + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWatch() {
		return watch;
	}

	public void setWatch(String watch) {
		this.watch = watch;
	}

}
