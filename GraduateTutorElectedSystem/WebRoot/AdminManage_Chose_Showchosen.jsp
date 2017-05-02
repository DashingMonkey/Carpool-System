<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>查看选择情况</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>

<body>
	<%
		String exportToExcel = request.getParameter("exportToExcel");
		if (exportToExcel != null
				&& exportToExcel.toString().equalsIgnoreCase("YES")) {
			response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition", "inline; filename="
					+ "excel.xls");

		}
	%>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>学号</th>
				<th>学生姓名</th>
				<th>教师号</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${showchosen}" var="gra">
				<tr>
					<td>${gra.id }</td>
					<td>${gra.name }</td>
					<td>${gra.ftutor }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<%
		if (exportToExcel == null) {
	%>
	<a href="AdminManage_Chose_Showchosen.jsp?exportToExcel=YES">导出</a>
	<%
		}
	%>
</body>
</html>
