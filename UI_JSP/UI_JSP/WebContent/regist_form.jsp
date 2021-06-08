
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="include/header.jsp"%>
<title>Insert title here</title>

<script>
	$(function() {
		// 학번 유효성 체크
		$("#btnSnoCheck").click(function() {
			var btn = $(this);
			var inputSno = $("#snoInput").val();
			var url = "/CheckSno";
			var sendData = {
				"sno" : inputSno
			};
			// 학번 전송
			$.post(url, sendData, function(rData) {
				console.log(rData);
				if (rData == "true") {
					btn.next().css("color", "green");
					$("#btnRegist").show(100);
					btn.next().text("유효한 학번");
					alert("사용할 수 있는 학번입니다.");
					$("#frmRegist").attr("action", "/regist_run.jsp");
				} else if(rData == "false"){
					btn.next().text("중복되거나 유효하지 않은 학번");
					alert("사용할 수 없는 학번입니다.");
				} else {
					alert(rData);
					$("#btnRegist").hide();
					$("#frmRegist").attr("action", "");
				}
			});
		});
		// 등록 이벤트
		$("#btnRegist").click(function(e) {
			//e.preventDefualt();
			var sno = $("#snoInput").val().trim();
			var sname = $("#snameInput").val().trim();
			var syear = $("#syearInput").val().trim();
			var man = $("#genderMan").is(":checked");
			var woman = $("#genderWoman").is(":checked");
			var major = $("#majorInput").val().trim();
			var score = $("#scoreInput").val().trim();

			var url = "/CheckValues";
			var sendData = {
				"sno" : sno,
				"sname" : sname,
				"syear" : syear,
				"man" : man,
				"woman" : woman,
				"major" : major,
				"score" : score
			};
			
			$.post(url, sendData, function(rData) {
				if(rData == "true"){
					alert("정상적인 입력");
					$("#frmRegist").submit();
				} else {
					alert(rData);
					return false;
				}
			});
			
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
			<form id="frmRegist" role="form" action="" method="post">
				<div class="form-group">

					<label for="snoInput"> 학번 </label>
					<button type="button" class="btn btn-secondary btn-sm"
						id="btnSnoCheck">학번체크</button>
					<span style="color: red;"></span><input type="text"
						class="form-control" id="snoInput" name="SNO" />
				</div>
				<div class="form-group">

					<label for="snameInput"> 이름 </label> <input type="text"
						class="form-control" id="snameInput" name="SNAME" />
				</div>
				<div class="form-group">

					<label for="syearInput"> 학년 </label> <input type="number"
						class="form-control" id="syearInput" name="SYEAR" />
				</div>
				<div class="form-group">

					<label for="genderInput"> 남자 </label> <input type="radio"
						id="genderMan" class="gender" name="GENDER" value="남" />
					<label for="genderInput"> 여자 </label> <input type="radio"
						id="genderWoman" class="gender" name="GENDER" value="여" />
				</div>
				<div class="form-group">

					<label for="majorInput"> 전공 </label> <input type="text"
						class="form-control" id="majorInput" name="MAJOR" />
				</div>
				<div class="form-group">

					<label for="scoreInput"> 점수 </label> <input type="number"
						class="form-control" id="scoreInput" name="SCORE" />
				</div>
				<a class="btn btn-primary" href="index.jsp">전체보기</a>
				<button type="button" class="btn btn-success" id="btnRegist"
					style="display: none">등록</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp"%>