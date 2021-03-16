<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="headerIn">
            <div class="gnb">
                <a href="/duri" class="logo"><img src="resources/image/logo.png" alt="로고"></a>
        <ul>
            <li><a href="/duri/intro">제주 용암수란?</a></li>
            <li><a href="/duri/item">일반주문</a></li>
            <li><a href="#">정기배송</a></li>
        </ul>
    </div>

        <div class="util">
        <ul>
   		     <c:if test="${login == null}">
   		     <li><a href="/duri/member/login">로그인</a></li>
   		      <li><a href="/duri/member/member">회원가입</a></li>
   		      </c:if>
   		      
   		     <c:if test="${login != null}">
   		     <li><a href="/duri/member/logout">로그아웃</a></li>
   		     <li><a href="/duri/member/mypage">마이페이지</a></li>
   		     </c:if>
   		     
            <li><a href="/duri/admin/notice">고객센터</a></li>
            <c:if test="${login.verify == 3}"><li><a href="/duri/admin/index">관리</a></li></c:if>
            <c:if test="${login.verify == 0}"><li><a href="#">쿠폰사용</a></li></c:if>
            <li><a href="/duri/heavybuying" style="color: #00aa91;">대량주문 문의</a></li>
        </ul>
    </div>
    </div>