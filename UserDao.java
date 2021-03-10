package com.fujitsu.loginAndRegister.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UserDao {
	public ResultSet fetchData()
	{
		String url="jdbc:mysql://localhost:3306/traininfo?autoReconnect=true&useSSL=false";
		String db_username="root";
		String db_password="root";
		
		
		
		
		Connection con;
		PreparedStatement pstmt;
		ResultSet rs=null;
		String sql="Select * from user";
		
		try {

			//step 1
			Class.forName("com.mysql.cj.jdbc.Driver");

			//step 2
			 con=DriverManager.getConnection(url,db_username,db_password);
			
             pstmt=con.prepareStatement(sql);
			
             
            
              rs=pstmt.executeQuery();
			
			
			
	
			
		}catch(Exception e)
		{
           e.printStackTrace();
		}
		return rs;
		
		
	}

}
