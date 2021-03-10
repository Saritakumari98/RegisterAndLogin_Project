package com.fujitsu.loginAndRegister.controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fujitsu.loginAndRegister.DAO.UserDao;
import com.fujitsu.loginAndRegister.model.User;

/**
 * Servlet implementation class CreateController
 */
@WebServlet("/CreateController")
public class CreateController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		UserDao dao = new UserDao();
		ResultSet rs=dao.fetchData();
		
		User user;
		
		ArrayList<User> users= new ArrayList<User>();
		try {
			while(rs.next())
			{   
				
				user = new User(rs.getInt(1), rs.getString(2),rs.getString(3), rs.getInt(4),rs.getString(5));
				
				
				
				users.add(user);
			}
			
			
			//System.out.println(users);
			
	
				request.setAttribute("users",users);
				//response.sendRedirect("admin.jsp");
				request.getRequestDispatcher("admin.jsp").forward(request, response);
				
				
				
			
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}

	

	

}
