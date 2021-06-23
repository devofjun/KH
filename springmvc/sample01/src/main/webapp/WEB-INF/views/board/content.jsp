<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../include/header.jsp"%>


<script>
	$(document).ready(function() {
		$("#btnModify").click(function() {
			$("#btnModifyFinish").show();
			// name 속성이 b_로 시작하는~ 셀렉터
			$("[name^=b_]").prop("readonly", false);
		});
	});
	
</script>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글 내용보기</h2>
				
			</div>
			<form role="form" action="/board/modifyRun" method="post">
				<input type="hidden" name="user_id" value="hong"/>
				
				<div class="form-group">

					<label for="b_title"> 글제목 </label> <input
						type="text" class="form-control" id="b_title" name="b_title"
						value="${boardVo.b_title}" readonly/>
				</div>
				<div class="form-group">

					<label for="b_content"> 글내용 </label>
					<textarea class="form-control" id="b_content" name ="b_content" readonly>${boardVo.b_content}</textarea>
				</div>
				<button type="button" class="btn btn-primary" id="btnModify">수정</button>
				<button type="submit" class="btn btn-success" id="btnModifyFinish" style="display:none">수정 완료</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="../include/footer.jsp"%>