package com.project.loan.service;

import java.sql.ResultSet;
import java.util.List;

import com.project.loan.dao.DAO;
import com.project.loan.dao.DAOImpl;
import com.project.loan.dto.Program;

public class ViewService {
	
	public List<Program> view(){
		DAO dao=new DAOImpl();
		return dao.view();
	}

}
