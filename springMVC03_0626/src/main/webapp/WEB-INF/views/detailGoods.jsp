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
			<td>��ǰ�̹���</td>
			<td>��ǰ��ȣ</td>
			<td>��ǰ��</td>
			<td>��ǰ����</td>
			<td>����</td>
			<td>���λ���</td>
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
	<a href="updateGoods.do?no=${g.no }">��ǰ����</a>

</body>
</html>