<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>상품 등록</h2>
<hr>
<form action="updateGoods.do" method="post" enctype="multipart/form-data">
	<input type="hidden" name="fname" value="${g.fname }">
	번호: <input type="text" name="no" value="${g.no }"><br>
	상품명  : <input type="text" name="item" value="${g.item }"><br>
	상품수량  : <input type="text" name="qty" value="${g.qty }"><br>
	<img src="resources/img/${g.fname }" width="60" height="60"><br>
	제품이미지 : <input type="file" name="uploadFile"><br>
	가격 : <input type="text" name="price" value="${g.price }"><br>
	상세설명  :<br><textarea rows="10" cols="60" name="detail">${g.detail }</textarea>
	<input type="submit" value="수정">
</form>
</body>
</html>