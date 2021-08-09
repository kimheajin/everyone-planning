<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계획 작성</title>
</head>
<body>
	<div class="loginInput">
		<h1>회원가입</h1>
		<form method="POST">
			<p>이름 : <input type="text" name="user_name"/> </p>
			<p>아이디 : <input type="text" name="login_id"/> </p>
			<p>닉네임 : <input type="text" name="nickname"/> </p>
			<p>휴대폰 : <input type="text" name="phone_number"/> </p>
			<p>생일 : <input type="text" name="birthday"/> </p>
			<p>주소 : <input type="text" name="address"/> </p>
			<input type="submit" value="회원가입">
		</form>
	</div>
</body>
</html>