package com.hand.beans;

import java.sql.Date;

public class FilmBean {

	private int film_id;

	private String title;

	private String description;

	private String language;

	private Date last_update;

	private int Language_id;

	public int getLanguage_id() {
		return Language_id;
	}

	public void setLanguage_id(int language_id) {
		Language_id = language_id;
	}

	public FilmBean(int film_id, String title, String description, String language, Date last_update) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.last_update = last_update;
	}

	public FilmBean() {
		super();
	}

	public int getFilm_id() {
		return film_id;
	}

	public void setFilm_id(int film_id) {
		this.film_id = film_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Date getLast_update() {
		return last_update;
	}

	public FilmBean(int film_id, String title, String description, int language_id, Date last_update) {
		super();
		this.film_id = film_id;
		this.title = title;
		this.description = description;
		this.last_update = last_update;
		Language_id = language_id;
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		return "FilmBean [film_id=" + film_id + ", title=" + title + ", description=" + description + ", language="
				+ language + ", last_update=" + last_update + ", Language_id=" + Language_id + "]";
	}

}
