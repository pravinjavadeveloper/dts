package com.dts.model;

import java.util.Date;

public class Module {

	private Long id;
	private String moduleName;
	private String description;
	private String software;
	private Date modifiedDate;
	private String softwareName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModuleName() {
		return moduleName;
	}

	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSoftware() {
		return software;
	}

	public void setSoftware(String software) {
		this.software = software;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}
	
	public String getSoftwareName() {
		return softwareName;
	}

}
