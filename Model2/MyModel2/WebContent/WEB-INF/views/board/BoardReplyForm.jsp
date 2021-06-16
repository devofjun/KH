<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/include/header.jsp"%>
<title>댓글 작성</title>
<%@ include file="/include/center.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>댓글 달기</h2>
			</div>
			<form role="form" action="/BoardReplyRun.do" method="post">
				<input type="hidden" name="re_group" value="${vo.re_group}"/>
				<input type="hidden" name="re_seq" value="${vo.re_seq}"/>
				<input type="hidden" name="re_level" value="${vo.re_level}"/>
				
				<div class="form-group">

					<label for="b_title"> 제목 </label> <input type="text"
						class="form-control" id="b_title" name="b_title" 
						value="s"/>
				</div>
				<div class="form-group">

					<label for="b_content"> 내용 </label> <input type="text"
						class="form-control" id="b_content" name="b_content" 
						value=""/>
				</div>
				<div class="form-group">

					<label for="m_id"> 작성자 </label> <input type="text"
						class="form-control" id="m_id" name="m_id" 
						value=""/>
				</div>
				
				<button type="submit" class="btn btn-primary">완료</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="/include/footer.jsp"%>