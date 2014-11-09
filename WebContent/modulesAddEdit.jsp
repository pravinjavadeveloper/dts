<%@page import="com.dts.service.SoftwareService"%>
<%@page import="com.dts.model.Software"%>
<%@page import="java.util.List"%>
<%@page import="com.dts.model.Module"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modules Add or Edit | <%=application.getInitParameter("title")%></title>
</head>
<body>
	<form action="modules" method="post">
	<%
	String id = "";
	String name = "";
	String desc = "";
	String software = "";
	if(request.getAttribute("module")!=null && request.getAttribute("module") instanceof Module){
		Module module = (Module)request.getAttribute("module");
		id = module.getId()+"";
		name = module.getModuleName();
		desc = module.getDescription();
		software = module.getSoftware();
	}
	
	List<Software> softwares = SoftwareService.getAllsoftwares();
	%>
		<input type="hidden" name="id" value="<%=id%>">
		<table>
			<tr>
				<td>Module Name</td>
				<td>:</td>
				<td><input name="moduleName" value="<%=name%>"/></td>
			</tr>
			<tr>
				<td>Module Description</td>
				<td>:</td>
				<td><input name="moduleDesc" value="<%=desc%>"/></td>
			</tr>
			<tr>
				<td>Software/Project</td>
				<td>:</td>
				<td>
				<select name="softwareId">
					<%
					for(int i=0;i<softwares.size();i++){
						if(softwares.get(i).getId().equals(software)){
							%>
							<option value="<%=softwares.get(i).getId()%>" selected="selected"><%=softwares.get(i).getSoftwareName()%></option>
							<%	
						}else{
							%>
							<option value="<%=softwares.get(i).getId()%>"><%=softwares.get(i).getSoftwareName()%></option>
							<%
						}
					}
					%>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td><input type="submit" value="Save Or Update"><input type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>