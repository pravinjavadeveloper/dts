package com.dts.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dts.model.Software;
import com.dts.util.DbUtil;

public class SoftwareService {

	public static List<Software> getAllsoftwares() {
		String query = "select * from softwares";
		List<Software> softwares = new ArrayList<Software>(0);
		try {
			ResultSet resultSet = DbUtil.getResultSet(query);
			while(resultSet.next()){
				Software software = new Software();
				setResultSetToSoftware(software, resultSet);
				softwares.add(software);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return softwares;
	}

	private static void setResultSetToSoftware(Software software, ResultSet resultSet) throws SQLException {
		software.setDescription(resultSet.getString("soft_desc"));
		software.setId(resultSet.getLong("id"));
		software.setModifiedDate(resultSet.getDate("modified_date"));
		software.setSoftwareName(resultSet.getString("soft_name"));
	}

	public static void deleteSoftware(Long id) {
		String query = "delete from softwares where id='"+id+"'";
		try {
			DbUtil.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static Software getSoftwareById(Long id) {
		String query = "select * from softwares where id='"+id+"'";
		try {
			ResultSet resultSet = DbUtil.getResultSet(query);
			while(resultSet.next()){
				Software software = new Software();
				setResultSetToSoftware(software, resultSet);
				return software;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void saveOrUpdate(String id, String softwareName, String softwareDesc) {
		if(softwareName==null || softwareName.equals("")) return;
		String query = "INSERT INTO softwares (soft_name, soft_desc, modified_date) "
				+ "values('"+softwareName+"', '"+softwareDesc+"', now())";
		if(id!=null && !"".equals(id)){
			try{
				Software software = getSoftwareById(Long.parseLong(id));
			if(software!=null)
				query = "UPDATE softwares SET soft_name='"+softwareName+"', soft_desc='"+softwareDesc+"', modified_date=now() WHERE id='"+id+"'";
			}catch(Exception e){}
		}
		try {
			DbUtil.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}

}
