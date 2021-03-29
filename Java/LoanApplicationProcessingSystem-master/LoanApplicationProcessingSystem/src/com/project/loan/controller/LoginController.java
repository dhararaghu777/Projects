package com.project.loan.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.project.loan.dto.User;
import com.project.loan.service.LoginService;



@WebServlet("/logincont")
public class LoginController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String role=req.getParameter("role");
		String user=req.getParameter("user");
		String pass=req.getParameter("pass");

		User u=new User();
		u.setRole(role);
		u.setLoginId(user);
		u.setPassword(pass);
		LoginService lgn=new LoginService();
		User b=lgn.login(u);
		
		if(b!=null)
		{
			HttpSession session=req.getSession();
			
			if(b.getRole().equals("Admin")) {
				resp.sendRedirect("./NewAdminHome.html");
			}else {
				resp.sendRedirect("./NewLadHome.html");
			}
			
		}else {
			resp.sendRedirect("./Login.html");			
		}
		
	}

}
