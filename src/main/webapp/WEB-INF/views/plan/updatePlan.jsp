<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계획 수정</title>
</head>
<body>
	<h1>아래의 여행지에대해 수정이 가능합니다.</h1>
	<form method="POST">
		<p>제목 : <input type="text" name="title" value="${data.title}"/> </p>
		<p>여행지역 : <input type="text" name="local" value="${data.local}"/> </p>
		<p>예약할 숙박 사이트 : <input type="text" name="site" value="${data.site}"/> </p>
		<p>인원수 : <input type="text" name="people_cnt" value="${data.people_cnt}"/> </p>
		<p>여행비 : <input type="text" name="price" value="${data.price}"/> </p>
		<input type="submit" value="저장">
	</form>
</body>
</html>