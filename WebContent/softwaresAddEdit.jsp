<%@page import="com.dts.model.Software"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Software/Project Add or Edit | <%=application.getInitParameter("title")%></title>
</head>
<body>
	<form action="softwares" method="post">
	<%
	String id = "";
	String name = "";
	String desc = "";
	if(request.getAttribute("software")!=null && request.getAttribute("software") instanceof Software){
		Software software = (Software)request.getAttribute("software");
		id = software.getId()+"";
		name = software.getSoftwareName();
		desc = software.getDescription();
	}
	%>
		<input type="hidden" name="id" value="<%=id%>">
		<table>
			<tr>
				<td>Software/Project Name</td>
				<td>:</td>
				<td><input name="softwareName" value="<%=name%>"/></td>
			</tr>
			<tr>
				<td>Software/Project Description</td>
				<td>:</td>
				<td><input name="softwareDesc" value="<%=desc%>"/></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="Save Or Update"><input
					type="reset"></td>
			</tr>
		</table>

	</form>
</body>
</html>