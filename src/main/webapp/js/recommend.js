// join club button click
const submitJoinRecommendClubBtn = document.querySelectorAll("#joinRecommendClubBtn");
const submitJoinClubBtn = document.querySelectorAll("#joinClubBtn");
const submitJoinActivityBtn = document.querySelectorAll("#joinActivityBtn");

for(let i = 0; i < submitJoinRecommendClubBtn.length; i++){
    submitJoinRecommendClubBtn[i].addEventListener("click", (e) => {
        e.preventDefault();
        alert("로그인 해주세요.");
    });
}

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