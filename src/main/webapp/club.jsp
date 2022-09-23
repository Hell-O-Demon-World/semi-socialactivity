<%--
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
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/main.css" type="text/css" />
    <link rel="stylesheet" href="css/createclub.css" type="text/css" />
    <title>클럽 생성</title>
</head>
<body>
<section id="navBar">
    <nav id="mainNav">
        <a href="#" class="logo">Logo</a>
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
    <section id="clubIntro">
        <h1>클럽 소개</h1>
    </section>
    <section id="createClub">
        <div class="container">
            <div class="title">Club 생성</div>
            <form action="club" method="post">
                <div class="user-details">
                    <div class="input-box">
                        <span class="details">Club Name</span>
                        <input type="text" placeholder="Enter Club name" name ="clubName" maxlength="11" required>
                    </div>
                    <div class="input-box">
                        <span class="details">Max Count</span>
                        <input type="number" pattern="\d*" placeholder="(Max : 999)"  oninput="memberMaxLength(this)" name = "maxCount" min="1" maxlength="3" required>
                    </div>

                    <div class="gender-details">
                        <input type="radio" name="sex" id = "dot-1" value="0">
                        <input type="radio" name="sex" id = "dot-2" value="1">
                        <input type="radio" name="sex" id = "dot-3" value="2">
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
                        <input type="file" name = "emblemPath">
                    </div>
                    <div class="input-box">
                        <span class="details">Club Password</span>
                        <input type="password" placeholder="Enter Password" name = "pw" maxlength="11">
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
                <span class="details" >Club Location</label>
                    <select name="location" id="clubLocation">
                  <option value = "0" selected>시/도 선택</option>
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
</section>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js" integrity="sha512-aVKKRRi/Q/YV+4mjoKBsE4x3H+BkegoM/em46NNlCqNTmUYADjBbeNefNxYV7giUp0VxICtqdrbqU7iVaeZNXA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src="js/juso.js"></script>
<script src="js/main.js"></script>
<script src="js/createclub.js"></script>
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
