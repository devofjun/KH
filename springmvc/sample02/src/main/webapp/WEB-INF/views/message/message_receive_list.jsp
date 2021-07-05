<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../include/header.jsp"%>


<div class="container mt-3">
	<h2>받은 쪽지 목록</h2>
	<p>Click on the Tabs to display the active and previous tab.</p>

	<!-- Nav tabs -->
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" href="#home">보낸
				쪽지함</a></li>
		<li class="nav-item"><a class="nav-link" href="#menu1">받은 쪽지함</a></li>
	</ul>

	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>#</th>
						<th>쪽지내용</th>
						<th>보낸사람</th>
						<th>받은날짜</th>
						<th>읽은날짜</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="messageVo" items="${list}">
					<tr>
						<td>${messageVo.msg_no}</td>
						<td><span<c:if test="${empty messageVo.msg_opendate }">
									style="font-weight:bold"
								</c:if>
							>${messageVo.msg_content}</span></td>
						<td>${messageVo.msg_sender}</td>
						<td>${messageVo.msg_senddate}</td>
						<td>
							<c:choose>
								<c:when test="${empty messageVo.msg_opendate}">
									읽지 않음
								</c:when>
								<c:otherwise>
									${messageVo.msg_opendate}
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<p class="act">
		<b>Active Tab</b>: <span></span>
	</p>
	<p class="prev">
		<b>Previous Tab</b>: <span></span>
	</p>
</div>


<%@ include file="../include/footer.jsp"%>