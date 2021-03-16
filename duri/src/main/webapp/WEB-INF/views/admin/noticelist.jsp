<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제주용암수</title>
 <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
<link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
<link rel="stylesheet" type="text/css" href="../resources/css/list.css">
 <link rel="stylesheet" href="../resources/css/reset.css">
 <script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
</head>
<body>

  <header>
	<%@ include file="../include/header2.jsp" %>
        </header>
<c:choose>
<c:when test="${msg eq 'SUCCESS'}">
<script>
alert("수정 되었습니다.");
</script>
</c:when>
</c:choose>
<section id="board_wrap">
<div class="board_table">
<h1>공지사항</h1>
<table>
<tr>
<th>번호</th>
<th>제목</th>
<th>작성일</th>
<th>조회</ths>
</tr>
<c:forEach items="${list}" var="list">

<div class="tab_wrap">
  <div class="tab_menu_container">
  </div> <!-- tab_menu_container e -->

  <div class="tab_box_container">
  </div> <!-- tab_box_container e -->
</div> <!-- tab_wrap e -->
<tr id="list">
<td>${list.bno}</td>
<%-- <td><a href="/duri/admin/read?bno=${list.bno}&pageNum=${pageMaker.cri.pageNum}">${list.title}</a></td> --%>
<td><a href="/duri/admin/noticeread?bno=${list.bno}">${list.title}</a></td>
<td>${list.regdate}</td>
<td>${list.viewcnt}</td>
</tr>
</c:forEach>
<tr>
<td colspan="2" align="center">
<c:if test="${pageMaker.prev }">
<a href="/duri/admin/notice?pageNum=${pageMaker.startPage-1}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">이전</a></c:if>
<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
<a href="/duri/admin/notice?pageNum=${num}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${num}</a>
</c:forEach>
<c:if test="${pageMaker.next}">
<a href="/duri/admin/notice?pageNum=${pageMaker.endPage+1}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">다음</a></c:if></td>

</tr>
</table>

<div class="searchbar">
<form id="search" action="/duri/admin/notice" method="get">
<select name="type">
<option value="TCW"<c:out value="${pageMaker.cri.type eq 'TCW'?' selected ':' '}"/>>통합</option>
<option value="TC"<c:out value="${pageMaker.cri.type eq 'TC'?' selected ':' '}"/>>제목+내용</option>
<option value="T"<c:out value="${pageMaker.cri.type eq 'T'?' selected ':' '}"/>>제목</option>
<option value="C"<c:out value="${pageMaker.cri.type eq 'C'?' selected ':' '}"/>>내용</option>
<option value="W"<c:out value="${pageMaker.cri.type eq 'W'?' selected ':' '}"/>>글쓴이</option>
</select>
<input type="text" name="keyword">
<input type="submit" value="검색">
</form>
</div>
</div>
</section>
<footer>
 	<%@ include file="../include/footer.jsp" %>
</footer>
</body>
</html>