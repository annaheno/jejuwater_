<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>제주용암수</title>
    <link rel="stylesheet" type="text/css" href="https://cdn.rawgit.com/moonspam/NanumSquare/master/nanumsquare.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">
    <link rel="stylesheet" href="resources/css/reset.css">
    <link rel="stylesheet" href="resources/css/headerfooter.css">
    <link rel="stylesheet" href="resources/css/home.css">
    <link rel="stylesheet" href="resources/css/slide.css">
    <script src="resources/js/main_scroll.js"></script>
</head>
<body>

   <header>
        <%@ include file="include/header.jsp" %>
    </header>
    
    <div id="main_wrap">
        <span><img src="resources/image/top_btn.png" alt="탑"></span>
            
            <!-- 슬라이드-->
            <div class="swiper-container">
    <div class="swiper-wrapper">
      <div class="swiper-slide" style="background: url('resources/image/slide_main.jpeg') no-repeat center;">
      <a href="#"><input type="button" class="a" value="자세히 보기"></a></div>
      
     <div class="swiper-slide" style="background: url('resources//image/slide_order.jpeg') no-repeat center;"></div>
      <div class="swiper-slide" style="background: url('resources/image/slide_co.jpeg') no-repeat center;">
      <a href="#"><input type="button" class="b" value="추천하기"></a></div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
    <!-- Add Arrows -->
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
  </div> <!--  슬라이드 끝 -->

  <div class="notice">
  <div class="board">
  <div class="board_tit">공지사항</div>
  <a href="#"><div class="content">제주용암수 정식 오픈!</div></a>
  </div></div>

  <div class="main1">
      <div class="main1_wrap">
    <span class="main1_tit">돈과 시간을 아껴주는, 정기배송</span>
    <div class="main1_box">
    <div class="main1_img"><img src="resources/image/main1-1.png" alt="배송"><br>
    <div>잊고 사는 즐거움</div>
    <br><span2>한 번 주문으로 원하는 요일, 장소로 배송</span2></div>
    
    <div class="main1_img"><img src="resources/image/main1-2.png" alt="편리"><br>
    <div>매번 편리하게</div><br><span2>
    간편한 주문, 세 번 클릭으로 주문 끝</span2></div>
    
    <div class="main1_img"><img src="resources/image/main1-3.png" alt="취소"><br>
    <div>안심하세요</div><br>
    <span2>언제든지 취소/해지가 가능합니다.</span2></div>
    </div>
    
    <input type="button" value="정기배송 신청하기" class="del_btn">
    </div></div>

    <div class="main2">
        <div class="main2_tit">내 몸에 맞춘 미네랄 블렌딩 워터 제주용암수</div>
        <div class="main2_box" style="background: url('resources/image/main2.png')no-repeat 50% 0"></div>
    </div>

    <div class="main3">
        <a href="/duri/item"><div class="main3_box1">
            <div class="main3_tit">오늘 밤 주문하면 내일 도착!</div><br>
            <div class="main3_content">오후 11시까지 결제만 하세요.<br>일부 도서산간지역은 예외</div>
            <img src="resources/image/main3-1.png" alt="배달원"></div></a>

        <a href="/duri/heavybuying"><div class="main3_box2">
            <div class="main3_tit">법인/대량 구매</div><br>
            <div class="main3_content">20팩 이상 구매고객<br>대량주문 문의하기</div>
            <img src="resources/image/main3-2.png" alt="상담원"></div></a>
    </div>

    <div class="app" style="background: url('resources/image/app.jpeg') center;">
        <span>제주용암수 어플로 더욱 편하게 이용하세요!</span>
        <div class="app_img"><img src="resources/image/app-1.png" alt="애플">
        <img src="resources/image/app-2.png" alt="구글"></div>
    </div>

    </div>
    
        <footer>
 <%@ include file="include/footer.jsp" %>
    </footer>
        <script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>
    <script src="resources/js/main_slide.js"></script>
</body>
</html>
