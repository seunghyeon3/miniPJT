<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../jquery-3.6.0.min.js"></script>
<title>Main</title>
</head>
<body>
	<div>
		<div>
		<!--session.getAttribute 부분은 로그인에서 데이터를 session에 뿌려주는거 확인 해야함-->
		<!-- 그리고, session timeout 설정 확인 해봐야함 -->
		<h3><%=session.getAttribute("member_id") %></h3>환영합니다. 즐거운 쇼핑되세요!!
		</div>
		<!-- 해당부분 css 필요함 -->
		<a href="logout.do">페이지 이동</a>
		<a href="mypage.do">마이페이지</a>
	</div>
</body>
</html>