<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 해당부분 productSelectAll 후, 슬라이드로 표현 -->
<script src="../jquery-3.6.0.min.js"></script>
<script>
$(document).ready(function () {
	$.ajax({
		method: 'get',
		url: '../productServlet',
		data: {
			cmd: 'productList'
		},
		dataType: 'json',
		success: successFnc,
		error: function (error) {
			console.log(error);
		}
	});
	//상품목록 보여주기
	function successFnc(result) {
		console.log(result);
		let tbd = $('.productList');
		result.forEach(item => {
			let tr = $('<tr>').on("click", viewList).hover(function () {
				$(this).css('color', 'red');
			}, function () {
				$(this).css('color', 'black');
			});
			for (let field in item) {
				if (field != 'product_picture') {
					let td = $('<td>').text(item[field])
					tr.append(td)
				} else {
					let td = $('<td>').attr('')
				}
			}
			tbd.append(tr);
		})

	}
	
	
	//상품 단건 조회
	function viewList() {
		var form = $('<form>');
		form.attr('action', '../productServlet/productShow.do');
		form.attr('method', 'post');
		form.appendTo('body');
		var no = $("<input type='hidden' value=" + event.target.parentNode.children[0].textContent + " name='no'>");
		form.append(no);
	
		form.submit();

	}
	
	
});


	
	
	
	
	
	
</script>
<title>All-product</title>
<h3>상품목록</h3>
<c:import url="../header.jsp"></c:import>
<jsp:include page="../nav.jsp"></jsp:include>
<div>
	<table border="1">
		<thead>
			<tr>
				<th>상품코드</th>
				<th>상품명</th>
				<th>상품가격</th>
				<th>상품설명</th>
				<th>상품이미지</th>
				<th>상품평점</th>

			</tr>
		</thead>
		<tbody class="productList"></tbody>
	</table>
</div>
</body>
</html>