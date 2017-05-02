<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>乘客主页</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/templatemo-style.css" rel="stylesheet">
</head>
<body>
	<!-- Left column -->
	<div class="templatemo-flex-row">
		<div class="templatemo-sidebar">
			<header class="templatemo-site-header">
			<h1>乘客窗口</h1>
			</header>
			<div class="profile-photo-container">
				<img src="Image/school.png" alt="School Photo"
					class="img-responsive">
				<div class="profile-photo-overlay"></div>
			</div>
			<nav class="templatemo-left-nav">
			<ul>
				<li><a href="noticeservlet?opttype=AqueryLatest">出发打车</a></li>
				<li><a href="graduateservlet?opttype=GraduateChosen" class="active">拼车</a></li>
				<li><a href="AdminManage_SystemFunction.jsp">系统设置</a></li>
				<li><a href="Home.jsp">退出登录</a></li>
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
					<h2 class="margin-bottom-10">地图</h2>
					<div class="panel panel-default no-border">
						<div class="profile-photo-container">
							<img src="Image/school.png" alt="School Photo"
								class="img-responsive">
								<img src="Image/school.png" alt="School Photo"
								class="img-responsive">
						</div>
						
					</div>
					
			
				</div>
			
				<footer class="text-right">
				<p>大作业-拼车系统-by许继中</p>
				</footer>
			</div>
		</div>
	</div>


</body>
</html>
