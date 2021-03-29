package com.project.loan.service;

import com.project.loan.dao.DAO;
import com.project.loan.dao.DAOImpl;
import com.project.loan.dto.CustomerDetails;
import com.project.loan.dto.User;

public class ApplyService {
	
	public boolean apply(CustomerDetails cd)
	{
		DAO dao=new DAOImpl();
		boolean b=dao.apply(cd);
		return b;
	}

}
