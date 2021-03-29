package com.project.loan.service;

import com.project.loan.dao.DAOImpl;

public class AddService {

	
	public boolean uploadSchemes(String name,String desc,String type,long dur,long min_amnt,long max_amnt,long interest,String proof)
	{
		DAOImpl dao=new DAOImpl();
		return dao.uploadSchemes(name,desc,type,dur,min_amnt,max_amnt,interest,proof);
	}
}
