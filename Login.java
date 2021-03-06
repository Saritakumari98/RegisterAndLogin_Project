package com.fujitsu.loginAndRegister.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.loginAndRegister.DAO.LoginDao;
import com.fujitsu.loginAndRegister.DAO.userRegistrationDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginDao dao = new LoginDao();
		boolean result=dao.verifyUserCredential(username, password);
		
		if(result)
		{
		
			HttpSession session=request.getSession();
			session.setAttribute("user" ,username);
			response.sendRedirect("welcome.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
		
	}

}
