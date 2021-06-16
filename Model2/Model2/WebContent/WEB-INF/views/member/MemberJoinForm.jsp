<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="../include/bootstrap_cdn.jsp" %>
<meta charset="UTF-8">
<title>회원가입폼</title>
<script>
$(document).ready(function() {
	$("#btnCheckDupId").click(function() {
		var user_id = $("#user_id").val();
		var url = "/CheckDupId.do";
		var sendData = {
			"user_id" : user_id	
		};
		$.get(url, sendData, function(receivedData) {
			console.log(receivedData);
		});
	});
});
</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>회원가입</h2>
					<p>
						<a class="btn btn-primary btn-large" href="/BoardList.do">목록</a>
					</p>
				</div>
				<form role="form" action="/MemberJoinRun.do" method="post" >
					<div class="form-group">

						<label for="user_id"> 아이디 </label> <input
							type="text" class="form-control" id="user_id" name="user_id" />
							<button type="button" id="btnCheckDupId">아이디 중복체크</button>
							<span></span>
					</div>
					<div class="form-group">

						<label for="user_pw"> 비밀번호 </label> <input
							type="password" class="form-control" id="user_pw" name="user_pw"/>
					</div>
					<div class="form-group">

						<label for="user_name"> 이름 </label> <input
							type="text" class="form-control" id="user_name" name="user_name" />
					</div>
					<button type="submit" class="btn btn-primary">가입완료</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>