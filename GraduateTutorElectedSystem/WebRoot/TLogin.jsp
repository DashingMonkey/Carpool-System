<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>��ʦ��¼</title>
<link rel="stylesheet" href="CSS/main.css">
<script type="text/javascript">
	function check() {
		if (document.form.id.value == "") {
			alert("�˺Ų���Ϊ�գ�");
			return false;
		} else if (document.form.ticketnum.value == "") {
			alert("���벻��Ϊ�գ�");
			return false;
		}
		return true;
	}
</script>
</head>

<body>
	<div class="login-form">
		<h1>��ʦ��¼</h1>
		<form action="tutorservlet" method="post" name="form" onsubmit="return check();">
			<div class="form-group ">
				<input type="text" class="form-control" placeholder="��ʦ�� " id="id"
					name="tid"
					onkeyup="(this.v=function(){this.value=this.value.replace(/[^0-9-]+/,'');}).call(this)"
					onblur="this.v();" >
			</div>
			<div class="form-group log-status">
				<input type="password" class="form-control" placeholder="����"
					id="pwd" name="tpwd">
			</div>
			<span class="alert">Invalid Credentials</span> <a class="link"
				href="LostPwd.jsp">Lost your password?</a>
			<button type="submit" class="log-btn"
				name="opttype" value="login">��¼</button>
		</form>
	</div>

</body>
</html>