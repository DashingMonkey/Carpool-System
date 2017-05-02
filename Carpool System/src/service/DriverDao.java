package service;

import java.sql.*;
import java.util.*;

import util.DBHelper;


public class DriverDao {

	public Driver login(String id, String pwd) throws Exception {
		Driver dri = null;
		String sql = "select * from Drivers where id='" + id + "'and pwd='" + pwd
				+ "'";
		ResultSet rs = DBHelper.executeQuery(sql);
		while (rs.next()) {
			dri = new Driver();
			dri.setId(rs.getString("id"));
			dri.setPwd(rs.getString("pwd"));
		}
		return dri;
	}

	public List<Admin> queryAdmins() {
		List<Admin> clist = new ArrayList<Admin>();
		try {
			String sql = "select * from Admin";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Admin cus = new Admin();
				cus.setId(rs.getString(1));
				cus.setPwd(rs.getString(2));
				clist.add(cus);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return clist;
	}

	public int deleteAdmin(String id) {
		String sql = "delete from Admin where id='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public int updateCustomer(String id, String pwd) {
		String sql = "update Admin set pwd='" + pwd + "' where id='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public Admin queryAdminByID(String id) {
		Admin cus = null;
		try {
			String sql = "select * from Admin where id='" + id + "'";
			ResultSet rs = DBHelper.executeQuery(sql);
			if (rs.next()) {
				cus = new Admin();
				cus.setId(rs.getString(1));
				cus.setPwd(rs.getString(2));
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return cus;
	}

	public int addAdmin(Admin cus) {
		String sql = "insert into  Admin values('" + cus.getId() + "','"
				+ cus.getPwd() + "')";
		return DBHelper.executeUpdate(sql);
	}

	public int addAdmin(String cid, String pwd) {
		String sql = "insert into  Admin values('" + cid + "','" + pwd + "')";
		return DBHelper.executeUpdate(sql);
	}

	public int changePassword(String pwd, String id) throws Exception {
		String sql = "update Admin set pwd='" + pwd + "' where id='" + id + "'";
		return DBHelper.executeUpdate(sql);
	}

	public List<Tutor> queryTforunchosenG(String Gid) {
		List<Tutor> tlist = new ArrayList<Tutor>();
		try {
			String sql = "select tid,name,major,graduate1,graduate2,graduate3 from Tutor where major in(select major from Major where depa=(select depa from Major where major=(select major from Graduate where gid='"
					+ Gid + "')))";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Tutor tut = new Tutor();
				tut.setId(rs.getInt(1));
				tut.setName(rs.getString(2));
				tut.setMajor(rs.getString(3));
				tut.setGraduate1(rs.getString(4));
				tut.setGraduate2(rs.getString(5));
				tut.setGraduate3(rs.getString(6));
				tlist.add(tut);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return tlist;
	}

	public int AchoseTforG(String Tid, String Gid) throws SQLException {
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
			rs1.previous();
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
			rs2.previous();
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
			rs3.previous();
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

	public List<Major> queryMajors() {
		List<Major> mlist = new ArrayList<Major>();
		try {
			String sql = "select major from Major";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Major maj = new Major();
				maj.setMajor(rs.getString(1));
				mlist.add(maj);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return mlist;
	}
	
	public List<Graduate> queryChosen() {
		List<Graduate> glist = new ArrayList<Graduate>();
		try {
			String sql = "select gid,name,tutor from Graduate";
			ResultSet rs = DBHelper.executeQuery(sql);
			while (rs.next()) {
				Graduate gra=new Graduate();
				gra.setId(rs.getString(1));
				gra.setName(rs.getString(2));
				gra.setFtutor(rs.getString(3));
				glist.add(gra);
			}
			DBHelper.closeConnection();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return glist;
	}

}
