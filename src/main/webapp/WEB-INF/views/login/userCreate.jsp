<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계획 작성</title>
</head>
<body>
	<h1>가고싶은 여행지에 대한 계획을 세워보세요!</h1>
	<form method="POST">
		<p>제목 : <input type="text" name="title"/> </p>
		<p>여행지역 : <input type="text" name="local"/> </p>
		<p>예약할 숙박 사이트 : <input type="text" name="site"/> </p>
		<p>인원수 : <input type="text" name="people_cnt"/> </p>
		<p>여행비 : <input type="text" name="price"/> </p>
		<input type="submit" value="다음단계">
	</form>
</body>
</html>