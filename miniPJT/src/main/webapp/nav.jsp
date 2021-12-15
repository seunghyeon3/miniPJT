<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../jquery-3.6.0.min.js"></script>
<title>navContent</title>
</head>
<body>
<ul>
		<li>
		<!-- 아래 내용은 전체 상품 눌렀는데 메인 화면으로 이동 -->
		<%-- <a href='${pageContext.request.contextPath}/product/productInsert.jsp'>메인화면</a></li> --%>
		<li>
		<%-- <a href='${pageContext.request.contextPath}/product/productInsert.jsp'>게시판</a> --%>
		</li>
		
		<!-- 여기서는 admin 확인하고 아래 내용 보이도록 수정 -->
		<%-- <c:choose>
			<li>
			<a href='${pageContext.request.contextPath}/product/productInsert.jsp'>상품등록</a>
			</li>
			<li>
			<a href='${pageContext.request.contextPath}/product/productInsert.jsp'>상품등록</a>
			</li>
		</c:choose> --%>

	</ul>
</body>
</html>