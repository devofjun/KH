<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/webShop/input" method="get">
		<input type="checkbox" name="subject" value="java">자바
		<input type="checkbox" name="subject" value="C">C언어
		<input type="checkbox" name="subject" value="JSP">JSP
		<input type="checkbox" name="subject" value="Android">안드로이드
		<br>
		<button type="submit">전송하기</button>
	</form>
</body>
</html>