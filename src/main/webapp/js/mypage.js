const clubSwiper = new Swiper(".club-container", {
  slidesPerView: 2, // 한 번에 보여질 element의 개수
  spaceBetween: 30, // 슬라이드 간격(px)
  slidesPerGroup: 2,
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

const activitySwiper = new Swiper(".activity-container", {
  slidesPerView: 2, // 한 번에 보여질 element의 개수
  spaceBetween: 30, // 슬라이드 간격(px)
  slidesPerGroup: 2,
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

/* 클럽, 액티비티 설명 Text 글자수 자르기 */
const textList = [...document.getElementsByClassName("description")];
textList.forEach((elem) => {
  elem.innerHTML = elem.innerHTML.substring(0, 15) + "...";
});
