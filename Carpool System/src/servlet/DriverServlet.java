package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.DriverDao;
import entity.Driver;
import entity.Passenger;

public class DriverServlet extends HttpServlet {
	DriverDao dao = new DriverDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opttype = request.getParameter("opttype");
		if ("add".equals(opttype)) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			if (dao.addAdmin(id, name) > 0) {
				response.sendRedirect("graduate.action?opttype=query");
			}
		} else if ("delete".equals(opttype)) {
			String id = request.getParameter("id");
			if (dao.deleteAdmin(id) > 0) {
				response.sendRedirect("graduate.action?opttype=query");
			}
		} else if ("query".equals(opttype)) {
			List<Admin> clist = dao.queryAdmins();
			request.getSession().setAttribute("clist", clist);
			response.sendRedirect("AdminView.jsp");
		} else if ("login".equals(opttype)) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			try {
				Admin admin = dao.login(id, pwd);
				if (admin != null) {
					HttpSession session = request.getSession();
					session.setAttribute("UserID", id);
					session.setAttribute("pwd", pwd);

					response.sendRedirect("noticeservlet?opttype=AqueryLatest");
				} else {
					response.sendRedirect("110.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("changePwd".equals(opttype)) {
			String id = request.getSession().getAttribute("UserID").toString();
			String pwd = request.getParameter("pwd");
			try {
				if (dao.changePassword(pwd, id) > 0) {
					response.sendRedirect("AdminLogin.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("showTforunchosenG".equals(opttype)) {
			String Gid = request.getParameter("Gid");
			List<Tutor> tlist = dao.queryTforunchosenG(Gid);
			request.getSession().setAttribute("TforunchosenG", tlist);
			request.getSession().setAttribute("unchosenGid", Gid);
			response.sendRedirect("AdminManage_Chose_SelectT.jsp");
		} else if ("finalchoseT".equals(opttype)) {
			String gid = request.getSession().getAttribute("unchosenGid")
					.toString();
			String tid = request.getParameter("Tid");
			try {
				if (dao.AchoseTforG(tid, gid) > 0) {
					response.sendRedirect("graduateservlet?opttype=GraduateChosen");
				} else {
					response.sendRedirect("120.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("showaddG".equals(opttype)) {
			List<Major> mlist = dao.queryMajors();
			request.getSession().setAttribute("mlist", mlist);
			response.sendRedirect("AdminManage_Graduate_AddG.jsp");
		} else if ("showaddT".equals(opttype)) {
			List<Major> mlist = dao.queryMajors();
			request.getSession().setAttribute("mlist", mlist);
			response.sendRedirect("AdminManage_Tutor_AddT.jsp");
		} else if ("openGchose".equals(opttype)) {
			ServletContext application = this.getServletContext();
			application.setAttribute("GchoseFunction", "open");
			response.sendRedirect("AdminManage_SystemFunction.jsp");
		} else if ("openTchose".equals(opttype)) {
			ServletContext application = this.getServletContext();
			application.setAttribute("TchoseFunction", "open");
			response.sendRedirect("AdminManage_SystemFunction.jsp");
		} else if ("closeGchose".equals(opttype)) {
			ServletContext application = this.getServletContext();
			application.setAttribute("GchoseFunction", "close");
			response.sendRedirect("AdminManage_SystemFunction.jsp");
		} else if ("closeTchose".equals(opttype)) {
			ServletContext application = this.getServletContext();
			application.setAttribute("TchoseFunction", "close");
			response.sendRedirect("AdminManage_SystemFunction.jsp");
		} else if ("showchosen".equals(opttype)) {
			List<Graduate> glist = dao.queryChosen();
			request.getSession().setAttribute("showchosen", glist);
			response.sendRedirect("AdminManage_Chose_Showchosen.jsp");
		}
		out.close();
	}
}
