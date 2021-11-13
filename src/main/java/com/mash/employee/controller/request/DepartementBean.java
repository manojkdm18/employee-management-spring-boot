/**
 * 
 */
package com.mash.employee.controller.request;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author manoj
 *
 */
public class DepartementBean {

	private Long deptrfnum;
	@JsonProperty("deptName")
	private String deptname;
	@JsonProperty("deptCode")
	private String deptcode;

	public void setDeptrfnum(Long deptrfnum) {
		this.deptrfnum = deptrfnum;
	}

	public Long getDeptrfnum() {
		return deptrfnum;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptcode(String deptcode) {
		this.deptcode = deptcode;
	}

	public String getDeptcode() {
		return deptcode;
	}

}
