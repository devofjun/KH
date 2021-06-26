<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file="../include/header.jsp"%>
<script>
$(document).ready(function() {
	console.log("${pagingDto}")
	// 글쓰기결과 메세지
	var resultWrite = "${resultWrite}";
	if (resultWrite == "success") {
		alert("작성성공");
	}
	// 삭제결과 메세지
	var removeResult = "${removeResult}";
	if (removeResult == "success") {
		alert("삭제성공");
	}
	
	// 페이지 번호 클릭시
	$(".pagination > li > a").click(function(e) {
		e.preventDefault();
		//console.log($(this).attr("href"));
		var page = $(this).attr("href");
		$("#frmPaging > input[name=page]").val(page);
		$("#frmPaging").submit();
	});
	
});
</script>

<form id="frmPaging">
	page:<input type="text" name="page" value="${pagingDto.page}"/>
	perPage:<input type="text" name="perPage" value="${pagingDto.perPage}"/>
	searchType:<input type="text" name="searchType" value="${pagingDto.searchType}"/>
	keyword:<input type="text" name="keyword" value="${pagingDto.keyword}"/>
</form>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>게시글 목록</h2>
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
	<div class="row">
		<div class="col-md-12">
			<nav>
				<!-- justify-content-center 가운데 정렬 -->
				<ul class="pagination justify-content-center">
					<li class="page-item"><a class="page-link" href="#">Previous</a>
					</li>
					<c:forEach var="p" begin="${startPage}" end="${endPage}">
						<li class="page-item"><a class="page-link" href="1">1</a></li>
					</c:forEach>
					<li class="page-item"><a class="page-link" href="#">Next</a></li>
				</ul>
			</nav>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>