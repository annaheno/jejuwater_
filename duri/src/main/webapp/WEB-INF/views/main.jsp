<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>Every Dream Matters!</title>
    <link rel="stylesheet" type="text/css" href="resources/css/main.css">
    <link rel="stylesheet" type="text/css" href="resources/css/headerfooter1x.css">
        <link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@100;300;400;700&display=swap" rel="stylesheet">
        <link href="https://fonts.googleapis.com/css2?family=Saira+Condensed:wght@700&display=swap" rel="stylesheet">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="resources/js/jquery-3.5.1.js"></script>
  
  <style>.gnbar, .slide_btn_prev, .slide_btn_next, .controls {z-index: 9999;}</style>
</head>

<body>
    <header>
            <div class="logo"><a href="/duri"><img src="resources/image/h_logo.png" alt="로고"></a></div>
            <nav class="gnb">
                <!--네비게이션바-->
                <ul>
                    <li class="gnbar">
                        <div class="menu">ABOUT</div>
                        <div class="somenu">
                            <a href="#">ABOUT EDM</a>
                            <a href="#">ABOUT MAKE-A-WISH</a>
                        <a href="#">EDM HISTORY</a>
                    </div>
                </li>
                
                <li class="gnbar">
                    <div class="menu">DONATE</div>
                    <div class="somenu">
                        <a href="#">WISH STORIES</a>
                    </div>
                </li>
                
                <li class="gnbar">
                    <div class="menu">NOTICE</div>
                    <div class="somenu">
                        <a href="#">NOTICE</a>
                        <a href="#">FAQ</a>
                    </div>
                </li>
            </ul>
        </nav>
        <!--네비게이션바 끝-->
        <div id="cbox">
            <div><img src="resources/image/bg_box_num.png" alt="소원성취"></div>
            <div>
                <div id="txt">소원성취아동</div>
                <div id="count">51</div>
            </div>
        </div>
        <c:if test="${login == null}">
        <div id="util"><a href="/duri/member/login">Login</a></div>
        </c:if>
        <c:if test="${login != null}">
                <a href="/duri/member/updateMemberView">Modify</a>
        <a href="/duri/member/logout">Logout</a></c:if>
        </header>
        <main>
            <section>
                <div id="main">
                    <!--  슬라이드 이미지 시작 -->
                    <ul class="slider">
                            <li><a href="#" >
                                <img  src="resources/image/straykidsmeet_PC.jpg" class="pc">
                                <img  src="resources/image/straykidsmeet_TB.jpg" class="tb">
                                <img  src="resources/image/straykidsmeet_MO.jpg" class="mo">
                            </a></li>
                            
                            <li><a href="#">
                                <img src="resources/image/twice_PC.jpg" class="pc">
                                <img src="resources/image/twice_TB.jpg" class="tb">
                                <img src="resources/image/twice_MO.jpg" class="mo">
                            </a></li>
                            
                            <li> <a href="#">
                                <img src="resources/image/day6meet_PC.jpg" class="pc">
                                <img src="resources/image/day6meet_TB.jpg" class="tb">
                                <img src="resources/image/day6meet_MO.jpg" class="mo">
                            </a></li> <!-- slide_content slide03 end -->
                            
                            <li><a href="#">
                                <img src="resources/image/card_PC.jpg" class="pc">
                                <img src="resources/image/card_TB.jpg" class="tb">
                                <img src="resources/image/card_MO.jpg" class="mo">
                            </a></li>
                        </ul> <!-- slide_list  end -->
                        
                        <!-- 슬라이드 버튼 -->
                        <ol class="pagination"></ol>
                        <!-- 슬라이드 버튼 끝-->
                        
                        <div class="left"><span>&lt;</span></div>
                        <div class="right"><span>&gt;</span></div>
                        
                        <div class="contents_box">
                            <div class="about">
                                <span class="title">EDM</span>
                        <div class="topline"></div>
                        <span class="content">누구나 <br> 꿈꿀 수 있는<br> 세상을 <br> 만듭니다.<br></span>
                        <div class="bottomline"></div>
                        <div class="aboutBtn"><a href="#">EDM 소개 ></a></div>
                    </div>
                    
                    <div class="donatecontent">
                        <img src="resources/image/img_mc1_box2.png" alt="#">
                        <p class="dotxt">기부총액(원)</p>
                        <div class="counting"></div>
                        <p>기부인원 284명</p></div>
                    </div>
                </div>
            
            <div class="donate">
                <div class="donate_header">
                    <p class="prev"><img src="resources/image/arr_main_prev.png" alt=""></p>
                    <p>DONATE</p>
                    <p class="next"><img src="resources/image/arr_main_next.png" alt=""></p>
                </div>
                
                <div class="slide_wrapper">
                    <ul class="slides">
                        <li><p>EDM 기념일 기부</p>
                <div id="progressbar"><div class="progress-label"></div>
                <div class="progress-label2"></div></div></li>
                
                <li><p>"믹싱 장비가 갖고 싶어요"</p>
                    <p>이준상, 15세, 판코니빈혈</p>
                    <div id="progress"></div>
                    <p>103%</p>
                    <p>3,211,860원</p></li>
                    
                      <li><p>"빵 굽는 파티셰가 되고 싶어요"</p>
                        <p>최은수, 12세, 악성림프종</p>
                        <div id="progress"></div>
                        <p>100%</p>
                        <p>2,970,000원</p></li>
                        
                        <li><p>"가상세계에서 축구를 하고 싶어요"</p>
                            <p>민호(가명), 11세, 악성림프종</p>
                            <div id="progress"></div>
                            <p>103%</p>
                            <p>3,211,860원</p></li>
                            
                            <li><p>"글을 쓰는 작가가 되고 싶어요"</p>
                                <p>민서(가명), 16세, 골육종</p>
                                <div id="progress"></div>
                                <p>100%</p>
                                <p>3,100,000원</p></li>
                                <li><p>"헬로키티로 가득찬 방을 갖고 싶어요"</p>
                                    <p>소율(가명), 6세, 급성 림프구성 백혈병</p>
                                    <div id="progress"></div>
                        <p>100%</p>
                        <p>3,080,000원</p></li>
                    </ul>
                </div>
            </div>
        </section>
        
        <div id="story">
                    <div class="story_header">
                        <button type="button" class="s_prev"><img src="resources/image/arr_main_prev.png" alt=""></button>
                        <p>EDM STORIES</p>
                        <button type="button" class="s_next"><img src="resources/image/arr_main_next.png" alt=""></button>
                    </div>
                    
                    <div class="slide_wrapper2">
                        <ul class="slides2">
                            <li class="letter1"><img src="resources/image/day6letter_LIST.png" alt="">
                                <div class="orange"><p>Thanks letter</p></div>
                                <div class="o_textbox">
                                    <div>DAY6를 만난 아마야의 감사편지</div>
                        <div>데이식스 여러분 안녕하세요. 지난 겨울 서울에서 열린 콘서트에서 ...</div>
                        <div>2020.05.11</div></div></li>
                        
                        <li class="letter2"><img src="resources/image/day6meet_LIST.JPG" alt="">
                            <div class="green"><p>Wish granted</p></div>
                            <div class="g_textbox">
                                <div>"메리크리스마스? 아니 메리위시데이식스!"</div>
                       <div>나를 향해 쏴 Bang bang 그게 편해 편해 이젠 너무 익숙해 ...</div>
                       <div>2019.12.21</div></div></li>
                       
                       <li class="letter3"><img src="resources/image/hawai_LIST.jpg" alt="">
                        <div class="orange"><p>Thanks letter</p></div>
                        <div class="o_textbox">
                            <div>스트레이키즈를 만난 알리샤의 손편지</div>
                            <div>JYP 엔터테인먼트 관계자분께 놀라움으로 가득했던 콘서트에 참석 ...</div>
                            <div>2019.11.30</div></div></li>
                            
                            <li class="letter4"><img src="resources/image/skzmeet_LIST.jpg" alt="">
                                <div class="green"><p>Wish granted</p></div>
                                <div class="g_textbox">
                                    <div>하와이 소녀 알리샤의 잊을 수 없는 경험, 스트…</div>
                                    <div>"고마워요 JYP. 나의 소원을 이뤄줘서. 정말 평생 제 삶에서 잊을 수 ...</div>
                                    <div>2019.11.24</div></div></li>
                                    
                                    <li class="letter5"><img src="resources/image/dance_LIST.jpg" alt="">
                            <div class="green"><p>Wish granted</p></div>
                            <div class="g_textbox">
                                <div>"나보다 훨씬 오래 춤과 노래를 즐기길" 박진영…</div>
                            <div>"춤이 너무 좋아요. 춤을 출 때는 아픈 걸 잊게 돼요. 그때만큼은 힘 ...</div>
                            <div>2019.06.28</div></div></li>
                        </ul>
        </div>
    </div>
    
    <div id="notice_board">
        <div class="board_title">NOTICE</div>
        <a href="/duri/board/list">
        <div class="txtbox1">
        <div class="tit">신한 SOL과 함께하는 EDM 체크카드 이벤트</div>
            <div class="date">2020.07.29</div>
            </div>
            </a>
            
            <a href="/duri/board/list"><div class="txtbox2"><div class="tit">JYP CSR 공식 SNS 계정 오픈 및 이벤트 안내</div>
                <div class="date">2020.06.24</div></div></a>
            </div>
        </section>
    </main>
    
    <footer>
        <div class="footerIn">
            <div id="left">
                <a href="#"><img src="resources/image/f_logo.png" alt=""></a>
                <a href="#"><img src="resources/image/f_logo2.png" alt=""></a>
            </div>
            <div id="right">
                <a href="#"><img src="resources/image/f_sns_fb.png" alt=""></a>
                <a href="#"><img src="resources/image/f_sns_in.png" alt=""></a>
                <a href="#"><img src="resources/image/f_sns_tw.png" alt=""></a>
                <p>COPYRIGHTS ⓒ JYP Entertainment Corp. Make-A-Wish Korea. All rights reserved.</p></div>
            </div>
        </footer>
        
        <script src="resources/js/storyslide.js"></script>
        <script src="resources/js/slide.js"></script>
        <script src="resources/js/contentslide.js"></script>
        <script src="resources/js/count.js"></script>
        <script src="resources/js/progress.js"></script>
</body>
</html>