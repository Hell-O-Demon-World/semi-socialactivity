const clubAgeLow = document.getElementById("clubAgeLow");
const clubAgeHigh = document.getElementById("clubAgeHigh");
const clubTierLow = document.getElementById("clubTierLow");
const clubTierHigh = document.getElementById("clubTierHigh");
const clubName = document.getElementById("clubName");
const clubLocation = document.getElementById("location");
const state = document.getElementById("state");
const tierSelect = document.getElementById("tierName");

tierSelect.innerHTML += `<option value=6>70타 미만</option>`;
for (let i = 7; i < 11; i++) {
  tierSelect.innerHTML += `<option value=${i}>${i * 10}타</option>`;
}
tierSelect.innerHTML += `<option value=11>110타 이상</option>`;

for (let i = 1; i < 8; i++) {
  clubAgeLow.innerHTML += `<option value=${i}>${i * 10}대</option>`;
}
clubAgeLow.innerHTML += `<option value=9>80대 이상</option>`;

for (let i = 7; i < 11; i++) {
  clubTierLow.innerHTML += `<option value=${i}>${i * 10}타</option>`;
}
clubTierLow.innerHTML += `<option value=11>110타 이상</option>`;

const clubAgeLowChange = () => {
  const lowAge = clubAgeLow.value;
  clubAgeHigh.innerHTML = '<option value="0">최대나이 선택</option>';
  for (let i = lowAge; i < 8; i++) {
    clubAgeHigh.innerHTML += `<option value=${i}>${i * 10}대</option>`;
  }
  clubAgeHigh.innerHTML += `<option value=9>70대 이상</option>`;
};

const clubTierLowChange = () => {
  const lowTier = clubTierLow.value;
  clubTierHigh.innerHTML = '<option value="0">최대타수 선택</option>';
  for (let i = lowTier; i < 11; i++) {
    clubTierHigh.innerHTML += `<option value=${i}>${i * 10}타</option>`;
  }
  clubTierHigh.innerHTML += `<option value=11>110타 이상</option>`;
};

/* chevronClick */
const chevronDown = document.getElementById("chevronIcon");
const optional = document.querySelector(".optional");

chevronDown.addEventListener("click", function () {
  optional.classList.toggle("hide");
});

/* submitButton onClick */

const submitFormBtn = document.getElementById("submitFormBtn");

submitFormBtn.addEventListener("click", function (e) {
  e.preventDefault();

  const formData = new FormData();
  formData.append("clubName", clubName.value);
  formData.append("minAge", clubAgeLow.value);
  formData.append("maxAge", clubAgeHigh.value);
  formData.append("minTier", clubTierLow.value);
  formData.append("maxTier", clubTierHigh.value);
  formData.append("clubLocation", clubLocation.value + " " + state.value);
  let str = "";
  for (let value of formData.values()) {
    str += value;
    str += "/";
  }
  alert(str);
});
