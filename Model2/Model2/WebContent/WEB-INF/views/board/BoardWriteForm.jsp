<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>BoardWriteForm.jsp</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>글쓰기폼</h2>
					
				</div>
				<form role="form" action="/BoardWriteRun.do" method="post">
					<div class="form-group">

						<label for="exampleInputEmail1"> Email address </label> <input
							type="email" class="form-control" id="exampleInputEmail1" />
					</div>
					<div class="form-group">

						<label for="exampleInputPassword1"> Password </label> <input
							type="password" class="form-control" id="exampleInputPassword1" />
					</div>
					<div class="form-group">

						<label for="exampleInputFile"> File input </label> <input
							type="file" class="form-control-file" id="exampleInputFile" />
						<p class="help-block">Example block-level help text here.</p>
					</div>
					<div class="checkbox">

						<label> <input type="checkbox" /> Check me out
						</label>
					</div>
					<button type="submit" class="btn btn-primary">작성완료</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>