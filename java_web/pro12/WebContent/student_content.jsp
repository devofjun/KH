<%@page import="com.kh.db.StudentVo"%>
<%@page import="com.kh.db.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int st_num = Integer.parseInt(request.getParameter("st_num"));
	StudentDao dao = StudentDao.getInstance();
	StudentVo vo = dao.getoneStudent(st_num);
%>
<%@ include file="include/header.jsp" %>
	<script>
	$(function() {
		// 수정버튼
		$("#btnModify").click(function() {
			$("#btnModifyFinish").fadeIn("fast");
			$(".readonly").attr("readonly", false);
		});
		// 수정완료버튼
		$("#btnModifyFinish").click(function() {
			$("#frmStudent").attr("action", "student_modify_run.jsp").submit();
		});
		// 삭제버튼
		$("#btnDelete").click(function() {
			$("#btnDeleteFinish").slideDown(100);
		});
		// 삭제완료버튼
		$("#btnDeleteFinish").click(function() {
			$("#frmStudent").attr("action", "student_delete_run.jsp").submit();
		});
	});
	</script>
<title>학생 상세 정보</title>
<%@ include file="include/bodystarter.jsp" %>
		<div class="row">
			<div class="col-md-12">
				<div class="jumbotron">
					<h2>학생 상세 정보</h2>
					<p>학생 상세 정보 보기입니다.</p>
				</div>
				<form action="" role="form" method="post" id="frmStudent">
					<div class="form-group">
						<!-- 서버로 전송 되어야 하니깐 name값도 추가한다. -->
						<label for="st_num"> 학번 </label> <input
							type="number" class="form-control" id="st_num"
							name="st_num" value="<%=vo.getSt_num() %>" readonly />
					</div>
					<div class="form-group">

						<label for="st_name"> 이름 </label> <input
							type="text" class="form-control readonly" id="st_name" 
							name="st_name" value="<%=vo.getSt_name() %>" readonly/>
					</div>
					<div class="form-group">

						<label for="st_major"> 전공 </label> <input
							type="text" class="form-control readonly" id="st_major" 
							name="st_major" value="<%=vo.getSt_major() %>" readonly/>
					</div>
					<div class="form-group">

						<label for="st_year"> 학년 </label> <input
							type="text" class="form-control readonly" id="st_year" 
							name="st_year" value="<%=vo.getSt_year() %>" readonly/>
					</div>
					<div class="form-group">

						<label for="st_score"> 점수 </label> <input
							type="text" class="form-control readonly" id="st_score" 
							name="st_score" value="<%=vo.getSt_score() %>" readonly/>
					</div>
					<div class="form-group">

						<label for="st_etc"> 비고 </label> <textarea
							class="form-control readonly" id="st_etc" 
							name="st_etc" readonly><%=vo.getSt_etc() %></textarea>
					</div>
					<a class="btn btn-primary" href="student_list.jsp">목록</a>
					<button type="button" class="btn btn-success" id="btnModify">수정</button>
					<button type="button" class="btn btn-info" id="btnDelete">삭제</button>
					<button type="button" class="btn btn-warning" id="btnModifyFinish"style="display:none">수정완료</button>
					<button type="button" class="btn btn-danger" id="btnDeleteFinish"style="display:none">삭제완료</button>
				</form>
			</div>
		</div>
<%@ include file="include/footer.jsp" %>