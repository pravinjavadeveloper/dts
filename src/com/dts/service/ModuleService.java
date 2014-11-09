package com.dts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dts.model.Module;
import com.dts.model.Software;
import com.dts.util.DbUtil;

public class ModuleService {

	public static List<Module> getAllModules() {
		String query = "select * from modules";
		List<Module> modules = new ArrayList<Module>(0);
		try {
			ResultSet resultSet = DbUtil.getResultSet(query);
			while(resultSet.next()){
				Module module = new Module();
				setResultSetToModule(module, resultSet);
				modules.add(module);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return modules;
	}

	private static void setResultSetToModule(Module module, ResultSet resultSet) throws SQLException {
		module.setDescription(resultSet.getString("description"));
		module.setId(resultSet.getLong("id"));
		module.setModifiedDate(resultSet.getDate("modified_date"));
		module.setModuleName(resultSet.getString("module_name"));
		String fk_id = resultSet.getString("fk_id");
		module.setSoftware(fk_id);
		try{
			Software software = SoftwareService.getSoftwareById(Long.parseLong(fk_id));
			module.setSoftwareName(software.getSoftwareName());
		}catch(Exception e){}
	}

	public static void deleteModule(Long id) {
		String query = "delete from modules where id='"+id+"'";
		try {
			DbUtil.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Module getModuleById(Long id) {
		String query = "select * from modules where id='"+id+"'";
		try {
			ResultSet resultSet = DbUtil.getResultSet(query);
			while(resultSet.next()){
				Module module = new Module();
				setResultSetToModule(module, resultSet);
				return module;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveOrUpdate(String id, String moduleName, String moduleDesc, String softwareId) {
		if(moduleName==null || moduleName.equals("")) return;
		String query = "INSERT INTO modules (module_name, description, fk_id, modified_date) "
				+ "values('"+moduleName+"', '"+moduleDesc+"', '"+softwareId+"', now())";
		if(id!=null && !"".equals(id)){
			try{
			Module module = getModuleById(Long.parseLong(id));
			if(module!=null)
				query = "UPDATE modules SET module_name='"+moduleName+"', description='"+moduleDesc+"',fk_id='"+softwareId+"', modified_date=now() WHERE id='"+id+"'";
			}catch(Exception e){}
		}
		try {
			DbUtil.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
