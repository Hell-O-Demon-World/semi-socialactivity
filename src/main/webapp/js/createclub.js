const ageLow = document.getElementById("ageLow");
const ageHigh = document.getElementById("ageHigh");
const tierAge = document.getElementById("tierAge");
const clubLoc = document.getElementById("clubLocation");

/** age 길이 최대 3으로 제한*/
const memberMaxLength = function (e) {
  if (e.value.length > e.maxLength) {
    e.value = e.value.slice(0, e.maxLength);
  }
};

/* club age select 최소값 설정 */
for (let i = 1; i < 8; i++) {
  ageLow.innerHTML += `<option value=${i}>${i * 10}대</option>`;
}
ageLow.innerHTML += `<option value=9>80대 이상</option>`;

/* club tier select 최소값 설정 */
for (let i = 7; i < 11; i++) {
  tierAge.innerHTML += `<option value=${i}>${i * 10}타</option>`;
}
tierAge.innerHTML += `<option value=11>110타 이상</option>`;

/* club location option값 설정 */
locationList.forEach((elem) => {
  clubLoc.innerHTML += `<option value=${elem}>${elem}</option>`;
});

$(".container textarea").keyup(function () {
  var content = $(this).val();
  if (content.length > 30) {
    alert("최대 30자까지 입력 가능합니다.");
    $(this).val(content.substring(0, 30));
  }
});
