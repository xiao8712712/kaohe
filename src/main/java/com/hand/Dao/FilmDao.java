package com.hand.Dao;

import java.sql.Connection;
import java.util.List;

import com.hand.beans.FilmBean;

public interface FilmDao {

	public List<FilmBean> filmList(Connection conn);

	public FilmBean filmListById(Connection conn, FilmBean film);

	public boolean filmAdd(Connection conn, FilmBean film);

	public boolean filmDel(Connection conn, FilmBean film);

	public boolean filmUpdate(Connection conn, FilmBean film);

}
