<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>��ǰ ���</h2>
<hr>
<form action="insertGoods.do" method="post" enctype="multipart/form-data">
	��ȣ: <input type="text" name="no"><br>
	��ǰ��  : <input type="text" name="item"><br>
	��ǰ����  : <input type="text" name="qty"><br>
	��ǰ�̹��� : <input type="file" name="uploadFile"><br>
	���� : <input type="text" name="price"><br>
	�󼼼���  : <br><textarea rows="10" cols="60" name="detail"></textarea>
	<input type="submit" value="����">
</form>
</body>
</html>