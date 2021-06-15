<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<title>게시글</title>
<%@ include file="/include/center.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글보기</h2>
				<p>
					<a type="button" class="btn btn-warning"
						href="BoardModifyForm.do?b_no=${boardVo.b_no}">수정</a>
					<button id="btnDelete" type="button" class="btn btn-danger">삭제</button>
					<a class="btn btn-success" href="BoardList.do">목록</a>
					<button type="button" class="btn btn-primary" id="btnReply">답글</button>
				</p>
			</div>
			<div class="row">
				<div class="col-md-9">
					<h3>여기는 제목</h3>
				</div>
				<div class="col-md-1">
					<span class="badge badge-default">작성일: </span>
				</div>
				<div class="col-md-1">
					<span class="badge badge-default">작성자: </span>
				</div>
				<div class="col-md-1">
					<span class="badge badge-default">조회수: </span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4">
					<img alt="Bootstrap Image Preview"
						src="https://www.layoutit.com/img/sports-q-c-140-140-3.jpg" />
				</div>
				<div class="col-md-8">
					<p>
						여기는 글 내용
					</p>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/include/footer.jsp"%>