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
	
		function deleteBoard(event) {
		}
				$.ajax({
				method: 'post',
				url: '../boardServlet',
				data : {
					cmd : 'delete',
					boardID : ${} 
				},
				success: successFnc,
				error: function (error) {
					console.log(error);
				}
		}
	</script>
	<title>lookBoard</title>

<body>
	<c:import url="../header.jsp"></c:import>
	<jsp:include page="../nav.jsp"></jsp:include>
	
<% BoardVO vo = (BoardVO) request.getAttribute("boardData"); %>
	<form action="../boardServlet/updateBoard.do" method="post">
		<%-- 	<%if(vo.getMemberId().equals(session.getAttribute("member_id"))){
		%>
		<input type='text' name='header' value=<%=vo.getBoardHeader() %>>
		<input type='text' value=<%=vo.getMemberId() %> readonly>
		<textarea rows="30" cols="50" name='content' value=<%=vo.getBoardContent() %>></textarea>
		<input type='submit' value="수정">
		<input type='button' value="삭제" onclick="../boardServlet/insertBoard.do">
	</form>
	<%}
	else{
	%>
	<input type='text' name='header' value=<%=vo.getBoardHeader() %> readonly>
	<input type='text' value=<%=vo.getMemberId() %> readonly>
	<textarea rows="30" cols="50" name='content' readonly><%=vo.getBoardContent() %> </textarea>
	</form>
	<%} %> --%>
	<input type='text' name='header' value=<%=vo.getBoardHeader() %>>
	<input type='text' name='memberId' value=<%=vo.getMemberId() %> readonly>
	<input type="hidden" name='boardId' value=<%=vo.getBoardId()%>>
	<textarea rows="30" cols="50" name='content'><%=vo.getBoardContent() %></textarea>
	<input type='submit' value="수정">
	<input type='button' value="삭제" onclick="deleteBoard">
	</form>



</body>

</html>