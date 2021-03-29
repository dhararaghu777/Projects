package com.project.loan.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.loan.dto.Eligibility;
import com.project.loan.service.EligibilityService;

@WebServlet("/check")
public class EligibilityController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String phn=req.getParameter("phn");
		long phnNum=Long.parseLong(phn);
		Eligibility check=new Eligibility();
		check.setPhone(phnNum);
		EligibilityService es=new EligibilityService();
		boolean b=es.checkEligibility(check);
		
		HttpSession session=req.getSession(false);
		//if(session!=null)
		//{
			if(b)
			{
				resp.getWriter().print("<h1>"+"Eligible for loan"+"</h1>");
				RequestDispatcher dis=req.getRequestDispatcher("./allot");
				dis.include(req, resp);
			}else {
				PrintWriter out=resp.getWriter();
				out.print("Not Eligible");
				RequestDispatcher dis=req.getRequestDispatcher("./notElligible");
				dis.include(req, resp);
				req.setAttribute("phnNum",check);
				
				
			}
//		}else {
//			resp.getWriter().print("<h1>"+"Login First"+"</h1>");
//			RequestDispatcher dis=req.getRequestDispatcher("./Login.html");
//			dis.include(req, resp);
//		}
		
		
		
	}

}
