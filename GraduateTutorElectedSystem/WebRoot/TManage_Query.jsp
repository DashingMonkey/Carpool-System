<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>教师界面</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/templatemo-style.css" rel="stylesheet">
</head>
<body>
	<!-- Left column -->
	<div class="templatemo-flex-row">
		<div class="templatemo-sidebar">
			<header class="templatemo-site-header">
			<h1>教师窗口</h1>
			</header>
			<div class="profile-photo-container">
				<img src="Image/school.png" alt="School Photo"
					class="img-responsive">
				<div class="profile-photo-overlay"></div>
			</div>
			<nav class="templatemo-left-nav">
			<ul>
				<li><a href="noticeservlet?opttype=TqueryLatest">查看公告</a></li>
				<li><a href="tutorservlet?opttype=showTchose">选择学生</a></li>
				<li><a href="graduateservlet?opttype=Tquery" class="active">查看学生</a></li>
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
						<li class="user">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎你，<%=session.getAttribute("UserName")%></li>
						<li><a href="TManage_Changepwd.jsp">修改密码</a></li>
						<li><a href="TShowInfo.jsp">我的信息</a></li>
					</ul>
					</nav>
				</div>
			</div>
			<div class="templatemo-content-container">
				<div class="templatemo-content-widget no-padding">
					<div class="panel panel-default table-responsive">
						<table
							class="table table-striped table-bordered templatemo-user-table">
							<thead>
								<tr>
									<td><a class="white-text templatemo-sort-by">学生准考证 </a></td>
									<td><a class="white-text templatemo-sort-by">学生姓名 </a></td>
									<td><a class="white-text templatemo-sort-by">学生性别 </a></td>
									<td><a class="white-text templatemo-sort-by">学生专业 </a></td>
									<td><a class="white-text templatemo-sort-by">学生电话 </a></td>
									<td><a class="white-text templatemo-sort-by">备注信息 </a></td>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${glistfort}" var="gra">
									<tr>
										<td>${gra.ticketnum }</td>
										<td>${gra.name }</td>
										<td>${gra.sex }</td>
										<td>${gra.major }</td>
										<td>${gra.tel }</td>
										<td>${gra.remark }</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
				<h6>&nbsp;&nbsp;*表格只显示本专业的学生</h6>
				<footer class="text-right">
				<p>大作业-研究生导师双选系统-by许继中</p>
				</footer>
			</div>
		</div>
	</div>
</body>
</html>