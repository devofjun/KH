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
	
	/* 이미지박스  */
	.divUploaded {
		width : 150px;
		float : left;
	}
</style>
<script src="/resources/js/my-script.js"></script>
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
					//var arrStr = receivedData.split("_");
				//console.log(arrStr);
					//var fileName = arrStr[2];
				//alert(fileName);
				var fileName = receivedData.substring(receivedData.lastIndexOf("_")+1);
				var cloneDiv = $("#uploadedList").prev().clone();
				var img = cloneDiv.find("img");
				if(isImage(fileName)){
					img.attr("src", "http://localhost/displayImage?fileName="+receivedData);
				}
				//$("#uploadedList").append("<span style='margin:10px'>" + fileName + "</span>")
				cloneDiv.find("span").text(fileName);
				cloneDiv.find(".a_times").attr("href", receivedData);
				$("#uploadedList").append(cloneDiv.show());
				
// 				// 모달 열기
// 				$("modal-273731").trigger("click");
// 				// 2초 뒤 실행 되는 함수
// 				setTimeout(function() {
// 					$("#modal-container-273731 .close").trigger("click");
// 					$("#uploadedList").append(cloneDiv.show());
// 				},2000);
			}
		});
	});
	
	// 첨부파일 삭제 링크
	$("#uploadedList").on("click", ".a_times", function(e) {
		e.preventDefault();
		var that = $(this);
		console.log	("클릭");
		var fileName = $(this).attr("href");
		console.log(fileName);
		var url = "/deleteFile?fileName=" + fileName;
		$.get(url, function(rData) {
			if(rData == "success"){
				that.parent().remove();
			}
		});
	});
	
	
	$("#frmWrite").submit(function() {
		// 올린 이미지가 썸네일로 표시되는 div
		var div = $("#uploadedList .divUploaded");
		// 생성하기 전에 비우고 생성함(날림)
		$(this).find("[name^=files]").remove();
		div.each(function(index) {
			var fileName = $(this).find(".a_times").attr('href');
			var html = "<input type='hidden' name='files["+index+"]' value='"+fileName+"''/>";
			$("#frmWrite").prepend(html);
		});
		return false;
	});
});
</script>

<div class="container-fluid">
	<!-- 파일 업로드 안내 모달 -->
	<div class="row">
		<div class="col-md-12">
			<a id="modal-273731" href="#modal-container-273731" role="button"
				class="btn" data-toggle="modal" style="display:none">Launch demo modal</a>

			<div class="modal fade" id="modal-container-273731" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">Modal title</h5>
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">...</div>
						<div class="modal-footer">

							<button type="button" class="btn btn-primary">Save
								changes</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</div>

				</div>

			</div>

		</div>
	</div>
	<!-- //파일 업로드 안내 모달 -->
	
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글쓰기</h2>
				<p>
<!-- 					<a class="btn btn-primary btn-large" href="#">Learn more</a> -->
				</p>
			</div>
			
			<!-- 글 작성하기 폼 -->
			<form id="frmWrite" role="form" action="/board/writeRun" method="post">
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
				
				<!-- 기본이미지 -->
				<div style="display:none;" class="divUploaded">
					<img height="50" src="/resources/img/default_image.png"
						class="img-rounded"/><br/>
					<span>default</span>
					<a href="#" class="a_times">&times;</a>
				</div>
				<!-- 기본이미지 -->
				
				<div id="uploadedList">
				</div>
				
				<hr/>
				<button type="submit" class="btn btn-primary"
					style="clear:bath">글쓰기</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>