<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글쓰기</h2>
				<p>
<!-- 					<a class="btn btn-primary btn-large" href="#">Learn more</a> -->
				</p>
			</div>
			<form role="form" action="/board/writeRun" method="post">
				<input type="hidden" name="user_id" value="kim"/>
				<div class="form-group">

					<label for="b_title"> 글제목 </label> <input
						type="text" class="form-control" id="b_title" name="b_title" />
						<!-- => name 값이 vo에 들어있는 필드명과 같아야한다. -->
						<!-- 그래야 컨트롤러에서 BoardVo형태의 데이터를 넘겨 받을 수 있다. -->
				</div>
				<div class="form-group">

					<label for="b_content"> 글내용 </label>
					<textarea class="form-control" id="b_content" name="b_content"></textarea>
					<!-- name 값이 vo에 들어있는 필드명과 같아야한다. -->
				</div>
				
				<button type="submit" class="btn btn-primary">글쓰기</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>