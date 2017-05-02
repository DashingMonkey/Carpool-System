package service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import util.DBHelper;
import entity.Major;

public class MajorDao {

	public List<Major> queryMajors() {
		List<Major> mlist = new ArrayList<Major>();
		try {
			String sql = "select * from major";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Major maj = new Major();
				maj.setMajor(rs.getString("major"));
				maj.setMid(rs.getString("mid"));
				maj.setDepa(rs.getString("depa"));
				mlist.add(maj);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mlist;
	}

	public int deleteMajor(String id) {
		String sql = "delete from major where mid='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public int updateMajor(String mid, String major,String depa) {
		String sql = "update major set major='" + major +"',depa='"+depa+ "' where mid='" + mid + "'";
		return DBHelper.executeUpdate(sql);
	}

	public Major queryMajorByID(String mid) {
		Major maj = null;
		try {
			String sql = "select mid,major,depa from major where mid='" + mid + "'";
			ResultSet rs = DBHelper.executeQuery(sql);
			if (rs.next()) {
				maj = new Major();
				maj.setMajor(rs.getString("major"));
				maj.setMid(rs.getString("mid"));
				maj.setDepa(rs.getString("depa"));
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return maj;
	}

	public int addMajor(Major maj) {
		String sql = "insert into  major values('" + maj.getMajor() + "','"
				+ maj.getMid() + "','" + maj.getDepa() + "')";
		return DBHelper.executeUpdate(sql);
	}

	public int addMajor(String major, String id, String depa) {
		String sql = "insert into major(major,mid,depa) values('" + major + "','" + id + "','"
				+ depa + "')";
		return DBHelper.executeUpdate(sql);
	}
}
