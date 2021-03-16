<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지수정 - 제주용암수</title>
<link rel="stylesheet" type="text/css" href="../resources/css/register.css">
<link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
 <link rel="stylesheet" href="../resources/css/reset.css">
</head>
<body>
<c:if test="${login.verify == 3}">
  <header>
 <%@ include file="../include/header2.jsp" %>
</header>
        
<form action="/duri/admin/noticemodify" method="post" id="regForm">
<input type="hidden" name="bno" value="${modify.bno}">

<input type="text" id="title" name="title" value="${modify.title}">

<textarea name="content" id="content">${modify.content}</textarea>

<div class="fileDrop">첨부파일을 끌어다 놓으세요.

	<div class="uploadResult">
	
	<ul></ul>
	</div>
</div>

<div id="butt">
<a href="/duri/admin/notice"><input type="button" id="cbtn" value="취소"></a>
<input type="submit" id="btn" value="완료">
</div>
</form>

<footer>
<%@ include file="../include/footer.jsp" %>
</footer>
</c:if>
</body>
</html>