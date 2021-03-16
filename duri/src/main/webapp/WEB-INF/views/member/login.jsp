<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>로그인 - 제주용암수</title>
    <link rel="stylesheet" type="text/css" href="../resources/css/headerfooter.css">
    <link rel="stylesheet" type="text/css" href="../resources/css/login.css">
     <link rel="stylesheet" href="../resources/css/reset.css">
     <script type="text/javascript" src="../resources/js/jquery-3.5.1.js"></script>
     <script type="text/javascript" src="../resources/js/login.js"></script>
     <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
</head>
<body>
    <header>
	<%@ include file="../include/header2.jsp" %>
    </header>
    

    <form role="form" class="login" action="/duri/member/loginPost" method="post" autocomplete="off">
        <div class="tit">로그인</div><br>
        <input type="text" name="userid" id="userid" placeholder="아이디" required="required"><br>
        <input type="password" name="userpw" id="userpw" placeholder="비밀번호" required="required"><br>

        <div class="checks">
        <input type="checkbox" id="saveid" value="아이디 저장">
        <label for="saveid">아이디 저장</label>
        </div>
        <div class="checks2">
        <input type="checkbox" id="ckbox2" value="로그인 상태 유지">
        <label for="ckbox2">로그인 상태 유지</label><br>
        </div>

        <input type="submit" id="userbtn" value="로그인"><br>
          <c:if test="${msg == false}">
   <p style="color:#f00;">로그인에 실패했습니다.</p>
  </c:if>
        아직 회원이 아니신가요? <a href="/duri/member/member">회원가입</a><br>
        <p>* 회원가입, 로그인 오류 문제 발생 시 imme0525@gmail.com 메일로 문의 바랍니다.</p>
    </form>

    <footer>
 	<%@ include file="../include/footer.jsp" %>
     </footer>
</body>
</html>