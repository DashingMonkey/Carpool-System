package service;

import java.sql.*;
import java.util.*;
import java.util.Date;

import util.DBHelper;
import entity.Graduate;
import entity.Tutor;

public class GraduateDao {

	public Graduate login(String id, String pwd) throws Exception {
		Graduate gra = null;
		String sql = "select * from graduate where gid='" + id + "'and pwd='"
				+ pwd + "'";
		ResultSet rs = DBHelper.executeQuery(sql);
		while (rs.next()) {
			gra = new Graduate();
			gra.setId(rs.getString("gid"));
			gra.setTicketnum(rs.getInt("ticketnum"));
			gra.setName(rs.getString("name"));
			gra.setSex(rs.getString("sex"));
			gra.setBirth(rs.getDate("birth"));
			gra.setMajor(rs.getString("major"));
			gra.setTel(rs.getString("tel"));
			gra.setRemark(rs.getString("remark"));
			gra.setPwd(rs.getString("pwd"));
		}
		return gra;
	}

	public List<Graduate> queryGraduate() {
		List<Graduate> glist = new ArrayList<Graduate>();
		try {
			String sql = "select * from graduate";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Graduate gra = new Graduate();
				gra.setId(rs.getString(1));
				gra.setTicketnum(rs.getInt(2));
				gra.setName(rs.getString(3));
				gra.setSex(rs.getString(4));
				gra.setBirth(rs.getDate(5));
				gra.setMajor(rs.getString(6));
				gra.setTel(rs.getString(7));
				gra.setRemark(rs.getString(8));
				gra.setPwd(rs.getString(9));
				glist.add(gra);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return glist;
	}

	public List<Graduate> TqueryGraduate(String major) {
		List<Graduate> tlist = new ArrayList<Graduate>();
		try {
			String sql = "select ticketnum,name,sex,major,tel,remark from Graduate where major='"
					+ major + "'";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Graduate gra = new Graduate();
				gra.setTicketnum(rs.getInt(1));
				gra.setName(rs.getString(2));
				gra.setSex(rs.getString(3));
				gra.setMajor(rs.getString(4));
				gra.setTel(rs.getString(5));
				gra.setRemark(rs.getString(6));
				tlist.add(gra);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tlist;
	}

	public int deleteGraduate(String id) {
		String sql = "delete from Graduate where gid='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public int updateGraduate(String id, int ticketnum, String name,
			String sex, String birth, String major, String tel, String remark,
			String pwd) {
		String sql = "update Graduate set ticketnum='" + ticketnum + "',name='"
				+ name + "',sex='" + sex + "',birth='" + birth + "',major='"
				+ major + "',tel='" + tel + "',remark='" + remark + "',pwd='"
				+ pwd + "' where gid='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public Graduate queryGraduateByID(String id) {
		Graduate gra = null;
		try {
			String sql = "select gid,ticketnum,name,sex,birth,major,tel,remark,pwd from Graduate where gid='"
					+ id + "'";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				gra = new Graduate();
				gra.setId(rs.getString(1));
				gra.setTicketnum(rs.getInt(2));
				gra.setName(rs.getString(3));
				gra.setSex(rs.getString(4));
				gra.setBirth(rs.getDate(5));
				gra.setMajor(rs.getString(6));
				gra.setTel(rs.getString(7));
				gra.setRemark(rs.getString(8));
				gra.setPwd(rs.getString(9));
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return gra;
	}

	public int addGraduate(Graduate gra) {
		String sql = "insert into Graduate values('" + gra.getId() + "','"
				+ gra.getName() + "','" + gra.getPwd() + "')";
		return DBHelper.executeUpdate(sql);
	}

	public int addGraduate(String id, int ticketnum, String name, String sex,
			String birth, String major, String tel, String remark, String pwd) {
		String sql = "insert into Graduate(gid,ticketnum,name,sex,birth,major,tel,remark,pwd) values('"
				+ id
				+ "','"
				+ ticketnum
				+ "','"
				+ name
				+ "','"
				+ sex
				+ "','"
				+ birth
				+ "','"
				+ major
				+ "','"
				+ tel
				+ "','"
				+ remark
				+ "','"
				+ pwd + "')";
		return DBHelper.executeUpdate(sql);
	}

	public int changePassword(String pwd, String id) throws Exception {
		String sql = "update Graduate set pwd='" + pwd + "' where gid='" + id
				+ "'";
		return DBHelper.executeUpdate(sql);
	}

	public List<Graduate> unchosenGraduate() {
		List<Graduate> glist = new ArrayList<Graduate>();
		try {
			String sql = "select gid,name,major,tutor1,tutor2,tutor3 from graduate where chosen=0";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Graduate gra = new Graduate();
				gra.setId(rs.getString(1));
				gra.setName(rs.getString(2));
				gra.setMajor(rs.getString(3));
				gra.setTutor1(rs.getString(4));
				gra.setTutor2(rs.getString(5));
				gra.setTutor3(rs.getString(6));
				glist.add(gra);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return glist;
	}

	public Graduate showGchose(String id) {
		Graduate gra = null;
		try {
			String sql = "select tutor1,tutor2,tutor3,tutor from Graduate where gid='"
					+ id + "'";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				gra = new Graduate();
				gra.setTutor1(rs.getString(1));
				gra.setTutor2(rs.getString(2));
				gra.setTutor3(rs.getString(3));
				gra.setFtutor(rs.getString(4));
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return gra;
	}

	public int updateGchose(String id, String tutor1, String tutor2,
			String tutor3) {
		String sql = "update Graduate set tutor1='" + tutor1 + "',tutor2='"
				+ tutor2 + "',tutor3='" + tutor3 + "' where gid='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public List<Tutor> GqueryTutor(String major) {
		List<Tutor> tlist = new ArrayList<Tutor>();
		try {
			String sql = "select tid,name,major,info from Tutor where major='"
					+ major + "'";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Tutor tut = new Tutor();
				tut.setId(Integer.valueOf(rs.getString(1)));
				tut.setName(rs.getString(2));
				tut.setMajor(rs.getString(3));
				tut.setInfo(rs.getString(4));
				tlist.add(tut);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tlist;
	}
}