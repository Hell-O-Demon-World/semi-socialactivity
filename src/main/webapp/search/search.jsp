<%@ page import="com.golfzone.social.user.UserVO" %>
<%@ page import="com.golfzone.social.user.UserDAO" %>
<%@ page import="com.golfzone.social.user.UserDAOImpl" %>
<%@ page import="com.golfzone.social.club.ClubVO" %>
<%@ page import="com.golfzone.social.search.SearchClubVO" %>
<%@ page import="com.golfzone.social.search.SearchClubDAO" %>
<%@ page import="com.golfzone.social.search.SearchClubDAOImpl" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: org
  Date: 2022/10/03Ò
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="../css/main.css"/>
    <link rel="stylesheet" href="../css/clubmain.css"/>
    <link rel ="stylesheet" href="../css/search.css"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"
    />
    <link rel="stylesheet" href="../css/navigation.css"/>
    <title>검색페이지</title>
</head>
<body>
<%
    UserVO userVO = new UserVO();
    UserDAO userDAO = new UserDAOImpl();
    if (request.getAttribute("userNum") != null) {
        Integer userNum = (Integer) request.getAttribute("userNum");
        userVO = userDAO.findByUserNum(userNum);
    }
    SearchClubVO searchClubVO = new SearchClubVO();
    SearchClubDAO searchClubDAO = new SearchClubDAOImpl();

    searchClubVO.setSearchLocation(request.getAttribute("searchLocation").toString());
    searchClubVO.setSearchTitle(request.getAttribute("searchTitle").toString());
    searchClubVO.setSearchMinAge(request.getAttribute("searchMinAge").toString());
    searchClubVO.setSearchMaxAge(request.getAttribute("searchMaxAge").toString());
    searchClubVO.setSearchMinScore(request.getAttribute("searchMinScore").toString());
    searchClubVO.setSearchMaxScore(request.getAttribute("searchMaxScore").toString());

    List<ClubVO> clubVOS = searchClubDAO.searchByCondition(searchClubVO);
    System.out.println("userNum: "+userVO.getUserNum());

%>
<section id="navBar">
    <nav id="mainNav">
        <form id="clubInfoPage" method="post" action="/searchclub">
            <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
            <input type="hidden" value="<%=searchClubVO.getSearchLocation()%>" name="location">
            <input type="hidden" value="<%=searchClubVO.getSearchTitle()%>" name="clubName">
            <input type="hidden" value="<%=searchClubVO.getSearchMinAge()%>" name="ageLow">
            <input type="hidden" value="<%=searchClubVO.getSearchMaxAge()%>" name="ageHigh">
            <input type="hidden" value="<%=searchClubVO.getSearchMinScore()%>" name="tierLow">
            <input type="hidden" value="<%=searchClubVO.getSearchMaxScore()%>" name="tierHigh">
        </form>
        <a onclick="document.getElementById('clubInfoPage').submit();" class="logo">Logo</a>
        <ul>
            <%if (userVO.getUserNum() != 0){%>
            <form id="mainPage" method="post" action="/club">
                <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
            </form>
            <form id="myPage" method="post" action="/mypage">
                <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
            </form>
            <%}else {%>
            <form id="mainPage" method="post" action="/main">
            </form>
            <%}%>
            <li><a onclick="document.getElementById('mainPage').submit();" class="linkText">Home</a></li>
            <%if (userVO.getUserNum() != 0){%>
            <li><a onclick="document.getElementById('myPage').submit();" class="linkText">MyPage</a></li>
            <li><a href="/">Logout</a></li>
            <%}%>
        </ul>
    </nav>
</section>
<section class="result-list">
    <h1>Search Result List</h1>
    <div class="swiper mySwiper">
        <div class="swiper-wrapper">
            <%for (int i = 0; i < clubVOS.size(); i++) { %>
            <div class="swiper-slide">
                <div class="activity-name">
                    <p><%=clubVOS.get(i).getClubName()%></p>
                </div>
                <div class="activity-description">
                    <p><%=clubVOS.get(i).getClubDescription()%></p>
                </div>
                <%if (userVO.getUserNum() != 0) {%>
                    <div class="link">
                        <form action="/joinclub" method="post">
                            <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum"/>
                            <input type="hidden" value="<%=i+1%>" name="clubNum"/>
                            <input type="submit" value="가입하기"/>
                        </form>
                    </div>
                <%}%>
            </div>
            <% }
            %>
        </div>
        <div class="swiper-button-next"></div>
        <div class="swiper-button-prev"></div>
        <div class="swiper-pagination"></div>
    </div>
</section>

<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script
        src="https://kit.fontawesome.com/1202a2b8dd.js"
        crossorigin="anonymous"
></script>

<script src = "../js/search.js"></script>
</body>
</html>
