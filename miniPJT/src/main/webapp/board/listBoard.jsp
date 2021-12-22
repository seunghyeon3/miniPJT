<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl사용을 위해 추가 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<link rel="stylesheet" href="board.css">

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
				data: {
					cmd: 'select'
				},
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
						if (field != 'boardContent') {
							let td = $('<td>').text(item[field])
							tr.append(td)
						}
					}
					tbd.append(tr);
				})

			}

			function viewList() {
				//여기서 데이터 조회 하고, jsp로 넘어가야함.
				var form = $('<form>');
				form.attr('action', '../boardServlet/showBoard.do');
				form.attr('method', 'post');
				form.appendTo('body');
				var no = $("<input type='hidden' value=" + event.target.parentNode.children[0].textContent +
					" name='no'>");
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
	<style>
		.mainBoard {
			display: inline-block;
			width: 90%;
			position: relative;
			top: -220px;
			padding: 0px 5px 10px 5px;
		}

		.tbl {
			width: 98%;
			text-align: center;
			right: 25px;
		}

		button {
			float: right;
			margin-right:30px;
			margin-bottom: 10px;
		}
	</style>
</head>

<body>
	<c:import url="../header.jsp"></c:import>
	<div class="mainBoard">
		<h3>게시판</h3>
		<button onclick="location.href='insertBoard.jsp'">등록</button>
		<table border="1" class="tbl">
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

	</div>
</body>

</html>