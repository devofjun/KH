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
		
		// 검색버튼 클릭시
		$("#btnSearch").click(function() {
			var keyword =$("#searchKeyword").val();
			$("#frmPaging > input[name=keyword]").val(keyword);
			$("#frmPaging > input[name=page]").val("1");
			$("#frmPaging").submit();
		});
		
		// 검색 옵션 선택시
		$(".searchType").click(function(e){
			e.preventDefault();
			var type = $(this).attr("href");
			$("#frmPaging > input[name=searchType]").val(type);
			var textType =$(this).text();
			$("#dropdownMenuLink").text(textType);
		});
		

	});
</script>

<form id="frmPaging" action="/board/listAll" method="post">
	page:<input type="text" name="page" value="${pagingDto.page}" />
	perPage:<input type="text" name="perPage" value="${pagingDto.perPage}" />
	searchType:<input type="text" name="searchType"
		value="${pagingDto.searchType}" /> keyword:<input type="text"
		name="keyword" value="${pagingDto.keyword}" />
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
		<form
			class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
			<div class="input-group">
				<div class="dropdown" style="margin-right: 5px;">
					<a class="btn btn-default dropdown-toggle" href="#" role="button"
						id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true"
						aria-expanded="false"> 검색 옵션 </a>
					<div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
						<a class="dropdown-item searchType" href="t">제목</a>
						<a class="dropdown-item searchType" href="c">내용</a>
						<a class="dropdown-item searchType" href="u">작성자</a> 
						<a class="dropdown-item searchType" href="tc">제목 + 내용</a> 
						<a class="dropdown-item searchType" href="tcu">제목 + 내용 + 작성자</a>
					</div>
				</div>
				<input id="searchKeyword" type="text" class="form-control bg-light border-0 small"
					placeholder="검색어 입력" aria-label="Search" aria-describedby="basic-addon2"
					value="${pagingDto.keyword}">
				<div class="input-group-append">
					<button id="btnSearch" class="btn btn-primary" type="button">
						<i class="fas fa-search fa-sm"></i>
					</button>
				</div>
			</div>
		</form>
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
					<c:if test="${pagingDto.startPage != 1 }">
						<li class="page-item"><a class="page-link"
							href="${pagingDto.startPage-1}">&laquo;</a></li>
					</c:if>
					<c:forEach var="p" begin="${pagingDto.startPage}"
						end="${pagingDto.endPage}">
						<c:choose>
							<c:when test="${pagingDto.page == p}">
								<li class="page-item active"><a class="page-link"
									href="${p}">${p}</a></li>
							</c:when>
							<c:otherwise>
								<li class="page-item"><a class="page-link" href="${p}">${p}</a></li>
							</c:otherwise>
						</c:choose>
					</c:forEach>
					<c:if test="${pagingDto.endPage < pagingDto.totalPage }">
						<li class="page-item"><a class="page-link"
							href="${pagingDto.endPage+1}">&raquo;</a></li>
					</c:if>
				</ul>
			</nav>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>