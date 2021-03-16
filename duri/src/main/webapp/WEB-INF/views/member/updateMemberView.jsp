<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Modify - Every Dream Matters!</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/join.css">
    <script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
    <script type="text/javascript" src="../resources/js/update.js"></script>
</head>
<body>
    <header>
<%@ include file="../include/header2.jsp" %>

    <main>
        <form class="join" method="post" action="/duri/member/updateMember">
            <h1>회원 정보 수정</h1>
            <label>아이디</label> <input type="text" name="userid" id="userid" value="${login.userid}" readonly><br>
            <label>비밀번호</label> <input type="password" name="userpw" id="userpw" placeholder="영문/숫자/특수문자 조합,최소 8자~ 최대 16자" value="${login.userpw}"> <br>
            <br><label id="pwmsg"></label><br>
            <label>비밀번호 재확인</label> <input type="password" name="repw" id="repw"><br><label id="remsg"></label><br>
            <label>성명</label> <input type="text" name="username" id="username" placeholder="반드시 실명으로 작성해 주시기 바랍니다." value="${info.username}"><br>
            <label>성별</label> <input type="radio" name="gender" id="female" value="여성" checked value="${info.gender}"><label for="female">여성</label>
                 <input type="radio" name="gender" id="male" value="남성"> <label for="male">남성</label><br>
            <label>주소</label><input type="text" value="(${info.zipcode}) ${info.address1} ${info.address2}" readonly>
              <label>전화번호</label> <input type="text" name="phone" id="phone" placeholder="'-'없이 숫자만 입력하세요." value="${info.phone}"><br>
              <input type="submit" id="joinbtn" value="정보 수정">
        </form>
    </main>

 	<%@ include file="../include/footer.jsp" %>
</body>
</html>