package com.project.loan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.loan.dto.Program;
import com.project.loan.service.UpdateService;

@WebServlet("/updateControl")
public class UpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html");
		HttpSession session=req.getSession(false);
		
		String where2=req.getParameter("where2");
		String where1=req.getParameter("where1");
		
		long value=Integer.parseInt(req.getParameter("value"));
		
		
		UpdateService update=new UpdateService();
		
		boolean b=update.update(where1, where2, value);
		
		
		
		if(session!=null)
		{
			if(b)
			{
				resp.getWriter().print("<h1>"+"Updated"+"</h1>");
			}else {
				resp.getWriter().print("<h1>"+"Not Updated"+"</h1>");
			}
		}else {
			resp.getWriter().print("<h1>"+"Login First"+"</h1>");
			RequestDispatcher dis=req.getRequestDispatcher("./Login.html");
			dis.include(req, resp);
		}
		
	}

}
