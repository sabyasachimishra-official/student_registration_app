package com.student_registration_app.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOServiceImpl implements DAOService
{
	Statement stmnt;
	@Override
	public void connectDB()
	{
	       try {
			      Class.forName("com.mysql.cj.jdbc.Driver");
			      Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student_registration","root","cherry");
		           stmnt = con.createStatement();
	       }
	       catch (Exception e)
	          {
			      e.printStackTrace();
	          }	
	}

	@Override
	public boolean verifyLogin(String email, String password) {

	   try 
	        {
		      ResultSet res = stmnt.executeQuery("select * from registration where email='"+email+"' and password='"+password+"'");
		      return res.next();
	        } 
	   catch (Exception e)
	          {
		          e.printStackTrace();
	           }
	   return false;
	
	}

	@Override
	public void addRegistration(String name, String course, String email, String mobile) {
		
	    try 
	    {
			stmnt.executeUpdate("insert into studentdetails values('"+name+"','"+course+"','"+email+"','"+mobile+"')");
		
	    } catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRegistration(String email) {
       
		try {
			stmnt.executeUpdate("delete from studentdetails where email='"+email+"'");
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRegistration(String mobile, String email) {
      
		try 
		{
			stmnt.executeUpdate("update studentdetails set mobile='"+mobile+"' where email='"+email+"'");
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void logOut() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ResultSet listRegistration() {
		 try 
	        {
		      ResultSet result = stmnt.executeQuery("select * from studentdetails");
		      return result;
	        } 
	   catch (Exception e)
	          {
		          e.printStackTrace();
	           }
		 return null;
	}

}
