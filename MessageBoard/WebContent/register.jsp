<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h1>注册界面</h1>
		<form action="RegisterServlet" method="post">
			<table>
				<tr>
					<td>ID:</td>
					<td><input name="id" type="text" size="20"></td>
				</tr>
				<tr>
					<td>登录名：</td>
					<td><input name="name" type="text" size="20"></td>
				</tr>
				<tr>
					<td>密码:</td>
					<td><input name="password" type="password" size="21"></td>
				</tr>
			</table>
			<input type="submit" value="注册"> <input type="reset"
				value="重置">
		</form>
		<br> <a href="login.jsp">登录</a>
	</div>
</body>
</html>