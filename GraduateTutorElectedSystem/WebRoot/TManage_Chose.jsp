<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<title>教师界面</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/templatemo-style.css" rel="stylesheet">
<script type="text/javascript">
	function check() {
		var a = "<%=application.getAttribute("TchoseFunction")%>";
		var b = "open";
		if (a==b) {
			return true;
		} else {
			alert("当前选学生功能未开放！");
			return false;
		}
	}
</script>
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
				<li><a href="tutorservlet?opttype=showTchose" class="active">选择学生</a></li>
				<li><a href="graduateservlet?opttype=Tquery">查看学生</a></li>
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
						<li class="user">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;欢迎你，<%=session.getAttribute("UserName")%>
						<li><a href="TManage_Changepwd.jsp">修改密码</a></li>
						<li><a href="TShowInfo.jsp">我的信息</a></li>
					</ul>
					</nav>
				</div>
			</div>
			<div class="templatemo-content-container">
				<div class="templatemo-content-widget white-bg">
					<div class="panel panel-default no-border">
						<div class="panel-heading border-radius-10">
							<h2>我的学生</h2>
						</div>
						<div class="panel-body">
							<div
								class="templatemo-flex-row flex-content-row margin-bottom-30">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<th>学生准考证号</th>
											<th>学生姓名</th>
											<th>学生性别</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${tchoselist}" var="gra">
											<tr>
												<td>${gra.ticketnum }</td>
												<td>${gra.name }</td>
												<td>${gra.sex }</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<h6>&nbsp;*每个教师只能选择3名学生</h6>
						</div>
					</div>
					<div class="panel panel-default no-border">
						<div class="panel-heading border-radius-10">
							<h2>选择你的学生</h2>
						</div>
						<div class="panel-body">
							<div class="templatemo-flex-row flex-content-row">
								<table class="table table-striped table-bordered">
									<thead>
										<tr>
											<td>学生准考证号</td>
											<td>学生姓名</td>
											<td>选择</td>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${GchoseUlist}" var="gra">
											<tr>
												<td>${gra.ticketnum }</td>
												<td>${gra.name }</td>
												<td><a
													href="tutorservlet?opttype=TchoseG&Gid=${gra.id}" onclick="return check();">选择</a></td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<h6>&nbsp;*提交后不能修改</h6>
						</div>
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