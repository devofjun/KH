<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--jstl은이미 있음 pom.xml-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>
<script>
$(document).ready(function() {
	var msg = "${msg}";
	if (msg == "success") {
		alert("글 등록 완료");
	}

	var msgDelete = "${msgDelete}";
	if (msgDelete == "success") {
		alert("글 삭제 완료");
	}
	
	$(".pagination > li > a").click(function(e) {
		e.preventDefault();
		var page = $(this).attr("href");
		//console.log(page);
		var frmPaging = $("#frmPaging");
		frmPaging.find("[name=page]").val(page);
		frmPaging.submit();
	});
});
</script>
<form id="frmPaging" action="/board/listAll" method="get">
	<input type="hidden" name="page" value="${page}"/>
	<input type="hidden" name="perPage" value="10"/>
	<input type="hidden" name="searchType"/>
	<input type="hidden" name="keyword"/>
</form>
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
	<!-- 데이터목록 -->
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
	<!-- // 데이터목록 -->
	<!-- 페이지  -->
	<div class="row">
		<div class="col-md-12 text-center">
			<nav style="width: 30%; float:none; margin:0 auto">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#">&laquo;</a></li>
					<c:forEach var="p" begin="1" end="10">
						<li class="page-item"><a class="page-link" href="${p}">${p}</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link" href="#">&raquo;</a></li>
				</ul>
			</nav>
		</div>
	</div>
	<!-- // 페이지 -->
</div>
<%@ include file="../include/footer.jsp"%>