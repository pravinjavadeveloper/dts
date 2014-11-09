<%@page import="com.dts.model.Software"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Software/Project | <%=application.getInitParameter("title")%></title>
<script type="text/javascript">
function submitFormForDelete(id){
	document.getElementById("deleteSoftwareId").value = id;
	document.getElementById("editSoftwareId").value = '';
	document.getElementById("formName").submit();
}
function submitFormForEdit(id){
	document.getElementById("deleteSoftwareId").value = '';
	document.getElementById("editSoftwareId").value = id;
	document.getElementById("formName").submit();
}
</script>
</head>
<body>
	<a href="softwaresAddEdit">Add New Software/Project</a><br/>
	<form id="formName" action="softwaresAddEdit" method="post">
		<input type="hidden" name="editSoftwareId" id="editSoftwareId">
		<input type="hidden" name="deleteSoftwareId" id="deleteSoftwareId">
		<table border="1" style="width:80%; padding: 2px;">
			<tr>
				<th width="25%"></th>
				<th width="25%">Software/Project</th>
				<th width="25%">Description</th>
				<th width="25%">Last Modified</th>
			</tr>
			<%
			if(request.getAttribute("softwares")!=null && request.getAttribute("softwares") instanceof List){
				List<Software> softwares = (List<Software>) request.getAttribute("softwares");
				for(int i=0; i<softwares.size(); i++){		
			%>
			<tr>
				<td><input type="button" onclick="submitFormForEdit(<%=softwares.get(i).getId()%>);" value="Edit Software"/>&nbsp;&nbsp;&nbsp;
				<input type="button" onclick="submitFormForDelete(<%=softwares.get(i).getId()%>);" value="Delete Software"/></td>
				<td><%=softwares.get(i).getSoftwareName() %></td>
				<td><%=softwares.get(i).getDescription() %></td>
				<td><%=softwares.get(i).getModifiedDate() %></td>
			</tr>
			<%
				}
			}
			%>
		</table>
	</form>
</body>
</html>