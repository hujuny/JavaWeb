<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div style="text-align: center; margin-top: 140px">
		<h1>请留言</h1>
		<form action="LeaveMessage" method="post">
			<table style="margin-left: 37%" border="1">
				<caption>填写留言信息</caption>
				<tr>
					<td>留言标题</td>
					<td><input type="text" name="title" /></td>
				</tr>
				<tr>
					<td>留言内容</td>
					<td><textarea name="message" rows="5" cols="35"></textarea></td>
				</tr>
			</table>
			<input type="submit" value="提交" /> <input type="reset" value="重置" />
		</form>
		<a href="main.jsp">返回留言板界面</a>
	</div>

</body>
</html>