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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author manoj
 *
 */
@Entity
public class Address implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ADDRFNUM")
	private Long addrfnum;
	@Column(name = "CITY")
	private String city;
	@Column(name = "STATE")
	private String state;
	@Column(name = "COUNTRY")
	private String country;
	@Column(name = "ZIPCODE")
	private String zipcode;
	@Column(name = "ISACTIVE")
	private String isactive;
	@Column(name = "CREATEDATE")
	private LocalDateTime createdate;
	@Column(name = "MODIDATE")
	private LocalDateTime modidate;
	
	@ManyToOne
	@JoinColumn(name = "FK_EMPRFNUM")
	private Employee emloyee;
	
	public Long getAddrfnum() {
		return addrfnum;
	}
	public void setAddrfnum(Long addrfnum) {
		this.addrfnum = addrfnum;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
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
	public Employee getEmloyee() {
		return emloyee;
	}
	public void setEmloyee(Employee emloyee) {
		this.emloyee = emloyee;
	}
	
	

	
	
	
	
	
	
}
