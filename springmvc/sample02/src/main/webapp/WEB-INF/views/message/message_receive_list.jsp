<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>


${list}
<div class="container mt-3">
	<h2>받은 쪽지 목록</h2>
	<p>Click on the Tabs to display the active and previous tab.</p>

	<!-- Nav tabs -->
	<ul class="nav nav-tabs">
		<li class="nav-item"><a class="nav-link active" href="#home">보낸
				쪽지함</a></li>
		<li class="nav-item"><a class="nav-link" href="#menu1">받은 쪽지함</a></li>
	</ul>

<p class="act">
	<b>Active Tab</b>: <span></span>
</p>
<p class="prev">
	<b>Previous Tab</b>: <span></span>
</p>
</div>


<%@ include file="../include/footer.jsp"%>