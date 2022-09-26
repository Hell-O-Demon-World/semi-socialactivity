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
  height: 550,
  slidesPerView: 10,
  freeMode: true,
  scrollbar: {
    el: ".swiper-scrollbar",
  },
  mousewheel: true,
});
/* 게시판 글추가  */
const createBoardBtn = document.getElementById("createBoardBtn");
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

const commentButton = document.getElementById("submitComment");
/** comment 추가
 *
 * @param {Event} e 이벤트 객체 추가
 */
const addComment = (e) => {
  e.preventDefault();
  const comment = e.target.parentNode;
  let commentDetails = comment.querySelector('input[type="text"]').value;
  let realCommentDetails = commentDetails;
  const commentList = document.querySelector(
    ".comment-container .swiper-wrapper"
  );
  if (commentDetails.length > 15) {
    commentDetails = commentDetails.substring(0, 15) + "...";
  }

  commentList.innerHTML += `
  <div class="swiper-slide">
    <div>
      <div>
        <input type="submit" value="삭제" name="deleteComment" />
        <div class="comment-details">자세히</div>
      </div>
      <div class="writer">작성자</div>
    </div>  
    <div class="comment-content">
      ${commentDetails}
    </div>
    <div class ="display-none">${realCommentDetails}</div>
  </div>
`;

  commentSwiper.update();
};
commentButton.addEventListener("click", addComment);

const boardButton = document.getElementById("submitBoard");
boardButton.addEventListener("click", removeForm);
/** comment 추가
 *
 * @param {Event} e 이벤트 객체 추가
 */

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

/* Comment 글자수 자르기 */

const comments = document.getElementsByClassName("comment-content");
console.log(comments);
Array.prototype.forEach.call(comments, (elem) => {
  elem.innerText = `${elem.innerText.substring(0, 15)} ...`;
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
