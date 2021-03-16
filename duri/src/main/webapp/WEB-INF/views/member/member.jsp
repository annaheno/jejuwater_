<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>회원가입 - 제주용암수</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/join.css">
     <link rel="stylesheet" href="../resources/css/reset.css">
    <script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="../resources/js/member.js"></script>
	<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="../resources/js/addressapi.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
	
</head>
<body>
    <header>
<%@ include file="../include/header2.jsp" %>
    </header>

        <form class="join" method="post" action="/duri/member/member" onsubmit="return checkmem()">
        
            <p>회원 정보 입력</p>
            
            <div>
            
            <div class="info"><div class="tit">아이디</div><input type="text" name="userid" id="userid" placeholder="아이디를 입력하세요.">
            <div id="idmsg"></div></div>
            
            <div class="info"><label class="tit">비밀번호</label><input type="password" name="userpw" id="userpw" placeholder="영문/숫자/특수문자 조합, 8자 ~ 16자">
            <label id="pwmsg"></label></div>
            
            <div class="info"><label class="tit">비밀번호 확인</label><input type="password" name="repw" id="repw" placeholder="비밀번호를 한 번 더 입력해주세요."> <label id="remsg"></label></div>
            
            <div class="info"><label class="tit">성명</label><input type="text" name="username" id="username" placeholder="반드시 실명으로 작성해 주시기 바랍니다."></div>
            
            <div class="info"><label class="tit">성별</label>
            <input type="radio" name="gender" id="female" value="여성" checked><label for="female">여성</label>
            <input type="radio" name="gender" id="male" value="남성"><label for="male">남성</label></div>
            
            <div class="info"><label class="tit" style="height: 95px;">주소</label>
            <div class="addressbox">
          	  <input type="text" id="zipcode" name="zipcode" placeholder="우편번호 검색" onclick="execPostCode();" readonly>
				<input type="text" name="address1" id="address1" placeholder="도로명 주소" readonly><br>
				<input type="text" placeholder="상세 주소를 입력해주세요." name="address2" id="address2">
            </div></div>
            
              <div class="info"><label class="tit">전화번호</label>
              <input type="text" name="phone" id="phone" placeholder="'-'없이 숫자만 입력하세요."></div>
              </div>
              <div id="btn" align="center"><input type="button" id="cbtn" value="이전"><input type="submit" id="joinbtn" value="가입"></div>
        </form>

    <footer>
<%@ include file="../include/footer.jsp" %>
    </footer>
</body>
</html>