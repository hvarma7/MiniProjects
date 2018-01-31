<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@page import="java.util.* , socialmonitoring.Contact,socialmonitoring.ContactDao" %>

	<form method="post" action="FilterController">
	
		<% 
				
			HashMap<String,String> myMap = ContactDao.getNamesAndUserNames();
		
		
			for(Map.Entry<String,String> m: myMap.entrySet()) {
				out.println("<input type='checkbox' name=names value="+m.getValue()+"/>");
				out.println("<label>"+m.getKey()+"</label>");
				out.println("<br />");
			}
			
		%>
		
		
		
		<br />
		
		
		<input type="submit"/>
	</form>


</body>
</html>