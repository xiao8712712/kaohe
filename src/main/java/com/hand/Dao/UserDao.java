package com.hand.Dao;

import java.sql.Connection;

import com.hand.beans.UserBean;

public interface UserDao {

	public boolean checkLogin(Connection conn, UserBean user);

}
