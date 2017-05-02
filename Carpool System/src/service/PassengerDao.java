package service;

import java.sql.*;
import java.util.*;

import entity.Passenger;
import util.DBHelper;

public class PassengerDao {
	public Passenger login(String id, String pwd) throws Exception {
		Passenger pas = null;
		String sql = "select * from Passenger where id='" + id + "'and pwd='"
				+ pwd + "'";
		ResultSet rs = DBHelper.executeQuery(sql);
		while (rs.next()) {
			pas = new Passenger();
			pas.setId(rs.getString("id"));
			pas.setPwd(rs.getString("pwd"));
		}
		return pas;
	}

	public int changePassword(String pwd, String id) throws Exception {
		String sql = "update passenger set pwd='" + pwd + "' where id='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	
	
}
