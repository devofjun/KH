<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<title>글 수정하기</title>
<%@ include file="/include/center.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글 수정하기</h2>
			</div>
			<form role="form" action="/BoardModifyRun.do" method="post">
				<input type="hidden" name="b_no" value="${vo.b_no}"/>
				<div class="form-group">

					<label for="b_title"> 제목 </label> <input type="text"
						class="form-control" id="b_title" name="b_title" 
						value="${vo.b_title}"/>
				</div>
				<div class="form-group">

					<label for="b_content"> 내용 </label> <input type="text"
						class="form-control" id="b_content" name="b_content" 
						value="${vo.b_content}"/>
				</div>
				<div class="form-group">

					<label for="m_id"> 작성자 </label> <input type="text"
						class="form-control" id="m_id" name="m_id" 
						value="${vo.m_id}"/>
				</div>
				
				<button type="submit" class="btn btn-primary">완료</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="/include/footer.jsp"%>