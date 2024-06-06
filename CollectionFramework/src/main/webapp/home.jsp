<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <%@ page import="java.sql.*" %>
  <%@ page import="java.util.*" %>
</head>
<body>
  <p>
   <% ArrayList all=(ArrayList) session.getAttribute("mylist"); 
    for(int i=0;i<all.size();i=i+4){
    %>
      out.println(all.get(i));
      out.println(all.get(i+1));
       out.println(all.get(i+2));
       out.println(all.get(i+3));
   }
    
   out.println();
   }  
  </body>
  </html>