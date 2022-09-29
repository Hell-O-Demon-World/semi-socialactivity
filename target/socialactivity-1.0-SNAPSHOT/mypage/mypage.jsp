<%@ page import="com.golfzone.social.user.UserVO" %>
<%@ page import="com.golfzone.social.user.UserDAO" %>
<%@ page import="com.golfzone.social.user.UserDAOImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="com.golfzone.social.club.ClubVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.golfzone.social.club.ClubDAO" %>
<%@ page import="com.golfzone.social.club.ClubDAOImpl" %>
<%@ page import="com.golfzone.social.clubmember.ClubMemberDAO" %>
<%@ page import="com.golfzone.social.clubmember.ClubMemberDAOImpl" %>
<%@ page import="com.golfzone.social.clubmember.ClubMemberVO" %>
<%@ page import="com.golfzone.social.activitymember.ActivityMemberDAO" %>
<%@ page import="com.golfzone.social.activitymember.ActivityMemberDAOImpl" %>
<%@ page import="com.golfzone.social.activity.ActivityVO" %>
<%@ page import="com.golfzone.social.activitymember.ActivityMemberVO" %>
<%@ page import="com.golfzone.social.activity.ActivityDAO" %>
<%@ page import="com.golfzone.social.activity.ActivityDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: org
  Date: 2022/09/28
  Time: 1:49 PM
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
    <link rel="stylesheet" href="../css/mypage.css"/>
    <link
            rel="stylesheet"
            href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"
    />

    <title>My Page</title>
</head>
<body>
<%
    UserVO userVO = new UserVO();
    UserDAO userDAO = new UserDAOImpl();
    if (request.getAttribute("userNum") != null) {
        Integer userNum = (Integer) request.getAttribute("userNum");
        userVO = userDAO.findByUserNum(userNum);
    }
    /* get club list */
    ClubMemberDAO clubMemberDAO = new ClubMemberDAOImpl();
    List<ClubMemberVO> clubMemberVOS = clubMemberDAO.selectAllByUserNum(userVO.getUserNum());

    ClubDAO clubDAO = new ClubDAOImpl();
    List<ClubVO> clubVOS = new ArrayList<>();
    for (int i = 0; i < clubMemberVOS.size(); i++) {
        ClubVO clubVO = new ClubVO();
        clubVO.setClubNum(clubMemberVOS.get(i).getClubNum());
        clubVOS.add(clubDAO.findByClubNum(clubVO));
    }
    /* get activity list */
    ActivityMemberDAO activityMemberDAO = new ActivityMemberDAOImpl();
    List<ActivityMemberVO> activityMemberVOS = activityMemberDAO.selectAllByUserNum(userVO);

    ActivityDAO activityDAO = new ActivityDAOImpl();
    List<ActivityVO> activityVOS = new ArrayList<>();
    for (int i = 0; i < activityMemberVOS.size(); i++) {
        ActivityVO activityVO = new ActivityVO();
        activityVO.setActivityNum(activityMemberVOS.get(i).getActivityNum());
        activityVOS.add(activityDAO.findByActivityNum(activityVO));
    }
    ActivityMemberVO activityMemberVO = new ActivityMemberVO();
    activityMemberVO.setActivityMemberNum(activityMemberDAO.findByUser(userVO).getActivityMemberNum());
%>
<section id="navBar">
    <nav id="mainNav">
        <form id="myPage" method="post" action="/mypage">
            <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
        </form>
        <a onclick="document.getElementById('myPage').submit();" class="logo">Logo</a>
        <ul>
            <form id="mainPage" method="post" action="/club">
                <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
            </form>
            <li><a onclick="document.getElementById('mainPage').submit();" class="linkText">Main</a></li>
            <li><a href="/">Logout</a></li>
        </ul>
    </nav>
</section>
<div id="left">
    <section id="myClub">
        <h1>My CLub</h1>
        <div class="swiper club-container">
            <div class="swiper-wrapper">
                <%for (int i = 0; i < clubVOS.size(); i++) {%>
                <div class="swiper-slide">
                    <div>club</div>
                    <div class="name"><%=clubVOS.get(i).getClubName()%>
                    </div>
                    <div>Description</div>
                    <div class="description"><%=clubVOS.get(i).getClubDescription()%>
                    </div>
                    <form id="linkToClubPage<%=i%>" method="post" action="/clubinfo">
                        <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
                        <input type="hidden" value="<%=clubVOS.get(i).getClubNum()%>" name="clubNum">
                    </form>
                    <div class="btn"><a onclick="document.getElementById('linkToClubPage<%=i%>').submit();"
                                        class="linkText">바로가기</a></div>
                </div>
                <%}%>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>
    </section>
    <section id="myActivity">
        <h1>My Activity</h1>
        <div class="swiper activity-container">
            <div class="swiper-wrapper">
                <%for (int i = 0; i < activityVOS.size(); i++) {%>
                <div class="swiper-slide">
                    <div>Name</div>
                    <div class="name"><%=activityVOS.get(i).getActivityTitle()%>
                    </div>
                    <div>Description</div>
                    <div class="description"><%=activityVOS.get(i).getActivityDescription()%>
                    </div>
                    <form id="linkToDeleteActivity<%=i%>" method="post" action="/quitactivity">
                        <input type="hidden" value="<%=activityMemberVO.getActivityMemberNum()%>"
                               name="activityMemberNum">
                        <input type="hidden" value="<%=activityVOS.get(i).getActivityNum()%>" name="activityNum">
                        <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
                        <input type="hidden" value="<%=clubVOS.get(i).getClubNum()%>" name="clubNum">
                    </form>
                    <div class="btn"><a onclick="document.getElementById('linkToDeleteActivity<%=i%>').submit();"
                                        class="linkText">액티비티 나가기</a></div>
                </div>
                <%}%>
            </div>
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>
    </section>
</div>
<div id="right">
    <section id="myInfo">
        <h1>My Info</h1>
        <div class="info-container">
            <div class="info-box">
                <div class="label">Name</div>
                <div><%=userVO.getUserName()%>
                </div>
            </div>
            <div class="info-box">
                <div class="label">ID</div>
                <div><%=userVO.getUserId()%>
                </div>
            </div>
            <div class="info-box">
                <div class="label">Location</div>
                <div><%=userVO.getUserLocation()%>
                </div>
            </div>
            <div class="info-box">
                <div class="label">Age</div>
                <div><%=userVO.getUserAge()%>
                </div>
            </div>
            <div class="info-box">
                <div class="label">Gender</div>
                <%
                    String gender = "?";
                    if (userVO.isUserSex() == true) {
                        gender = "남자";
                    } else {
                        gender = "여자";
                    }
                %>
                <div><%=gender%>
                </div>
            </div>
            <div class="info-box">
                <div class="label">Tier</div>
                <div><%=userVO.getUserTier()%>
                </div>
            </div>
        </div>
        <input id="exitUser" type="submit" value="탈퇴"/>
    </section>
</div>
<script src="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.js"></script>
<script src="js/mypage.js"></script>
</body>
</html>

