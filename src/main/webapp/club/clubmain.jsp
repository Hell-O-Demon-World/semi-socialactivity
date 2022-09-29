<%@ page import="com.golfzone.social.user.UserVO" %>
<%@ page import="com.golfzone.social.user.UserDAO" %>
<%@ page import="com.golfzone.social.user.UserDAOImpl" %>
<%@ page import="com.golfzone.social.clubmember.ClubMemberDAO" %>
<%@ page import="com.golfzone.social.clubmember.ClubMemberDAOImpl" %>
<%@ page import="com.golfzone.social.clubmember.ClubMemberVO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.golfzone.social.activitymember.ActivityMemberDAO" %>
<%@ page import="com.golfzone.social.activitymember.ActivityMemberDAOImpl" %>
<%@ page import="com.golfzone.social.activitymember.ActivityMemberVO" %>
<%@ page import="com.golfzone.social.activity.ActivityDAO" %>
<%@ page import="com.golfzone.social.activity.ActivityDAOImpl" %>
<%@ page import="com.golfzone.social.activity.ActivityVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.golfzone.social.club.ClubVO" %>
<%@ page import="com.golfzone.social.club.ClubDAO" %>
<%@ page import="com.golfzone.social.club.ClubDAOImpl" %><%--
  Created by IntelliJ IDEA.
  User: org
  Date: 2022/09/28
  Time: 1:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <link rel="stylesheet" href="../css/main.css" />
  <link rel="stylesheet" href="../css/clubmain.css" />
  <link
          rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/swiper/swiper-bundle.min.css"
  />
  <link rel="stylesheet" href="../css/navigation.css" />
  <title>클럽 메인페이지</title>
</head>
<body>
<%
  UserVO userVO = new UserVO();
  UserDAO userDAO = new UserDAOImpl();
  if (request.getAttribute("userNum") != null) {
    Integer userNum = (Integer) request.getAttribute("userNum");
    userVO = userDAO.findByUserNum(userNum);
  }
  ClubVO clubVO = new ClubVO();
  ClubDAO clubDAO = new ClubDAOImpl();
  if (request.getAttribute("clubNum") != null) {
    Integer clubNum = (Integer) request.getAttribute("clubNum");
    clubVO.setClubNum(clubNum);
    clubVO = clubDAO.findByClubNum(clubVO);
  }
  /* get activity list */
  ActivityDAO activityDAO = new ActivityDAOImpl();
  List<ActivityVO> activityVOS = activityDAO.selectAllByClubNum(clubVO);
%>
<div class="navigation">
  <div class="toggle">
    <ul>
      <li>
        <a href="#board"><div class="add-board">ADD BOARD</div></a>
      </li>
      <li>
        <a href="#activity"
        ><div class="create-activity">CREATE ACTIVITY</div></a
        >
      </li>
      <li><div class="add-image">ADD IMG</div></li>
    </ul>
  </div>
</div>
<section id="navBar">
  <nav id="mainNav">
    <form id="clubInfoPage" method="post" action="/clubinfo">
      <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
      <input type="hidden" value="<%=clubVO.getClubNum()%>" name="clubNum">
    </form>
    <a onclick="document.getElementById('clubInfoPage').submit();" class="logo">Logo</a>
    <ul>
      <form id="mainPage" method="post" action="/club">
        <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
      </form>
      <form id="myPage" method="post" action="/mypage">
        <input type="hidden" value="<%=userVO.getUserNum()%>" name="userNum">
      </form>
      <li><a onclick="document.getElementById('mainPage').submit();" class="linkText">Home</a></li>
      <li><a href="#activity">Activity List</a></li>
      <li><a href="#board">Board</a></li>
      <li><a href="#album">Album</a></li>
      <li><a onclick="document.getElementById('myPage').submit();" class="linkText">MyPage</a></li>
      <li><a href="/">Logout</a></li>
    </ul>
  </nav>
</section>
<section id="activity">
  <h1>Activity List</h1>
  <div class="swiper mySwiper">
    <div class="swiper-wrapper">
      <!-- activity slide start -->
      <%for (int i = 0; i < activityVOS.size(); i++) {%>
      <div class="swiper-slide">
        <div class="activity-name"><%=activityVOS.get(i).getActivityTitle()%></div>
        <div class="activity-description">
          <%=activityVOS.get(i).getActivityDescription()%>
        </div>
      </div>
      <%}%>
      <!-- activity slide end -->
    </div>
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
    <div class="swiper-pagination"></div>
  </div>
</section>
<section id="board">
  <div class="header">
    <h1>board section</h1>
  </div>
  <div id="left">
    <div class="swiper board-container">
      <div class="swiper-wrapper">
        <div class="swiper-slide">
          <div class="board-info">
            <div class="board-number">
              <div>게시글 번호</div>
              <div class="text">번호</div>
            </div>
            <div class="board-creator">
              <div>게시글 작성자</div>
              <div class="text">작성자명</div>
            </div>
          </div>
          <div class="board-content">
            <div class="board-title">
              <div>게시글 제목</div>
              <div class="text">NO.1 JSP, Servlet</div>
            </div>
            <p class="board-description">
              Lorem ipsum dolor sit amet, consectetur adipisicing elit.
              Amet, quis ad. Ea corporis accusamus possimus aperiam sapiente
              id, ipsam dolorem non voluptates quidem eaque accusantium
              facilis odit quibusdam, soluta sequi repellendus similique
            </p>
          </div>
          <div class="button-container">
            <div class="button-delete">
              <input type="submit" value="삭제" name="deleteBoard" />
            </div>
            <div class="button-details">자세히</div>
          </div>
          <div class="line"></div>
        </div>
      </div>
      <div class="swiper-scrollbar"></div>
    </div>
    <div id="board-details">
      <div id="info">
        <h1>board details</h1>
        <div class="details-info">
          <div class="details-title">
            <div>제목</div>
            <div class="text"></div>
          </div>
          <div class="details-writer">
            <div>작성자</div>
            <div class="text"></div>
          </div>
        </div>
        <div class="line"></div>
        <div class="details-content">
          <div class="text">내용</div>
          <div class="board-content-details"></div>
        </div>
      </div>
      <div id="comment">
        <h1>comment</h1>
        <div class="commentInput">
          <form action="" method="">
                <textarea
                        name="activity-description"
                        cols="30"
                        rows="10"
                        placeholder="write comment"
                ></textarea>
            <input type="submit" value="comment" id="submitComment" />
          </form>
        </div>
        <div id="commentHeader">
          <div>writer</div>
          <div>content</div>
          <div>delete</div>
        </div>
        <div class="swiper comment-container">
          <div class="swiper-wrapper">
            <div class="swiper-slide">
              <div class="comment-writer">작성자</div>
              <div class="comment-content">
                Lorem ipsum dolor sit amet consectetur adipisicing elit.
                Explicabo illo cupiditate consequatur quisquam quaerat
                quibusdam omnis eveniet voluptas reprehenderit consequuntur.
              </div>
              <div class="comment-delete">X</div>
            </div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
            <div class="swiper-slide">slide1</div>
          </div>
          <div class="swiper-scrollbar"></div>
        </div>
      </div>
    </div>
  </div>
</section>
<section id="createBoard">
  <h1>Create Board</h1>
  <div id="boardForm">
    <div class="close-btn"><i class="fa-solid fa-xmark"></i></div>
    <form action="" method="">
      <div>
        <div class="title">
          <label for="boardTitle">Title</label>
          <input type="text" id="boardTitle" name="title" />
        </div>
        <div class="creator">
          <div>creator</div>
          <div class="creator-name">작성자 이름</div>
        </div>
      </div>
      <div class="content">
        <label for="boardContent">내용 작성</label>
        <textarea
                name="content"
                id="boardContent"
                cols="30"
                rows="10"
        ></textarea>
      </div>
      <input type="submit" value="board" id="submitBoard" />
    </form>
  </div>
</section>
<section id="album">
  <h1>Album</h1>
  <div class="swiper album-container">
    <div class="swiper-wrapper">
      <!-- activity slide start -->
      <div class="swiper-slide">
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <div>image name</div>
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <div>image name</div>
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <div>image name</div>
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <div>image name</div>
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <div class="swiper-slide">
        <img src="../img/golfzon-logo.jpeg" alt="" />
      </div>
      <!-- activity slide end -->
    </div>
    <div class="swiper-button-next"></div>
    <div class="swiper-button-prev"></div>
    <div class="swiper-pagination"></div>
  </div>
</section>
<section id="createActivity">
  <div class="container">
    <div class="close-activity">X</div>
    <form action="" method="">
      <div>
        <label for="activityName">Activity Name</label>
        <input type="text" id="activityName" name="name" />
      </div>
      <div>
        <label for="activityDescription">Activity Description</label>
        <textarea
                name="description"
                id="activityDescription"
                cols="30"
                rows="10"
        ></textarea>
      </div>
      <input type="submit" value="Create activity" />
    </form>
  </div>
</section>
<section id="addImage">
  <div class="container">
    <form action="" method="">
      <div class="input-box">
        <span class="details">Image Name</span>
        <input type="text" name="emblemPath" />
      </div>
      <div class="input-box">
        <span class="details">Club Image</span>
        <input type="file" name="emblemPath" />
      </div>
      <input type="submit" name="image" value="Submit Image" />
    </form>
  </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/swiper@8/swiper-bundle.min.js"></script>
<script
        src="https://kit.fontawesome.com/1202a2b8dd.js"
        crossorigin="anonymous"
></script>

<script src="../js/clubmain.js"></script>
<script src="../js/navigation.js"></script>
</body>
</html>

