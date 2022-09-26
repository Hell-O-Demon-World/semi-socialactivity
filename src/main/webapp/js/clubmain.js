const swiperPrev = document.querySelector(".swiper-button-prev");
const swiperNext = document.querySelector(".swiper-button-next");
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
  height: 550,
  slidesPerView: 10,
  freeMode: true,
  scrollbar: {
    el: ".swiper-scrollbar",
  },
  mousewheel: true,
});

/* 게시판 crud */
const updateBoard = document.querySelectorAll(".button-update");
const deleteBoard = document.querySelectorAll(".button-delete");
const detailsBoard = document.getElementsByClassName("button-details");

/** 게시판 자세히 보기
 *
 * @param {Event} e 이벤트 객체 전달
 */
const showDetail = (e) => {
  console.log(1);
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

const commentButton = document.getElementById("submitComment");
/** comment 추가
 *
 * @param {Event} e 이벤트 객체 추가
 */
const addComment = (e) => {
  e.preventDefault();
  const comment = e.target.parentNode;
  const commentDetails = comment.querySelector('input[type="text"]').value;
  const commentList = document.querySelector(
    ".comment-container .swiper-wrapper"
  );
  if (commentList.innerHTML.innerText === "댓글이 없습니다.") {
    commentList.innerHTML = "";
  }
  const div = document.createElement("div");
  div.className = "swiper-slide";
  div.innerHTML = `<div class="content"> ${commentDetails}</div>`;
  commentList.insertBefore(div, null);
  commentSwiper.update();
};
commentButton.addEventListener("click", addComment);

const boardButton = document.getElementById("submitBoard");
/** comment 추가
 *
 * @param {Event} e 이벤트 객체 추가
 */

const boardList = document.querySelector("#board .swiper-wrapper");
const addBoard = (e) => {
  e.preventDefault();
  const board = e.target.parentNode;
  const title = board.querySelector("#boardTitle").value;
  const creator = board.querySelector(".creator-name").innerText;
  const text = board.querySelector("textarea").value;
  boardList.innerHTML += `<div class="swiper-slide">
  <div class="board-info">
    <div class="board-number">
      <div>게시글 번호</div>
      <div class="text">번호</div>
    </div>
    <div class="board-creator">
      <div>게시글 작성자</div>
      <div class="text">${creator}</div>
    </div>
  </div>
  <div class="board-content">
    <div class="board-title">
      <div>게시글 제목</div>
      <div class="text">${title}</div>
    </div>
    <p>${text}</p>
  </div>
  <div class="button-container">
    <div class="button-update">수정</div>
    <div class="button-delete">삭제</div>
    <div class="button-details">자세히</div>
  </div>
  <div class="line"></div>
</div>`;
  boardSwiper.update();
};
boardButton.addEventListener("click", addBoard);

/* textarea 글자 수 제한 */
const createBoardText = document.querySelector("#createBoard textarea");

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
createBoardText.keyup = function () {
  var content = $(this).val();
  if (content.length > 100) {
    alert("최대 100자까지 입력 가능합니다.");
    $(this).val(content.substring(0, 100));
  }
};
