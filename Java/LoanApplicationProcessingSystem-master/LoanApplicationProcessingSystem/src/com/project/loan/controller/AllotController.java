package com.project.loan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.loan.dto.Allot;
import com.project.loan.dto.Eligibility;
import com.project.loan.service.AllotService;

@WebServlet("/allot")
public class AllotController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String phn=req.getParameter("phn");
		long phnNum=Long.parseLong(phn);
		
		Eligibility e=new Eligibility();
		e.setPhone(phnNum);
		
		AllotService allot=new AllotService();
		Allot all=allot.allot(e);
		
		if(all!=null) {
			if(all.isB()) {
				resp.getWriter().print("<h1>"+"Your Interview Date is :"+all.getStr()+"</h1>");
				}
		}else {
			System.out.println("last");
			resp.getWriter().print("<h1>"+"Enter Valid Data"+"</h1>");
		}
		
		
		
	}}


