package com.project.loan.dto;

public class CustomerDetails {
	
	private String name;
	private String dob;
	private String martial;
	private long number;
	private int dependents;
	private String email;
	private String date;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getMartial() {
		return martial;
	}
	public void setMartial(String martial) {
		this.martial = martial;
	}
	public long getNumber() {
		return number;
	}
	public void setNumber(long number) {
		this.number = number;
	}
	public int getDependents() {
		return dependents;
	}
	public void setDependents(int dependents) {
		this.dependents = dependents;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "CustomerDetails [name=" + name + ", dob=" + dob + ", martial=" + martial + ", number=" + number
				+ ", dependents=" + dependents + ", email=" + email + ", date=" + date + "]";
	}
	
	
	

}
