<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
  request.setCharacterEncoding("utf-8");
	//정보 바인딩
  request.setAttribute("id","hong");
  request.setAttribute("pwd","1234");
  session.setAttribute("name","홍길동");
  application.setAttribute("email","hong@test.com");
%>    

<html>
	<head>
	   <meta charset="UTF-8">
	   <title>forward</title>
	</head>
	<body>
		<!-- 포워딩 -->
	    <jsp:forward page="member1.jsp"></jsp:forward>
	</body>
</html>