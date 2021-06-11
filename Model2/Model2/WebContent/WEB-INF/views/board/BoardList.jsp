<%@page import="com.kh.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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
						<a class="btn btn-primary btn-large" href="/BoardWriteForm.do">글쓰기</a>
					</p>
				</div>
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
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>${vo.b_no}</td>
							<td>${vo.b_title}</td>
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
</body>
</html>