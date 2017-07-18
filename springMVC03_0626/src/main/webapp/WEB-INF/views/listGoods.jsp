<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>${title }</h2>
<hr>
<a href="insertGoods.do">상품 등록</a>
<table border="1" width="60%">
	<tr>
		<td>상품번호</td>
		<td>상품명</td>
		<td>가격</td>
	</tr>
	 <c:forEach var="g" items="${list }">
		<tr>
			<td>${g.no }</td>
			<td><a href="detailGoods.do?no=${g.no }">${g.item }</a></td>
			<td>${g.price }</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>