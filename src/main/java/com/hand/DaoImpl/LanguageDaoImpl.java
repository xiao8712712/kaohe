package com.hand.DaoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hand.Dao.LanguageDao;
import com.hand.beans.LanguageBean;

public class LanguageDaoImpl implements LanguageDao {

	public List<LanguageBean> languagelist(Connection conn) {

		List<LanguageBean> languagelist = null;
		try {
			String sql = "select * from language";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			languagelist = new ArrayList<LanguageBean>();
			while (rs.next()) {
				languagelist.add(
						new LanguageBean(rs.getInt("language_id"), rs.getString("name"), rs.getDate("last_update")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return languagelist;

	}

}
