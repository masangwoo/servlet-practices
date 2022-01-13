<%@page import="com.poscoict.emaillist01.dao.EmaillistDao"%>
<%@page import="com.poscoict.emaillist01.vo.EmaillistVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    request.setCharacterEncoding("utf-8");
                    	String firstName = request.getParameter("fn");
                    	String lastName = request.getParameter("ln");
                    	String email = request.getParameter("email");
                    	
                    	EmaillistVo vo = new EmaillistVo();
                		vo.setFirstName(firstName);
                		vo.setLastName(lastName);
                		vo.setEmail(email);
                		
                		new EmaillistDao().insert(vo);
                		
                		response.sendRedirect("/emaillist01");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>잘 들어갔습니다.</h1>
</body>
</html>