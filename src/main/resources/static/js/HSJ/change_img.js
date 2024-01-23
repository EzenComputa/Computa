//사진바꾸기- 왜인지 모르겠는데 body에서 작동됩니다...
const myImg = document.getElementById("pr_dt_photo");
const mysmall1 = document.getElementById("pr_dt_img1");
const mysmall2 = document.getElementById("pr_dt_img2");
const mysmall3 = document.getElementById("pr_dt_img3");
const mysmall4 = document.getElementById("pr_dt_img4");
const mysmall5 = document.getElementById("pr_dt_img5");
const mysmall6 = document.getElementById("pr_dt_img6");


mysmall1.addEventListener("click", function() {
myImg.src = mysmall1.src;
});

mysmall2.addEventListener("click", function() {
myImg.src = mysmall2.src;
});

mysmall3.addEventListener("click", function() {
myImg.src = mysmall3.src;
});

mysmall4.addEventListener("click", function() {
myImg.src = mysmall4.src;
});

mysmall5.addEventListener("click", function() {
myImg.src = mysmall5.src;
});

mysmall6.addEventListener("click", function() {
myImg.src = mysmall6.src;
});