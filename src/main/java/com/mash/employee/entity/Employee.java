/**
 * 
 */
package com.mash.employee.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author manoj
 *
 */
@Entity
public class Employee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EMPRFNUM")
	private Long emprfnum;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "EMPID", unique = true)
	private String empId;
	@Column(name = "EMAIL", unique = true)
	private String email;
	@Column(name = "MOBILE", unique = true)
	private String mobile;
	@Column(name = "DESIGNATION")
	private String designation;
	@Column(name="SALARY")
	private BigDecimal salary;
	@Column(name = "DATE_OF_BIRTH")
	private String dateOfBirth;
	@Column(name = "GENDER")
	private String gender;
	@Column(name = "ISACTIVE")
	private String isactive;
	@Column(name = "CREATEDATE")
	private LocalDateTime createdate;
	@Column(name = "MODIDATE")
	private LocalDateTime modidate;
	@ManyToOne
	@JoinColumn(name = "FK_DEPTRFNUM")
	private Department department;


	public Long getEmprfnum() {
		return emprfnum;
	}

	public void setEmprfnum(Long emprfnum) {
		this.emprfnum = emprfnum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
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

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	

}
