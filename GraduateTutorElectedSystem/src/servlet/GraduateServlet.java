package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.GraduateDao;
import entity.Graduate;
import entity.Tutor;

public class GraduateServlet extends HttpServlet {
	GraduateDao dao = new GraduateDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opttype = request.getParameter("opttype");
		if ("add".equals(opttype)) {
			String id = request.getParameter("id");
			int ticketnum = Integer.valueOf(request.getParameter("ticketnum"));
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String birth = request.getParameter("birth");
			String major = request.getParameter("major");
			String tel = request.getParameter("tel");
			String remark = request.getParameter("remark");
			String pwd = id.substring(12, 18);
			if (dao.addGraduate(id, ticketnum, name, sex, birth, major, tel,
					remark, pwd) > 0) {
				response.sendRedirect("graduateservlet?opttype=query");
			}
		} else if ("delete".equals(opttype)) {
			String id = request.getParameter("id");
			if (dao.deleteGraduate(id) > 0) {
				response.sendRedirect("graduateservlet?opttype=query");
			}
		} else if ("preupdate".equals(opttype)) {
			String id = request.getParameter("id");
			Graduate upgra = dao.queryGraduateByID(id);
			request.getSession().setAttribute("upgra", upgra);
			response.sendRedirect("AdminManage_Graduate_UpdateG.jsp");
		} else if ("update".equals(opttype)) {
			String id = request.getParameter("id");
			int ticketnum = Integer.valueOf(request.getParameter("ticketnum"));
			String name = request.getParameter("name");
			String sex = request.getParameter("sex");
			String birth = request.getParameter("birth");
			String major = request.getParameter("major");
			String tel = request.getParameter("tel");
			String remark = request.getParameter("remark");
			String pwd = request.getParameter("pwd");
			if (dao.updateGraduate(id, ticketnum, name, sex, birth, major, tel,
					remark, pwd) > 0) {
				response.sendRedirect("graduateservlet?opttype=query");
			}
		} else if ("query".equals(opttype)) {
			List<Graduate> glist = dao.queryGraduate();
			request.getSession().setAttribute("glist", glist);
			response.sendRedirect("AdminManage_Graduate.jsp");
		} else if ("Tquery".equals(opttype)) {
			String major = request.getSession().getAttribute("major")
					.toString();
			List<Graduate> glist = dao.TqueryGraduate(major);
			request.getSession().setAttribute("glistfort", glist);
			response.sendRedirect("TManage_Query.jsp");
		} else if ("login".equals(opttype)) {
			String id = request.getParameter("gid");
			String pwd = request.getParameter("gpwd");
			try {
				Graduate graduate = dao.login(id, pwd);
				if (graduate != null) {
					String ticketnum = String.valueOf(graduate.getTicketnum());
					String name = graduate.getName();
					String sex = graduate.getSex();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date birth = graduate.getBirth();
					String str = sdf.format(birth);
					String major = graduate.getMajor();
					String tel = graduate.getTel();
					String remark = graduate.getRemark();
					HttpSession session = request.getSession();
					session.setAttribute("UserID", id);
					session.setAttribute("ticketnum", ticketnum);
					session.setAttribute("UserName", name);
					session.setAttribute("sex", sex);
					session.setAttribute("birth", str);
					session.setAttribute("major", major);
					session.setAttribute("tel", tel);
					session.setAttribute("remark", remark);
					session.setAttribute("pwd", pwd);
					response.sendRedirect("noticeservlet?opttype=GqueryLatest");
				} else {
					response.sendRedirect("110.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("GraduateChosen".equals(opttype)) {
			List<Graduate> unchosenglist = dao.unchosenGraduate();
			request.getSession().setAttribute("unchosenglist", unchosenglist);
			response.sendRedirect("AdminManage_Chose.jsp");
		} else if ("changePwd".equals(opttype)) {
			String id = request.getSession().getAttribute("UserID").toString();
			String pwd = request.getParameter("pwd");
			try {
				if (dao.changePassword(pwd, id) > 0) {
					response.sendRedirect("GLogin.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("showGchose".equals(opttype)) {
			String id = request.getSession().getAttribute("UserID").toString();
			Graduate gra = dao.showGchose(id);
			String tutor1 = gra.getTutor1();
			String tutor2 = gra.getTutor2();
			String tutor3 = gra.getTutor3();
			String Ftutor = gra.getFtutor();
			request.getSession().setAttribute("tutor1", tutor1);
			request.getSession().setAttribute("tutor2", tutor2);
			request.getSession().setAttribute("tutor3", tutor3);
			request.getSession().setAttribute("finaltutor", Ftutor);
			String major = request.getSession().getAttribute("major")
					.toString();
			List<Tutor> tlist = dao.GqueryTutor(major);
			request.getSession().setAttribute("tlistforg", tlist);
			response.sendRedirect("GManage_Chose.jsp");
		} else if ("updateGchose".equals(opttype)) {
			String id = request.getSession().getAttribute("UserID").toString();
			String tutor1 = request.getParameter("tutor1");
			String tutor2 = request.getParameter("tutor2");
			String tutor3 = request.getParameter("tutor3");
			try {
				if (dao.updateGchose(id, tutor1, tutor2, tutor3) > 0) {
					response.sendRedirect("graduateservlet?opttype=showGchose");
				} else {
					response.sendRedirect("120.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.close();
	}

}