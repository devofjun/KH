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
		if (result == "true") {
			alert("로그인 성공");
		}
	});
</script>


<title>게시판 목록</title>
</head>
<body>
	<!-- EL : Expression Language -->
	<!-- 아래로 갈수록 범위가 커짐
pageContext - 페이지 범위
requestScope - 요청 범위
sessionScope - 세션 범위(로그인)
applicationScope - 컨텍스트(Model2) 범위 -->
	<!-- ${requestScope.list} request범위에서 list찾기 -->
	<!-- ${list} 모든 범위에서 list찾기-->

	<div class="container-fluid">
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>글목록</h2>
					<p>
						<c:choose>
							<c:when test="${not empty memberVo}">
								${memberVo.user_id}(${memberVo.user_name})님 반갑습니다.
							</c:when>
							<c:otherwise>
								<a href="/MemberLoginForm.do">로그인</a>
							</c:otherwise>
						</c:choose>
					</p>
					<p>
						<a class="btn btn-primary btn-large" href="/BoardWriteForm.do">글쓰기</a>
						<c:if test="${empty memberVo}">
							<a class="btn btn-success btn-large" href="/MemberJoinForm.do">회원가입</a>
						</c:if>
					</p>
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
								<td><c:choose>
										<c:when test="${not empty vo.b_filepath}">
											<img src="/upload/${vo.b_filepath}" height="30" />
										</c:when>
										<c:otherwise>
											<img src="/upload/smile.jpg" height="30" />
										</c:otherwise>
									</c:choose> <!-- path가 비어있지 않았을때만 이미지 출력하기 --> <%-- 								<c:if test="${not empty vo.b_filepath}"> --%>
									<%-- 									<img src="/upload/${vo.b_filepath}" height="50"/> --%>
									<%-- 								</c:if> --%></td>
								<td><a href="BoardContent.do?b_no=${vo.b_no}"
									style="margin-left:${vo.re_level * 30}px"> <!-- 조건문 --> <c:if
											test="${vo.re_level > 0}">ㄴ</c:if> ${vo.b_title}
								</a></td>
								<td>${vo.m_id}</td>
								<td>${vo.b_date}</td>
								<td>${vo.b_readcount}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
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
