package com.project.loan.dto;

public class Program {
	
	private String programName;
	private String description;
	private String type;
	private int duration;
	private double minAmnt;
	private double maxAmnt;
	private double interest;
	private String proofs;
	public String getProgramName() {
		return programName;
	}
	public void setProgramName(String programName) {
		this.programName = programName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getMinAmnt() {
		return minAmnt;
	}
	public void setMinAmnt(double minAmnt) {
		this.minAmnt = minAmnt;
	}
	public double getMaxAmnt() {
		return maxAmnt;
	}
	public void setMaxAmnt(double maxAmnt) {
		this.maxAmnt = maxAmnt;
	}
	public double getInterest() {
		return interest;
	}
	public void setInterest(double interest) {
		this.interest = interest;
	}
	public String getProofs() {
		return proofs;
	}
	public void setProofs(String proofs) {
		this.proofs = proofs;
	}
	@Override
	public String toString() {
		return "Program [programName=" + programName + ", description=" + description + ", type=" + type + ", duration="
				+ duration + ", minAmnt=" + minAmnt + ", maxAmnt=" + maxAmnt + ", interest=" + interest + ", proofs="
				+ proofs + "]";
	}
	

}
