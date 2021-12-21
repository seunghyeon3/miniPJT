<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!-- jstl사용을 위해 추가 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- jquery 사용을 위해 추가 -->
<script src="../jquery-3.6.0.min.js"></script>
<!-- web browser tab 명명하기 위함 -->
<title>InsertBoard</title>
</head>
<body>
	<c:import url="../header.jsp"></c:import>
	<jsp:include page="../nav.jsp"></jsp:include>
	<form action="../boardServlet/insertBoard.do" method="post">
		<input type='text' name='header'>
		<input type='text' value=<%=session.getAttribute("member_id")%>  readonly>
		<textarea rows="30" cols="50" name='content'  placeholder="글자수는 100자 내로 쓰소."></textarea>
		<input type='submit' value="등록">
		<input type='reset' value="취소">
	</form>
</body>
</html>