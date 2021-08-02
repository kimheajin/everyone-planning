<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/inc/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0"> 
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
<title>The Planning - Home</title>
</head>
<body>

	<h1>당신의 여행 계획을 세워보세요!</h1>
	<h2>The Planning</h2>
	
	<h3>오늘은 <fmt:formatDate value="${serverTime}" pattern="yyyy-MM-dd E" />요일 입니다.</h3>
	
	<div class="topnav">
		<p><a href="/list">목록으로</a></p>	
		<!-- Trigger/Open The Modal -->
		<button id="modal_open_btn">로그인</button>
	</div>
	

	<!-- The Modal -->
	<div id="loginModal" class="modal">

	  	<!-- Modal content -->
	  	<div class="modal-content">
	    	<span class="close">&times;</span>
	    	<p><a href="/login">아이디/비밀번호 찾기</a></p>
			<p><a href="/userCreate">회원가입</a></p>
		</div>
	</div>
	<div class="content">
	  <h2>CSS Template</h2>
	  <p>A topnav, content and a footer.</p>
	</div>
	
	<div class="footer">
	  <p>Footer</p>
	</div>
</body>
<script>
// modal내용
var modal = document.getElementById("loginModal");

// modal버튼
var btn = document.getElementById("modal_open_btn");

// modal창 닫기 버튼
var span = document.getElementsByClassName("close")[0];

// 버튼 클릭 시 modal의 스타일이 block(보여짐)으로 바뀜
btn.onclick = function() {
  modal.style.display = "block";
}

// user가 x버튼을 클릭할 시 모달 창이 닫힘
span.onclick = function() {
  modal.style.display = "none";
}

// user가 바깥부분(window)을 클릭할 경우 modal화면은 닫히게 된다.
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
</script>
</html>
