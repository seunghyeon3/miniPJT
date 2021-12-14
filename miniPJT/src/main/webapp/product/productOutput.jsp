<%@page import="com.edu.VO.productVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	productVO vo = (productVO) request.getAttribute("product");
	%>
	<h3>
		사진 :
		<%=vo.getProduct_picture()%>
	</h3>
	<h3>
		상품명 :
		<%=vo.getProduct_name()%>
	</h3>
	<h3>
		상품가격 :
		<%=vo.getProduct_price()%>
	</h3>
	<h3>
		상품설명 :
		<%=vo.getProduct_content()%>>
	</h3>
	<h3>
		상품별점 :
		<%=vo.getProduct_eval()%>
	</h3>

</body>
</html>