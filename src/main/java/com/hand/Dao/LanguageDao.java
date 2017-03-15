package com.hand.Dao;

import java.sql.Connection;
import java.util.List;

import com.hand.beans.LanguageBean;

public interface LanguageDao {

	public List<LanguageBean> languagelist(Connection conn);

}
