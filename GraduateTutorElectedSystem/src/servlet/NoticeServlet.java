package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Notice;
import service.NoticeDao;

public class NoticeServlet extends HttpServlet {
	NoticeDao dao = new NoticeDao();

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
			Date now = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			String time = sdf.format(now);
			System.out.println(time);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			if (dao.addNotice(time, title, content) > 0) {
				response.sendRedirect("noticeservlet?opttype=AqueryLatest");
			}
		} else if ("delete".equals(opttype)) {
			String str = request.getParameter("time").substring(0, 19);
			if (dao.deleteNotice(str) > 0) {
				response.sendRedirect("noticeservlet?opttype=AqueryLatest");
			}
		} else if ("GqueryLatest".equals(opttype)) {
			List<Notice> nlist = dao.queryNoticeLatest();
			request.getSession().setAttribute("nlist", nlist);
			response.sendRedirect("GManage_Notice.jsp");
		} else if ("TqueryLatest".equals(opttype)) {
			List<Notice> nlist = dao.queryNoticeLatest();
			request.getSession().setAttribute("nlist", nlist);
			response.sendRedirect("TManage_Notice.jsp");
		} else if ("AqueryLatest".equals(opttype)) {
			List<Notice> nlist = dao.queryNoticeTitle();
			request.getSession().setAttribute("nlist", nlist);
			response.sendRedirect("AdminManage_Notice.jsp");
		}
		out.close();
	}

}