/**
 * Copyright (c) 2014. Designed By BaiQiang.
 */
package org.bq.model;

import java.sql.Date;

public class Film {

	private int film_id;
	private String name;
	private String filmUrl;
	private String description;
	private String director;
	private String showtime;
	private Date runtime;
	private String language;
	private String nickname;
	private String rate;
	private int hot_grade;
	private String poster_link;
	private String photo_link;
	private String view_link;

	public Film() {
	}

	public Film(String name, String filmUrl, String description,
			String director, String showtime, String view_link) {
		this.name = name;
		this.filmUrl = filmUrl;
		this.description = description;
		this.director = director;
		this.showtime = showtime;
		this.view_link = view_link;
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFilmUrl() {
		return filmUrl;
	}

	public void setFilmUrl(String filmUrl) {
		this.filmUrl = filmUrl;
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

	public String getShowtime() {
		return showtime;
	}

	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}

	public Date getRuntime() {
		return runtime;
	}

	public void setRuntime(Date runtime) {
		this.runtime = runtime;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public int getHot_grade() {
		return hot_grade;
	}

	public void setHot_grade(int hot_grade) {
		this.hot_grade = hot_grade;
	}

	public String getPoster_link() {
		return poster_link;
	}

	public void setPoster_link(String poster_link) {
		this.poster_link = poster_link;
	}

	public String getPhoto_link() {
		return photo_link;
	}

	public void setPhoto_link(String photo_link) {
		this.photo_link = photo_link;
	}

	public String getView_link() {
		return view_link;
	}

	public void setView_link(String view_link) {
		this.view_link = view_link;
	}

	@Override
	public String toString() {
		return "Film [film_id=" + film_id + ", name=" + name + ", filmUrl="
				+ filmUrl + ", description=" + description + ", director="
				+ director + ", showtime=" + showtime + ", runtime=" + runtime
				+ ", language=" + language + ", nickname=" + nickname
				+ ", rate=" + rate + ", hot_grade=" + hot_grade
				+ ", poster_link=" + poster_link + ", photo_link=" + photo_link
				+ ", view_link=" + view_link + "]";
	}

}
