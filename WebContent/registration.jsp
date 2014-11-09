<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration | <%=application.getInitParameter("title")%></title>
</head>
<body>
	<form action="registratorUser" method="post">
		<table>
			<tr>
				<td colspan="3"><font color="red"><%=request.getAttribute("msg")!=null ? request.getAttribute("msg") : "" %></font></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td>:</td>
				<td><input name="fname" placeholder="First Name" /></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td>:</td>
				<td><input name="lname" placeholder="Last Name" /></td>
			</tr>
			<tr>
				<td>User name</td>
				<td>:</td>
				<td><input name="username" placeholder="Login Username" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td>:</td>
				<td><input type="password" name="password" placeholder="password" /></td>
			</tr>
			<tr>
				<td>Designation</td>
				<td>:</td>
				<td><input name="designation" placeholder="Designation" /></td>
			</tr>
			<tr>
				<td>Qualification</td>
				<td>:</td>
				<td><input name="qualification" placeholder="Qualification" /></td>
			</tr>
			<tr>
				<td>Address</td>
				<td>:</td>
				<td><textarea name="address" cols="19" rows="4" placeholder="Address"></textarea></td>
			</tr>
			<tr>
				<td>E-mail Address</td>
				<td>:</td>
				<td><input name="e-mail" placeholder="e-mail@domain.com" /></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td>:</td>
				<td><input name="contactNumber" placeholder="+91 9999999999" /></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="Submit" /> <input type="reset"
					value="Reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>