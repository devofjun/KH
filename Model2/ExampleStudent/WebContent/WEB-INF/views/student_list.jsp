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
								<a class="btn btn-warning btn-large" href="/StudentDeleteRun.kh?sno=${vo.sno}">삭제</a>
							</td>
						</tr>
					</c:forEach>
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