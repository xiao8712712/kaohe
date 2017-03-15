package com.hand.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.Dao.FilmDao;
import com.hand.beans.FilmBean;

public class FilmDaoImpl implements FilmDao {

	public List<FilmBean> filmList(Connection conn) {
		List<FilmBean> filmList = null;
		try {
			String sql = "select f.film_id,f.title,f.description,l.name,f.last_update from film f,language l where f.language_id=l.language_id;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			filmList = new ArrayList<FilmBean>();

			while (rs.next()) {
				filmList.add(new FilmBean(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
						rs.getString("name"), rs.getDate("last_update")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return filmList;

	}

	public boolean filmAdd(Connection conn, FilmBean film) {
		int num = 0;
		try {
			String sql = "insert into film (title,description,language_id ) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getLanguage_id());
			num = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (num == 0) {
			return false;
		} else {
			return true;
		}
	}

	public boolean filmDel(Connection conn, FilmBean film) {
		int num = 0;
		try {
			String sql = "SET FOREIGN_KEY_CHECKS = 0;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			String sql2 = "delete from film where film_id = ?;";
			ps = conn.prepareStatement(sql2);
			ps.setInt(1, film.getFilm_id());
			num = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (num == 0) {
			return false;
		} else {
			return true;
		}

	}

	public boolean filmUpdate(Connection conn, FilmBean film) {
		int num = 0;
		try {
			String sql = "update film f set f.title=?,f.description=?,f.language_id=?,f.last_update=? where f.film_id = ?";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, film.getTitle());
			ps.setString(2, film.getDescription());
			ps.setInt(3, film.getLanguage_id());
			ps.setDate(4, film.getLast_update());
			ps.setInt(5, film.getFilm_id());
			num = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (num == 0) {
			return false;
		} else {
			return true;
		}

	}

	public FilmBean filmListById(Connection conn, FilmBean film) {
		try {
			String sql = "select f.film_id,f.title,f.description,f.language_id,f.last_update from film f where f.film_id=?;";

			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, film.getFilm_id());
			ResultSet rs = ps.executeQuery();

			film = new FilmBean();

			while (rs.next()) {
				film.setFilm_id(rs.getInt("film_id"));
				film.setTitle(rs.getString("title"));
				film.setDescription(rs.getString("description"));
				film.setLanguage_id(rs.getInt("language_id"));
				film.setLast_update(rs.getDate("last_update"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return film;
	}

}
