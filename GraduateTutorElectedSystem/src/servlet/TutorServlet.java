package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Graduate;
import entity.Tutor;
import service.TutorDao;

public class TutorServlet extends HttpServlet {
	TutorDao dao = new TutorDao();

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
			int id = Integer.valueOf(request.getParameter("id"));
			String name = request.getParameter("name");
			String pwd = request.getParameter("id");
			String major = request.getParameter("major");
			String info = request.getParameter("info");
			if (dao.addTutor(id, name, major, info, pwd) > 0) {
				response.sendRedirect("tutorservlet?opttype=query");
			}
		} else if ("delete".equals(opttype)) {
			int id = Integer.valueOf(request.getParameter("id"));
			if (dao.deleteTutor(id) > 0) {
				response.sendRedirect("tutorservlet?opttype=query");
			}
		} else if ("preupdate".equals(opttype)) {
			String id = request.getParameter("id");
			Tutor uptut = dao.queryTutorByID(id);
			request.getSession().setAttribute("uptut", uptut);
			response.sendRedirect("AdminManage_Tutor_UpdateT.jsp");
		} else if ("update".equals(opttype)) {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String major = request.getParameter("major");
			String info = request.getParameter("info");
			String pwd = request.getParameter("pwd");
			if (dao.updateTutor(id, name, major, info, pwd) > 0) {
				response.sendRedirect("tutorservlet?opttype=query");
			}
		} else if ("query".equals(opttype)) {
			List<Tutor> tlist = dao.queryTutor();
			request.getSession().setAttribute("tlist", tlist);
			response.sendRedirect("AdminManage_Tutor.jsp");
		} else if ("Gquery".equals(opttype)) {
			String major = request.getSession().getAttribute("major")
					.toString();
			List<Tutor> tlist = dao.GqueryTutor(major);
			request.getSession().setAttribute("tlistforg", tlist);
			response.sendRedirect("GManage_Query.jsp");
		} else if ("login".equals(opttype)) {
			String id = request.getParameter("tid");
			String pwd = request.getParameter("tpwd");
			try {
				Tutor tutor = dao.login(id, pwd);
				if (tutor != null) {
					String name = tutor.getName();
					String major = tutor.getMajor();
					String info = tutor.getInfo();
					HttpSession session = request.getSession();
					session.setAttribute("UserName", name);
					session.setAttribute("UserID", id);
					session.setAttribute("major", major);
					session.setAttribute("info", info);
					session.setAttribute("pwd", pwd);
					response.sendRedirect("noticeservlet?opttype=TqueryLatest");
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
					response.sendRedirect("TLogin.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("showTchose".equals(opttype)) {
			String id = request.getSession().getAttribute("UserID").toString();
			List<Graduate> glist = dao.showTchose(id);
			request.getSession().setAttribute("tchoselist", glist);
			List<Graduate> GchoseUlist = dao.showGchoseU(id);
			request.getSession().setAttribute("GchoseUlist", GchoseUlist);
			response.sendRedirect("TManage_Chose.jsp");
		} else if ("TchoseG".equals(opttype)) {
			String Tid = request.getSession().getAttribute("UserID").toString();
			String Gid = request.getParameter("Gid");
			try {
				if (dao.TChoseG(Tid, Gid) > 0) {
					response.sendRedirect("tutorservlet?opttype=showTchose");
				}
				else {
					response.sendRedirect("120.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		out.close();
	}

}