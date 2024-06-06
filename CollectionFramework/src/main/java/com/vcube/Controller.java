package com.vcube;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String empno=request.getParameter("empno");
      String ename=request.getParameter("ename");
      String job=request.getParameter("job");
      String hiredate=request.getParameter("hiredate");     
	  Model m=new Model();
	  m.setEmpno(empno);
	  m.setEname(ename);
	  m.setJob(job);
	  m.setHiredate(hiredate);
      DAO d=new DAO();
    ArrayList<String> al=d.getConnection(m);
    HttpSession session=request.getSession(true);
    if(al.isEmpty()==false) {   
    session.setAttribute("mylist",al);
    RequestDispatcher rd= request.getRequestDispatcher("/home.jsp");
    rd.forward(request, response);
   }
    else {
    	RequestDispatcher rd= request.getRequestDispatcher("/index.jsp");
    	rd.forward(request, response);
    }
}
}
