const menuIcon = document.querySelector(".menu-icon");
const sideBar = document.querySelector(".sideBar");
const containers = document.querySelectorAll(".container");

menuIcon.onclick = function () {
    sideBar.classList.toggle("sidebar-left");

    containers.forEach(function(container) {
        container.classList.toggle("large-container");
    });
}
