<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>product/productInsert.jsp</title>
</head>
<body>
	<c:import url="../header.jsp"></c:import>
	<jsp:include page="../nav.jsp"></jsp:include>
	<fieldset>
		<legend> 상품등록 </legend>
		<form action='../productServlet/productInsert.do' enctype="multipart/form-data"  method='post'>
			<!-- <form action='../productInsert.do' method='post'> -->
			상품코드: <input type='text' name='product_id'><br> 
			상품명: <input type='text' name='product_name'><br> 
			상품가격: <input type="number"	name='product_price'><br> 
			상품설명: <input type='text'	name='product_content'><br>
			<!-- 이미지: <input type='text' name='pImage'><br>  -->
			이미지: <input type='file' name='product_picture'><br> 
			평점: <input	type="text" name='product_eval_Point'><br> 
			<input type='submit'value='등록'>
		</form>
	</fieldset>
</body>
</html>