<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<table border="1" width="60%">
		<tr>
			<td>상품이미지</td>
			<td>상품번호</td>
			<td>상품명</td>
			<td>상품수량</td>
			<td>가격</td>
			<td>세부사항</td>
		</tr>
		<tr>
			<td><img src="resources/img/${g.fname }" width="150" height="150"></td>
			<td>${g.no }</td>
			<td>${g.item }</td>
			<td>${g.qty }</td>
			<td>${g.price }</td>
			<td>${g.detail }</td>			
		</tr>
	</table>
	<hr>
	<a href="updateGoods.do?no=${g.no }">상품수정</a>

</body>
</html>