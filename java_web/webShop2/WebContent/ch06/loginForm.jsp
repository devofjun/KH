<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인2</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
	$(function() {
		$("#frmLogin").submit(function(){
			var user_id = $("#user_id").val();
			var user_pw = $("#user_pw").val();
			var url = $("#frmLogin").attr("action");
			var sendData = {
				"user_id" : user_id,
				"user_pw" : user_pw
			};
			
			$.post(url, sendData, function(rData){
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
	<!-- 서버의 Context path가 "/"는 하나만 된다. -->
	<!-- 그래서 webShop2는 path가 "/webShop2"이기 때문에 --> 
	<!-- form의 action도 "/webShop2/login2"이다.  -->
	<form id="frmLogin" action="/webShop2/login2" method="post">
		<label for="user_id">아이디: </label>
		<input type="text" name="user_id" id="user_id"/><br/>
		<label for="user_pw">패스워드: </label>
		<input type="password" name="user_pw" id="user_pw"/><br/>
		<button id="btnLogin" type="submit">로그인</button>
	</form>
</body>
</html>