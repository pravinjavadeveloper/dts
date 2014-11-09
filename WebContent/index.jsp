<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><%=application.getInitParameter("title")%></title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<tr>
				<td colspan="3"><font color="red"><%=request.getAttribute("msg")!=null ? request.getAttribute("msg") : "" %></font></td>
			</tr>
			<tr>
				<td>User Name</td>
				<td>:</td>
				<td><input name="username" placeholder="username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password" placeholder="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="Login" /> <input type="reset"
					value="Reset" /></td>
			</tr>
			<tr>
				<td>New User</td>
				<td></td>
				<td><a href="registration.jsp">Register New user</a></td>
			</tr>
		</table>
	</form>
</body>
</html>