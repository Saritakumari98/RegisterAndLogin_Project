package com.fujitsu.loginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.fujitsu.loginAndRegister.model.User;

public class userRegistrationDao {
	
	public boolean registerUser(User user)
	{
		
		System.out.println("Start the userRegistrationDAO :: registerUser");
		
		String url="jdbc:mysql://localhost:3306/traininfo?autoReconnect=true&useSSL=false";
		String db_username="root";
		String db_password="root";
		
		Connection con;
		PreparedStatement pstmt;
		String sql="insert into user values(?,?,?,?,?)";
		
		try {

			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");

			//step 2
			 con=DriverManager.getConnection(url,db_username,db_password);
			
             pstmt=con.prepareStatement(sql);
			
             pstmt.setInt(1, user.getId());
             pstmt.setString(2,user.getUserName());
             pstmt.setString(3, user.getPassword());
             pstmt.setInt(4, user.getPhone());
             pstmt.setString(5, user.getAddress());
			
			int result=pstmt.executeUpdate();
			
			if(result>0)
				return true;
			
		}catch(Exception e)
		{
           e.printStackTrace();
		}
		
		System.out.println("Start the userRegistrationDAO :: registerUser");
		return false;
		
		//abc.save(user)
		
	}

}
