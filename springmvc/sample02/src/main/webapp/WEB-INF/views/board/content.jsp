<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<!-- 날짜 포멧 함수 -->

<script src="/resources/js/my-script.js"></script>
<script>
$(document).ready(function() {
	var modifyResult = "${modifyResult}";
	if (modifyResult == "success") {
		alert("수정성공");
	}

	// 수정버튼
	$("#btnModify").click(function() {
		//console.log($(this).prop("class"));
		if ($(this).attr("class") == "btn btn-primary") {
			$(this).attr("class",
					"btn btn-success");
			$("[name^=b_]").prop(
					"readonly", false);
			$(this).text("수정완료");
		} else if ($(this).attr("class") == "btn btn-success") {
			$("#frmModify").submit();
		}
	});

	// 삭제버튼
	$("#btnRemove").click(function() {
		//var b_no = $("#b_no").val();
		if (confirm("삭제하시겠습니까?")) {
			location.href = "/board/RemoveRun?b_no=${boardVo.b_no}";
		}
	});

	// 목록 버튼
	$("#btnList").click(function() {
		location.href = "/board/listAll?page=${pagingDto.page}&perPage=${pagingDto.perPage}&searchType=${pagingDto.searchType}&keyword=${pagingDto.keyword}";
	});

	// 댓글 버튼
	$("#btnCommentList").click(function() {
		// 비동기 요청: $.ajax, $.get, $.post, $.getJSON

		// 데이터를 하나만 보내야 할 땐 주소에 데이터를 붙여서 보낼 수도있다.
		var url = "/comment/getCommentList/${boardVo.b_no}";
		$.get(url, function(receivedData) {
			console.log(receivedData);
			$("#commentTable > tbody > tr:gt(0)").remove();
			$.each(receivedData,function() {
				var cloneTr = $("#commentTable > tbody > tr:first").clone();
				var td = cloneTr.find("td");
				td.eq(0).text(this.c_no);
				td.eq(1).text(this.c_content);
				td.eq(2).text(this.user_id);
				td.eq(3).text(changeDateString(this.c_regdate));
				td.eq(5).find("button").attr("data-cno", this.c_no);
				// changeDateString 직접 만든 자바스크립트 함수
				$("#commentTable > tbody").append(cloneTr);
				//cloneTr.css("display", "block");
				cloneTr.slideDown(100);
			});
		});
	});
	
	// 댓글 입력 버튼
	$("#btnCommentInsert").click(function() {
		var c_content = $("#c_content").val();
		var b_no = parseInt("${boardVo.b_no}"); // 숫자로 변환 하는 이유가 뭘까?
		//var user_id = "test";
		var url = "/comment/insertComment";
		var sendData = {
			"c_content" : c_content,
			"b_no" : b_no
		};
		//$.get, $.post의 원형
		// 객체를 하나 만들어서 보낸다.
		$.ajax({
			"url" : url,
			"headers" : {"Content-Type" : "application/json"},
			"method" : "post",
			"dataType" : "text", 
			"data" : JSON.stringify(sendData),
			"success" : function(receivedData){
				console.log(receivedData);
				// 처리가 잘 되었다면, 댓글 목록 버튼을 클릭시켜서 목록을 새로 얻음
				if(receivedData == "success"){
					$("#btnCommentList").trigger("click");
				}
			}
		});
		// headers: 요청할때 어떤 데이터인지 설명한다. 옵션은 다양함.
		// dataType: http에선 text와 바이너리 두종류가 있다.
		// JSON.stringify() : json 데이터를 문자열로 변환
	});
	
	// 댓글 수정 버튼
	// 비동기방식 등으로 추가된 엘리먼트에 대해서 이벤트 처리는
	// 처음 로딩된 상태에서 존재하는 엘리먼트에 설정한다.
	$("#commentTable").on("click", ".commentModify", function() {
		//console.log("click");
		// 눌러진 버튼의 해당하는 댓글의 번호와 내용을 셀렉트해서 text값을 가져옴
		var c_no = $(this).parent().parent().find("td").eq(0).text();
		var c_content = $(this).parent().parent().find("td").eq(1).text();
		$(".modal-body > .c_content").val(c_content);
		$("#btnModalOk").attr("data-cno", c_no);
		$("#modal-912157").trigger("click");
	});
	
	// 댓글 수정완료 버튼
	$("#btnModalOk").click(function() {
		var c_no = $(this).attr("data-cno");
		var c_content = $(".modal-body > .c_content").val();
		var url = "/comment/updateComment";
		var sendData = {
				"c_no" : c_no,
				"c_content" : c_content
		};
		console.log(sendData);
		$.ajax({
			"url" : url,
			"headers" : {"Content-Type" : "application/json"},
			"method" : "post",
			"dataType" : "text", 
			"data" : JSON.stringify(sendData),
			"success" : function(receivedData){
				console.log(receivedData);
				if(receivedData == "success"){
					$("#btnCommentList").trigger("click");
					$("#btnModalClose").trigger("click");
				}
			}
		});
	});
	
	// 댓글 삭제 버튼
	$("#commentTable").on("click", ".commentDelete", function() {
		//console.log("click");
		var c_no = $(this).attr("data-cno");
		var b_no = "${boardVo.b_no}";
		if(confirm("해당 댓글을 삭제하시겠습니까?")){
			//var c_no = $(this).parent().parent().find("td").eq(0).text();
			//location.href="/comment/deleteComment/"+c_no;
			var url = "/comment/deleteComment/"+c_no+"/"+b_no;
			$.get(url, function(rData){
				if(rData == "success"){
					$("#btnCommentList").trigger("click");
					alert("삭제되었습니다.");
				}
			});
		}
	});
	
	$("#btnLike").click(function(){
		var that = $(this);
		url="/board/updateLike?b_no=${boardVo.b_no}";
		$.get(url, function(rData){
			console.log(rData);
			if(rData > 0){
				that.text("♥");
			} else {
				that.text("♡");
			}
			var likeCount = "["+rData+"]";
			that.next().text(likeCount);
		});
	});
});
</script>

<!-- 모달창 -->
<!-- 작동받식은 트리거롤 통해서 열리게 한다. -->
<div class="row">
	<div class="col-md-12">
		<a style="display:none" id="modal-912157" href="#modal-container-912157" role="button"
			class="btn" data-toggle="modal">Launch demo modal</a>

		<div class="modal fade" id="modal-container-912157" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="myModalLabel">수정</h5>
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span>
						</button>
					</div>
					<div class="modal-body">
						<input type="text" class="form-control c_content"/>
					</div>
					<div class="modal-footer">

						<button id="btnModalOk" type="button" class="btn btn-primary">수정완료</button>
						<button id="btnModalClose" type="button" class="btn btn-secondary"
							data-dismiss="modal">닫기</button>
					</div>
				</div>

			</div>

		</div>

	</div>
</div>
<!-- //모달창 -->


<!-- 게시글 내용 -->
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>글쓰기</h2>
				<p>
					<!-- 					<a class="btn btn-primary btn-large" href="#">Learn more</a> -->
				</p>
			</div>
			<form id="frmModify" role="form" action="/board/modifyRun"
				method="post">
				<input type="hidden" id="user_id" value="test" />
				<input type="hidden" id="b_no" name="b_no" value="${boardVo.b_no}" />
				<div class="form-group">

					<label for="b_title"> 글제목 </label> <input type="text"
						class="form-control" id="b_title" name="b_title"
						value="${boardVo.b_title}" readonly />
					<!-- => name 값이 vo에 들어있는 필드명과 같아야한다. -->
					<!-- 그래야 컨트롤러에서 BoardVo형태의 데이터를 넘겨 받을 수 있다. -->
				</div>
				<div class="form-group">

					<label for="b_content"> 글내용 </label>
					<textarea class="form-control" id="b_content" name="b_content"
						readonly>${boardVo.b_content}</textarea>
					<!-- name 값이 vo에 들어있는 필드명과 같아	야한다. -->
				</div>

				<button id="btnModify" type="button" class="btn btn-primary">수정</button>
				<button id="btnRemove" type="button" class="btn btn-danger">삭제</button>
				<button id="btnList" type="button" class="btn btn-warning">목록</button>
<!-- 				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-heart" viewBox="0 0 16 16"> -->
<!--   					<path d="m8 2.748-.717-.737C5.6.281 2.514.878 1.4 3.053c-.523 1.023-.641 2.5.314 4.385.92 1.815 2.834 3.989 6.286 6.357 3.452-2.368 5.365-4.542 6.286-6.357.955-1.886.838-3.362.314-4.385C13.486.878 10.4.28 8.717 2.01L8 2.748zM8 15C-7.333 4.868 3.279-3.04 7.824 1.143c.06.055.119.112.176.171a3.12 3.12 0 0 1 .176-.17C12.72-3.042 23.333 4.867 8 15z"/> -->
<!-- 				</svg> -->
				<span id="btnLike" style="font-size:25px">
				<c:choose>
					<c:when test="${boardVo.like_count > 0 }">♥</c:when>
					<c:otherwise>♡</c:otherwise>
				</c:choose>
				</span><span>[${boardVo.like_count}]</span>
			</form>
		</div>
	</div>
	<!-- //게시글 내용 -->
	
	
	
	<!-- 댓글 목록 -->
	<div class="row">
		<div class="col-md-12">
			<hr />
			<button id="btnCommentList" type="button" class="btn btn-info">댓글목록</button>
			<hr />
			<div class="row">
				<div class="col-md-2"></div>
				<div class="col-md-8">
					<input type="text" class="form-control" placeholder="댓글을 입력하세요." id="c_content"/>
				</div>
				<div class="col-md-2">
					<button type="button" class="btn btn-primary" id="btnCommentInsert">입력</button>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<table id="commentTable" class="table">
						<thead>
							<tr>
								<th>댓글번호</th>
								<th>댓글 내용</th>
								<th>작성자</th>
								<th>작성일</th>
							</tr>
						</thead>
						<tbody>
							<tr style="display:none;">
								<td></td>
								<td></td>
								<td></td>
								<td></td>
								<td><button type="button" class="btn btn-sm btn-warning commentModify">수정</button></td>
								<td><button type="button" class="btn btn-sm btn-danger commentDelete">삭제</button></td>
								
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>