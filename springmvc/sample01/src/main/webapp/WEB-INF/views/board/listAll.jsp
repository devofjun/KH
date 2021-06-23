<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--jstl은이미 있음 pom.xml-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>
<script>
	var msg = "${msg}";
	if(msg == "success"){
		alert("글 등록 완료");
	}
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글 목록 보기</h2>
				<p></p>
				<p>
					<a class="btn btn-primary btn-large" href="/board/writeForm">글쓰기</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>글번호</th>
						<th>글제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="boardVo" items="${list}">
						<tr>
							<td>${boardVo.b_no}</td>
							<td><a href="/board/content?b_no=${boardVo.b_no}">${boardVo.b_title}</a></td>
							<td>${boardVo.user_id}</td>
							<td>${boardVo.b_reg_date}</td>
							<td>${boardVo.b_viewcnt}</td>
						</tr>
					</c:forEach>

				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>