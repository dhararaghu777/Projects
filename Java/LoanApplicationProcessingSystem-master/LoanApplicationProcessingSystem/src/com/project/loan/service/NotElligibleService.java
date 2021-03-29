package com.project.loan.service;

import com.project.loan.dao.DAO;
import com.project.loan.dao.DAOImpl;
import com.project.loan.dto.Eligibility;

public class NotElligibleService {

	public boolean notElligible(Eligibility e)
	{
		DAO dao=new DAOImpl();
		return dao.deleteApplicant(e);
	}
	
}
