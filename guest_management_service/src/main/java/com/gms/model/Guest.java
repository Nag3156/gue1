package com.gms.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Guestdetails")
public class Guest {

	private String guestname;
	private String age;
	private String gender;
	private String noofchildren;
	private String noofadults;
	@Id
	private String emailid;
	private String mobileno;
	private String country;
	private String state;
	private String city;
	private String zipcode;
	
	public Guest() {}

	public Guest(String guestname, String age, String gender, String noofchildren, String noofadults,
			String emailid, String mobileno, String country, String state, String city, String zipcode) {
		super();
		this.guestname = guestname;
		this.age = age;
		this.gender = gender;
		this.noofchildren = noofchildren;
		this.noofadults = noofadults;
		this.emailid = emailid;
		this.mobileno = mobileno;
		this.country = country;
		this.state = state;
		this.city = city;
		this.zipcode = zipcode;
	}

	public String getGuestname() {
		return guestname;
	}

	public void setGuestname(String guestname) {
		this.guestname = guestname;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getNoofchildren() {
		return noofchildren;
	}

	public void setNoofchildren(String noofchildren) {
		this.noofchildren = noofchildren;
	}

	public String getNoofadults() {
		return noofadults;
	}

	public void setNoofadults(String noofadults) {
		this.noofadults = noofadults;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	@Override
	public String toString() {
		return "Guest [guestname=" + guestname + ", age=" + age + ", gender=" + gender
				+ ", noofchildren=" + noofchildren + ", noofadults=" + noofadults + ", emailid=" + emailid
				+ ", mobileno=" + mobileno + ", country=" + country + ", state=" + state + ", city=" + city
				+ ", zipcode=" + zipcode + "]";
	}
	
}

	