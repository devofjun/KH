<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ include file="include/header.jsp" %>
<script>
$(function() {
	$("#frmStudent").submit(function() {
		// 반복문으로 줄이기
		if($("#st_num").val().trim() == "") {
			alert("학번을 입력해주세요");
			$("#st_num").focus();
			return false;
		}
		if($("#st_name").val().trim() == "") {
			alert("이름을 입력해주세요");
			$("#st_name").focus();
			return false;
		}
		if($("#st_major").val().trim() == "") {
			alert("전공을 입력해주세요");
			$("#st_major").focus();
			return false;
		}
		if($("#st_year").val().trim() == "") {
			alert("학년을 입력해주세요");
			$("#st_year").focus();
			return false;
		}
		if($("#st_score").val().trim() == "") {
			alert("점수을 입력해주세요");
			$("#st_score").focus();
			return false;
		}
		$(this).submit();
	});
	$("#btnChecknum").click(function() {
		var that = $(this);
		var st_num = $("#st_num").val();
		var url = "/pro12/checkNum";
		var sendData = {
			"st_num" : st_num
		};
		$.get(url, sendData, function(rData) {
			console.log(rData);
			var message = "등록된 학번입니다.";
			if(rData == "true"){
				message = "등록 가능한 학번입니다.";
			} 
			that.next().text(message);
		});
	});
});
</script>
<title>학생 등록 양식</title>
<%@ include file="include/bodystarter.jsp" %>
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>학생 등록</h2>
					<p>학생 정보를 올바르게 입력해 주세요.</p>
				</div>
				<form id="frmStudent"role="form" action="student_regist_run.jsp" method="post">
					<div class="form-group">
						<!-- 서버로 전송 되어야 하니깐 name값도 추가한다. -->
						<label for="st_num"> 학번 </label>
						<button type="button" class="btn btn-success" id="btnChecknum">학번체크</button>
						<span></span>
						<input
							type="number" class="form-control" id="st_num"
							name="st_num" />
					</div>
					<div class="form-group">

						<label for="st_name"> 이름 </label> <input
							type="text" class="form-control" id="st_name" 
							name="st_name"/>
					</div>
					<div class="form-group">

						<label for="st_major"> 전공 </label> <input
							type="text" class="form-control" id="st_major" 
							name="st_major"/>
					</div>
					<div class="form-group">

						<label for="st_year"> 학년 </label> <input
							type="text" class="form-control" id="st_year" 
							name="st_year"/>
					</div>
					<div class="form-group">

						<label for="st_score"> 점수 </label> <input
							type="text" class="form-control" id="st_score" 
							name="st_score"/>
					</div>
					<div class="form-group">

						<label for="st_etc"> 비고 </label> <textarea
							class="form-control" id="st_etc" 
							name="st_etc"></textarea>
					</div>
					<button type="submit" class="btn btn-primary">등록하기</button>
				</form>
			</div>
		</div>
<%@ include file="include/footer.jsp" %>