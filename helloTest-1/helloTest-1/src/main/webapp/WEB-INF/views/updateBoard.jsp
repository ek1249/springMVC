<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="updateBoard.do" method="post" enctype="multipart/form-data">
		
		<input type="hidden" name="no" value="${b.no }">
		제목: <input type="text" name="title" value="${b.title }"><br>
		작성자: <input type="text" name="writer" value="${b.writer }"><br>
		비밀번호: <input type="password" name="pwd" value="${pwd }"><br>
		첨부파일 : <input type="file" name="uploadFile"><br>
		내용: <br>
		<textarea rows="10" cols="60" name="content">${b.content }</textarea><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>