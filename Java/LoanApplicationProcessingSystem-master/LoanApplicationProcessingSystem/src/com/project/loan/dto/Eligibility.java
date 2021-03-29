package com.project.loan.dto;

public class Eligibility {
	private String martial;
	private int depndents;
	private long phone;
	private String date;
	public String getMartial() {
		return martial;
	}
	public void setMartial(String martial) {
		this.martial = martial;
	}
	public int getDepndents() {
		return depndents;
	}
	public void setDepndents(int depndents) {
		this.depndents = depndents;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Eligibility [martial=" + martial + ", depndents=" + depndents + ", phone=" + phone + ", date=" + date
				+ "]";
	}
	
		
	
}
