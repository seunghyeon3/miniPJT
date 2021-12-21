<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:import url="../header.jsp"></c:import>
<jsp:include page="../nav.jsp"></jsp:include>
<!-- 해당부분 productSelectAll 후, 슬라이드로 표현 -->
<script>

</script>
<title>All-product</title>
<h3>상품목록</h3>
<table border="1">
	<jsp:useBean id="vo1" class="com.edu.VO.ProductVO"></jsp:useBean>
	<thead>
		<tr>
			<th>상품사진</th>
			<th>상품명</th>
			<th>상품설명</th>
			<th>상품가격</th>
			<th>상품평점</th>
		</tr>
	</thead>
	<tbody>

		<c:forEach var="product" items="${product}">
			<tr>
				<td>상품사진: ${items.product_picture }</td>
				<td>상품설명: ${items.product_content }</td>
				<td>상품명:  ${items.product_name }</td>
				<td>상품평점: ${items.product_eval }</td>
				<td>상품가격: ${items.product_price }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
<body>


</body>
</html>