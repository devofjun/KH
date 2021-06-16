<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%@ include file="../include/bootstrap_cdn.jsp"%>
<script>
$(document).ready(function() {
	var resultMemberJoin = "${resultMemberJoin}";
	if(resultMemberJoin == "true"){
		alert("회원 가입성공");
	} else if(resultMemberJoin == "false"){
		alert("회원 가입실패");
	}
});
</script>
<title>로그인</title>
</head>
<body>
<%
	session.removeAttribute("resultMemberJoin");
%>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>로그인폼</h2>
					<p>
						<a class="btn btn-primary btn-large" href="/BoardList.do">목록</a>
					</p>
				</div>
				<form role="form" action="/MemberLoginRun.do" method="post">
					<div class="form-group">

						<label for="user_id"> 아이디 </label> <input
							type="text" class="form-control" id="user_id" name="user_id"
							value="${cookie.user_id.value}"/>
					</div>
					<div class="form-group">

						<label for="user_pw"> Password </label> <input
							type="password" class="form-control" id="user_pw" name="user_pw"/>
					</div>
					<div class="checkbox">

						<label> <input type="checkbox" /> 아이디 저장
						</label>
					</div>
					<button type="submit" class="btn btn-primary">로그인</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>