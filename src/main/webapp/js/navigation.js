const toggle = document.querySelector(".toggle");
const navigation = document.querySelector(".navigation");
toggle.addEventListener("click", (e) => {
  e.target.classList.toggle("active");
  navigation.classList.toggle("active");
});
const openActivityBtn = document.querySelector(".create-activity");
const closeActivityBtn = document.querySelector(".close-activity");

const activityForm = document.getElementById("createActivity");
const openActivityForm = () => {
  activityForm.style.display = "block";
};
const closeActivityForm = () => {
  activityForm.style.display = "none";
};

openActivityBtn.addEventListener("click", openActivityForm);
closeActivityBtn.addEventListener("click", closeActivityForm);
