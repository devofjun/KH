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
<title>학생목록</title>
<script>
$(document).ready(function() {
	var registResult = "${registResult}";
	if(registResult == "success"){
		alert("등록성공");
	}
	var modifyResult = "${modifyResult}";
	if(modifyResult == "success"){
		alert("수정성공");
	}
	var removeResult = "${removeResult}";
	if(removeResult == "success"){
		alert("삭제성공");
	}
	// 수정버튼
	$(".btnModify").click(function() {
		var sno = $(this).attr("data-sno");
		//console.log(sno);
		location.href = "/std/stdModify/"+sno;
	});
	
	// 삭제버튼
	$(".btnRemove").click(function() {
		var sno = $(this).attr("data-sno");
		var sname = $(this).parent().parent().find("td").eq(1).text();
		if(confirm(sname+"를 삭제하시겠습니까?")){
			location.href = "/std/stdRemoveRun/"+sno;
		}
	});
	
	/* $(".option").click(function() {
		$("#navbarDropdownMenuLink").text($(this).text());
		var option = $(this).attr("data-option");
		$("#searchOption").val(option);
	}); */
	
	// 학생 클릭 => 상담목록
	$(".oneStudent").click(function() {
		//console.log("test");
		var sno = $(this).find("td").eq(0).text();
		var url = "/consult/showList/"+sno;
		
		$("#consultList > tr:gt(0)").remove();
		$.get(url, function(rData){
			console.log(rData);
			$.each(rData, function(){
				var clone = $("#consultList > tr:first").clone();
				var td = clone.find("td");
				var date = new Date(this.consult_date);
				td.eq(0).text(this.consult_no);
				td.eq(1).text(this.sname);
				td.eq(2).text(this.consult_content);
				td.eq(3).text(date.toLocaleString());
				$("#consultList").append(clone);
				clone.show();
			});
		});
	});
	
// 	$("#btnAddConsult").click(function() {
// 		console.log($(this).attr("date-sname"));
// 		$(".modal-title").text("님 상담내역 추가");
// 	});
	
});
</script>
</head>
<body>
	<!-- 상담추가 모달 -->
	<a id="modal-273731" href="#modal-container-273731" role="button"
		class="btn" data-toggle="modal" style="display:none">Launch demo modal</a>

	<div class="modal fade" id="modal-container-273731" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="myModalLabel">Modal title</h5>
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">×</span>
					</button>
				</div>
				<div class="modal-body">...</div>
				<div class="modal-footer">

					<button type="button" class="btn btn-primary">Save changes
					</button>
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
				</div>
			</div>

		</div>

	</div>
	<!-- //상담추가 모달 -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>학생정보목록</h2>
					<p>
						<a class="btn btn-primary btn-large" href="/std/stdRegist">등록하기</a>
					</p>
				</div>
				
				<!-- 검색 -->
				<!-- <nav class="navbar navbar-expand-lg navbar-light bg-light">

					<button class="navbar-toggler" type="button" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse"
						id="bs-example-navbar-collapse-1">
						<ul class="navbar-nav">
							<li class="nav-item dropdown"><a
								class="nav-link dropdown-toggle" href="http://example.com"
								id="navbarDropdownMenuLink" data-toggle="dropdown">검색 옵션</a>
								<div class="dropdown-menu"
									aria-labelledby="navbarDropdownMenuLink">
									<a class="option dropdown-item" href="#" data-option="sno">학번</a>
									<a class="option dropdown-item" href="#" data-option="sname">이름</a> 
									<a class="option dropdown-item" href="#" data-option="major">전공</a>
								</div></li>
						</ul>
						<form class="form-inline" action="/std/stdSearch" method="get">
							<input id="searchOption" name="searchOption" type="hidden"/>
							<input class="form-control mr-sm-2" name="keyword" type="text" />
							<button class="btn btn-primary my-2 my-sm-0" type="button">
								검색</button>
						</form>
					</div>
				</nav> -->
				<!-- //검색 -->
				
				<!-- 학생목록 -->
				<table class="table">
					<thead>
						<tr>
							<th>학번</th>
							<th>이름</th>
							<th>학년</th>
							<th>성별</th>
							<th>전공</th>
							<th>점수</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="stdVo" items="${list}">
						<tr class="oneStudent">
							<td>${stdVo.sno}</td>
							<td>${stdVo.sname}</td>
							<td>${stdVo.syear}</td>
							<td>
							<c:choose>
								<c:when test='${stdVo.gender=="M"}'>남자</c:when>
								<c:otherwise>여자</c:otherwise>
							</c:choose>
							</td>
							<td>${stdVo.major}</td>
							<td>${stdVo.score}</td>
							<td>
							<button type="button" class="btnModify btn btn-warning btn-sm" data-sno="${stdVo.sno}">수정</button>
							<button type="button" class="btnRemove btn btn-danger btn-sm" data-sno="${stdVo.sno}">삭제</button>
							<a type="button" class="btnAddConsult btn btn-info btn-sm" data-sno="${stdVo.sno}" data-sname="${stdVo.sname}"
							href="#modal-container-273731" data-toggle="modal">상담추가</a>
							</td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
				<!-- //학생목록 -->
				
				<!-- 상담목록 -->
				<table  class="table">
					<thead>
						<tr>
							<th>상담번호</th>
							<th>상담학생</th>
							<th>상담내용</th>
							<th>상담일시</th>
						</tr>
					</thead>
					<tbody id="consultList">
						<tr>
							<td></td>
							<td></td>
							<td></td>
							<td></td>
						</tr>
					</tbody>
				</table>
				<!-- //상담목록 -->
			</div>
		</div>
	</div>
</body>
</html>