<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生界面</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/templatemo-style.css" rel="stylesheet">
<script type="text/javascript">
	function check() {
		var a = "<%=application.getAttribute("GchoseFunction")%>";
		var b = "open";
		if (a==b) {
			return true;
		} else {
			alert("当前选导师功能未开放！");
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
			<h1>学生窗口</h1>
			</header>
			<div class="profile-photo-container">
				<img src="Image/school.png" alt="School Photo"
					class="img-responsive">
				<div class="profile-photo-overlay"></div>
			</div>
			<nav class="templatemo-left-nav">
			<ul>
				<li><a href="noticeservlet?opttype=GqueryLatest">查看公告</a></li>
				<li><a href="graduateservlet?opttype=showGchose" class="active">选择导师</a></li>
				<li><a href="tutorservlet?opttype=Gquery">查看导师</a></li>
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
						<li><a href="GManage_Changepwd.jsp">修改密码</a></li>
						<li><a href="GShowInfo.jsp">我的信息</a></li>
					</ul>
					</nav>
				</div>
			</div>
			<div class="templatemo-content-container">
				<div class="templatemo-content-widget white-bg">
					<div class="panel panel-default no-border">
						<div class="panel-heading border-radius-10">
							<h2>我的志愿</h2>
						</div>
						<div class="panel-body">
							<div
								class="templatemo-flex-row flex-content-row margin-bottom-30">
								<table class="table table-striped table-bordered">
									<tr>
										<th>我的选择</th>
										<th>教师姓名</th>
									</tr>
									<tr>
										<td>志愿1</td>
										<td><%=session.getAttribute("tutor1")%></td>
									</tr>
									<tr>
										<td>志愿2</td>
										<td><%=session.getAttribute("tutor2")%></td>
									</tr>
									<tr>
										<td>志愿3</td>
										<td><%=session.getAttribute("tutor3")%></td>
									</tr>
									<tr>
										<td>最终教师</td>
										<td><%=session.getAttribute("finaltutor")%></td>
									</tr>
								</table>
							</div>
							<h6>&nbsp;&nbsp;*同一个老师多选无效</h6>
						</div>
					</div>
					<form action="graduateservlet" method="post" name="form"
						onsubmit="return check();">
						<div class="panel panel-default no-border">
							<div class="panel-heading border-radius-10">
								<h2>选择志愿</h2>
							</div>
							<div class="panel-body">
								<div
									class="templatemo-flex-row flex-content-row margin-bottom-30">
									<table class="table table-striped table-bordered">
										<thead>
											<tr>
												<td>教师号</td>
												<td>教师姓名</td>
												<td>志愿1</td>
												<td>志愿2</td>
												<td>志愿3</td>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${tlistforg}" var="tut">
												<tr>
													<td>${tut.id }</td>
													<td>${tut.name }</td>
													<td><input type="radio" name="tutor1"
														value="${tut.name }"></td>
													<td><input type="radio" name="tutor2"
														value="${tut.name }"></td>
													<td><input type="radio" name="tutor3"
														value="${tut.name }"></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
								<button type="submit" name="opttype" value="updateGchose">提交志愿</button>
							</div>
						</div>
					</form>
				</div>
				<footer class="text-right">
				<p>大作业-研究生导师双选系统-by许继中</p>
				</footer>
			</div>
		</div>
	</div>
</body>
</html>