const swiper = new Swiper(".recommendSwiper", {
    slidesPerView: 2, // 한 번에 보여질 element의 개수
    spaceBetween: 30, // 슬라이드 간격(px)
    slidesPerGroup: 2,

    navigation: {
        nextEl: ".swiper-button-next",
        prevEl: ".swiper-button-prev",
    },
    loopFillGroupWithBlank: true, // 빈칸인 경우 빈칸으로 메우기
    pagination: {
        el: ".swiper-pagination",
        clickable: true,
    },

    observer: true,
    observeParents: true,
});