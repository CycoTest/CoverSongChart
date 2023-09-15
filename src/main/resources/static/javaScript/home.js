const menuIcon = document.querySelector(".menu-icon");
const sideBar = document.querySelector(".sideBar");

menuIcon.onclick = function () {
    sideBar.classList.toggle("sidebar-left");
}