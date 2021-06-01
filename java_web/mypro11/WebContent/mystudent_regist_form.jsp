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
<title>학생 등록</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>학생 등록</h2>
					<p>학생 정보를 올바르게 입력해주세요</p>
				</div>
				<form role="form" action="mystudent_regist_run.jsp" method="post">
					<div class="form-group">

						<label for="st_num"> 학번 </label> <input
							type="number" class="form-control" id="st_num" 
							name="st_num"/>
					</div>
					<div class="form-group">

						<label for="st_name"> 이름 </label> <input
							type="number" class="form-control" id="st_name" 
							name="st_name"/>
					</div>
					<div class="form-group">

						<label for="st_major"> 전공 </label> <input
							type="number" class="form-control" id="st_major" 
							name="st_major"/>
					</div>
					<div class="form-group">

						<label for="st_year"> 학년 </label> <input
							type="number" class="form-control" id="st_year" 
							name="st_year"/>
					</div>
					<div class="form-group">

						<label for="st_score"> 점수 </label> <input
							type="number" class="form-control" id="st_score" 
							name="st_score"/>
					</div>
					<div class="form-group">

						<label for="st_etc"> 비고 </label> <textarea
							class="form-control" id="st_etc" 
							name="st_etc"></textarea>
					</div>

					<button type="submit" class="btn btn-primary">등록</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>