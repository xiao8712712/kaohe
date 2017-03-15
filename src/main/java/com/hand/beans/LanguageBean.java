package com.hand.beans;

import java.sql.Date;

public class LanguageBean {

	private int language_id;

	private String name;

	private Date last_update;

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLast_update() {
		return last_update;
	}

	public LanguageBean(int language_id, String name, Date last_update) {
		super();
		this.language_id = language_id;
		this.name = name;
		this.last_update = last_update;
	}

	public LanguageBean() {
		super();
	}

	public void setLast_update(Date last_update) {
		this.last_update = last_update;
	}

	@Override
	public String toString() {
		return "LanguageBean [language_id=" + language_id + ", name=" + name + ", last_update=" + last_update + "]";
	}

}
