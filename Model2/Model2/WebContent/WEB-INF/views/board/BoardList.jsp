<%@page import="com.kh.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
		var resultWrite = "${sessionScope.resultWrite}"; // 스크립트 안에서는 "" 를 붙여줘야한다.
		if (resultWrite == "true") {
			alert("글 등록 성공");
		} else if (resultWrite == "false") {
			alert("글 등록 실패");
		}

		var resultDelete = "${sessionScope.resultDelete}";
		if (resultDelete == "true") {
			alert("글 삭제 성공");
		} else if (resultDelete == "false") {
			alert("글 삭제 실패");
		}

		var resultReply = "${resultReply}";
		if (resultReply == "true") {
			alert("답글 달기 성공");
		} else if (resultReply == "false") {
			alert("답글 달기 실패");
		}

		var resultLogin = "${resultLogin}";
		if (resultLogin == "true") {
			alert("로그인 성공");
		}
		
		$("ul.pagination > li > a").click(function(e) {
			e.preventDefault();
			var page = $(this).attr("href");
			console.log(page);
			location.href = "/BoardList.do?page=" + page + "&perPage=${pagingDto.perPage}";
		});
		
		$("#perPage").change(function() {
			var perPage = $(this).val();
			console.log("perPage", perPage);
			location.href = "/BoardList.do?perPage=" + perPage;
		});
		
		$("#btnSearch").click(function() {
			var searchType = $("#searchType").val();
			var keyword = $("#keyword").val();
			console.log("searchType:" + searchType);
			console.log("keyword:" + keyword);
			//location.href = "/BoardList.do?"~~~~ 이렇게 하기도하고 아래처럼 폼을 이용해서 넘겨주기도 함.
			$("#frmSearch").find("input[name=searchType]").val(searchType);
			$("#frmSearch").find("input[name=keyword]").val(keyword);
			$("#frmSearch").submit();
		});
	});
</script>


<title>게시판 목록</title>
</head>
<body>
	<!-- EL : Expression Language -->	`
	<!-- 아래로 갈수록 범위가 커짐
pageContext - 페이지 범위
requestScope - 요청 범위
sessionScope - 세션 범위(로그인)
applicationScope - 컨텍스트(Model2) 범위 -->
	<!-- ${requestScope.list} request범위에서 list찾기 -->
	<!-- ${list} 모든 범위에서 list찾기-->
	<form id="frmSearch" action="/BoardList.do" method="get">
		<input type="hidden" name="searchType" />
		<input type="hidden" name="keyword" />
	</form>
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>글목록</h2>
					<p>
						<c:choose>
							<c:when test="${not empty memberVo}">
								${memberVo.user_id}(${memberVo.user_name})님 반갑습니다.
								<a href="/MemberLogout.mem">로그아웃</a>
							</c:when>
							<c:otherwise>
								<a href="/MemberLoginForm.do">로그인</a>
							</c:otherwise>
						</c:choose>
					</p>
					<p>
						<c:if test="${not empty memberVo}">
							<a class="btn btn-primary btn-large" href="/BoardWriteForm.mem">글쓰기</a>
						</c:if>
						<c:if test="${empty memberVo}">
							<a class="btn btn-success btn-large" href="/MemberJoinForm.do">회원가입</a>
						</c:if>
					</p>
				</div>
				<div>
					<select name="perPage" id="perPage">
						<c:forEach var='v' begin="5" end="30" step="5">
						<!-- 현재 선택된 perPage를 selected함. -->
						<option value="${v}"
						<c:if test="${v == pagingDto.perPage}">
							selected
						</c:if>
						>${v}줄씩 보기</option>
						</c:forEach>
					</select>
					
					<span style="margin:0px 20px">|</span>
					<select id="searchType">
						<option value="t">제목</option>
						<option value="c">내용</option>
						<option value="u">작성자</option>
						<option value="tc">제목 + 내용</option>
						<option value="tcu">제목 + 내용 + 작성자</option>
					</select>
					<input type="text" id="keyword">
					<button type="button" id="btnSearch">검색</button>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>글번호</th>
							<th>이미지</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody>
						<!-- 반복문 -->
						<c:forEach var="vo" items="${list}">
							<tr>
								<td>${vo.b_no}</td>
								<!-- 이미지 시작-->
								<td>
								<!-- path가 비어있다면 다른 기본 이미지 출력하기 -->
<%-- 								<c:choose> --%>
<%-- 									<c:when test="${not empty vo.b_filepath}"> --%>
<%-- 										<img src="/upload/${vo.b_filepath}" height="30" /> --%>
<%-- 									</c:when> --%>
<%-- 									<c:otherwise> --%>
<!-- 										<img src="/upload/smile.jpg" height="30" /> -->
<%-- 									</c:otherwise> --%>
<%-- 								</c:choose>  --%>
								<!-- path가 비어있지 않았을때만 이미지 출력하기 --> 
								<c:if test="${not empty vo.b_filepath}">
									<img src="/upload/${vo.b_filepath}" height="50"/>
								</c:if>
								</td>
								<!-- 이미지 끝 -->
								<td><c:choose>
										<c:when test="${not empty memberVo}">
											<a href="BoardContent.mem?b_no=${vo.b_no}"
												style="margin-left:${vo.re_level * 30}px"> <!-- 조건문 -->
												<c:if test="${vo.re_level > 0}">ㄴ</c:if> ${vo.b_title}
											</a>
										</c:when>
										<c:otherwise>
											<c:if test="${vo.re_level > 0}">ㄴ</c:if> ${vo.b_title}
										</c:otherwise>
									</c:choose></td>
								<td>${vo.m_id}</td>
								<td>${vo.b_date}</td>
								<td>${vo.b_readcount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
		<!-- Pagination -->
		<div class="row">
			<div class="col-md-12">
				<nav>
					<ul class="pagination">
						<c:if test="${pagingDto.startPage != 1 }">
							<!-- 첫번째 페이지가 1이 아닐때만 '이전'버튼을 표시한다. -->
							<li class="page-item"><a class="page-link" href="${pagingDto.startPage - 1}">이전</a></li>
						</c:if>
						<!-- 시작페이지 값부터 끝페이지 값까지 반복 -->
						<!-- 현재 페이지와 i와 같다면 클래스에 active 추가 -->
						<c:forEach var="i" begin="${pagingDto.startPage}" end="${pagingDto.endPage}">
						<li 
							<c:choose>
								<c:when test="${i == pagingDto.page}">
									class="page-item active"
								</c:when>
								<c:otherwise>
									class="page-item"
								</c:otherwise>
							</c:choose>
						><a class="page-link" href="${i}">${i}</a></li>
						</c:forEach>
						<!-- 각 페이지버튼은 href속성에 페이지 번호를 가진다. -->
						<!-- 전체페이지수와 끝페이지가 같지 않을때 '다음' 버튼 출력 -->
						<c:if test="${pagingDto.totalPage != pagingDto.endPage }">
							<li class="page-item"><a class="page-link" href="${pagingDto.endPage + 1}">다음</a></li>
						</c:if>
					</ul>
				</nav>
			</div>
		</div>
		<!-- End Pagination -->
	</div>
	<%
		// JSP의 session -> java, 내장객체
		// 한번만 필요한 세션정보는 출력된 뒤에 지워주면 된다.
		session.removeAttribute("resultWrite");
		session.removeAttribute("resultDelete");
		session.removeAttribute("resultReply");
		session.removeAttribute("resultLogin");
	%>
</body>
</html>
