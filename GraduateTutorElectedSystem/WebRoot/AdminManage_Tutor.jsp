<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
				<li><a href="noticeservlet?opttype=AqueryLatest">修改公告</a></li>
				<li><a href="graduateservlet?opttype=GraduateChosen">师生互选</a></li>
				<li><a href="tutorservlet?opttype=query" class="active">教师管理</a></li>
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
					<h2 class="margin-bottom-10">所有导师</h2>
					<a href="adminservlet?opttype=showaddT">新增教师</a>
					<div class="panel panel-default no-border">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th>教师号</th>
									<th>教师姓名</th>
									<th>教师专业</th>
									<th>教师信息</th>
									<th>密码</th>
									<th>修改</th>
									<th>删除</th>
								</tr>
							</thead>

							<tbody>
								<c:forEach items="${tlist}" var="tut">
									<tr>
										<td>${tut.id }</td>
										<td>${tut.name }</td>
										<td>${tut.major }</td>
										<td>${tut.info }</td>
										<td>${tut.pwd }</td>
										<td><a href="tutorservlet?opttype=preupdate&id=${tut.id }">修改</a></td>
										<td><a href="tutorservlet?opttype=delete&id=${tut.id }">删除</a></td>
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