<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="com.edu.VO.ProductVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../header.jsp"></c:import>
	<jsp:include page="../nav.jsp"></jsp:include>
<h3>상품</h3>

	<form action="../productServlet/productSearch.do" method='get'>
		<input type='text' name='product_id' value='${product.product_id}'> 
		<input type='hidden' name='job' value='update'> 
		<input type='submit' value='수정'>
	</form>
	<form action="../productServlet/productSearch.do" method='get'>
		<input type='text' name='product_id' value='${product.product_id}'> 
		<input type='hidden' name='job' value='delete'> 
		<input type='submit' value='삭제'>
	</form> 
	

</body>
</html>