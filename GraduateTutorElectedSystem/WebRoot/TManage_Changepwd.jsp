<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>修改密码</title>
<script type="text/javascript">
	function check() {
		if (document.form.pwd.value == "") {
			alert("密码不能为空！");
			return false;
		} else if (document.form.content.value == "") {
			alert("密码不一致！");
			return false;
		}

		return true;
	}
</script>
</head>

<body>
	<center>
		<h3>请输入新密码</h3>
		<form action="tutorservlet" method="post" onsubmit="return check();">
			<input type="password" placeholder="新密码" id="pwd" name="pwd">
			<button class="submit" name="opttype" value="changePwd">确认</button>
		</form>
	</center>
</body>
</html>

