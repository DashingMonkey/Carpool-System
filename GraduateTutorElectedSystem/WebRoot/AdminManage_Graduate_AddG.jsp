<%@page import="entity.Major"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>管理员界面</title>
<link href="CSS/bootstrap.min.css" rel="stylesheet">
<link href="CSS/templatemo-style.css" rel="stylesheet">
<script type="text/javascript">
	function check() {
		if (document.form.id.value == "") {
			alert("身份证号号不能为空！");
			return false;
		} else if (document.form.ticketnum.value == "") {
			alert("准考证号不能为空！");
			return false;
		} else if (document.form.name.value == "") {
			alert("姓名不能为空！");
			return false;
		} else if (document.form.sex.value == "") {
			alert("性别不能为空！");
			return false;
		} else if (document.form.birth.value == "") {
			alert("生日不能为空！");
			return false;
		} else if (document.form.major.value == "") {
			alert("专业不能为空！");
			return false;
		}

		return true;
	}
</script>
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
				<li><a href="tutorservlet?opttype=query">教师管理</a></li>
				<li><a href="graduateservlet?opttype=query" class="active">学生管理</a></li>
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
					<h2 class="margin-bottom-10">添加学生</h2>
					<div class="panel panel-default no-border">
						<form action="graduateservlet" method="post" name="form"
							onsubmit="return check();">
							<table class="table table-striped table-bordered">
								<tr>
									<td>身份证号</td>
									<td><input type="text" id="id" name="id"></td>
								</tr>
								<tr>
									<td>考号</td>
									<td><input type="text" id="ticketnum" name="ticketnum"></td>
								</tr>
								<tr>
									<td>姓名</td>
									<td><input type="text" id="name" name="name"></td>
								</tr>
								<tr>
									<td>性别</td>
									<td><input type="radio" name="sex" value="男" checked />男
										<input type="radio" name="sex" value="女" />女</td>
								</tr>
								<tr>
									<td>生日</td>
									<td><input type="date" id="birth" name="birth"></td>
								</tr>
								<tr>
									<td>专业</td>
									<td><select id="major" name="major">
											<%
												List<Major> list = (List) session.getAttribute("mlist");
												for (int i = 0; i < list.size(); i++) {
													Major maj = list.get(i);
											%>
											<option value="<%=maj.getMajor()%>"><%=maj.getMajor()%></option>
											<%
												}
											%>

									</select></td>
								</tr>
								<tr>
									<td>电话</td>
									<td><input type="text" id="tel" name="tel"></td>
								</tr>
								<tr>
									<td>备注</td>
									<td><input type="text" id="remark" name="remark"></td>
								</tr>
							</table>
							<h6>&nbsp;&nbsp;*初始密码为身份证后6位</h6>
							<button type="submit" name="opttype" value="add">添加</button>
						</form>
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