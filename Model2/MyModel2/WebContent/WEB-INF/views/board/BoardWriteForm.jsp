<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/header.jsp"%>
<title>글쓰기</title>
<%@ include file="/include/center.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글쓰기</h2>
			</div>
			<form role="form" action="/BoardWriteRun.do" method="post"
				enctype="multipart/form-data">
				<div class="form-group">

					<label for="b_title"> 제목 </label> <input type="text"
						class="form-control" id="b_title" name="b_title"/>
				</div>
				<div class="form-group">

					<label for="b_content"> 내용 </label> <input type="text"
						class="form-control" id="b_content" name="b_content"/>
				</div>
				<div class="form-group">

					<label for="m_id"> 작성자 </label> <input type="text"
						class="form-control" id="m_id" name="m_id"/>
				</div>
				<div class="form-group">

					<label for="b_filepath"> 첨부파일 </label> <input type="file"
						class="form-control" id="b_filepath" name="b_filepath"/>
				</div>
				<button type="submit" class="btn btn-primary">완료</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="/include/footer.jsp"%>