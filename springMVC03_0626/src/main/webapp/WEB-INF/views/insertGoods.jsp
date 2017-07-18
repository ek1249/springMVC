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
<form action="insertGoods.do" method="post" enctype="multipart/form-data">
	번호: <input type="text" name="no"><br>
	상품명  : <input type="text" name="item"><br>
	상품수량  : <input type="text" name="qty"><br>
	제품이미지 : <input type="file" name="uploadFile"><br>
	가격 : <input type="text" name="price"><br>
	상세설명  : <br><textarea rows="10" cols="60" name="detail"></textarea>
	<input type="submit" value="전송">
</form>
</body>
</html>