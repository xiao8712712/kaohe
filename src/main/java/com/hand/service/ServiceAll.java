package com.hand.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.hand.DaoImpl.FilmDaoImpl;
import com.hand.DaoImpl.LanguageDaoImpl;
import com.hand.DaoImpl.UserDaoImpl;
import com.hand.beans.FilmBean;
import com.hand.beans.LanguageBean;
import com.hand.beans.UserBean;
import com.hand.util.ConnectionFactory;

public class ServiceAll {

	private ConnectionFactory factory = ConnectionFactory.getInstance();
	private Connection conn = factory.getconn();
	private UserDaoImpl userDao = new UserDaoImpl();
	private FilmDaoImpl filmDao = new FilmDaoImpl();
	private LanguageDaoImpl languageDao = new LanguageDaoImpl();

	public List<FilmBean> filmList() {
		return filmDao.filmList(conn);
	}

	public boolean filmAdd(FilmBean film) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filmDao.filmAdd(conn, film);
	}

	public boolean filmDel(FilmBean film) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filmDao.filmDel(conn, film);
	}

	public boolean filmUpdate(FilmBean film) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filmDao.filmUpdate(conn, film);
	}

	public FilmBean filmListById(FilmBean film) {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filmDao.filmListById(conn, film);
	}

	public List<LanguageBean> languagelist() {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new LanguageDaoImpl().languagelist(conn);
	}

	public boolean loginCheck(UserBean user) {
		return userDao.checkLogin(conn, user);
	}
}
