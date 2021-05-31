<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="get" action="/webShop2/input2">
		이름: <input type="text" name="user_name"><br>
		생년: <select name="birth_year">
				<option value="2000">2000년</option>
				<option value="2001">2001년</option>
				<option value="2002">2002년</option>
			</select><br>
		점수: <input type="number" name="score">점<br>
		성별: <input type="radio" name="gender" value="F">여자
			 <input type="radio" name="gender" value="M">남자
		<input type="submit" value="전송하기"/>
	</form>
</body>
</html>