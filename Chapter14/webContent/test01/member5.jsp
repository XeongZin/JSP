<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, sec01.ex01.*" pageEncoding="UTF-8" 
    isELIgnored="false"  %>
<%
   request.setCharacterEncoding("UTF-8");
   // 표현식으로 출력하기 위해 회원 정보 가져옴.
%>   

<jsp:useBean id="m1" class="sec01.ex01.MemberBean" />
<jsp:setProperty name="m1" property="*" />
<jsp:useBean id="memberList" class="java.util.ArrayList" />
<jsp:useBean id="memberMap" class="java.util.HashMap" />

<%
   // memberMap에 회원 정보를 key와 value로 저장.
   memberMap.put("id", "park2");
   memberMap.put("pwd", "4321");
   memberMap.put("name", "김성진");
   memberMap.put("email", "park2@test.com");
   
   MemberBean m2 = new MemberBean("son", "1234", "손흥민", "son@test.com");
   memberList.add(m1);
   memberList.add(m2);
   // 회원 정보가 저장된 memberList를 memberList라는 key로 memberMap에 저장
   memberMap.put("memberList", memberList);
%>

<html>
   <head>
      <meta charset=”UTF-8">
      <title>회원 정보 출력창</title>
   </head>
   <body>
      <table border="1"  align="center" >
          <tr align="center" bgcolor="#99ccff">
            <td width="20%"><b>아이디</b></td>
            <td width="20%"><b>비밀번호</b></td>
            <td width="20%"><b>이름</b></td>
            <td width="20%"><b>이메일</b></td>
         </tr>
         <tr align=center>
         <!-- key로 접근하여 value를 출력 -->
            <td>${memberMap.id} </td>
            <td>${memberMap.pwd} </td>
            <td>${memberMap.name} </td>
            <td>${memberMap.email} </td>
         </tr> 
         <tr align=center>
         <!-- HashMap에 저장된 ArrayList에 .으로 접그하여 회원정보 출력 -->
            <td>${memberMap.memberList[0].id} </td>
            <td>${memberMap.memberList[0].pwd} </td>
            <td>${memberMap.memberList[0].name} </td>
            <td>${memberMap.memberList[0].email} </td>
         </tr>   
         <tr align=center>
            <td>${memberMap.memberList[1].id} </td>
            <td>${memberMap.memberList[1].pwd} </td>
            <td>${memberMap.memberList[1].name} </td>
            <td>${memberMap.memberList[1].email} </td>
         </tr>
      </table>
   </body>
</html>