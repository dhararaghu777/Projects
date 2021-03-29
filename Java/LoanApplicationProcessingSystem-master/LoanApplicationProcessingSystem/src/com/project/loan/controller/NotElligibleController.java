package com.project.loan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.loan.dto.Eligibility;
import com.project.loan.service.NotElligibleService;

@WebServlet("/notElligible")
public class NotElligibleController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Eligibility elli=(Eligibility)req.getAttribute("phnNum");
		NotElligibleService nel = new NotElligibleService();
		boolean b = nel.notElligible(elli);
		if(b) {
			RequestDispatcher dis = req.getRequestDispatcher("./Home.html");
			dis.forward(req, resp);
		}else {
			resp.getWriter().print("<h1>"+"No records Found"+"</h1>");
			RequestDispatcher dis = req.getRequestDispatcher("./Home.html");
			dis.forward(req, resp);			
		}
		
	}

}
