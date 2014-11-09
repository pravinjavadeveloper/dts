<%@page import="com.dts.model.Module"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Modules | <%=application.getInitParameter("title")%></title>
<script type="text/javascript">
function submitFormForDelete(id){
	document.getElementById("deleteModuleId").value = id;
	document.getElementById("formName").submit();
}
function submitFormForEdit(id){
	document.getElementById("editModuleId").value = id;
	document.getElementById("formName").submit();
}
</script>
</head>
<body>
	<a href="modulesAddEdit">Add New Modules</a>
	<br />
	<form id="formName" action="modulesAddEdit" method="post">
		<input type="hidden" id="editModuleId" name="editModuleId">
		<input type="hidden" id="deleteModuleId" name="deleteModuleId">
		<table border="1" style="width: 80%; padding: 2px;">
			<tr>
				<th width="20%"></th>
				<th width="20%">Module</th>
				<th width="20%">Description</th>
				<th width="20%">Software/Project</th>
				<th width="20%">Last Modified</th>
			</tr>
			<%
				if (request.getAttribute("modules") != null && request.getAttribute("modules") instanceof List) {
					List<Module> modules = (List<Module>) request.getAttribute("modules");
					for (int i = 0; i < modules.size(); i++) {
			%>
			<tr>
				<td><input type="button" onclick="submitFormForEdit(<%=modules.get(i).getId()%>)" value="Edit Module"/>&nbsp;&nbsp;&nbsp;
					<input type="button" onclick="submitFormForDelete(<%=modules.get(i).getId()%>)" value="Delete Module"/></td>
				<td><%=modules.get(i).getModuleName()%></td>
				<td><%=modules.get(i).getDescription()%></td>
				<td><%=modules.get(i).getSoftwareName()%></td>
				<td><%=modules.get(i).getModifiedDate()%></td>
			</tr>
			<%
				}
				}
			%>
		</table>
	</form>
</body>
</html>