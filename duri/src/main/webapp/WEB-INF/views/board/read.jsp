<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제주용암수</title>
<link rel="stylesheet" type="text/css" href="../resources/css/read.css">
<script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
<script type="text/javascript" src="../resources/js/ajaxtest.js"></script>
<script type="text/javascript" src="../resources/js/read.js"></script>
<link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
 <link rel="stylesheet" href="../resources/css/reset.css">
</head>
<body>
 <header>
<%@ include file="../include/header2.jsp" %>
        </header>
<div id="reply_section">
	<div id="reply_title"></div>
	<div>
	<input type="text" id="replytext">
	</div>
	<div>
	<button type="button" id="replyModify">수정</button>
	<button type="button" id="replyDelete">삭제</button>
	<button type="button" id="replyClose">닫기</button>
	</div>
</div>

<form role="form">
<input type="hidden" name="bno" id="bno" value="${read.bno}">
<input type="hidden" name="pageNum" value="${cri.pageNum}">

<table border="1">
<tr>
<td class="title">${read.title}</td>
<td class="writer">${read.title}</td>
<td class="viewcnt">${read.viewcnt}</td>
</tr>
<tr>
<td colspan="3" class="content">${read.content}
<div class="uploadResult"><ul></ul></div>
</td>
</tr>

<tr>
<td colspan="3" class="con">
<button type="submit" class="btn-modify">수정</button>
<button type="submit" class="btn-delete">삭제</button>
<button type="submit" class="btn-list">목록</button>
</td>
</tr>
</table>

<div class="replyForm">
<ul id=replies></ul>
<ul id="replypage"></ul>
<div>
<input type="text" name="replyer" id="newReplyer" placeholder="댓글쓴이">
<input type="text" name="replytext" id="newReplytext" placeholder="댓글 내용">
<button id="replyAdd">등록</button>
</div>
</div>
</form>

<footer>
<%@ include file="../include/footer.jsp" %>
        </footer>
</body>
</html>