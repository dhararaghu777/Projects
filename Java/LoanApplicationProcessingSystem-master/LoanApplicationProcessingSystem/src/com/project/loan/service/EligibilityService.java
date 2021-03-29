package com.project.loan.service;

import com.project.loan.dao.DAO;
import com.project.loan.dao.DAOImpl;
import com.project.loan.dto.Eligibility;

public class EligibilityService {
	
	public boolean checkEligibility(Eligibility eli) {
		DAO dao=new DAOImpl();
		Eligibility e=dao.checkEligibility(eli);
		
		if(e!=null)
		{
			if(e.getDepndents()>=4 && e.getMartial().equals("yes"))
			{
				return true;
			}
		}		
		
		return false;
	}

}
