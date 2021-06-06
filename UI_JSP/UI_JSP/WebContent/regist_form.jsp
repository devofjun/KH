
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
				"SNO" : inputSno
		};
		// 아무런 입력을 하지 않았다면 종료
		if(inputSno.trim() == ""){
			btn.next().text("학번을 입력하고 다시 체크해주세요.");
			$("#btnRegist").hide();
			alert("학번은 필수 입력사항입니다.");
			$("#frmRegist").attr("action","");
			return;
		}
		// 학번 전송
		$.post(url, sendData, function(rData) {
			if(rData == "true"){
				btn.next().attr("color","blue");
				$("#btnRegist").show(100);
				btn.next().text("유효한 학번");
				alert("사용할 수 있는 학번입니다.");
				$("#frmRegist").attr("action","/regist_run.jsp");
			} else {
				$("#btnRegist").hide();
				btn.next().text("유효하지 않은 학번");
				alert("사용할 수 없는 학번입니다.");
				$("#frmRegist").attr("action","");
			}
		});
	});
	// 등록 이벤트
	$("#frmRegist").submit(function(e) {
		//e.preventDefualt();
		var sno = $("#snoInput").val().trim();
		var sname = $("#snameInput").val().trim();
		var syear = $("#syearInput").val().trim();
		var man = $("#genderMan").is(":checked");
		var woman = $("#genderWoman").is(":checked");
		var major = $("#majorInput").val().trim();
		var score = $("#scoreInput").val().trim();
		
		// 입력 데이터 조절
		if(sno == ""){
			alert("학번을 입력해주세요");
			$("#snoInput").focus();
			return false;
		} else if(sname == ""){
			alert("이름을 입력해주세요");
			$("#snameInput").focus();
			return false;
		} else if(!(syear>0 && syear<10)){
			alert("학년은 한자리수로 입력해주세요.");
			$("#syearInput").focus();
			return false;
		} else if(man == false && woman == false){
			alert("성별을 선택해주세요");
			return false;
		} else if(major == ""){
			alert("전공을 입력해주세요");
			$("#majorInput").focus();
			return false;
		} else if(!(score>=0 && score<=100)){
			alert("점수는 0~100까지의 값만 넣어주세요. 기본값은 0입니다.");
			$("#scoreInput").val(0);
			$("#scoreInput").focus();
			return false;
		} else if(score == ""){
			alert("점수는 0~100까지의 값만 넣어주세요. 기본값은 0입니다.");
			$("#scoreInput").val(0);
			$("#scoreInput").focus();
			return false;
		}
		
		$(this).submit();
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
					<button type="button" class="btn btn-secondary btn-sm" id="btnSnoCheck">학번체크</button>
					<span style="color:red;"></span><input
						type="text" class="form-control" id="snoInput" name="SNO"
						/>
				</div>
				<div class="form-group">

					<label for="snameInput"> 이름 </label> <input
						type="text" class="form-control" id="snameInput" name="SNAME"
						/>
				</div>
				<div class="form-group">

					<label for="syearInput"> 학년 </label> <input
						type="number" class="form-control" id="syearInput" name="SYEAR"
						/>
				</div>
				<div class="form-group">
					
					<label for="genderInput"> 남자 </label> <input
						type="radio" id="genderMan" class="gender"
						name="GENDER" value="남" 
						/>
					<label for="genderInput"> 여자 </label> <input
						type="radio" id="genderWoman" class="gender"
						name="GENDER" value="여" 
						/>
				</div>
				<div class="form-group">

					<label for="majorInput"> 전공 </label> <input
						type="text" class="form-control" id="majorInput" name="MAJOR"
						/>
				</div>
				<div class="form-group">

					<label for="scoreInput"> 점수 </label> <input
						type="number" class="form-control" id="scoreInput" name="SCORE"
						/>
				</div>
				<a class="btn btn-primary" href="index.jsp">전체보기</a>
				<button type="submit" class="btn btn-success" id="btnRegist" style="display:none">등록</button>
			</form>
		</div>
	</div>
</div>

<%@ include file="include/footer.jsp"%>