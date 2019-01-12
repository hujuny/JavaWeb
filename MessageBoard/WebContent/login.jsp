<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="margin-left: 35%; margin-top: 100px; font-family: Microsoft YaHei">
		<h1>登录界面</h1>
		<form action="LoginServlet" method="post">
			<table>
				<tr>
					<td>账号:</td>
					<td><input name="name" type="text"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td ><input name="password" type="password"></td>
				</tr>
			</table>
			<input type="submit"  value="登录" style="font-size: 16px"> 
			&nbsp;&nbsp;<a href="register.jsp">注册</a>
		</form>
	</div>
</body>

</html>