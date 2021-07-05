<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp" %>

<script>
$(document).ready(function() {
	$("#modal-865121").click(function() {
		
	});
	
	$("#btnReply").click(function() {
		var url = "/message/replyMessage";
		var sendData = {
			"msg_sender" : $("#replySender").val(),
			"msg_receiver" : $("#replyReceiver").val(),
			"msg_content" : $("#message-text").val()
		};
		$.post(url, sendData, function(rData){
			if(rData == "success") {
				alert("전송 성공");
				$("#btnClose").trigger("click");
			}
		});
	});
});
</script>


<div class="modal fade" id="modal-container-865121" role="dialog"
	aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="myModalLabel">답장하기</h5>
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">×</span>
				</button>
			</div>
			<div class="modal-body">
				<form id="frmReply" action="/message/replyMessage" method="post">
					<input id="replySender" type="hidden" name="msg_sender" value="${sessionScope.loginVo.user_id}"/>
					<input id="replyReceiver" type="hidden" name="msg_receiver" value="${messageVo.msg_sender}"/>
					<textarea class="form-control" id="message-text" name="msg_content"></textarea>
				</form>
			</div>
			<div class="modal-footer">

				<button id="btnReply" type="button" class="btn btn-primary">전송하기
				</button>
				<button id="btnClose" type="button" class="btn btn-secondary" data-dismiss="modal">
					Close</button>
			</div>
		</div>
	</div>
</div>


<table class="table">
	<tbody>
		<tr>
			<th>#</th>
			<td>${messageVo.msg_no}</td>
		</tr>
		<tr>
			<th>쪽지내용</th>
			<td>${messageVo.msg_content}</td>
		</tr>
		<tr>
			<th>보낸사람</th>
			<td>${messageVo.msg_sender}</td>
		</tr>
		<tr>
			<th>보낸날짜</th>
			<td>${messageVo.msg_senddate}</td>
		</tr>
		<tr>
			<th>읽은 날짜</th>
			<td>${messageVo.msg_opendate}</td>
		</tr>
	</tbody>
</table>
<a id="btnDelete" href="/message/deleteMessage?msg_no=${messageVo.msg_no}" type="button" class="btn btn-danger"> 삭제 </a>
<a id="modal-865121" href="#modal-container-865121" role="button" class="btn btn-primary" data-toggle="modal">답장</a>
<a id="btnList" href="/message/messageListReceive" type="button" class="btn btn-secondary"> 목록 </a>

<%@ include file="../include/footer.jsp" %>