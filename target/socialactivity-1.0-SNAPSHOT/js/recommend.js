// show list
// const recommendClubContainer = document.getElementById("recommendClubContainer");
// const recommendActivityContainer = document.getElementById("recommendActivityContainer");

// for (let i = 0; i < recommendClubList.length; i++){
//     let form = `<form action="#" method="post"></form>`;
//     let clubImg = `<img src="${pageContext.request.contextPath}/img/${recommendClubList[i].getClubEmblemName}" alt="no-emblem-img" />`
//     let clubNameP = `<p>${recommendClubList[i].getClubName()}</p>`;
//     let clubCountP = `<p>${recommendClubList[i].getClubMemberCount()}</p>`;
//     let clubLocationP = `<p>${recommendClubList[i].getClubLocation()}</p>`;
//     let ipt = `<input id ="joinClubBtn" type="submit" value="가입하기"/>`
//     form.appendChild(clubImg);
//     form.appendChild(clubNameP);
//     form.appendChild(clubCountP);
//     form.appendChild(clubLocationP);
//     form.appendChild(ipt);
//     recommendClubContainer.appendChild(form);
// }

// for (let i = 0; i < recommendActivityList.length; i++){
//     let form = `<form action="#" method="post"></form>`;
//     let activityImg = `<img src="${pageContext.request.contextPath}/img/${recommendClubList[i].getActivityEmblemName}" alt="no-emblem-img" />`
//     let activityNameP = `<p>${recommendClubList[i].getActivityName()}</p>`;
//     let activityCountP = `<p>${recommendClubList[i].getActivityMemberCount()}</p>`;
//     let activityLocationP = `<p>${recommendClubList[i].getActivityLocation()}</p>`;
//     let ipt = `<input id ="joinActivityBtn" type="submit" value="가입하기"/>`
//     form.appendChild(activityImg);
//     form.appendChild(activityNameP);
//     form.appendChild(activityCountP);
//     form.appendChild(activityLocationP);
//     form.appendChild(ipt);
//     recommendActivityContainer.appendChild(form);
// }
// join club button click
const submitJoinClubBtn = document.querySelectorAll("#joinClubBtn");
const submitJoinActivityBtn = document.querySelectorAll("#joinActivityBtn");

for(let i = 0; i < submitJoinClubBtn.length; i++){
    submitJoinClubBtn[i].addEventListener("click", (e) => {
        e.preventDefault();
        alert("로그인 해주세요.");
    });
}

for(let j = 0; j < submitJoinActivityBtn.length; j++){
    submitJoinActivityBtn[j].addEventListener("click", (e) => {
        e.preventDefault();
        alert("로그인 해주세요.");
    });
}