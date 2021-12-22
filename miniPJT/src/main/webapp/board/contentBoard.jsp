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
				url: '../boardServlet',
				data: {
					cmd: 'comment'
				},
				dataType: 'json',
				success: commentCall,
				error: function (error) {
					console.log(error);
				}
			});

			function commentCall(result) {
				//result 결과보고 comment 출력하면됨.
				var comm = $('#showComm');

				result.forEach(item => {
						if (result != null && (item.memberId == sessionStorage.getItem("member_Id"))) {
							comm.append(
								$('<div>').attr('id', item.commentID).append(
									$('<input>').attr('type', 'hidden').val(item.memberId),
									$('<input>').text(item.commentContent),
									$('<button>').val('수정').attr('click', modifyCommFnc(event)),
									$('<button>').val('삭제').attr('click',  deleteCommFnc(event))
								)
							);
						} else if (result != null && (item.memberId != sessionStorage.getItem("member_Id"))) {
							comm.append(
								$('<div>').attr('id', item.commentID).append(
									$('<input>').attr('type', 'hidden').val(item.memberId),
									$('<input>').text(item.commentContent),
									$('<button>').val('수정').attr('click', modifyCommFnc(event)).hide(),
									$('<button>').val('삭제').attr('click', deleteCommFnc(event)).hide()
								)
							);
						} else {
							comm.append(
								$('<p>').text("등록 된 댓글이 없습니다.")
							)
						}
					});
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

			}
		});

		function modifyCommFnc(event) {
			console.log(event.target);
			let commentId = event.target.parentNode.textContent;
			let commentValue = event.target.parentNode.children[2].textContent;
			let boardID = $('#board').val();
			$.ajax({
				method: 'post',
				url: '../CommentServlet',
				data: {
					cmd: 'modify',
					commId: commentId,
					commVal: commentValue,
					boardId: boardID
				},
				success: function () {
					console.log("수정완료");
					location.reload();
				},
				error: function () {
					conosle.log(error);
				}
			})
		}

		function deleteCommFnc(event) {
			let commentId = event.target.parentNode.textContent;
			$.ajax({
				method: 'post',
				url: '../CommentServlet',
				data: {
					cmd: 'delete',
					commId: commentId
				},
				success: function () {
					console.log("삭제완료");
					event.target.parentNode.remove();
				},
				error: function () {
					conosle.log(error);
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

			console.log($('#addComm').val())
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
				error: function (error) {
					console.log(error);
				}

			});

		}
	</script>
	<title>lookBoard</title>

<body>
	<c:import url="../header.jsp"></c:import>
	<jsp:include page="../nav.jsp"></jsp:include>

	<% BoardVO vo = (BoardVO) request.getAttribute("boardData"); %>
	<form action="../boardServlet/updateBoard.do" method="post">

		<input type='text' name='header' value=<%=vo.getBoardHeader() %>>
		<!-- 아래 내용 세션으로 바꿔야함. -->
		<input type='text' name='memberId' value=<%=vo.getMemberId() %> readonly>
		<input type="hidden" name='boardId' id='board' value=<%=vo.getBoardId()%>>
		<textarea rows="30" cols="50" name='content'><%=vo.getBoardContent() %></textarea>
		<input type='submit' value="수정">
		<input type='button' value="삭제" id='delbtn' onclick='deleteBoard("<%=vo.getBoardId()%>")'>
	</form>

	<div id="comment">
		<p>댓글</p>
		<input type="text" id="addComm">
		<button onclick="addComm('<%=vo.getBoardId()%>')">+</button>
	</div>
	<hr>
	<div id="showComm">
	</div>



</body>

</html>