<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>대량 구매 문의 - 제주용암수</title>
<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/heavy.css">
    <link rel="stylesheet" href="resources/css/headerfooter.css">
   	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="resources/js/addressapi.js"></script>
</head>
<body>
   <header>
        <%@ include file="include/header.jsp" %>
    </header>
    
    <form style="margin-top : 100px;">
    <div class="titbox"><span class="tit"><span style="color:#00aa91">법인/대량주문</span> 제주용암수에서 판매하는 <br>
	제품의 견적서비스를 받으실 수 있습니다.</span><br>
	<span>법인 및 20팩 이상 구매 고객 대상 대량주문상담을 통해 문의 주시면 담당자 확인 후 답변 드리겠습니다.</span>
	<img alt="" src="resources/image/main3-2.png"> </div><br>
    <div class="inputbox"><label>작성자</label><input type="text"></div><br>
    <div class="inputbox"><label>회사명</label><input type="text"></div><br>
    <div class="inputbox"><label>연락처</label><input type="text"></div><br>
    <div class="inputbox"><label>제품 정보</label><input type="text" class="s">
    명 기준 오피스 평균 1일 사용량 <span></span></div><br>
    <div class="inputbox" style="height: 130px;"><label style="height: 130px; line-height: 130px; top : -20px;">배송지</label>
    <div class="addressbox">
    <input type="text"id="zipcode" name="zipcode" placeholder="우편번호 검색" onclick="execPostCode();" readonly	>
    <input type="text" name="address1" id="address1" placeholder="도로명 주소" readonly><br>
    <input type="text" placeholder="상세 주소를 입력해주세요." name="address2" id="address2"><br></div></div>
    
    <div class="inputbox1"><label style="top : -50%;">내용</label>
    <textarea class="c" placeholder="요청하실 내용을 적어주세요."></textarea></div>
    	
    <div class="accept">
    <div class="accept_txt" style="margin:0 auto; width : 700px; height: 25px;"><input type="checkbox"> 개인정보 수집 이용 및 제공 동의 (필수)</div>
    <div class="acceptbox">
    <div><span>수집하는 개인정보 항목</span><br><span>이름, 회사명, 연락처, 주소</span></div>
    <div><span>수집 및 이용목적</span><br><span>문의사항 답변을 위한 연락</span></div>
    <div><span>보유 및 이용기간</span><br><span>답변 완료 후 90일</span></div></div>
    </div>
    
    <div class="btnbox"><input type="button" class="btn" value="문의하기"></div>
    </form>
    <footer>
 <%@ include file="include/footer.jsp" %>
    </footer>

</body>
</html>