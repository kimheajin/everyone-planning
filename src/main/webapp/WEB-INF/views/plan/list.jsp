<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Plan list</title>
</head>
<body>
	<div>
		<p>
			<form>
				<input class="serch" type="text" placeholder="검색" name="keyword" value="${keyword}" />
				<input type="submit" value="검색" />
			</form>
		</p>
	</div>

	<h1>여행 목록</h1>
	<table class="travelTable">
		<thead>
			<tr>
				<td>제목</td>
				<td>카테고리</td>
				<td>가격</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${data}">
				<tr>
					<td>
						<a href="/detail?planId=${row.plan_id}">
							${row.title}
						</a>
					</td>
					<td>${row.category}</td>
					<td><fmt:formatNumber type="number" maxFractionDigits="3" value="${row.price}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="/createPlan">여행 계획 작성</a>
	</p>
</body>
</html>