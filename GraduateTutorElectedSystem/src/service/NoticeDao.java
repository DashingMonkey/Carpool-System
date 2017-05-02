package service;

import entity.Notice;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import util.DBHelper;

public class NoticeDao {

	public List<Notice> queryNoticeTitle() {
		List<Notice> nlist = new ArrayList<Notice>();
		try {
			String sql = "select * from notice order by time desc";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Notice no = new Notice();
				no.setTime(rs.getTimestamp(1));
				no.setTitle(rs.getString(2));
				no.setContent(rs.getString(3));
				nlist.add(no);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return nlist;
	}

	public List<Notice> queryNoticeLatest() {
		List<Notice> nlist = new ArrayList<Notice>();
		Notice no = new Notice();
		try {
			String sql = "select * from notice order by time desc limit 1";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				no.setTime(rs.getTimestamp(1));
				no.setTitle(rs.getString(2));
				no.setContent(rs.getString(3));
				nlist.add(no);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return nlist;
	}

	public int deleteNotice(String time) {
		String sql = "delete from notice where time='" + time + "'";
		return DBHelper.executeUpdate(sql);
	}

	public int updateCustomer(Date time, String title, String content) {
		String sql = "update notice set title='" + title + "',content='"
				+ content + "' where time='" + time + "'";
		return DBHelper.executeUpdate(sql);
	}

	public int addNotice(Notice not) {
		String sql = "insert into notice values('" + not.getTime() + "','"
				+ not.getTitle() + "','" + not.getContent() + "')";
		return DBHelper.executeUpdate(sql);
	}

	public int addNotice(String time, String title, String content) {
		String sql = "insert into notice(time,title,content) values('" + time + "','" + title
				+ "','" + content + "')";
		return DBHelper.executeUpdate(sql);
	}
}
