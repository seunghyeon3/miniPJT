<%@page import="com.edu.VO.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jstl사용을 위해 추가 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<!-- jquery 사용을 위해 추가 -->
	<script src="../jquery-3.6.0.min.js"></script>
	<!-- web browser tab 명명하기 위함 -->
	<script>
		$(document).ready(function () {
			$.ajax({
				method: 'get',
				url: '../CommentServlet',
				data: {
					cmd: 'comment',
					boardId: $('#board').val()
				},
				success: commentCall,
				error: function (error) {
					console.log(error);
				}
			});

			function commentCall(result) {
				//result 결과보고 comment 출력하면됨.
				var comm = $('#showComm');
				if (result.length > 0) {
					result.forEach(item => {
						// if (result != null && (item.memberId == sessionStorage.getItem("member_Id"))) {
						// 	comm.append(
						// 		$('<div>').attr('id', item.commentID).append(
						// 			$('<input>').attr('type', 'hidden').val(item.memberId),
						// 			$('<input>').text(item.commentContent),
						// 			$('<button>').val('수정').attr('click', modifyCommFnc(event)),
						// 			$('<button>').val('삭제').attr('click',  deleteCommFnc(event))
						// 		)
						// 	);
						// } else if (result != null && (item.memberId != sessionStorage.getItem("member_Id"))) {
						// 	comm.append(
						// 		$('<div>').attr('id', item.commentID).append(
						// 			$('<input>').attr('type', 'hidden').val(item.memberId),
						// 			$('<input>').text(item.commentContent),
						// 			$('<button>').val('수정').attr('click', modifyCommFnc(event)).hide(),
						// 			$('<button>').val('삭제').attr('click', deleteCommFnc(event)).hide()
						// 		)
						// 	);
						// } else {
						// 	comm.append(
						// 		$('<p>').text("등록 된 댓글이 없습니다.")
						// 	)
						// }
						if ($('#board').val() == item.boardId) {
							comm.append(
								$('<div>').append(
									$('<input>').attr({
										type: 'hidden',
										id: 'boardid'
									}).val(item.boardId),
									$('<input>').attr({
										type: 'hidden',
										id: 'commentId'
									}).val(item.commentId),
									$('<input>').val(item.commentContent),
									$('<button>').text('수정').click(modifyCommFnc),
									$('<button>').text('삭제').click(deleteCommFnc)
								)
							);
						}

					});
				} else {
					comm.append($('<p>').text('등록된 댓글이 없습니다.'));
				}
			};
			//아래 내용 참고하여 작성하면됨.
			//버튼 이벤트까지만 걸어주면끝

			// let tbd = $('.showList');
			// 	result.forEach(item => {
			// 		let tr = $('<tr>').on("click", viewList).hover(function () {
			// 			$(this).css('color', 'red');
			// 		}, function () {
			// 			$(this).css('color', 'black');
			// 		});
			// 		for (let field in item) {
			// 			if (field != 'boardHeader') {
			// 				let td = $('<td>').text(item[field])
			// 				tr.append(td)
			// 			}
			// 		}
			// 		tbd.append(tr);
			// 	})

		});

		function modifyCommFnc(e) {
			//수정중
			console.log(e.target.parentNode.children[0].value); //boardid
			console.log(e.target.parentNode.children[1].value); //commentId
			console.log(e.target.parentNode.children[2].value); //commentContent

			$.ajax({
				method: 'post',
				url: '../CommentServlet',
				data: {
					cmd: 'modify',
					commId: e.target.parentNode.children[1].value,
					commVal: e.target.parentNode.children[2].value,
					boardId: e.target.parentNode.children[0].value
				},
				success: function () {
					console.log("수정완료");
					location.reload();
				},
				error: function (request, status, error) {
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" +
						error);
				}
			})
		}

		function deleteCommFnc(e) {
			$.ajax({
				method: 'post',
				url: '../CommentServlet',
				data: {
					cmd: 'delete',
					commId: e.target.parentNode.children[1].value,
					boardId: e.target.parentNode.children[0].value
				},
				success: function () {
					console.log("삭제완료");
					e.target.parentNode.remove();
					location.reload();
				},
				error: function (request, status, error) {
					console.log(error);
				}
			})
		}

		function deleteBoard(boardId) {
			$.ajax({
				method: 'post',
				url: '../boardServlet',
				data: {
					cmd: 'delete',
					boardId: boardId
				},
				success: function () {
					location.href = '../board/listBoard.jsp';
				},
				error: function (error) {
					console.log(error);
				}
			})

		}

		function addComm(boardId) {
			console.log(window.location.pathname);
			$.ajax({
				method: 'post',
				url: '../CommentServlet',
				data: {
					cmd: 'insert',
					commdata: $('#addComm').val(),
					boardId: boardId
				},
				success: function () {
					// result에 retCode 추가 해보기
					location.reload();
				},
				error: function (request, status, error) {
					alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" +
						error);

				}

			});

		}
	</script>

	<title>lookBoard</title>
	<style>
		div {
			display: inline-block;
			padding-right: 30px;
		}
	</style>

<body>
	<c:import url="../header.jsp"></c:import>

	<% BoardVO vo = (BoardVO) request.getAttribute("boardData"); %>
	<div>
	<form action="../boardServlet/updateBoard.do" method="post">
	제목<br>
		<input type='text' name='header' value=<%=vo.getBoardHeader() %>><br>
		<!-- 아래 내용 세션으로 바꿔야함. -->
		작성자<br>
		<input type='text' name='memberId' value=<%=vo.getMemberId() %> readonly><br>
		<input type="hidden" name='boardId' id='board' value=<%=vo.getBoardId()%>>
		내용<br>
		<textarea  rows=8" cols="50"  name='content'><%=vo.getBoardContent() %></textarea><br>
		<input type='submit' value="수정">
		<input type='button' value="삭제" id='delbtn' onclick='deleteBoard("<%=vo.getBoardId()%>")'>
	</form>

	<div id="comment">
		<p>댓글 추가</p>
		<input type="text" id="addComm">
		<button onclick="addComm('<%=vo.getBoardId()%>')">+</button>
	</div>
	<hr>
	<div id="showComm">
	</div><br>
</div>


</body>

</html>