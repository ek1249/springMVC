<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>${title }</h2>
<hr>
<table border="1" width="80%">
	<tr>
		<td>회원아이디</td>
		<td>회원명</td>
		<td>성별</td>
		<td>나이</td>
	</tr>
	<c:forEach var="l" items="${list }">
		<tr>
		<td>${l.member_id }</td>
		<td>${l.member_name }</td>
		<td>${l.member_gender }</td>
		<td>${l.member_age }</td>
	</tr>
	</c:forEach>
</table>
</body>
</html>