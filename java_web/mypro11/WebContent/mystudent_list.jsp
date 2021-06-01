<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>학생 목록</title>
</head>
<body>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>학생목록</h2>
				<p>등록된 학생 목록입니다.</p>
				<p>
					<a class="btn btn-primary btn-large" href="mystudent_regist_form.jsp">학생 등록</a>
				</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>학번</th>
						<th>이름</th>
						<th>전공</th>
						<th>학년</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1001</td>
						<td><a href="mystudent_content.jsp">홍길동</a></td>
						<td>생활체육</td>
						<td>3</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>