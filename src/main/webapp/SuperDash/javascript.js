(function () {
    const notificationMenu = document.getElementById("notificationPopup");
    const bellButton = document.getElementById("bellButton");
    const closeMenuButton = document.getElementById("closeMenuButton");

    bellButton.onclick = function () {
        notificationMenu.classList.remove("hidden");
    }

    closeMenuButton.onclick = function () {
        notificationMenu.classList.add("hidden");
    }
}());