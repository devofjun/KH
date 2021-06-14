<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>myData: ${myData}</h1>
	<h1>yourData: ${yourData}</h1>
	<h1>sessionData: ${sessionScope.sessionData}</h1>
	<%
		//session.removeAttribute("sessionData");
		// 세션은 톰캣이 브라우저가 요청한 순간 만들어진다.
		String id = session.getId();
		// 브라우저가 닫히면 세션이 닫힌다.
		// 세션은 쿠키에 저장 된다.
		
	%>
	<h1>sessionData: ${sessionScope.sessionData}</h1>
	<h2>id: <%=id %></h2>
</body>
</html>