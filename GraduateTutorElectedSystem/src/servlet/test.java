package servlet;

import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBHelper;

public class test {

	public static void main(String[] args) throws SQLException {
		String sql1 = "select graduate1 from tutor where tid=20011988";
		ResultSet rs1 = DBHelper.executeQuery(sql1);
		String sql2 = "select graduate2 from tutor where tid=20011988";
		ResultSet rs2 = DBHelper.executeQuery(sql2);
		String sql3 = "select graduate3 from tutor where tid=20011988";
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
		System.out.print(a);
		//System.out.print(b);
	//	System.out.print(c);
		if (a == null || a.equals("")) {
			System.out.print("第一个栏位空着");
		} else if (b == null|| a.equals("")) {
			System.out.print("第二个栏位空着");
		} else if (c == null|| a.equals("")) {
			System.out.print("第三个栏位空着");
		}
	}
}
