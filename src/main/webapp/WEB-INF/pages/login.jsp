<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
</head>

<body>
	<h1>登录页面----${message }</h1>
	<form action="/login" method="post">
		用户名：
		<input type="text" name="username" /><br />
		密码：
		<input type="password" name="password" /><br />
		验证码:
		<img alt="" src="/validatecode.jsp" onclick="this.src='/validatecode.jsp?'+Math.random()" >
		<input type="text" name="randomcode" /> <br>
		<input type="checkbox" name="rememberMe" />自动登录<br />
		<input type="submit" value="Submit" />
	</form>
</body>
</html>
