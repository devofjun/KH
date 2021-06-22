<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<title>학생 등록 양식</title>
<%@ include file="/WEB-INF/include/bodystarter.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>학생 등록 양식</h2>
				<p></p>
				<p>
					<a class="btn btn-primary btn-large" href="/StudentList.kh">목록으로</a>
				</p>
			</div>
			<form role="form" action="/StudentRegistRun.kh" method="post">
				<div class="form-group">

					<label for="exampleInputEmail1">학번</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="sno"/>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">학생 명</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="sname"/>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">학년</label>
					<select name="syear">
						<option value="none">== 선택 ==</option>
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">성별</label>
					<select name="gender">
						<option value="none">== 선택 ==</option>
						<option value="남">남자</option>
						<option value="여">여자</option>
					</select>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">전공</label>
					<select name="major">
						<option value="none">== 선택 ==</option>
						<option value="컴공">컴공</option>
						<option value="물리">물리</option>
						<option value="물리">화학</option>
						<option value="물리">생물</option>
					</select>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">점수</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="score"/>
				</div>
				<button type="submit" class="btn btn-primary">등록하기</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>