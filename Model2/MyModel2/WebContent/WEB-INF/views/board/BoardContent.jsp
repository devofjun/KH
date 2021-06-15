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
					<a class="btn btn-success" href="BoardList.do">목록</a>
					<button type="button" class="btn btn-primary" id="btnReply">답글</button>
					<a type="button" class="btn btn-warning"
						href="BoardModifyForm.do?b_no=${vo.b_no}">수정</a>
					<button id="btnDelete" type="button" class="btn btn-danger">삭제</button>
				</p>
			</div>
			<div class="row">
				<div class="col-md-8">
					<h3>${vo.b_title}</h3>
				</div>
				<div class="col-md-2">
					<span class="badge badge-default">작성일: ${vo.b_date}</span>
				</div>
				<div class="col-md-1">
					<span class="badge badge-default">작성자: ${vo.m_id}</span>
				</div>
				<div class="col-md-1">
					<span class="badge badge-default">조회수: ${vo.b_readcount}</span>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4" style="background: #F5F5F5">
					<img alt="Bootstrap Image Preview" src="/upload/${vo.b_filepath }" />
				</div>
				<div class="col-md-8" style="background: #DCDCDC">
					<p>${vo.b_content}</p>
				</div>
			</div>
			
		</div>
	</div>
</div>
<%@ include file="/include/footer.jsp"%>