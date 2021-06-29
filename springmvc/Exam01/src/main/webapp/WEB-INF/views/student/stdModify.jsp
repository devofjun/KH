<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>학생 정보 수정</title>
<script>
$(document).ready(function() {
	$("#btnModifyRun").click(function(e) {
		e.preventDefault();
		var chk = true;
		

		var score = parseInt($("#score").val().trim());
		if(score < 0 || score > 100){
			alert("점수는 0~100값만 입력하세요.");
			chk = false;
		}
		
		
		if(chk == true){
			$("#frmRegist").submit();			
		}
	});
});
</script>
</head>
<body>
<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>학생 등록 페이지</h2>
<!-- 					<p>This is a template for a simple marketing or informational -->
<!-- 						website. It includes a large callout called the hero unit and -->
<!-- 						three supporting pieces of content. Use it as a starting point to -->
<!-- 						create something more unique.</p> -->
					<p>
						<a class="btn btn-primary btn-large" href="/std/stdList">목록</a>
					</p>
				</div>
				<form id="frmRegist" role="form" action="/std/stdModifyRun" method="post">
					<div class="form-group">

						<label for="sno"> 학번 </label> <input
							type="text" class="form-control" id="sno" name="sno"
							value="${studentVo.sno}" readonly/>
					</div>
					
					<div class="form-group">

						<label for="sname"> 이름 </label> <input
							type="text" class="form-control" id="sname" name="sname"
							value="${studentVo.sname}" required/>
					</div>
					
					<div class="form-group">

						<label for="syear"> 학년 </label>
						<select id="syear" name="syear">
							<option value="1"
							<c:if test="${studentVo.syear == 1}">selected</c:if>
							>1</option>
							<option value="2"
							<c:if test="${studentVo.syear == 2}">selected</c:if>
							>2</option>	
							<option value="3"
							<c:if test="${studentVo.syear == 3}">selected</c:if>
							>3</option>
							<option value="4"
							<c:if test="${studentVo.syear == 4}">selected</c:if>
							>4</option>
						</select>
					</div>
					<div class="form-group">

						<p>성별</p>
						<c:choose>
							<c:when test='${studentVo.gender == "M"}'>
								<label><input type="radio" name="gender" value="M" checked> 남자</label>
								<label><input type="radio" name="gender" value="F"> 여자</label>
							</c:when>
      						<c:otherwise>
      							<label><input type="radio" name="gender" value="M"> 남자</label>
								<label><input type="radio" name="gender" value="F" checked> 여자</label>
      						</c:otherwise>
      					</c:choose>
					</div>
					
					<div class="form-group">

						<label for="major"> 전공 </label> <input
							type="text" class="form-control" id="major" name="major"
							value="${studentVo.major}"/>
					</div>
					
					<div class="form-group">

						<label for="score"> 점수 </label> <input
							type="number" class="form-control" id="score" name="score"
							value="${studentVo.score}"/>
					</div>
					
					<button id="btnModifyRun" type="submit" class="btn btn-primary">수정하기</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>