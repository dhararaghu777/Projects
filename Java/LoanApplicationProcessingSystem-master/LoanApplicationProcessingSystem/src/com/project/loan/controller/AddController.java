package com.project.loan.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.loan.service.AddService;

@WebServlet("/addControl")
public class AddController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name=req.getParameter("name");
		String desc=req.getParameter("description");
		String type=req.getParameter("type");
		long dur=Long.parseLong(req.getParameter("duration"));
		//int min_amnt=req.getParameter("min_amnt");
		long min_amnt=Long.parseLong(req.getParameter("min_amnt"));
		//int max_amnt=req.getParameter("max_amnt");
		long max_amnt=Long.parseLong(req.getParameter("max_amnt"));
		//String interest=req.getParameter("interest");
		long interest=Long.parseLong(req.getParameter("interest"));
		String proof=req.getParameter("proof");
		
		AddService add=new AddService();
		boolean b=add.uploadSchemes(name,desc,type,dur,min_amnt,max_amnt,interest,proof);
		HttpSession session=req.getSession(false);
		
		if(session!=null)
		{
		if(b)
		{
			resp.getWriter().print("<h1>"+"Program Added Succesfully"+"</h1>");
		}}else
		{
			resp.getWriter().print("<h1>"+"Login first"+"</h1>");
			RequestDispatcher dis=req.getRequestDispatcher("./Login.html");
			dis.include(req, resp);
		}
		
		
	}
	

}
