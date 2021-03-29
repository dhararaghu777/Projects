package com.project.loan.dao;

import java.sql.ResultSet;
import java.util.List;

import com.project.loan.dto.Eligibility;
import com.project.loan.dto.Approved;
import com.project.loan.dto.CustomerDetails;
import com.project.loan.dto.Program;
import com.project.loan.dto.User;

public interface DAO {
	
	boolean apply(CustomerDetails cd);
	
	List<Program> view();
	User login(User u);
	Eligibility checkEligibility(Eligibility c);
	void allotInterview();
	void doVerification();	
	boolean uploadSchemes(String name,String desc,String type,long dur,long min_amnt,long max_amnt,long interest,String proof);
	boolean deleteSchemes(String name);
	boolean updateSchemes(String where1,String where2,long value);
	Program search(String name);
	boolean deleteApplicant(Eligibility e);
	boolean logout();
	boolean approve(Approved a);
	

}
