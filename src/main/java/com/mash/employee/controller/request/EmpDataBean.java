/**
 * 
 */
package com.mash.employee.controller.request;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author manoj
 *
 */
public class EmpDataBean implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = 1L;
	private Long emprfnum;
	private String firstName;
	private String lastName;
	private String empId;
	private String email;
	private String mobile;
	private String designation;
	private BigDecimal salary;
	private String gender;
	private String dateofbirth;
	private AddressBean address;
	private DepartementBean department;

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

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateofbirth() {
		return dateofbirth;
	}

	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}

	public AddressBean getAddress() {
		return address;
	}

	public void setAddress(AddressBean address) {
		this.address = address;
	}

	public DepartementBean getDepartment() {
		return department;
	}

	public void setDepartment(DepartementBean department) {
		this.department = department;
	}

}
