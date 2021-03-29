package com.project.loan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.loan.service.DeleteService;

@WebServlet("/deleteControl")
public class DeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name=req.getParameter("trainingcode");
		
		DeleteService del=new DeleteService();
		boolean b=del.delete(name);
		HttpSession session=req.getSession(false);
		if(session!=null)
		{		
			resp.getWriter().print("<h1>"+"Deleted Succesfully"+"</h1>");
		}else {
			resp.getWriter().print("<h1>"+"Login First"+"</h1>");
			RequestDispatcher dis=req.getRequestDispatcher("./Login.html");
			dis.include(req, resp);
		}
		
	}

}
