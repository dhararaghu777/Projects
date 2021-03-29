package com.project.loan.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.project.loan.dao.DAO;
import com.project.loan.dao.DAOImpl;
import com.project.loan.dto.Allot;
import com.project.loan.dto.Eligibility;

public class AllotService {
	
	public Allot allot(Eligibility e) {
		Allot allot=new Allot();
		DAO dao=new DAOImpl();
		EligibilityService es=new EligibilityService();		
		Eligibility el=dao.checkEligibility(e);
		boolean b=es.checkEligibility(el);
		String interviewDate=null;
		
			if(el!=null) {
				String applyDate=el.getDate();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				Calendar c = Calendar.getInstance();
				try {
					c.setTime(sdf.parse(applyDate));
				} catch (Exception e2) {
					e2.printStackTrace();
					System.out.println("aaa");
				}
				c.add(Calendar.DAY_OF_MONTH, 8);
				interviewDate = sdf.format(c.getTime()); 
				allot.setB(b);
				allot.setDate(interviewDate);
				return allot;
			}
			return null;
		
		
		
			
		
		
		
	}

}
