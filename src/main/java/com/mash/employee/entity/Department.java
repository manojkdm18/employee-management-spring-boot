/**
 * 
 */
package com.mash.employee.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author manoj
 *
 */
@Entity
public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DEPTRFNUM")
	private Long deptrfnum;
	@Column(name = "DEPTNAME")
	private String deptName;
	@Column(name = "DEPTCODE", unique = true)
	private String deptCode;
	@Column(name = "ISACTIVE")
	private String isactive;
	@Column(name = "CREATEDATE")
	private LocalDateTime createdate;
	@Column(name = "MODIDATE")
	private LocalDateTime modidate;

	public Long getDeptrfnum() {
		return deptrfnum;
	}

	public void setDeptrfnum(Long deptrfnum) {
		this.deptrfnum = deptrfnum;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public String getIsactive() {
		return isactive;
	}

	public void setIsactive(String isactive) {
		this.isactive = isactive;
	}

	public LocalDateTime getCreatedate() {
		return createdate;
	}

	public void setCreatedate(LocalDateTime createdate) {
		this.createdate = createdate;
	}

	public LocalDateTime getModidate() {
		return modidate;
	}

	public void setModidate(LocalDateTime modidate) {
		this.modidate = modidate;
	}

}
