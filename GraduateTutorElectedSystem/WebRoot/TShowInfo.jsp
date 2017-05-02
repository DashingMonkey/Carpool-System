<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>查看个人信息</title>
</head>

<body>
	<center>
		<%=session.getAttribute("UserID")%>
		<%=session.getAttribute("UserName")%>
		<%=session.getAttribute("major")%>
		<%=session.getAttribute("info")%>
	</center>
</body>
</html>
