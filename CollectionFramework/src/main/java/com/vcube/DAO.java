package com.vcube;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DAO {
	public ArrayList<String> getConnection(Model m) {
		System.out.println(m.getEmpno());
		System.out.println(m.getEname());
		System.out.println(m.getJob());
		System.out.println(m.getHiredate());
		String empno=m.getEmpno();
		String ename=m.getEname();
		String job=m.getJob();
		String hiredate=m.getHiredate();
		Connection con=null;
		Statement st;
		ArrayList<String> status = null;
       try {
      	  Class.forName("com.mysql.jdbc.Driver");         	   
      	   con=DriverManager.getConnection("jdbc:mysql://localhost:3306/office","root","root");
      	   st =con.createStatement();
      	  String Query="select*from employee";
   	      System.out.println(Query);
      	  ResultSet rs=st.executeQuery(Query);
      	  while(rs.next()) {
      	  ArrayList<String>	al=new ArrayList<String>();
      	      System.out.println(rs.getString(1));
      		  System.out.println(rs.getString(2));
      		  System. out.println(rs.getString(3));
      		  System. out.println(rs.getString(4));
      		  al.add(rs.getString(1));
      		  al.add(rs.getString(2));
      		  al.add(rs.getString(3));
      		  al.add(rs.getString(4));  
      		  status=al;
      	  } 
       }
		catch(Exception e) {
			System.out.println(e);}
       return status;
}
}

