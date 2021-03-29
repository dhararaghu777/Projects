package com.project.loan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.loan.dto.Program;
import com.project.loan.service.ViewService;

@WebServlet("/view")
public class ViewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		ViewService view =new ViewService();
		List<Program> li = view.view();
		if(li!=null) {
			PrintWriter out=resp.getWriter();
			Iterator<Program> it = li.iterator();
			while(it.hasNext()) {				
				out.println(it.next());
				String str=("<a href="+"http://localhost:8080/LoanApplicationProcessingSystem/NewCustomerDetails.html"+"><input type="+"submit"+" value="+"Apply"+"/></a><br><br>");
				resp.getWriter().print(str);
			}
			
		}else {
			RequestDispatcher dis = req.getRequestDispatcher("./Homepage.html");
			dis.forward(req, resp);
		}
	}

}
