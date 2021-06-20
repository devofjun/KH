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
	$(document).ready(function() {
		var resultModify = "${sessionScope.resultModify}";
		if(resultModify == "true"){
			alert("수정성공");
		} else if(resultModify == "false"){
			alert("수정실패");
		}
		
		
		$("#btnDelete").click(function() {
			/*
			var conf = confirm("삭제하시겠습니까?");
			console.log(conf); // 확인->true, 취소->false
			if (conf == true) {i
				location.href = "/BoardDeleteRun.do?b_no=${boardVo.b_no}";
			}
			 */
			// 모달을 클릭하게 한다.
			$("#myModal").trigger("click");
		});
		$("#modalYes").click(function() {
			location.href = "BoardDeleteRun.mem?b_no=${boardVo.b_no}";
		});
		
		// 답글버튼
		$("#btnReply").click(function() {
			//location = "/BoardReplyForm.do?re_group=${boardVo.re_group}&re_seq=${boardVo.re_seq}&re_level=${boardVo.re_level}";
			$("#frmReply").submit();
		});
		
		// 댓글 보기 버튼
		$("#btnComment").click(function() {
			// 테이블을 한번 비우고 다시 출력
			$("#commentTable > tbody").empty();
			var b_no = $(this).attr("data-bno");
			//console.log(b_no);
			var url = "/CommentList.mem";
			var sData = {"b_no" : b_no};
			//console.log("this:"+this);
			// 비동기 방식으로 넘어오는 데이터는 json 데이터로 받는것이 좋다.
			$.getJSON(url, sData, function(rData){
				//console.log(rData); // json 형태로 받아오는지 확인해야한다.
				//console.log("this:"+this); // -> 자바스크립트
				//console.log("$this:"$(this)); // -> 문서?
				var tr = ""
				
				// 이안에서의 this는 자바스크립트의 this이다. -> 자바스크립트 안에 JSON 데이터가 있음
				// 댓글이 보여질 곳에 태그가 달린 문자열을 추가한다.
				$.each(rData, function() {
					tr += "<tr>";
					tr += "<td>" + this.c_no + "</td>";
					tr += "<td>" + this.c_content + "</td>";
					tr += "<td>" + this.m_id + "</td>";
					tr += "<td>" + this.c_date + "</td>";
					tr += "</tr>";
					$("#commentTable > tbody").append(tr);
					tr = "";
				});
			});
			$("#commentTable").show();
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<!-- 답글에 필요한 정보를 넘겨주기 위한 폼 -->
<form id="frmReply" action="/BoardReplyForm.mem" method="get">
	<input type="hidden" name="re_group" value="${boardVo.re_group}"/>
	<input type="hidden" name="re_seq" value="${boardVo.re_seq}"/>
	<input type="hidden" name="re_level" value="${boardVo.re_level}"/>
</form>

	<div class="container-fluid">
		<!-- 모달 -->
		<div class="row">
			<div class="col-md-12">
				<a id="myModal" href="#modal-container-742914" role="button"
					class="btn" data-toggle="modal" style="display: none">Launch
					demo modal</a>

				<div class="modal fade" id="modal-container-742914" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog" role="document">
						<div class="modal-content">
							<div class="modal-header">
								<h5 class="modal-title" id="myModalLabel">삭제 확인</h5>
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">×</span>
								</button>
							</div>
							<div class="modal-body">삭제하시겠습니까?</div>
							<div class="modal-footer">

								<button type="button" class="btn btn-primary" id="modalYes">예</button>
								<button type="button" class="btn btn-secondary"
									data-dismiss="modal">아니오</button>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- 모달 끝 -->
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>상세보기</h2>
					<p>
						<a type="button" class="btn btn-warning"
							href="BoardModifyForm.mem?b_no=${boardVo.b_no}">수정</a>
						<button id="btnDelete" type="button" class="btn btn-danger">삭제</button>
						<a class="btn btn-success" href="BoardList.do">목록</a>
						<button type="button" class="btn btn-primary"
							id="btnReply">답글</button>
					</p>
				</div>
				<table class="table">
					<tbody>
						<tr>
							<th>글번호</th>
							<td>${boardVo.b_no}</td>
						<tr>
							<th>글제목</th>
							<td>${boardVo.b_title}</td>
						<tr>
							<th>글내용</th>
							<td>${boardVo.b_content}</td>	
						<tr>

							<th>작성일</th>
							<td>${boardVo.b_date}</td>
						<tr>

							<th>작성자</th>
							<td>${boardVo.m_id}</td>
						<tr>

							<th>조회수</th>
							<td>${boardVo.b_readcount}</td>
						<tr>
						<tr>	
							<th>첨부파일</th>
							<td><img src="/upload/${boardVo.b_filepath}"/></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<hr/>
		<div class="row">
			<div class="col-md-12">
			<!-- data-bno 는 bno같이 정의되지 않은 쓰고 싶은 속성이 있다면 쓰는 속성이다. -->
			<!-- 원글의 번호 -->
				<button type="button" id="btnComment" class="btn btn-primary"
					data-bno="${boardVo.b_no}">댓글보기</button>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12">
			<!-- 댓글보기 누르면 테이블이 보여짐 -->
				<table class="table" id="commentTable" style="display:none">
					<thead>
						<tr>
							<th>#</th>
							<th>내용</th>
							<th>작성자</th>
							<th>작성일</th>
						</tr>
					</thead>
					<tbody>
					<!-- 댓글보기 버튼 누르면 테이블이 채워짐 -->
					</tbody>
				</table>
			</div>
		</div>
	</div>
<% 
	session.removeAttribute("resultModify");
%>
</body>
</html>