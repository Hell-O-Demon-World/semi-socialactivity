const toggle = document.querySelector(".toggle");
const navigation = document.querySelector(".navigation");
const openBoardBtn = document.querySelector(".add-board");
const closeBoardBtn = document.querySelector(".close-btn");
const addImageBtn = document.querySelector(".add-image");
const removeImageFormBtn = document.querySelector(".close-image");
const openActivityBtn = document.querySelector(".create-activity");
const closeActivityBtn = document.querySelector(".close-activity");

toggle.addEventListener("click", (e) => {
  e.target.classList.toggle("active");
  navigation.classList.toggle("active");
});

/* board open,close  */
const createBoard = document.getElementById("createBoard");

const openBoardForm = () => {
  createBoard.style.display = "flex";
  createBoard.style.zIndex = "1000";
};

const closeBoardForm = () => {
  createBoard.style.display = "none";
};

closeBoardBtn.addEventListener("click", closeBoardForm);
openBoardBtn.addEventListener("click", openBoardForm);

/* Activity form open close */
const activityForm = document.getElementById("createActivity");

const openActivityForm = () => {
  activityForm.style.display = "block";
  activityForm.style.zIndex = "1000";
};
const closeActivityForm = () => {
  activityForm.style.display = "none";
};

openActivityBtn.addEventListener("click", openActivityForm);
closeActivityBtn.addEventListener("click", closeActivityForm);

/* IMage form open close */

const addImage = document.getElementById("addImage");
const newImageForm = (e) => {
  addImage.style.display = "flex";
  addImage.style.zIndex = "1000";
};

const removeImageForm = () => {
  addImage.style.display = "none";
  addImage.style.zIndex = "-1";
};
removeImageFormBtn.addEventListener("click", removeImageForm);

addImageBtn.addEventListener("click", newImageForm);
