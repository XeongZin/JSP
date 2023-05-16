<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %> 
<%
   request.setCharacterEncoding("utf-8");
%> 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>include.jsp : 김성진</title>
	</head>
	<body>
		안녕하새요. JSP 쇼핑몰 시작 부분입니다.<br>
		<jsp:include page="duke_image.jsp" flush="true" >
			<jsp:param name="name" value="듀크" />
			<jsp:param name="imgName" value="duke.png" />
		</jsp:include>
		<br>
		JSP 쇼핑몰끝 부분입니다.
	</body>
</html>