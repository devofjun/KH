<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="/WEB-INF/include/header.jsp"%>
<script>
$(document).ready(function() {
	var resultRegist = "${resultRegist}";
	if(resultRegist == "true"){
		alert("등록성공");
	} else if(resultRegist == "false"){
		alert("등록실패");
	}
	var resultModify = "${resultModify}";
	if(resultModify == "true"){
		alert("수정성공");
	} else if(resultModify == "false"){
		alert("수정실패");
	}
	var resultDelete = "${resultDelete}";
	if(resultDelete == "true"){
		alert("삭제성공");
	} else if(resultDelete == "false"){
		alert("삭제실패");
	}
	
	$(".btnConsult").click(function() {
		$("#consultTable > tbody").empty();
		
		var sno = $(this).attr("data-sno");
		var url = "/StudentConsultList.kh";
		var sData = {"sno" : sno};
		
		$.getJSON(url, sData, function(rData){
			console.log(rData);
			var tr = ""
			$.each(rData, function() {
				tr += "<tr>";
				tr += "<td>" + this.c_no + "</td>";
				tr += "<td>" + this.sno + "</td>";
				tr += "<td>" + this.c_content + "</td>";
				tr += "<td>" + this.c_date + "</td>";
				tr += "</tr>";
				$("#consultTable > tbody").append(tr);
				tr = "";
			});
		});
		$("#consultTable").show();
	});
	
});
</script>
<title>학생목록</title>
<%@ include file="/WEB-INF/include/bodystarter.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>학생 정보 목록</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/StudentRegistForm.kh">등록하기</a>
				</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>학번</th>
						<th>학생명</th>
						<th>학년</th>
						<th>성별</th>
						<th>전공</th>
						<th>점수</th>
						<th>#</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>${vo.sno}</td>
							<td>${vo.sname}</td>
							<td>${vo.syear}</td>
							<td>${vo.gender}</td>
							<td>${vo.major}</td>
							<td>${vo.score}</td>
							<td>	
								<a class="btn btn-success btn-large" href="/StudentModifyForm.kh?sno=${vo.sno}">수정</a>
								<a class="btn btn-danger btn-large" href="/StudentDeleteRun.kh?sno=${vo.sno}">삭제</a>
								<a class="btn btn-warning btn-large btnConsult" data-sno="${vo.sno}">상담내역</a>
								<a class="btn btn-primary btn-large btnConsultInsert" href="/StudentConsultForm.kh?sno=${vo.sno}">상담내역추가</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<table id="consultTable"class="table" style="display:none">
				<thead>
					<tr>
						<th>상담번호</th>
						<th>상담학생</th>
						<th>상담내역</th>
						<th>상담일</th>
					</tr>
				</thead>
				<tbody>
				
				</tbody>
			</table>
		</div>
	</div>
</div>
<% 
	session.removeAttribute("resultRegist");
	session.removeAttribute("resultModify");
	session.removeAttribute("resultDelete");
%>
<%@ include file="/WEB-INF/include/footer.jsp"%>