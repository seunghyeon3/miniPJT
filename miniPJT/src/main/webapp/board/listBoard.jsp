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
	<title>showBoard</title>
	<script>
		$(document).ready(function () {
			$.ajax({
				method: 'get',
				url: '../boardServlet',
				dataType: 'json',
				success: successFnc,
				error: function (error) {
					console.log(error);
				}
			});

			function successFnc(result) {
				let tbd = $('.showList');
				result.forEach(item => {
					let tr = $('<tr>').on("click", viewList).hover(function () {
						$(this).css('color', 'red');
					}, function () {
						$(this).css('color', 'black');
					});
					for (let field in item) {
						if (field != 'boardHeader') {
							let td = $('<td>').text(item[field])
							tr.append(td)
						}
					}
					tbd.append(tr);
				})

			}

			function viewList(event) {
				//여기서 데이터 조회 하고, jsp로 넘어가야함.
				var form = $('<form>');
				form.attr('action', '../boardServlet/showBoard.do');
				form.attr('method', 'post');
				form.appendTo('body');
				var no = $("<input type='hidden' value=" + event.target.parentNode.children[0].textContent + " name='no'>");
				form.append(no);
			
				form.submit();



				// 	document.body.append(forms);
				// var forms = $('<form>').attr({
				// 	'method': 'post',
				// 	'action': '../boardServlet/showBoard.do'
				// }).append($('<input>').attr({
				// 	'type': 'hidden',
				// 	'name': 'writer',
				// 	'value': 
				// })).submit();


			}
		});
	</script>
</head>

<body>
	<c:import url="../header.jsp"></c:import>
	<jsp:include page="../nav.jsp"></jsp:include>
	<div>
		<table border="1">
			<thead>
				<tr>
					<th>No.</th>
					<th>제목</th>
					<th>작성자</th>
				</tr>
			</thead>
			<tbody class="showList">
			</tbody>
		</table>
		<button onclick="location.href='insertBoard.jsp'">등록</button>
	</div>
</body>

</html>