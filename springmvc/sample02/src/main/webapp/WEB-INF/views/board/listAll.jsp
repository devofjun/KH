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
		
		// 글제목 클릭시
		$(".a_title").click(function(e){
			e.preventDefault();
			// 페이징 정보도 넘겨주기 위함 => 목록으로 다시 돌아갈때 보고 있던 페이지 출력하기
			var bno = $(this).attr("data-bno");
			$("#frmPaging > input[name=b_no]").val(bno);
			$("#frmPaging").attr("action", "/board/content");
			$("#frmPaging").submit();
		});
		
		$(".sendMessage").click(function() {
			var user_id = $(this).attr("data-user_id");
			$("#btnSendMessage").attr("data-msg_receiver", user_id);
		});
		
		// 쪽지보내기 링크
		$("#btnSendMessage").click(function() {
			var that = $(this);
			var msg_sender = "hong";
			var msg_receiver = $(this).attr("data-msg_receiver");
			var msg_content = $("#msg_content").val();
			var sendData = {
				"msg_sender" : msg_sender,
				"msg_receiver" : msg_receiver,
				"msg_content" : msg_content
			};
			console.log(sendData);
			var url = "/message/sendMessage";
// 			$.post(url, sendData, function(rData){
// 				console.log(rData);
// 			})
			$.ajax({
				"url" : url,
				"method" : "post",
				"dataType" : "text", // 응답 데이터에 대한 타입
				"headers" : {
					"Content-Type" : "application/json" // 요청 데이터에 대한 타입
				},
				"data" : JSON.stringify(sendData), // 문자열 객체로 변환시켜줌
				"success" : function(receivedData){
					console.log(receivedData)
					if(receivedData == "success"){ 
						that.next().trigger("click"); // 창닫기
					}
				}
			});
		});
	});
</script>
<!-- 링크 공유가 가능하게 하기 위해서 get방식으로 보내는게 좋음 -->
<form id="frmPaging" action="/board/listAll" method="get">
	<!-- page: --><input type="hidden" name="page" value="${pagingDto.page}" />
	<!-- perPage: --><input type="hidden" name="perPage" value="${pagingDto.perPage}" />
	<!-- searchType: --><input type="hidden" name="searchType" value="${pagingDto.searchType}" />
	<!-- keyword: --><input type="hidden" name="keyword" value="${pagingDto.keyword}" />
	<!-- b_no: --><input type="hidden" name="b_no"/>
</form>

<!-- 쪽지 보내기 모달창 -->
<div class="row">
	<div class="col-md-12">
		<!-- <a id="modal-388406" href="#modal-container-388406" role="button"
			class="btn" data-toggle="modal">모달</a> -->

		<div class="modal fade" id="modal-container-388406" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="myModalLabel">쪽지 보내기</h5>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<input type="text" class="form-control" id="msg_content"/>
					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-primary"
							id="btnSendMessage">보내기</button>
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">닫기</button>
					</div>
				</div>
			</div>
		</div>

	</div>
</div>
<!-- //쪽지 보내기 모달창 -->

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
							<!-- 제목 -->
							<td> 
								<ul class="nav nav-pills">
									<li class="nav-item"><a class="a_title nav-link" href="#"
										data-bno="${boardVo.b_no}">${boardVo.b_title} <span
											class="badge badge-info">${boardVo.comment_cnt}</span>
									</a></li>
								</ul>
							</td>
							<td>
								<div class="dropdown">

									<button class="btn btn-default" type="button"
										id="dropdownMenuButton" data-toggle="dropdown">
										${boardVo.user_id}</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
										<a class="dropdown-item sendMessage"
											href="#modal-container-388406" data-toggle="modal"
											data-user_id="${boardVo.user_id}">쪽지 보내기</a> <a
											class="dropdown-item" href="#">포인트 선물하기</a>
									</div>
								</div>
							</td>
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