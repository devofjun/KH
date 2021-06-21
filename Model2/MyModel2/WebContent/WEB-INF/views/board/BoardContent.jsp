<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<script>
	$(document).ready(function() {
		$("#btnDelete").click(function() {
			$("#mymodal").trigger("click");
		});
		$("#modalYes").click(function() {
			location.href = "BoardDeleteRun.do?b_no=${vo.b_no}";
		});
		
		$("btnReply").click(function() {
			$("#frmReply").submit();
		});
	});
</script>
<title>게시글</title>
<%@ include file="/include/center.jsp"%>
<div class="container-fluid">
<form id="frmReply" action="/BoardReplyForm.do" method="post">
	<input type="hidden" name="re_group" value="${vo.re_group}"/>
	<input type="hidden" name="re_seq" value="${vo.re_seq}"/>
	<input type="hidden" name="re_level" value="${vo.re_level}"/>
</form>
	<!-- 글 삭제 모달 -->
	<div class="row">
		<div class="col-md-12">
			<a id="mymodal" href="#modal-container-983206" role="button"
				class="btn" data-toggle="modal" style="display:none">삭제 모달</a>

			<div class="modal fade" id="modal-container-983206" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">삭제 확인</h5>
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">정말 삭제하시겠습니까?</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-primary" id="modalYes">네</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">아니오</button>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>
	<!-- 글 삭제 모달 끝 -->
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