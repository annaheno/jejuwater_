<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>일반 주문 - 제주용암수</title>
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
<link rel="stylesheet" href="resources/css/reset.css">
<link rel="stylesheet" type="text/css" href="resources/css/headerfooter.css">
<link rel="stylesheet" type="text/css" href="resources/css/item.css">
<script src="resources/js/jquery-3.5.1.js"></script>
<script src="resources/js/count.js"></script>
<script src="resources/js/gallery.js"></script>
</head>
<body>

<header>
<%@ include file="include/header.jsp" %>
</header>
        <form action="/duri/item" method="get" id="main_wrap" class="item">
            
        <div class="item_order">
        <div class="item_box">
            <!-- 슬라이드 -->
            <div id="gallery">
                <p id="photo"><img src="resources/image/item1.jpg" alt=""></p>
                
                <div id="photo_list">
                    <ul id="inner_list">
                        <li><a href="resources/image/item1.jpg"><img src="resources/image/item1.jpg" alt=""></a></li>
                        <li><a href="resources/image/item2.jpg"><img src="resources/image/item2.jpg" alt=""></a></li>
            <li><a href="resources/image/item3.jpg"><img src="resources/image/item3.jpg" alt=""></a></li>
        </ul>
    </div>
</div>


<div class="item_list">
<p class="free_d">무료배송</p>
<div class="item_tit">제주용암수</div>
<table>
<c:forEach var="row" items="${list}">
<tr>
<td id="gno${row.gno}" style="display:none;">${row.gno}</td>
<td class="items">${row.gname}</td>
<td id="price"><fmt:formatNumber value="${row.price}" pattern="###,###,###"/></td>
</tr>
</c:forEach>
</table>
<div class="itemcount_wrap" >
<div class="item_count">
<input type="text" name="price" value="10000" hidden=hidden>
            <input type="button" name="minus" onclick="reduce(0);" value="-">
            <input type="text" name="amount" id="amount1" value="0">
            <input type="button" name="plus" onclick="add(0);" value="+"></div>
			<div id="price0">10000</div>
<div class="item_count">
<input type="text" name="price" value="12000" hidden=hidden>
            <input type="button" name="minus" onclick="reduce(1);" value="-">
            <input type="text" name="amount" id="amount2" value="0">
            <input type="button" name="plus" onclick="add(1);" value="+"></div>
			<div id="price1">12000</div>
<div class="item_count">
<input type="text" name="price" value="7800" hidden=hidden>
            <input type="button" name="minus" onclick="reduce(2);" value="-">
            <input type="text" name="amount" id="amount3" value="0">
            <input type="button" name="plus" onclick="add(2);" value="+"></div> </div>
            <div id="price2">7800</div>
  
           
            <div id="itemcount">결제금액 <div id="totalPrice"><span></span></div><br>
            <div class="buttonbox">
            <button type="button" class="order">주문하기</button>
            <input type="submit" class="gift" value="선물하기">
            </div>
        </div> 
    </div>
</div>
    <div class="item_info">
        <div class="info1"><img src="resources/image/iteminfo-1.jpg" alt=""></div>
        <div class="info2"><img src="resources/image/iteminfo-2.jpg" alt=""></div>
        <div class="info3"><img src="resources/image/iteminfo-3.jpg" alt=""></div>
        <div class="info3"><img src="resources/image/iteminfo-4.jpg" alt=""></div>
        <div class="info3"><img src="resources/image/iteminfo-5.jpg" alt=""></div>
    </div>
    </form>
    
    <footer>
    <%@ include file="include/footer.jsp" %>
    </footer>

<script src="resources/js/cart.js"></script>
</body>
</html>