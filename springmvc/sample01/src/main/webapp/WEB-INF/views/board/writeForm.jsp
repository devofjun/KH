<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- board/writeForm.jsp -->

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글쓰기</h2>
				
			</div>
			<form role="form" action="/board/writeRun" method="post">
				<input type="hidden" name="user_id" value="hong"/>
				
				<div class="form-group">

					<label for="b_title"> 글제목 </label> <input
						type="text" class="form-control" id="b_title" name="b_title"/>
				</div>
				<div class="form-group">

					<label for="b_content"> 글내용 </label>
					<textarea class="form-control" id="b_content" name ="b_content"></textarea>
				</div>
				<button type="submit" class="btn btn-primary">작성완료</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>