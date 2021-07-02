<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include/header.jsp" %>
<script>
$(document).ready(function() {
// 	var resultLogin = "${msg}";
// 	if(resultLogin == "fail"){
// 		alert("로그인 실패");
// 	}
});
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/loginRun" method="post">
				<div class="form-group">
					<label for="user_id"> 아이디 </label> <input
						type="text" class="form-control" id="user_id" name="user_id"/>
				</div>
				<div class="form-group">
					<label for="user_pw"> 패스워드 </label> <input
						type="password" class="form-control" id="user_pw" name="user_pw" />
				</div>
				<div class="checkbox">
					<label> <input type="checkbox" /> 아이디 저장
					</label>
				</div>
				<button type="submit" class="btn btn-primary">login</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp" %>