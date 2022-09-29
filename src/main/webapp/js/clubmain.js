const swiperPrev = document.querySelector("#activity .swiper-button-prev");
const swiperNext = document.querySelector("#activity .swiper-button-next");
const slideCount = document.querySelectorAll("#activity .swiper-slide").length;
const pageCount = // 슬라이드 페이지 개수
    slideCount % 4
        ? slideCount - (slideCount % 4)
        : slideCount - (slideCount % 4) - 4;

const swiper = new Swiper(".mySwiper", {
  slidesPerView: 4, // 한 번에 보여질 element의 개수
  spaceBetween: 30, // 슬라이드 간격(px)
  slidesPerGroup: 4,
  allowTouchMove: false,
  loop: true,
  loopFillGroupWithBlank: true, // 빈칸인 경우 빈칸으로 메우기
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
  lazy: {
    loadPrevNext: true, // 이전, 다음 이미지는 미리 로딩
  },
  on: {
    activeIndexChange: function () {
      if (this.realIndex === 0) {
        this.allowSlidePrev = false;
        swiperPrev.classList.add("swiper-button-disabled");
      } else {
        this.allowSlidePrev = true;
        swiperPrev.classList.remove("swiper-button-disabled");
      }
      if (this.realIndex === pageCount) {
        this.allowSlideNext = false;
        swiperNext.classList.add("swiper-button-disabled");
      } else {
        this.allowSlideNext = true;
        swiperNext.classList.remove("swiper-button-disabled");
      }
    },
  },
});

const swiperAlbum = new Swiper(".album-container", {
  slidesPerView: 4, // 한 번에 보여질 element의 개수
  spaceBetween: 30, // 슬라이드 간격(px)
  slidesPerGroup: 4,
  allowTouchMove: false,
  height: 400,
  loop: true,
  loopFillGroupWithBlank: true, // 빈칸인 경우 빈칸으로 메우기
  pagination: {
    el: ".swiper-pagination",
    clickable: true,
  },
  navigation: {
    nextEl: ".swiper-button-next",
    prevEl: ".swiper-button-prev",
  },
  lazy: {
    loadPrevNext: true, // 이전, 다음 이미지는 미리 로딩
  },
});

/* 게시판 swiper */
const boardSwiper = new Swiper(".board-container", {
  direction: "vertical",
  slidesPerView: 3,
  freeMode: true,
  scrollbar: {
    el: ".swiper-scrollbar",
  },
  mousewheel: true,
});
/* comment swiper */
const commentSwiper = new Swiper(".comment-container", {
  direction: "vertical",
  height: 350,
  slidesPerView: 4,
  freeMode: true,
  scrollbar: {
    el: ".swiper-scrollbar",
  },
  mousewheel: true,
});
/* 게시판 글추가  */
const createBoardBtn = document.querySelector(".add-board");
const createBoard = document.getElementById("createBoard");
const newBoardForm = (e) => {
  createBoard.style.display = "flex";
  createBoard.style.zIndex = "100";
};
/* 글 추가 form display none */
const removeFormBtn = document.querySelector(".close-btn");
const removeForm = () => {
  createBoard.style.display = "none";
  createBoard.style.zIndex = "-1";
};
removeFormBtn.addEventListener("click", removeForm);

createBoardBtn.addEventListener("click", newBoardForm);
/* image 추가 */
const addImageBtn = document.querySelector(".add-image");
const addImage = document.getElementById("addImage");
const newImageForm = (e) => {
  addImage.style.display = "flex";
  addImage.style.zIndex = "1000";
};
const removeImageFormBtn = document.querySelector(".close-image");
const removeImageForm = () => {
  addImage.style.display = "none";
  addImage.style.zIndex = "-1";
};
removeImageFormBtn.addEventListener("click", removeImageForm);

addImageBtn.addEventListener("click", newImageForm);
/* 액티비티 추가 */
const addActivityBtn = document.querySelector(".create-activity");
const addActivity = document.getElementById("createActivity");
const newActivityForm = (e) => {
  addActivity.style.display = "flex";
  addActivity.style.zIndex = "100";
};
const removeActivityFormBtn = document.querySelector(".close-activity");
const removeActivityForm = () => {
  addImage.style.display = "none";
  addImage.style.zIndex = "-1";
};
removeActivityFormBtn.addEventListener("click", removeActivityForm);

addActivityBtn.addEventListener("click", newActivityForm);
/* 게시판 crud */
const updateBoard = document.querySelectorAll(".button-update");
const deleteBoard = document.querySelectorAll(".button-delete");
const detailsBoard = document.getElementsByClassName("button-details");

/** 게시판 자세히 보기
 *
 * @param {Event} e 이벤트 객체 전달
 */
const showDetail = (e) => {
  const detail = e.target.parentNode.parentNode;
  const title = detail.querySelector(".board-title .text").innerText;
  const creator = detail.querySelector(".board-creator .text").innerText;
  const content = detail.querySelector(".board-content p").innerText;
  const detailsTitle = document.querySelector(".details-title .text");
  detailsTitle.innerText = title;
  const detailsWriter = document.querySelector(".details-writer .text");
  detailsWriter.innerText = creator;
  const detailsContent = document.querySelector(".board-content-details");
  detailsContent.innerText = content;
};
for (const $button of detailsBoard) {
  $button.addEventListener("click", showDetail);
}

const boardButton = document.getElementById("submitBoard");
boardButton.addEventListener("click", removeForm);
/** comment 추가
 *
 * @param {Event} e 이벤트 객체 추가
 */

/* textarea 글자 수 제한 */
const createBoardText = document.querySelector("#createBoard textarea");
const BoardText = document.querySelector("#board textarea");
const createActivity = document.getElementById("createActivity");
const imageName = document.querySelector("#addImage input[type=text]");
/** 글자수 체크
 *
 * @param {Event}
 * */
const countText = (e) => {
  const textLength = e.target.value.length;
  if (textLength > 100) {
    alert("최대 100자까지 입력 가능합니다.");
    e.target.value = e.target.value.substring(0, 100);
  }
};

createBoardText.addEventListener("keyup", countText);
BoardText.addEventListener("keyup", countText);
createActivity.addEventListener("keyup", countText);
imageName.addEventListener("keyup", countText);
/* Comment 글자수 자르기 */

const comments = document.getElementsByClassName("board-description");
console.log(comments);
Array.prototype.forEach.call(comments, (elem) => {
  elem.innerText = `${elem.innerText.substring(0, 50)} ...`;
});

/* comment 자세히 보기 */
const commentDetailList = document.getElementsByClassName("comment-details");
const showCommentDetails = (e) => {
  console.log(
      e.target.parentNode.parentNode.parentNode.querySelector(".display-none")
          .innerText
  );
};
Array.prototype.forEach.call(commentDetailList, (elem) => {
  elem.addEventListener("click", showCommentDetails);
});
showCommentDetails;