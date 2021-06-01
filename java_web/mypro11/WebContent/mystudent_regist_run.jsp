<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String st_num = request.getParameter("st_num");
	String st_name = request.getParameter("st_name");
	String st_major = request.getParameter("st_major");
	String st_year = request.getParameter("st_year");
	String st_score = request.getParameter("st_score");
	String st_etc = request.getParameter("st_etc");
	
	System.out.println(st_num);
	System.out.println(st_name);
	System.out.println(st_major);
	System.out.println(st_year);
	System.out.println(st_score);
	System.out.println(st_etc);
%>
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
<title>학생 등록 처리 결과</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>등록 성공</h2>
					<p>학생 목록으로 이동하시려면 아래의 목록 버튼을 클릭해주세요.</p>
					<p>
						<a class="btn btn-primary btn-large" href="mystudent_list.jsp">목록</a>
					</p>
				</div>
			</div>
		</div>
	</div>
</body>
</html>