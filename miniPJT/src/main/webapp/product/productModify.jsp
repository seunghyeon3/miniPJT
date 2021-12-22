<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:import url="../header.jsp"></c:import>
<jsp:include page="../nav.jsp"></jsp:include>
<form action='../productServlet/productUpdate.do' name="registerProduct"
			enctype="multipart/form-data" method='post'>
		상품코드 : <input type="hidden" name='product_id' value='${product.product_id }'>${product.product_id }<br>
		상품명 : <input type='text' name='product_name' value='${product.product_name }'><br> 
		상품가격 : <input type="number" name='product_price' value='${product.product_price }'><br>
		상품설명 : <input type='text' name='product_content' value='${product.product_content }'><br> 
		상품이미지 : <input type='file' name='product_picture' value='upload/${product.product_picture }'><br>
		상품평 : <input type="text" name='product_eval_Point' value='${product.product_eval_Point }'><br> 
		<input type='submit' value='수정'>
</form>
</body>
</html>