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

import com.project.loan.dto.Program;
import com.project.loan.service.SearchService;

@WebServlet("/search")
public class SearchController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		String name=req.getParameter("name");
		
		HttpSession session=req.getSession(false);
		if(session!=null)
		{
		SearchService s=new SearchService();
		Program p=s.search(name);
		
		if(p!=null)
		{
			out.println("<h1>"+"Program Name: "+p.getProgramName()+"</h1>");
			out.println("<h1>"+"Description: "+p.getDescription()+"</h1>");
			out.println("<h1>"+"Type: "+p.getType()+"</h1>");
			out.println("<h1>"+"Duration: "+p.getDuration()+"</h1>");
			out.println("<h1>"+"Minimum Amount: "+p.getMinAmnt()+"</h1>");
			out.println("<h1>"+"Maximum Amount: "+p.getMaxAmnt()+"</h1>");
			out.println("<h1>"+"Interest: "+p.getInterest()+"</h1>");
			out.println("<h1>"+"Proofs Required: "+p.getProofs()+"</h1>");
			
		
		}else {
			out.print("");
			resp.getWriter().print("No records Found");
		}
						
		}else {
			resp.getWriter().print("<h1>"+"Login First"+"</h1>");
			RequestDispatcher dis=req.getRequestDispatcher("./Login.html");
			dis.include(req, resp);
		}
		
	}

}
