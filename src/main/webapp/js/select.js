const clubAgeLow = document.getElementById("clubAgeLow");
const clubAgeHigh = document.getElementById("clubAgeHigh");
const clubTierLow = document.getElementById("clubTierLow");
const clubTierHigh = document.getElementById("clubTierHigh");

/* 최저 나이 */
for (let i = 1; i < 8; i++) {
  clubAgeLow.innerHTML += `<option value=${i}>${i * 10}대</option>`;
}
/* 최저 타수 */
for (let i = 7; i < 11; i++) {
  clubTierLow.innerHTML += `<option value=${i}>${i * 10}타</option>`;
}
clubTierLow.innerHTML += `<option value=11>110타 이상</option>`;
/* 최저 나이 변경시 최대 나이 option 추가 */
const clubAgeLowChange = () => {
  const lowAge = clubAgeLow.value;
  clubAgeHigh.innerHTML = '<option value="0">최대나이 선택</option>';
  for (let i = lowAge; i < 8; i++) {
    clubAgeHigh.innerHTML += `<option value=${i}>${i * 10}대</option>`;
  }
  clubAgeHigh.innerHTML += `<option value=9>70대 이상</option>`;
};

/* 최저 티어 변경시 최대 티어 option 추가 */
const clubTierLowChange = () => {
  const lowTier = clubTierLow.value;
  clubTierHigh.innerHTML = '<option value="0">최대타수 선택</option>';
  for (let i = lowTier; i < 11; i++) {
    clubTierHigh.innerHTML += `<option value=${i}>${i * 10}타</option>`;
  }
  clubTierHigh.innerHTML += `<option value=11>110타 이상</option>`;
};

/* chevronClick - 상세 검색 dropdow toggle*/
const chevronDown = document.getElementById("chevronIcon");
const optional = document.querySelector(".optional");

chevronDown.addEventListener("click", function () {
  optional.classList.toggle("hide");
});
