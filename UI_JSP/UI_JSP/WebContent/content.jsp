
<%@page import="com.kh.db.UIVo"%>
<%@page import="com.kh.db.UIDao"%>
<%@page import="sun.security.jca.GetInstance"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String sno = request.getParameter("SNO");
	//System.out.println(sno);
	UIDao dao = UIDao.getInstance();
	UIVo vo = dao.getContent(sno);
	//System.out.println(vo);
%>

<%@ include file="include/header.jsp"%>
<title>Insert title here</title>
<script>
$(function() {
	// 수정버튼 클릭
	$("#btnModify").click(function() {
		// 비활성화 -> 활성화
		$(".readonly").attr("readonly", false);
		$(".disabled").attr("disabled", false);
		$("#btnModifyFinish").show(100);
	});
	// 수정완료버튼 클릭
	$("#btnModifyFinish").click(function() {
		var sno = $("#snoInput").val().trim();
		var sname = $("#snameInput").val().trim();
		var syear = $("#syearInput").val().trim();
		var man = $("#genderMan").is(":checked");
		var woman = $("#genderWoman").is(":checked");
		var major = $("#majorInput").val().trim();
		var score = $("#scoreInput").val().trim();
		
		// 입력 데이터 조절
		if(sno == ""){
			$("#valCheck").text("학번을 입력해주세요");
			return false;
		} else if(sname == ""){
			$("#valCheck").text("이름을 입력해주세요");
			return false;
		} else if(!(syear>0 && syear<10)){
			$("#valCheck").text("학년은 한자리수로 입력해주세요.");
			return false;
		} else if(man == false && woman == false){
			$("#valCheck").text("성별을 입력해주세요");
			return false;
		} else if(major == ""){
			$("#valCheck").text("전공을 입력해주세요");
			return false;
		} else if(!(score>=0 && score<=100)){
			$("#valCheck").text("점수는 0~100까지의 값만 넣어주세요. 기본값은 0입니다.");
			$("#scoreInput").val("0");
			return false;
		}
		
		// 수정 실행
		$("#frmContent").attr("action", "s_modify_run.jsp").submit();
	});
	// 삭제버튼 클릭
	$("#btnDelete").click(function() {
		$("#btnDeleteFinish").show(100);
	});
	// 삭제완료버튼 클릭
	$("#btnDeleteFinish").click(function() {
		//$("#frmContent").attr("action", "s_delete_run.jsp").submit();
		location.href = "s_delete_run.jsp?SNO=<%=vo.getSNO()%>";
	});
	
});
</script>

<%@ include file="include/bodystarter.jsp"%>

<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>학생 상세 정보</h2>
				<p>학생 정보 상세보기입니다.</p>
			</div>
			<form id="frmContent" method="post" role="form" action="">
				<div class="form-group">

					<label for="snoInput"> 학번 </label> <input
						type="text" class="form-control" id="snoInput" readonly
						name="SNO" value="<%=vo.getSNO()%>"/>
				</div>
				<div class="form-group">

					<label for="snameInput"> 이름 </label> <input
						type="text" class="form-control readonly" id="snameInput" readonly
						name="SNAME" value="<%=vo.getSNAME()%>"/>
				</div>
				<div class="form-group">

					<label for="syearInput"> 학년 </label> <input
						type="number" class="form-control readonly" id="syearInput" readonly
						name="SYEAR" value="<%=vo.getSYEAR()%>"/>
				</div>
				<div class="form-group">
					
					<label for="genderInput"> 남자 </label> <input
						type="radio" id="genderMan" class="disabled" disabled
						name="GENDER" value="남" 
						<%if(vo.getGENDER().equals("남")){ %> checked="checked" <% } %>
						/>
					<label for="genderInput"> 여자 </label> <input
						type="radio" id="genderWoman" class="disabled" disabled
						name="GENDER" value="여" 
						<%if(vo.getGENDER().equals("여")){ %> checked="checked" <% } %>
						/>
				</div>
				<div class="form-group">

					<label for="majorInput"> 전공 </label> <input
						type="text" class="form-control readonly" id="majorInput" readonly
						name="MAJOR" value="<%=vo.getMAJOR()%>"/>
				</div>
				<div class="form-group">

					<label for="scoreInput"> 점수 </label> <input
						type="number" class="form-control readonly" id="scoreInput" readonly
						name="SCORE" value="<%=vo.getSCORE()%>"/>
				</div>
				<a class="btn btn-primary" href="index.jsp">전체보기</a>
				<button type="button" class="btn btn-success" id="btnModify">수정</button>
				<button type="button" class="btn btn-info" id="btnDelete">삭제</button>
				<button type="button" class="btn btn-warning" id="btnModifyFinish"style="display:none">수정완료</button>
				<button type="button" class="btn btn-danger" id="btnDeleteFinish"style="display:none">삭제완료</button>
				<span id="valCheck"></span>
			</form>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp"%>