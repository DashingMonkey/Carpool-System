<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生登录</title>
<link rel="stylesheet" href="CSS/main.css">
<script type="text/javascript">
	function check() {
		if (document.form.id.value == "") {
			alert("账号不能为空！");
			return false;
		} else if (document.form.ticketnum.value == "") {
			alert("密码不能为空！");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div class="login-form">
		<h1>研究生登录</h1>
		<form action="graduateservlet" method="post" name="form"
			onsubmit="return check();">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="身份证号" id="id"
					name="gid">
			</div>
			<div class="form-group log-status">
				<input type="password" class="form-control" placeholder="密码"
					id="pwd" name="gpwd">
			</div>
			<span class="alert">Invalid Credentials</span> <a class="link"
				href="LostPwd.jsp">Lost your password?</a>
			<button type="submit" onclick="check()" class="log-btn"
				name="opttype" value="login">登录</button>
		</form>
	</div>

</body>
</html>