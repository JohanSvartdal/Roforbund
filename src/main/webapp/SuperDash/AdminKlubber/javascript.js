(function () {
    const deleteListElement = document.getElementsByClassName("deleteListElement");
    const removeButton = document.getElementById("removeButton");

    var removeButtonsVisible = false;

    removeButton.onclick = function () {
        if (removeButtonsVisible) {
            removeButtonsVisible = false;
            for (var i = 0; i < deleteListElement.length; i++) {
                deleteListElement.item(i).classList.add("hidden");
            }
        }else {
            removeButtonsVisible = true;
            for (var i = 0; i < deleteListElement.length; i++) {
                deleteListElement.item(i).classList.remove("hidden");
            }
        }
    }
}());