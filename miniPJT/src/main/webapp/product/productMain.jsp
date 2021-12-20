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
$(document).ready(function(){
	#.ajax({
		method: 'get',
		url: '../productServlet'
		date: {
			cmd:'productList'
		},
		dataType: 'json',
		success: prdListCall,
		error: function (error) {
			console.log(error);
		}
	});
	
	function prdListCall(rsult) {
		var prd = $('')
	}
	
	
})
</script>
<title>All-product</title>
<h3>상품목록</h3>
<table border="1">
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
					<c:forEach var="product" items="${product }">
						<tr>
						<td>상품사진: ${item.id }</td>
							<td>비밀번호: ${item.passward }</td>
							<td>이름: ${item.name }</td>
							<td>이메일: ${item.mail }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

<body>


</body>
</html>