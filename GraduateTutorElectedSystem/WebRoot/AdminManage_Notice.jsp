<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员界面</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/templatemo-style.css" rel="stylesheet">
</head>
<body>
	<!-- Left column -->
	<div class="templatemo-flex-row">
		<div class="templatemo-sidebar">
			<header class="templatemo-site-header">
			<h1>管理员窗口</h1>
			</header>
			<div class="profile-photo-container">
				<img src="Image/school.png" alt="School Photo"
					class="img-responsive">
				<div class="profile-photo-overlay"></div>
			</div>
			<nav class="templatemo-left-nav">
			<ul>
				<li><a href="noticeservlet?opttype=AqueryLatest" class="active">修改公告</a></li>
				<li><a href="graduateservlet?opttype=GraduateChosen">师生互选</a></li>
				<li><a href="tutorservlet?opttype=query">教师管理</a></li>
				<li><a href="graduateservlet?opttype=query">学生管理</a></li>
				<li><a href="majorservlet?opttype=query">专业管理</a></li>
				<li><a href="AdminManage_SystemFunction.jsp">系统功能</a></li>
				<li><a href="home.jsp">退出登录</a></li>
			</ul>
			</nav>
		</div>
		<!-- Main content -->
		<div class="templatemo-content col-1 light-gray-bg">
			<div class="templatemo-top-nav-container">
				<div class="row">
					<nav class="templatemo-top-nav col-lg-12 col-md-12">
					<ul class="text-uppercase">
						<li class="user">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎你，<%=session.getAttribute("UserID")%>
						<li><a href="AdminManage_Changepwd.jsp">修改密码</a></li>
					</ul>
					</nav>
				</div>
			</div>
			<div class="templatemo-content-container">
				<div class="templatemo-content-widget white-bg">
					<h2 class="margin-bottom-10">所有公告</h2>
					<a href="AdminManage_Notice_AddN.jsp">新增公告</a>
					<div class="panel panel-default no-border">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>时间</th>
									<th>标题</th>
									<th>内容</th>
									<th>删除</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${nlist}" var="no">
									<tr>
										<td><fmt:formatDate type="both" value="${no.time}" /></td>
										<td>${no.title }</td>
										<td>${no.content }</td>
										<td><a
											href="noticeservlet?opttype=delete&time=${no.time}">删除</a></td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<footer class="text-right">
				<p>大作业-研究生导师双选系统-by许继中</p>
				</footer>
			</div>
		</div>
	</div>


</body>
</html>