package com.project.loan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.loan.dto.CustomerDetails;
import com.project.loan.service.ApplyService;

@WebServlet("/applyCont")
public class ApplyController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name=req.getParameter("name");
		String date=req.getParameter("date");
		String martial=req.getParameter("martial");
		long number=Long.parseLong(req.getParameter("number"));
		int dependents=Integer.parseInt(req.getParameter("dependents"));
		String email=req.getParameter("email");
		
		CustomerDetails cd=new CustomerDetails();
		cd.setName(name);
		cd.setDob(date);
		cd.setMartial(martial);
		cd.setNumber(number);
		cd.setDependents(dependents);
		cd.setEmail(email);
		
		ApplyService apply=new ApplyService();
		boolean b=apply.apply(cd);
		
		
			if(b)
			{
				resp.getWriter().print("<h1>"+"Succesfully Appilied for Loan"+"</h1>");
				RequestDispatcher dis=req.getRequestDispatcher("./Homepage.html");
				dis.include(req, resp);
			}else{
				resp.getWriter().print("<h1>"+"Not Applied for Loan"+"</h1>");
				RequestDispatcher dis=req.getRequestDispatcher("./Homepage.html");
				dis.include(req, resp);
			}
		
		
		
		
		
	}
}
