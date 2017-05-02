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

import service.PassengerDao;
import entity.Passenger;

public class PassengerServlet extends HttpServlet {
	PassengerDao dao = new PassengerDao();

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String opttype = request.getParameter("opttype");
		if ("login".equals(opttype)) {
			String id = request.getParameter("id");
			String pwd = request.getParameter("pwd");
			try {
				Passenger Passenger = dao.login(id, pwd);
				if (Passenger != null) {
					HttpSession session = request.getSession();
					session.setAttribute("UserID", id);
					session.setAttribute("pwd", pwd);

					response.sendRedirect("passengerservlet?opttype=Start");
				} else {
					response.sendRedirect("Error.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("changePwd".equals(opttype)) {
			String id = request.getSession().getAttribute("UserID").toString();
			String pwd = request.getParameter("pwd");
			try {
				if (dao.changePassword(pwd, id) > 0) {
					response.sendRedirect("Passenger_Login.jsp");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if ("Start".equals(opttype)) {
			String UserID = request.getParameter("UserID");
			//List<Tutor> tlist = dao.queryTforunchosenG(Pid);
			//request.getSession().setAttribute("TforunchosenG", tlist);
			request.getSession().setAttribute("unchosenGid", UserID);
			response.sendRedirect("AdminManage_Chose_SelectT.jsp");
		} else if ("Carpool".equals(opttype)) {
			String UserID = request.getParameter("UserID");
			//List<Tutor> tlist = dao.queryTforunchosenG(Pid);
			//request.getSession().setAttribute("TforunchosenG", tlist);
			request.getSession().setAttribute("unchosenGid", UserID);
			response.sendRedirect("AdminManage_Chose_SelectT.jsp");
		}

		out.close();
	}
}