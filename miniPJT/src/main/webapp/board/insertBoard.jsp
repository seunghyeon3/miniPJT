<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<!-- jstl사용을 위해 추가 -->
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
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
<!-- menu 추가..JSTL 방식 -->
<c:import url="../css/menu.jsp"></c:import>

<!-- nav 추가..JSP 액션태그 방식 -->
<jsp:include page ="../css/nav.jsp">

<!-- footer 추가 -->
<c:import url="../css/footer.jsp"></c:import>

</body>
</html>