(function () {
    const paramsFromLast = window.location.href;
    const splittedParams = paramsFromLast.split("?");
    const realParams = splittedParams[1];

    const nextButton = document.getElementById('footerRight');

    const listOfCheckboxes = document.querySelectorAll(".checker")

    nextButton.onclick = function () {

        var peopleToAdd = "";
        for (i = 0; i < listOfCheckboxes.length; i++) {
            if (listOfCheckboxes[i].checked) {
                if (peopleToAdd != "") {
                    peopleToAdd = peopleToAdd + ","
                }
                peopleToAdd = peopleToAdd + listOfCheckboxes[i].id;
            }
        }

        window.location.href = "../FullscreenMessage?" + realParams + "&TrenereToAdd=" + peopleToAdd;
    }
}());