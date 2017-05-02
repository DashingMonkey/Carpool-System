<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>管理员登录</title>
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
		<h1>管理员登录</h1>
		<form action="adminservlet" method="post" name="form"
			onsubmit="return check();">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="账号" id="id"
					name="id">
			</div>
			<div class="form-group log-status">
				<input type="password" class="form-control" placeholder="密码"
					id="pwd" name="pwd">
			</div>
			<button type="submit" class="log-btn" name="opttype" value="login">登录</button>
		</form>
	</div>

</body>
</html>