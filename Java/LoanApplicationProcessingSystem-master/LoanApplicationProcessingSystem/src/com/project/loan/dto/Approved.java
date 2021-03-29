package com.project.loan.dto;

public class Approved {
	
	private String name;
	private double approvedLoan;
	private double monthly;
	private int duration;
	private double downPayment;
	private int interest;
	private double totalAmnt;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getApprovedLoan() {
		return approvedLoan;
	}
	public void setApprovedLoan(double approvedLoan) {
		this.approvedLoan = approvedLoan;
	}
	public double getMonthly() {
		return monthly;
	}
	public void setMonthly(double monthly) {
		this.monthly = monthly;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getDownPayment() {
		return downPayment;
	}
	public void setDownPayment(double downPayment) {
		this.downPayment = downPayment;
	}
	public int getInterest() {
		return interest;
	}
	public void setInterest(int interest) {
		this.interest = interest;
	}
	public double getTotalAmnt() {
		return totalAmnt;
	}
	public void setTotalAmnt(double totalAmnt) {
		this.totalAmnt = totalAmnt;
	}
	@Override
	public String toString() {
		return "Approved [name=" + name + ", approvedLoan=" + approvedLoan + ", monthly=" + monthly + ", duration="
				+ duration + ", downPayment=" + downPayment + ", interest=" + interest + ", totalAmnt=" + totalAmnt
				+ "]";
	}
	

}
