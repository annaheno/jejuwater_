<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<link rel="stylesheet" type="text/css" href="../resources/css/register.css">
<link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
 <link rel="stylesheet" href="../resources/css/reset.css">
</head>
<body>
  <header>
 <%@ include file="../include/header2.jsp" %>
</header>
        
<h2>${result}</h2>

<form role="form" action="/duri/admin/noticewrite" method="post" id="regForm" enctype="multipart/form-data">

<input type="text" id="title" name="title" placeholder="제목을 입력하세요.">

<textarea name="content" id="content" placeholder="내용을 입력하세요."></textarea>

<div class="fileDrop">첨부파일을 끌어다 놓으세요.

	<div class="uploadResult">
	
	<ul></ul>
	</div>
</div>

<div id="butt">
<a href="/duri/index"><input type="button" id="cbtn" value="취소"></a>
<input type="submit" id="btn" value="완료">
</div>
</form>

<footer>
<%@ include file="../include/footer.jsp" %>
</footer>
</body>
</html>