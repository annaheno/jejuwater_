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
    <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
<link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
 <link rel="stylesheet" href="../resources/css/reset.css">
</head>
<body>
 <header>
<%@ include file="../include/header2.jsp" %>
        </header>
<%-- <input type="hidden" name="pageNum" value="${cri.pageNum}"> --%>
<form role="form">
<input type="hidden" name="bno" id="bno" value="${read.bno}">
<table border="1">
<tr>
<td class="title">${read.title}</td>
<td class="viewcnt">${read.viewcnt}</td>
</tr>
<tr>
<td colspan="3" class="content">${read.content}
<div class="uploadResult"><ul></ul></div>
</td>
</tr>

<tr>
<td colspan="3" class="con">
<c:if test="${login.verify == 3}">
<button type="submit" class="btn-modify">수정</button>
<button type="submit" class="btn-delete">삭제</button>
</c:if>
<a href="/duri/admin/notice"><button type="submit" class="btn-list">목록</button></a>
</td>
</tr>
</table>
</form>
<footer>
<%@ include file="../include/footer.jsp" %>
        </footer>
        <script>
        $(document).ready(function() {
        	var formObj = $("form[role='form']");
        	console.log(formObj);
        	
//        	수정 버튼 클릭
        	$(".btn-modify").on("click",function(){
        		formObj.attr("action","/duri/admin/noticemodify");
        		formObj.attr("method","get");
        		formObj.submit();
        	});
        	
//        	삭제 버튼 클릭
        	$(".btn-delete").on("click",function(){
        		formObj.attr("action","/duri/admin/noticedelete");
        		formObj.attr("method","post");
        		formObj.submit();
        		alert("게시물을 삭제합니다.")
        	});
//        	목록 버튼 클릭
        	$(".btn-list").on("click",function(){
        		formObj.attr("action","/duri/admin/notice");
        		formObj.attr("method","get");
        		formObj.submit();
        	});
        	});
        </script>
</body>
</html>