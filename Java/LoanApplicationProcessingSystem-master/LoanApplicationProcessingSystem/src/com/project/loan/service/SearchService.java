package com.project.loan.service;

import com.project.loan.dao.DAO;
import com.project.loan.dao.DAOImpl;
import com.project.loan.dto.Program;
import com.project.loan.dto.User;

public class SearchService {
	
	public Program search(String name)
	{
		DAO dao=new DAOImpl();
		Program p=dao.search(name);
		
		return p;
	}

}
