<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="/WEB-INF/include/header.jsp"%>
<script>
	
</script>
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
			<form role="form" action="/StudentConsultInsert.kh" method="post">
				<div class="form-group">

					<label for="sno">학번</label> <input type="text"
						class="form-control" id="sno" name="sno"
						value="${sno}" readonly/>
				</div>
				<div class="form-group">

					<label for="c_content">상담 내역</label> <input type="text"
						class="form-control" id="c_content" name="c_content"/>
				</div>
				
				<button type="submit" class="btn btn-primary">수정하기</button>
			</form>
		</div>
	</div>
</div>
<%@ include file="/WEB-INF/include/footer.jsp"%>