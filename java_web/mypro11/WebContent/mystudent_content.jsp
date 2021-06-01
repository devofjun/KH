<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>학생 정보 상세보기</title>
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
			$("#btnModify").click(function() {
				$("#btnModifyFinish").fadeIn("fast");
				$(".writeLock").attr("readonly", false);
			});
			$("#btnDelete").click(function() {
				$("#btnDeleteFinish").slideDown(100);
			});
			$("#btnModifyFinish").click(function() {
				$("#frm").attr("action","mystudent_modify_run.jsp").submit();
			});
			$("#btnDeleteFinish").click(function() {
				$("#frm").attr("action","mystudent_delete_run.jsp").submit();
			});
		});
	</script>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>학생 정보</h2>
					<p>학생 정보 상세보기</p>
				</div>
				<form id="frm"role="form" action="" method="post">
					<div class="form-group">

						<label for="st_num"> 학번 </label> <input
							type="number" class="form-control" id="st_num" 
							name="st_num" value="1001" readonly/>
					</div>
					<div class="form-group">

						<label for="st_name"> 이름 </label> <input
							type="text" class="form-control writeLock" id="st_name" 
							name="st_name" value="정병준" readonly/>
					</div>
					<div class="form-group">

						<label for="st_major"> 전공 </label> <input
							type="text" class="form-control writeLock" id="st_major" 
							name="st_major" value="컴공" readonly/>
					</div>
					<div class="form-group">

						<label for="st_year"> 학년 </label> <input
							type="number" class="form-control writeLock" id="st_year" 
							name="st_year" value="2" readonly/>
					</div>
					<div class="form-group">

						<label for="st_score"> 점수 </label> <input
							type="number" class="form-control writeLock" id="st_score" 
							name="st_score" value="4.3" readonly/>
					</div>
					<div class="form-group">

						<label for="st_etc"> 비고 </label> <textarea
							class="form-control writeLock" id="st_etc" 
							name="st_etc" readonly>심심함</textarea>
					</div>
					<a href="mystudent_list.jsp" class="btn btn-primary">목록</a>
					<button id="btnModify"type="button" class="btn btn-success">수정</button>
					<button id="btnDelete"type="button" class="btn btn-info">삭제</button>
					<button id="btnModifyFinish"type="button" class="btn btn-warning" style="display:none">수정완료</button>
					<button id="btnDeleteFinish"type="button" class="btn btn-danger" style="display:none">삭제완료</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>