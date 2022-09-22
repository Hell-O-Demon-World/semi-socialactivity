const formBx = document.querySelector(".form-box");
const signIn = document.getElementById("signIn");
const signUp = document.getElementById("signUp");
const signupMsg = document.getElementById("signupMsg");
const signinMsg = document.getElementById("signinMsg");
const signinId = document.getElementById("signinId");
const signinPw = document.getElementById("signinPw");
const signupId = document.getElementById("signupId");
const signupPw = document.getElementById("signupPw");

const addActive = function () {
  formBx.classList.add("active");
};

const removeActive = function () {
  formBx.classList.remove("active");
};

/* 로그인 유효성 검증 */
/**
 *
 * @param {Element} msgLocation  msg 표시 위치 지정
 * @param {string} msg 메시지 본문
 */
const showAlert = (msgLocation, msg) => {
  msgLocation.innerHTML = msg;
};

/** id, password 입력 길이 제한 - 11자리 */
const numberMaxLength = function (e) {
  if (e.value.length > e.maxLength) {
    e.value = e.value.slice(0, e.maxLength);
  }
};
/** id 유효성 검증 - 영문자로 시작하는 영문자 또는 숫자 6~11자
 *
 * @param {Event} e 이벤트 객체 전달
 * @param {Element} msgLoc 메시지 표시 위치
 */
const signupIdCheck = (e) => {
  let regExp = /^[a-z]+[a-z0-9]{5,10}$/g;
  if (!regExp.test(e.value)) {
    showAlert(signupMsg, "영문자로 시작하는 영문자 또는 숫자 6~11자");
  }
};
const signinIdCheck = (e) => {
  let regExp = /^[a-z]+[a-z0-9]{5,10}$/g;

  if (!regExp.test(e.value)) {
    showAlert(signinMsg, "영문자로 시작하는 영문자 또는 숫자 6~11자");
  }
};
/** password 유효성 검증 - 영문, 숫자, 특수문자 최소 한가지 이상 포함
 *
 * @param {Event} e 이벤트 객체 전달
 */
const signinPwdCheck = (e) => {
  let regExp =
    /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{6,11}$/;
  if (!regExp.test(e.value)) {
    showAlert(signinMsg, "영문, 숫자, 특수문자 최소 한가지 이상 포함 6~11자.");
  }
};
const signupPwdCheck = (e) => {
  let regExp =
    /^(?=.*[a-zA-z])(?=.*[0-9])(?=.*[$`~!@$!%*#^?&\\(\\)\-_=+]).{6,11}$/;
  if (!regExp.test(e.value)) {
    showAlert(signupMsg, "영문, 숫자, 특수문자 최소 한가지 이상 포함 6~11자.");
  }
};

/* 회원가입 유효성 검증 */
/** NickName 유효성 검증 */

const nickNameCheck = (e) => {
  let regExp = new RegExp("^(?=.*[a-z0-9가-힣])[a-z0-9가-힣]{2,16}$");
  const msg =
    "한글, 영문, 특수문자(- _ .)포함한 2 ~ 12글자 닉네임(한글 초성 및 모음)";
  if (!regExp.test(e.target.value)) {
    showAlert(signupMsg, msg);
  }
};
const nickName = document.getElementById("userName");
nickName.addEventListener("focus", (e) => nickNameCheck(e));

/** age 길이 최대 3으로 제한*/
const ageMaxLength = function (e) {
  if (e.value.length > e.maxLength) {
    e.value = e.value.slice(0, e.maxLength);
  }
};
