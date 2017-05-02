package service;

import java.sql.*;
import java.util.*;

import util.DBHelper;
import entity.Graduate;
import entity.Tutor;

public class TutorDao {

	public Tutor login(String id, String pwd) throws Exception {
		Tutor tu = null;
		String sql = "select * from tutor where tid='" + id + "'and pwd='"
				+ pwd + "'";
		ResultSet rs = DBHelper.executeQuery(sql);
		while (rs.next()) {
			tu = new Tutor();
			tu.setId(rs.getInt("tid"));
			tu.setName(rs.getString("name"));
			tu.setPwd(rs.getString("pwd"));
			tu.setMajor(rs.getString("major"));
			tu.setInfo(rs.getString("info"));
		}
		return tu;
	}

	public List<Tutor> queryTutor() {
		List<Tutor> tlist = new ArrayList<Tutor>();
		try {
			String sql = "select * from Tutor";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Tutor cus = new Tutor();
				cus.setId(Integer.valueOf(rs.getString(1)));
				cus.setName(rs.getString(2));
				cus.setMajor(rs.getString(3));
				cus.setInfo(rs.getString(4));
				cus.setPwd(rs.getString(5));
				tlist.add(cus);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tlist;
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

	public int deleteTutor(int id) {
		String sql = "delete from Tutor where tid='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public int updateTutor(String id, String name, String major, String info,
			String pwd) {
		String sql = "update Tutor set name='" + name + "',major='" + major
				+ "',info='" + info + "',pwd='" + pwd + "' where tid='" + id
				+ "'";
		return DBHelper.executeUpdate(sql);
	}

	public Tutor queryTutorByID(String id) {
		Tutor tut = null;
		try {
			String sql = "select tid,name,major,info,pwd from Tutor where tid='"
					+ id + "'";
			ResultSet rs = DBHelper.executeQuery(sql);
			if (rs.next()) {
				tut = new Tutor();
				tut.setId(Integer.valueOf(rs.getString(1)));
				tut.setName(rs.getString(2));
				tut.setMajor(rs.getString(3));
				tut.setInfo(rs.getString(4));
				tut.setPwd(rs.getString(5));
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tut;
	}

	public int addTutor(Tutor cus) {
		String sql = "insert into Tutor values('" + cus.getId() + "','"
				+ cus.getName() + "','" + cus.getMajor() + "','"
				+ cus.getInfo() + "','" + cus.getPwd() + "')";
		return DBHelper.executeUpdate(sql);
	}

	public int addTutor(int id, String name, String major, String info,
			String pwd) {
		String sql = "insert into Tutor(tid,name,major,info,pwd) values('" + id
				+ "','" + name + "','" + major + "','" + info + "','" + pwd
				+ "')";
		return DBHelper.executeUpdate(sql);
	}

	public int changePassword(String pwd, String id) throws Exception {
		String sql = "update Tutor set pwd='" + pwd + "' where tid='" + id
				+ "'";
		return DBHelper.executeUpdate(sql);
	}

	public List<Graduate> showTchose(String id) {
		List<Graduate> glist = new ArrayList<Graduate>();
		Graduate gra = null;
		try {
			String sql = "select ticketnum,name,sex from Graduate where (gid = (select graduate1 from Tutor where tid='"
					+ id
					+ "'))or (gid =(select graduate2 from Tutor where tid='"
					+ id
					+ "'))or (gid =(select graduate3 from Tutor where tid='"
					+ id + "'))";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				gra = new Graduate();
				gra.setTicketnum(Integer.valueOf(rs.getString(1)));
				gra.setName(rs.getString(2));
				gra.setSex(rs.getString(3));
				glist.add(gra);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return glist;
	}

	public int updateGchose(String id, String tutor1, String tutor2,
			String tutor3) {
		String sql = "update Graduate set tutor1='" + tutor1 + "',tutor2='"
				+ tutor2 + "',tutor3='" + tutor3 + "' where gid='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public int TChoseG(String Tid, String Gid) throws SQLException {
		String sql1 = "select graduate1 from tutor where tid='" + Tid + "'";
		ResultSet rs1 = DBHelper.executeQuery(sql1);
		String sql2 = "select graduate2 from tutor where tid='" + Tid + "'";
		ResultSet rs2 = DBHelper.executeQuery(sql2);
		String sql3 = "select graduate3 from tutor where tid='" + Tid + "'";
		ResultSet rs3 = DBHelper.executeQuery(sql3);
		String a = null;
		String b = null;
		String c = null;
		if (rs1.next()) {
			a = rs1.getString(1);
		}
		if (rs2.next()) {
			b = rs2.getString(1);
		}
		if (rs3.next()) {
			c = rs3.getString(1);
		}
		if (a == null || a.equals("")) {
			String sql4 = "update Tutor set graduate1='" + Gid
					+ "' where tid='" + Tid + "'";
			String sql5 = "update Graduate set chosen=1 where gid='" + Gid
					+ "'";
			String sql6 = "update Graduate set tutor='" + Tid + "'where gid='"
					+ Gid + "'";
			String sql7 = "update Graduate set tutor1=null,tutor2=null,tutor3=null where gid='"
					+ Gid + "'";
			int rs4 = DBHelper.executeUpdate(sql4);
			int rs5 = DBHelper.executeUpdate(sql5);
			int rs6 = DBHelper.executeUpdate(sql6);
			return DBHelper.executeUpdate(sql7);
		} else if (b == null || b.equals("")) {
			String sql4 = "update Tutor set graduate2='" + Gid
					+ "' where tid='" + Tid + "'";
			String sql5 = "update Graduate set chosen=1 where gid='" + Gid
					+ "'";
			String sql6 = "update Graduate set tutor='" + Tid + "'where gid='"
					+ Gid + "'";
			String sql7 = "update Graduate set tutor1=null,tutor2=null,tutor3=null where gid='"
					+ Gid + "'";
			int rs4 = DBHelper.executeUpdate(sql4);
			int rs5 = DBHelper.executeUpdate(sql5);
			int rs6 = DBHelper.executeUpdate(sql6);
			return DBHelper.executeUpdate(sql7);
		} else if (c == null || c.equals("")) {
			String sql4 = "update Tutor set graduate3='" + Gid
					+ "' where tid='" + Tid + "'";
			String sql5 = "update Graduate set chosen=1 where gid='" + Gid
					+ "'";
			String sql6 = "update Graduate set tutor='" + Tid + "'where gid='"
					+ Gid + "'";
			String sql7 = "update Graduate set tutor1=null,tutor2=null,tutor3=null where gid='"
					+ Gid + "'";
			int rs4 = DBHelper.executeUpdate(sql4);
			int rs5 = DBHelper.executeUpdate(sql5);
			int rs6 = DBHelper.executeUpdate(sql6);
			return DBHelper.executeUpdate(sql7);
		} else {
			return 0;
		}
	}

	public List<Graduate> showGchoseU(String id) {
		List<Graduate> glist = new ArrayList<Graduate>();
		Graduate gra = null;
		try {
			String sql = "select gid,ticketnum,name from graduate where (tutor1 = (select name from Tutor where tid='"
					+ id
					+ "'))or (tutor2 =(select name from Tutor where tid='"
					+ id
					+ "'))or (tutor3 =(select name from Tutor where tid='"
					+ id + "'))";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				gra = new Graduate();
				gra.setId(rs.getString(1));
				gra.setTicketnum(Integer.valueOf(rs.getString(2)));
				gra.setName(rs.getString(3));
				glist.add(gra);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return glist;
	}
}
