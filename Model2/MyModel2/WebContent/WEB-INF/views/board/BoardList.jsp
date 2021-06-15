<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<script>
$(document).ready(function() {
	var resultWrite = "${sessionScope.resultWrite}"; 
	if(resultWrite == "true"){
		alert("글 작성 성공");
	} else if(resultWrite == "false") {
		alert("글 작성 실패");
	}
});
</script>
<title>게시글 목록</title>
<%@ include file="/include/center.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글 목록</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/BoardWriteForm.do">글쓰기</a>
				</p>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>글번호</th>
						<th>이미지</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="vo" items="${list}">
						<tr>
							<td>${vo.b_no}</td>
							<td><c:if test="${not empty vo.b_filepath }">
									<img src="/upload/${vo.b_filepath}" height="30" />
								</c:if></td>
							<td><a href="/BoardContent.do?b_no=${vo.b_no}"> <c:if test="${vo.re_level > 0}">ㄴ</c:if>
									${vo.b_title}
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
<%@ include file="/include/footer.jsp"%>
<%
	session.removeAttribute("resultWrite");
%>