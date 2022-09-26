<%@ page import="com.golfzone.social.activity.ActivityDAO" %>
<%@ page import="com.golfzone.social.activity.ActivityDAOImpl" %>
<%@ page import="com.golfzone.social.club.ClubDAO" %>
<%@ page import="com.golfzone.social.club.ClubDAOImpl" %>
<%@ page import="com.golfzone.social.activity.ActivityVO" %>
<%@ page import="com.golfzone.social.club.ClubVO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: org
  Date: 2022/09/23
  Time: 1:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="css/main.css" type="text/css"/>
    <link rel="stylesheet" href="css/createclub.css" type="text/css"/>
    <title>클럽 생성</title>
</head>
<body>
<% String msg = (String) request.getAttribute("resultMsg"); %>
<%
    ActivityDAO activityDAO = new ActivityDAOImpl();
    ClubDAO clubDAO = new ClubDAOImpl();
    List<ActivityVO> activityVOS = activityDAO.selectAll();
    List<ClubVO> clubVOS = clubDAO.selectAll();
%>
<section id="navBar">
    <nav id="mainNav">
        <a href="/club.jsp" class="logo">Logo</a>
        <ul>
            <li><a href="#">MyPage</a></li>
        </ul>
    </nav>
    <div id="dropDown">
        <form action="" method="post" class="search-form">
            <div class="search-name">
                <ion-icon class="search-icon" name="search-outline"></ion-icon>
                <input
                        type="text"
                        placeholder="모임/액티비티 검색"
                        id="clubName"
                        name="clubName"
                />
                <ion-icon
                        class="chevron-icon"
                        id="chevronIcon"
                        name="chevron-down-outline"
                ></ion-icon>
            </div>
            <div class="optional hide">
                <div class="age">
                    <label for="clubAgeLow">연령</label>
                    <select
                            name="ageLow"
                            id="clubAgeLow"
                            onchange="clubAgeLowChange()"
                    >
                        <option value="0" selected>최소나이 선택</option>
                    </select>
                    <b>~</b>
                    <select name="ageHigh" id="clubAgeHigh">
                        <option value="0" selected>최대나이 선택</option>
                    </select>
                </div>
                <div class="tier">
                    <label for="clubTierLow">타수</label>
                    <select
                            name="tierLow"
                            id="clubTierLow"
                            onchange="clubTierLowChange()"
                    >
                        <option value="0" selected>최소타수 선택</option>
                    </select>
                    <b>~</b>

                    <select name="tierHigh" id="clubTierHigh">
                        <option value="0">최대타수 선택</option>
                    </select>
                </div>
                <div class="location">
                    <label for="location">지역 선택</label>
                    <select
                            name="location"
                            id="location"
                            onchange="categoryChange(this)"
                    >
                        <option value selected>시/도 선택</option>
                    </select>
                    <b>/</b>
                    <select name="state" id="state">
                        <option selected>군/구 선택</option>
                    </select>
                    <input
                            id="submitFormBtn"
                            type="submit"
                            value="모임/액티비티 검색"
                    />
                </div>
            </div>
        </form>
    </div>
</section>

<section id="main">
    <div class="main-flex-container ">
        <div class="list-container">
            <section id="clubIntro">
                <h1>모임(광고)</h1>
                <div class="slide">
                    <div class="left-button" onclick="showLeftItem()"><p>
                        <div class="arrow-left" id="leftArrow"></div>
                    </div>
                    <div class="promotion-club-container">
                        <%  int clubNum = 3;
                            String clubName = "KIM";
                            String clubLocation = "SEOUL";%>
                        <div class="promotion-club-item">
                            <form action="/joinclub" method="post">
                                <img src="${pageContext.request.contextPath}/img/test-emblem-logo.png" alt="no-emblem-img"/>
                                <p>모임명 : </p>
                                <p>인원</p>
                                <p>지역</p>
                                <input type="hidden" name="clubNum" value="<%=clubNum%>">
                                <input type="hidden" name="clubName" value="<%=clubName%>">
                                <input type="hidden" name="clubLocation" value="<%=clubLocation%>">
                                <input id="joinClubBtn2" type="submit" value="가입하기"/>
                            </form>
                        </div>
                    </div>
                    <div class="right-button" onclick="showRightItem">
                        <div class="arrow-right" id="rightArrow"></div>
                    </div>
                </div>
            </section>
            <section id="recommendClub">
                <h1>추천 모임</h1>
                <div class="recommend-club-container" id="recommendClubContainer">
                    <%for (int i = 0; i < clubVOS.size(); i++) {%>
                        <div class="recommend-club-item">
                            <form action="/joinclub" method="post">
                                <img src=<%=clubVOS.get(i).getClubEmblemPath()%> alt="no-emblem-img"/>
                                <p>모임명 : <%=clubVOS.get(i).getClubName()%>
                                </p>
                                <p>인원 : <%=clubVOS.get(i).getClubMaxCount()%>
                                </p>
                                <p>지역 : <%=clubVOS.get(i).getClubLocation()%>
                                </p>
                                <input type="hidden" value=<%=clubVOS.get(i).getClubName()%>>
                                <input class="join-club-button" type="submit" value="가입하기" />
                            </form>
                        </div>
                    <%}%>
                </div>
            </section>
            <section id="recommendActivity">
                <h1>추천 액티비티</h1>
                <div class="recommend-activity-container" id="recommendActivivityContainer">
                    <%for (int i = 0; i < activityVOS.size(); i++) {%>
                    <div class="recommend-activity-item">
                        <form action="#" method="post">
                            <p>액티비티명 : <%=activityVOS.get(i).getActivityTitle()%>
                            </p>
                            <p>인원 : ? / 4 명</p>
                            <p>소개 : <%=activityVOS.get(i).getActivityDescription()%>
                            </p>
                            <input class="join-activity-button" type="submit" value="가입하기"/>
                        </form>
                    </div>
                    <%}%>
                </div>
            </section>
        </div>
        <section id="createClub">
        <div class="container">
            <div class="title">Club 생성</div>
            <form action="/club" method="post">
                <div class="user-details">
                    <div class="input-box">
                        <span class="details">Club Name</span>
                        <input type="text" placeholder="Enter Club name" name="clubName" maxlength="11" required>
                    </div>
                    <div class="input-box">
                        <span class="details">Max Count</span>
                        <input type="number" pattern="\d*" placeholder="(Max : 999)" oninput="memberMaxLength(this)"
                               name="maxCount" min="1" maxlength="3" required>
                    </div>

                    <div class="gender-details">
                        <input type="radio" name="sex" id="dot-1" value="0">
                        <input type="radio" name="sex" id="dot-2" value="1">
                        <input type="radio" name="sex" id="dot-3" value="2">
                        <span class="gender-title">Gender</span>
                        <div class="category">
                            <label for="dot-1">
                                <span class="dot one"></span>
                                <span class="gender">Male</span>
                            </label>
                            <label for="dot-2">
                                <span class="dot two"></span>
                                <span class="gender">Female</span>
                            </label>
                            <label for="dot-3">
                                <span class="dot three"></span>
                                <span class="gender">All</span>
                            </label>
                        </div>
                    </div>
                    <div class="input-box">
                        <span class="details">Club Emblem</span>
                        <input type="file" name="emblemPath">
                    </div>
                    <div class="input-box">
                        <span class="details">Club Password</span>
                        <input type="password" placeholder="Enter Password" name="pw" maxlength="11">
                    </div>
                    <div class="etc">
                        <span class="details">Club Tier</span>
                        <select name="tier" id="tierAge">
                            <option value="0" selected>타수 선택</option>
                        </select>
                    </div>
                    <div class="etc">
                        <span class="details">Club Age</span>
                        <select name="age" id="ageLow">
                            <option value="0" selected>연령 선택</option>
                        </select>
                    </div>

                    <div class="etc">
                        <label class="details">Club Location</label>
                        <select name="location" id="clubLocation">
                            <option value="0" selected>시/도 선택</option>
                        </select>
                    </div>
                    <div class="input-box">
                        <span class="details">Club Description</span>
                        <textarea name="description" cols="30" rows="10 " placeholder="Club Description"></textarea>
                    </div>
                    <div class="button">
                        <input type="submit" value="Register">
                    </div>
                </div>
            </form>
        </div>

        </form>
    </section>
    </div>
</section>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"
        integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA=="
        crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="js/main.js"></script>
<script src="js/juso.js"></script>
<script src="js/createclub.js"></script>
<script src="./js/arrow.js" charset="UTF-8"></script>
<script src="./js/recommend.js" charset="UTF-8"></script>
<script
        type="module"
        src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"
></script>
<script
        nomodule
        src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"
></script>
</body>
</html>
