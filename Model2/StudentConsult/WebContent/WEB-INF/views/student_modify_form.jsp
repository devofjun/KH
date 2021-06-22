<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<title>학생 정보 수정</title>
<%@ include file="/WEB-INF/include/bodystarter.jsp"%>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>학생 양식</h2>
				<p></p>
				<p>
					<a class="btn btn-primary btn-large" href="/StudentList.kh">목록으로</a>
				</p>
			</div>
			<form role="form" action="/StudentModifyRun.kh" method="post">
				<div class="form-group">

					<label for="exampleInputEmail1">학번</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="sno"
						value="${vo.sno }"/>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">학생 명</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="sname"
						value="${vo.sname }"/>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">학년</label>
					<select name="syear">
						<option value="none">== 선택 ==</option>
						<c:forEach var='v' begin="1" end="4" step="1">
						<option value="${v}"
						<c:if test="${vo.syear == v }">selected</c:if>
						>${v}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">성별</label>
					<select name="gender">
						<option value="none">== 선택 ==</option>
						<option value="남" <c:if test="${vo.gender == '남' }">selected</c:if>>남자</option>
						<option value="여" <c:if test="${vo.gender == '여' }">selected</c:if>>여자</option>
					</select>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">전공</label>
					<select name="major">
						<option value="none">== 선택 ==</option>
						<option value="컴공" <c:if test="${vo.major == '컴공' }">selected</c:if>>컴공</option>
						<option value="물리" <c:if test="${vo.major == '물리' }">selected</c:if>>물리</option>
						<option value="화학" <c:if test="${vo.major == '화학' }">selected</c:if>>화학</option>
						<option value="생물" <c:if test="${vo.major == '생물' }">selected</c:if>>생물</option>
					</select>
				</div>
				<div class="form-group">

					<label for="exampleInputEmail1">점수</label> <input type="text"
						class="form-control" id="exampleInputEmail1" name="score"
						value="${vo.score}"/>
				</div>
				<button type="submit" class="btn btn-primary">수정하기</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>