<%@page import="com.edu.VO.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/productOutput.jsp</title>
</head>
<body>
	<c:import url="../header.jsp"></c:import>
	<jsp:include page="../nav.jsp"></jsp:include>
	<h3>상품리스트</h3>
	<div id="list">
		<c:forEach var="product" items="${requestScope.productList }">
			<form action="../productServlet/productSearch.do" method='get'>
				<ul>	
					<li><img src="upload/${product.product_picture }"></li>
					<li>상품명: ${product.product_name }</li>
					<li>상품평: ${product.product_eval_Point }</li>
					<li>상품가격: ${product.product_price }</li>
					<input type='hidden' name='product_id' value='${product.product_id }'>
					<input type='hidden' name='job' value='search'>
					<input type='submit' value='상품보기'>
				</ul>
			</form>
		</c:forEach>
	</div>
</body>
</html>