<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지 - 제주용암수</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
    <link rel="stylesheet" href="../resources/css/reset.css">
    <link rel="stylesheet" href="../resources/css/mypage.css">
    <script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
</head>
<body>
<header>
<%@ include file="../include/header2.jsp" %>
</header>

<form id="content" action="/duri/member/mypage" method="get">
<ul>
	<c:forEach items="${cartList}" var="cartList">
	<li>	
			<h1>주문 목록</h1>
	<div class="ginfo">
		<table>
		<tr>
			<td>주문 번호</td> <td>${cartList.cno}</td>
			<td>상품명</td> <td style="width:200px;">${cartList.gname}</td>
			<td>개당 가격</td> <td><fmt:formatNumber pattern="###,###,###" value="${cartList.price }"/>원</td>
			<td>구입 수량</td> <td>${cartList.cstock}</td>
			<td>총 가격</td> <td><fmt:formatNumber pattern="###,###,###" value="${cartList.price * cartList.cstock}"/>원</td>
		</tr>
		</table>
	<div class="delete">
     <button type="button" class="delete_btn" data-cno="${cartList.cno}">삭제</button>
    </div>
	</div>
	</li>
	</c:forEach>
</ul>
</form>
<div class="userinfo">
	<table>
            <h1>회원 정보</h1>
            <tr><td>아이디<td><td name="userid" id="userid">${login.userid}</td></tr>
            <tr><td>성명</td><td name="username" id="username">${info.username}</td></tr>
            <tr><td>성별</td><td name="gender" id="female">${info.gender}</td></tr>
            <tr><td>주소</td><td>(${info.zipcode}) ${info.address1} ${info.address2}</td></tr>
            <tr><td>전화번호</td><td name="phone" id="phone">${info.phone}</td></tr>
        </table>
			<a href="/duri/member/updateMemberView">회원 정보 수정</a>
</div>
     <script>
 $(".delete_btn").on("click",function(){
  let	 dcno = $(this).data("cno");
  console.log(dcno);
  
   $.ajax({
    url : "/duri/deleteCart",
    type : "post",
    data : {cno : dcno},
    success : function(result){
    	if(result == 1){
     location.href = "/duri/member/mypage";
    	}else{
    		alert("삭제 실패");
    	}
   }
   });
 });
</script>
    <footer>
 	<%@ include file="../include/footer.jsp" %>
     </footer>
</body>
</html>