<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script>
	$(function() {
		// 수정버튼
		$("#btnModify").click(function() {
			$("#btnModifyFinish").fadeIn("fast");
			$(".readonly").attr("readonly", false);
		});
		// 수정완료버튼
		$("#btnModifyFinish").click(function() {
			$("#frmStudent").attr("action", "student_modify_run.jsp").submit();
		});
		// 삭제버튼
		$("#btnDelete").click(function() {
			$("#btnDeleteFinish").slideDown(100);
		});
		// 삭제완료버튼
		$("#btnDeleteFinish").click(function() {
			$("#frmStudent").attr("action", "student_delete_run.jsp").submit();
		});
	});
	</script>
<title>학생 상세 정보</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>학생 상세 정보</h2>
					<p>학생 상세 정보 보기입니다.</p>
				</div>
				<form action="" role="form" method="post" id="frmStudent">
					<div class="form-group">
						<!-- 서버로 전송 되어야 하니깐 name값도 추가한다. -->
						<label for="st_num"> 학번 </label> <input
							type="number" class="form-control" id="st_num"
							name="st_num" value="1001" readonly />
					</div>
					<div class="form-group">

						<label for="st_name"> 이름 </label> <input
							type="text" class="form-control readonly" id="st_name" 
							name="st_name" value="홍길동" readonly/>
					</div>
					<div class="form-group">

						<label for="st_major"> 전공 </label> <input
							type="text" class="form-control readonly" id="st_major" 
							name="st_major" value="생활체육" readonly/>
					</div>
					<div class="form-group">

						<label for="st_year"> 학년 </label> <input
							type="text" class="form-control readonly" id="st_year" 
							name="st_year" value="3" readonly/>
					</div>
					<div class="form-group">

						<label for="st_score"> 점수 </label> <input
							type="text" class="form-control readonly" id="st_score" 
							name="st_score" value="95" readonly/>
					</div>
					<div class="form-group">

						<label for="st_etc"> 비고 </label> <textarea
							class="form-control readonly" id="st_etc" 
							name="st_etc" readonly>쾌활한 성격의 소유자임.</textarea>
					</div>
					<a class="btn btn-primary" href="student_list.jsp">목록</a>
					<button type="button" class="btn btn-success" id="btnModify">수정</button>
					<button type="button" class="btn btn-info" id="btnDelete">삭제</button>
					<button type="button" class="btn btn-warning" id="btnModifyFinish"style="display:none">수정완료</button>
					<button type="button" class="btn btn-danger" id="btnDeleteFinish"style="display:none">삭제완료</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>