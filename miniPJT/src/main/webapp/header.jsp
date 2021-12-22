<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../jquery-3.6.0.min.js"></script>
<title>Main</title>
<style>
div {
	display: inline-block;
}

li {
	margin: 80px 0px 80px;
}

.list {
	border: 1px soild black;
}
</style>
</head>
<body>
	<div style="width: 95%;">
		<div>
			<!--session.getAttribute 부분은 로그인에서 데이터를 session에 뿌려주는거 확인 해야함-->
			<!-- 그리고, session timeout 설정 확인 해봐야함 -->
			<h3><%=session.getAttribute("member_id")%>
				환영합니다. 즐거운 쇼핑되세요!!
			</h3>
			<!-- 해당부분 css 필요함 -->
			<a href="logout.do">페이지 이동</a> <a href="mypage.do">마이페이지</a>
		</div>
		<hr>

	</div>
	<div class='list'>
		<ul>
			<li>
				<!-- 아래 내용은 전체 상품 눌렀는데 메인 화면으로 이동 --> <a href='/miniPJT/main.jsp'>메인화면</a>
			</li>
			<li><a href='/miniPJT/board/listBoard.jsp'>게시판</a></li>

			<!-- 여기서는 admin 확인하고 아래 내용 보이도록 수정 -->
			<li><a href='/miniPJT/product/productInsert.jsp'>상품등록</a></li>
			<li><a href='/miniPJT/product/productInsert.jsp'>상품수정</a></li>

		</ul>
	</div>
</body>
</html>