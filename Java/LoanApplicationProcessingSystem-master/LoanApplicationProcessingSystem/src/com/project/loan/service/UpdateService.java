package com.project.loan.service;

import com.project.loan.dao.DAOImpl;

public class UpdateService {
	
	public boolean update(String where1,String where2,long value)
	{
		DAOImpl dao=new DAOImpl();
		return dao.updateSchemes(where1,where2,value);
	}

}
