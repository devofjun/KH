<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<script>
$(document).ready(function() {
	var modifyResult = "${modifyResult}";
	if(modifyResult == "success"){
		alert("수정성공");
	}
	
	$("#btnModify").click(function(){
		//console.log($(this).prop("class"));
		if($(this).attr("class") == "btn btn-primary"){
			$(this).attr("class", "btn btn-success");
			$("[name^=b_]").prop("readonly", false);
		} else if($(this).attr("class") == "btn btn-success"){
			$("#frmModify").submit();
		}
	});
	
	$("#btnRemove").click(function() {
		//var b_no = $("#b_no").val();
		if(confirm("삭제하시겠습니까?")){
			location.href="/board/RemoveRun?b_no=${boardVo.b_no}";
		}
	});
});
</script>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글쓰기</h2>
				<p>
<!-- 					<a class="btn btn-primary btn-large" href="#">Learn more</a> -->
				</p>
			</div>
			<form id="frmModify" role="form" action="/board/modifyRun" method="post">
				<input type="hidden" id="user_id" value="test"/>
				<input type="hidden" id="b_no" name="b_no" value="${boardVo.b_no}"/>
				<div class="form-group">

					<label for="b_title"> 글제목 </label> <input
						type="text" class="form-control" id="b_title" name="b_title" 
						value="${boardVo.b_title}" readonly/>
						<!-- => name 값이 vo에 들어있는 필드명과 같아야한다. -->
						<!-- 그래야 컨트롤러에서 BoardVo형태의 데이터를 넘겨 받을 수 있다. -->
				</div>
				<div class="form-group">

					<label for="b_content"> 글내용 </label>
					<textarea class="form-control" id="b_content" name="b_content" readonly>${boardVo.b_content}</textarea>
					<!-- name 값이 vo에 들어있는 필드명과 같아	야한다. -->
				</div>
				
				<button id="btnModify" type="button" class="btn btn-primary">수정</button>
				<button id="btnRemove" type="button" class="btn btn-danger">삭제</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>