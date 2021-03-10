package com.fujitsu.loginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDao {
	public boolean verifyUserCredential(String username,String password)
	{
		String url="jdbc:mysql://localhost:3306/traininfo?autoReconnect=true&useSSL=false";
		String db_username="root";
		String db_password="root";
		
		Connection con;
		PreparedStatement pstmt;
		String sql="Select * from user where userName=? and password=?";
		
		try {

			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");

			//step 2
			 con=DriverManager.getConnection(url,db_username,db_password);
			
             pstmt=con.prepareStatement(sql);
			
             
             pstmt.setString(1,username);
             pstmt.setString(2, password);
            
             ResultSet rs=pstmt.executeQuery();
			
			
			
			if(rs.next())
				return true;
			
		}catch(Exception e)
		{
           e.printStackTrace();
		}
		
		return false;
	}

}
