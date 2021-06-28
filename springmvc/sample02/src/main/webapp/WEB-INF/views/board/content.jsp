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
		location.href = "/board/listAll?page=${pagingDto.page}perPage=${pagingDto.perPage}&searchType=${pagingDto.searchType}&keyword=${pagingDto.keyword}";
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
		var user_id = "test";
		var url = "/comment/insertComment";
		var sendData = {
			"c_content" : c_content,
			"b_no" : b_no,
			"user_id" : user_id
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
});
</script>
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
				<input type="hidden" id="user_id" value="test" /> <input
					type="hidden" id="b_no" name="b_no" value="${boardVo.b_no}" />
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
							</tr>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="../include/footer.jsp"%>