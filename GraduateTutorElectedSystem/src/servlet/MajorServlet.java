package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MajorDao;
import entity.Major;
import entity.Tutor;

public class MajorServlet extends HttpServlet {
	MajorDao dao = new MajorDao();

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
			String major = request.getParameter("major");
			String mid = request.getParameter("mid");
			String depa = request.getParameter("depa");
			if (dao.addMajor(major, mid, depa) > 0) {
				response.sendRedirect("majorservlet?opttype=query");
			}
		} else if ("delete".equals(opttype)) {
			String id = request.getParameter("id");
			if (dao.deleteMajor(id) > 0) {
				response.sendRedirect("majorservlet?opttype=query");
			}
		} else if ("preupdate".equals(opttype)) {
			String mid = request.getParameter("mid");
			Major upmaj = dao.queryMajorByID(mid);
			request.getSession().setAttribute("upmaj", upmaj);
			response.sendRedirect("AdminManage_Major_UpdateM.jsp");
		} else if ("update".equals(opttype)) {
			String mid = request.getParameter("mid");
			String major = request.getParameter("major");
			String depa = request.getParameter("depa");
			if (dao.updateMajor(mid, major, depa) > 0) {
				response.sendRedirect("majorservlet?opttype=query");
			}
		} else if ("query".equals(opttype)) {
			List<Major> mlist = dao.queryMajors();
			request.getSession().setAttribute("mlist", mlist);
			response.sendRedirect("AdminManage_Major.jsp");
		}
		out.close();
	}

}