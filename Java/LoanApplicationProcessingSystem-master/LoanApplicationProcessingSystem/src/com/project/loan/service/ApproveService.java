package com.project.loan.service;

import com.project.loan.dao.DAO;
import com.project.loan.dao.DAOImpl;
import com.project.loan.dto.Approved;

public class ApproveService {
	
	public boolean approve(Approved a) {
		DAO dao=new DAOImpl();
		return dao.approve(a);
	}

}
