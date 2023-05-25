<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.util.*, sec02.ex01.*"
    pageEncoding="UTF-8"
    isELIgnored="false"%>
<!-- 포매팅 태그 라이브러리를 사용하기 위해 반드시 선언 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%  request.setCharacterEncoding("utf-8");  %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<jsp:useBean id="m" class="sec02.ex01.MemberBean" />
		<jsp:setProperty name="m" property="*" />
		<%
			MemberDAO memDAO = new MemberDAO();
			// 회원 정보를 추가.
			memDAO.addMember(m);
			// 회원 정보를 조회.
			List membersList = memDAO.listMembers();
			// 조회한 회원 정보를 request에 바인딩.
			request.setAttribute("membersList", membersList);
		%>
		<title>Insert title here</title>
	</head>
	<body>
		<!-- 다시 memberList.jsp로 포워딩 -->
		<jsp:forward page="memberList.jsp" />
	</body>
</html>