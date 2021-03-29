package com.project.loan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.loan.dto.Approved;
import com.project.loan.service.ApproveService;

@WebServlet("/approve")
public class ApproveController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String approvedAmnt=req.getParameter("amnt");
		String install=req.getParameter("instal");
		String duration=req.getParameter("duration");
		String payment=req.getParameter("payment");
		String interest=req.getParameter("interest");
		String totalAmnt=req.getParameter("total");
		
		Approved approved=new Approved();
		approved.setName(name);
		approved.setApprovedLoan(Double.parseDouble(approvedAmnt));
		approved.setMonthly(Double.parseDouble(install));
		approved.setDuration(Integer.parseInt(duration));
		approved.setDownPayment(Double.parseDouble(payment));
		approved.setInterest(Integer.parseInt(interest));
		approved.setTotalAmnt(Double.parseDouble(totalAmnt));
		
		ApproveService service=new ApproveService();
		boolean b=service.approve(approved);
		
		HttpSession session=req.getSession(false);
		if(session!=null) {
			
			if(b) {
				resp.getWriter().print("<h1>"+"Loan Approval Added Succesfully"+"</h1>");
				RequestDispatcher dis=req.getRequestDispatcher("./NewLadHome.html");
				dis.include(req, resp);
			}else {
				resp.getWriter().print("<h1>"+"Loan Approval Not Added Succesfully"+"</h1>");
				RequestDispatcher dis=req.getRequestDispatcher("./NewLadHome.html");
				dis.include(req, resp);
			}
			
		}else {
			resp.getWriter().print("<h1>"+"Login First"+"</h1>");
			RequestDispatcher dis=req.getRequestDispatcher("./Login.html");
			dis.include(req, resp);
		}
		
		
		
		
	}

}
