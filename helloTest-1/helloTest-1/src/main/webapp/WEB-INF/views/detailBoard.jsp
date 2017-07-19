<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>상세보기</h2>
	글번호 : ${b.no }<br>
	제목 : ${b.title }<br>
	작성자 : ${b.writer }<br>
	내용 : <br>
	<textarea rows="10" cols="60">${b.content }</textarea>
	<br>
<a href="insertBoard.do?no=${b.no }">답글작성</a><br>
	<a href="updateBoard.do?no=${b.no }">수정</a>
</body>
</html>