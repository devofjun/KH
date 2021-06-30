<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<style>
	#fileDrop {
		width : 80%;
		height : 100px;
		background-color : yellow;
		margin : 20px auto;
		border : 2px dashed blue;
	}
</style>
<script>
$(document).ready(function() {
	// 해당 영역 진입하는 시점, 해당 영역에 있을때
	$("#fileDrop").on("dragenter dragover", function(e) {
		e.preventDefault();
		
	});
	
	// 해당 영역에서 마우스를 놨을때
	$("#fileDrop").on("drop",function(e) {
		e.preventDefault();
		console.log(e);
		var file = e.originalEvent.dataTransfer.files[0];
		console.log(file);
		// 이미지파일(바이너리 파일)
		// <form enctype="multipart/formdata">
		// 		<input type="file"/>
		// </form>
		var formData = new FormData(); // <form>을 만들었다고 이해하자
		formData.append("file", file); // <input type="file">
									   // 파일선택창 -> 선택한 파일 -> "file" (파일을 선택한 상태)
		// 파일을 비동기 방식으로 전송
		// enctype="multipart/form-data"
		$.ajax({
			"processData" : false,
			"contentType" : false,
			"url" : "/uploadAjax",
			"method" : "post",
			"data" : formData,
			"success" : function(receivedData) {
				console.log(receivedData);
				var arrStr = receivedData.split("_");
				//console.log(arrStr);
				var fileName = arrStr[1];
				alert(fileName);
				$("#uploadedList").append("<span style='margin:10px'>" + fileName + "</span>")
			}
		});
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
				
				<!-- 첨부파일 -->
					<div>
						<label>첨부할 파일을 드래그&amp; 드롭하세요.</label>
						<div id="fileDrop">
						</div>
					</div>
				<!-- //첨부파일 -->
				
				
				<div id="uploadedList">
					
				</div>
				
				
				<button type="submit" class="btn btn-primary">글쓰기</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>