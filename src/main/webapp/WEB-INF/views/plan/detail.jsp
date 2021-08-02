<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan 상세</title>
</head>
<body>
	<h1>여행 상세</h1>
	<p>제목 : ${data.title}</p>
	<p>지역 : ${data.local}</p>
	<p>참고 사이트 : ${data.site}</p>
	<p>가격 : <fmt:formatNumber type="number" maxFractionDigits="3" value="${data.price}" /></p>
	<p>입력일 : <fmt:formatDate value="${data.insert_date}" pattern="yyyy.MM.dd HH:mm:ss" /></p>

	<p>
		<a href="update?planId=${planId}">수정</a>
	</p>
	<form method="POST" action="/delete">
		<input type="hidden" name="planId" value="${planId}"/>
		<input type="submit" value="삭제">
	</form>
	<p>
		<a href="/list">목록으로</a>
	</p>
</body>
</html>