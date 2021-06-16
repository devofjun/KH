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
<title>Insert title here</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>글쓰기 수정 폼</h2>

				</div>
				<form role="form" action="/BoardModifyRun.mem" method="post">
					<input type="hidden" name ="b_no" value="${boardVo.b_no}"/>
					<div class="form-group">

						<label for="b_title">글제목</label> <input type="text"
							class="form-control" id="b_title" name="b_title" 
							value="${boardVo.b_title}"/>
					</div>
					<div class="form-group">

						<label for="b_content">글내용</label> <input type="text"
							class="form-control" id="b_content" name="b_content" 
							value="${boardVo.b_content}"/>
					</div>

					<div class="form-group">

						<label for="m_id">작성자</label> <input type="text"
							class="form-control" id="m_id" name="m_id" 
							value="${boardVo.m_id}"/>
					</div>
					<button type="submit" class="btn btn-primary">수정완료</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>