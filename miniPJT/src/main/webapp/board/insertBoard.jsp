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
<style>

div{
display: inline-block;
padding-right: 30px;
}
</style>
</head>
<body>
	<c:import url="../header.jsp"></c:import>
	<div>
	<form action="../boardServlet/insertBoard.do" method="post">
		제목<br><input type='text' name='header'><br>
		작성자<br><input type='text' value=<%=session.getAttribute("member_id")%>  readonly><br>
		내용<br><textarea rows=8" cols="50" name='content'  placeholder="글자수는 100자 내로 쓰소."></textarea>
		<input type='submit' value="등록">
		<input type='reset' value="취소">
	</form>
	</div>
</body>
</html>