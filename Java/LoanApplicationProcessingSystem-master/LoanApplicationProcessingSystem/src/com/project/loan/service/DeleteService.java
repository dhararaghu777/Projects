package com.project.loan.service;

import com.project.loan.dao.DAOImpl;

public class DeleteService {
	
	public boolean delete(String name)
	{
		DAOImpl dao=new DAOImpl();
		return dao.deleteSchemes(name);
		
	}

}
