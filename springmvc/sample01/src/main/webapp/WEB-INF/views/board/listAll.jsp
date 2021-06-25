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

		// 페이지 번호
		$(".pagination > li > a").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href");
			//console.log(page);
			var frmPaging = $("#frmPaging");
			frmPaging.find("[name=page]").val(page);
			frmPaging.submit();
		});

		// 검색 옵션 선택
		$(".searchType").click(function(e) {
			e.preventDefault();
			var searchType = $(this).attr("href");
			$("#frmPaging > input[name=searchType]").val(searchType);
			$("#spanSearchType").text($(this).text());
		});
		
		$("#btnSearch").click(function() {
			var searchType = $("#frmPaging > input[name=searchType]").val();
			if(searchType == ""){
				alert("검색 옵션을 먼저 선택해주세요.");
				return;
			}
			
			var keyword = $("#txtSearch").val().trim();
			if(keyword== ""){
				alert("검색어를 입력해 주세요.");
				return;
			}
			
			$("#frmPaging > input[name=keyword]").val(keyword);
			$("#frmPaging > input[name=page]").val("1");
			$("#frmPaging").submit();
		});
	});
</script>
<form id="frmPaging" action="/board/listAll" method="get">
	<input type="text" name="page" value="${pagingDto.page}" />
	<input type="text" name="perPage" value="${pagingDto.perPage}" /> 
	<input type="text" name="searchType" value="${pagingDto.searchType}"/> 
	<input type="text" name="keyword" value="${pagingDto.keyword}"/>
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

	<!-- 검색  -->
	<div class="row">
		<div class="col-md-12">
			<div class="dropdown">

				<button class="btn btn-default dropdown-toggle" type="button"
					id="dropdownMenuButton" data-toggle="dropdown">검색옵션</button>
					<span id="spanSearchType" style="color:#336699">
					<c:choose>
						<c:when test="${pagingDto.searchType == 't'}">제목</c:when>
						<c:when test="${pagingDto.searchType == 'c'}">내용</c:when>
						<c:when test="${pagingDto.searchType == 'u'}">작성자</c:when>
						<c:when test="${pagingDto.searchType == 'tc'}">제목+내용</c:when>
						<c:when test="${pagingDto.searchType == 'tcu'}">제목+내용+작성자</c:when>
					</c:choose>
					</span>
				<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
					<a class="dropdown-item searchType" href="t">제목</a> <a
						class="dropdown-item searchType" href="c">내용</a> <a
						class="dropdown-item searchType" href="u">작성자</a> <a
						class="dropdown-item searchType" href="tc">제목+내용</a> <a
						class="dropdown-item searchType" href="tcu">제목+내용+작성자</a>
				</div>
				<form
					class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
					<div class="input-group">
						<input id="txtSearch"type="text" class="form-control bg-light border-0 small" placeholder="검색어 입력..."
							placeholder="Search for..." aria-label="Search"
							aria-describedby="basic-addon2" value="${pagingDto.keyword}">
						<div class="input-group-append">
							<button id="btnSearch"class="btn btn-primary" type="button">
								<i class="fas fa-search fa-sm"></i>
							</button>
						</div>
					</div>
				</form>
				<!-- 				<button id="btnSearch" type="button" class="btn btn-success">검색</button> -->
			</div>
		</div>
	</div>
	<!-- //검색  -->

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
			<nav style="width: 30%; float: none; margin: 0 auto">
				<ul class="pagination">
					<c:if test="${pagingDto.startPage != 1 }">
						<li class="page-item"><a class="page-link"
							href="${pagingDto.startPage - 1}">&laquo;</a></li>
					</c:if>
					<c:forEach var="p" begin="${pagingDto.startPage}"
						end="${pagingDto.endPage}">
						<li class="page-item "><a class="page-link" href="${p}">${p}</a></li>
					</c:forEach>
					<c:if test="${pagingDto.endPage < pagingDto.totalPage}">
						<li class="page-item"><a class="page-link"
							href="${pagingDto.endPage + 1}">&raquo;</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
	<!-- // 페이지 -->
</div>
<%@ include file="../include/footer.jsp"%>