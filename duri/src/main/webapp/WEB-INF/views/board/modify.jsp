<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
 <link rel="stylesheet" href="../resources/css/reset.css">
 <link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
</head>
<body>
<header>
	<%@ include file="../include/header2.jsp" %>
</header>

<h1>수정 화면</h1>
<form action="/duri/board/modify" method="post">
<input type="text" name="pageNum" value="${cri.pageNum }">
<input type="hidden" name="bno" value="${modify.bno}">
제 목 : <input type="text" name="title" value="${modify.title}"><br>
내 용 : <textarea name="content">${modify.content}</textarea><br>
작성자 : <input type="text" name="writer" value="${modify.writer}" readonly><br>
<input type="submit" value="글 수정">
</form>
<footer>
 	<%@ include file="../include/footer.jsp" %>
</footer>
</body>
</html>