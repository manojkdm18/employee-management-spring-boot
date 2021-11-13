/**
 * 
 */
package com.mash.employee.controller.request;

/**
 * @author manoj
 *
 */
public class AddressBean {

	private String city;
	private String state;
	private String country;
	private String zipcode;

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return country;
	}

	public void setZipcode(String string) {
		this.zipcode = string;
	}

	public String getZipcode() {
		return zipcode;
	}
}
