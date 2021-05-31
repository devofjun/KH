<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
$(function() {
	$("#frmLogin").submit(function() {
		//e.preventDefault();
		var user_id = $("#user_id").val();
		var user_pw = $("#user_pw").val();
		var url = $("#frmLogin").attr("action");
		var sendData = {
				"user_id" : user_id,
				"user_pw" : user_pw
		};
		$.post(url, sendData, function(rData){
			console.log(rData);
			if(rData == "success"){
				alert("로그인 성공");
			} else {
				alert("로그인 실패");
			}
		});
		return false;
	});
});
</script>
</head>
<body>
	<!-- localhost/ch06/login_form.jsp이기 때문에 절대경로로 지정  -->
	<form id="frmLogin"action="/login" method="post">
	<!-- label로 만든 이유는 모바일 대응용 -->
		<label for="user_id">아이디: </label>
		<input type="text" name="user_id" id="user_id"/><br/>
		<label for="user_pw">패스워드: </label>
		<input type="password" name="user_pw" id="user_pw"/><br/>
		<button type="submit" id="btnLogin">로그인</button>
	</form>
</body>
</html>