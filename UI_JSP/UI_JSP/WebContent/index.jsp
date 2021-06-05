
<%@page import="com.kh.db.UIVo"%>
<%@page import="com.kh.db.UIDao"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	UIDao dao = UIDao.getInstance();
	ArrayList<UIVo> voList = dao.getSelectAll();
%>
<%@ include file="include/header.jsp"%>
<title>학생 정보</title>
<script>
	$(function() {
		
		$("#sNameSearch").click(function() {
			$("#textSearch").val('');
		});
		
		$("#sMajorSearch").click(function() {
			$("#textSearch").val('');
		});
		
		// 검색 버튼
		$("#btnSearch").click(function(e) {
			e.preventDefault();
			var nameChk = $("#sNameSearch").prop("checked");
			var majorChk = $("#sMajorSearch").prop("checked");
			// 이름으로 검색 할 때
			if (nameChk) {
				var url = $("#frmSearch").attr("action");
				var sendData = {
						"SNAME" : $("#textSearch").val()
				};
				// 검색 결과 테이블
				$.post(url, sendData, function(rData) {
					//console.log(rData);
					$("#TableList").empty();
					$("#TableList").html(rData);
				});
			// 전공으로 검색 할 때
			} else if(majorChk) { 
				var url = $("#frmSearch").attr("action");
				var sendData = {
						"MAJOR" : $("#textSearch").val()
				};
				// 검색 결과 테이블
				$.post(url, sendData, function(rData) {
					//console.log(rData);
					$("#TableList").empty();
					$("#TableList").html(rData);
				});
				// 아무것도 선택하지 않았을 때
			} else {
				var url = $("#frmSearch").attr("action");
				var sendData = {
						"SNAME" : ""
				};
				// 검색 결과 테이블
				$.post(url, sendData, function(rData) {
					//console.log(rData);
					$("#TableList").empty();
					$("#TableList").html(rData);
				});
			}
		});
	});
</script>
<%@ include file="include/bodystarter.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>학생 목록</h2>
				<p>학생 정보 등록 하려면 아래 버튼</p>
				<p>
					<a class="btn btn-primary btn-large" href="regist_form.jsp">학생 등록</a>
				</p>
			</div>
			<div>
				<form id="frmSearch" action="/ListSearch" role="form">
					<div class="form-group">
						<label for="sNameSearch"> 학생명으로 검색: </label> <input
							id="sNameSearch" type="radio" name="radiochk"/><br>
						<label for="sMajorSearch"> 전공으로 검색: </label> <input
							id="sMajorSearch" type="radio" name="radiochk"/> <input
							id="textSearch" type="text" class="form-control"/><br>
						<button id="btnSearch" type="submit" class="btn btn-success">검색</button>
					</div>
				</form>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>학번</th>
						<th>학생명</th>
						<th>학년</th>
						<th>성별</th>
						<th>전공</th>
						<th>점수</th>
					</tr>
				</thead>
				<tbody id="TableList">
					<%
						for (UIVo vo : voList) {
					%>
					<tr>
						<td><%=vo.getSNO()%></td>
						<td><a href="content.jsp?SNO=<%=vo.getSNO()%>"><%=vo.getSNAME()%></a></td>
						<td><%=vo.getSYEAR()%></td>
						<td><%=vo.getGENDER()%></td>
						<td><%=vo.getMAJOR()%></td>
						<td><%=vo.getSCORE()%></td>
					</tr>
					<%
						}
					%>
				</tbody>
			</table>
		</div>
	</div>
</div>
<%@ include file="include/footer.jsp"%>