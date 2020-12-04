(function () {
    const nextButton = document.getElementById('footerRight');

    const listOfPossibleUserCheckboxes = document.getElementsByClassName('possibleUserCheckBox');

    nextButton.onclick = function() {
        var brukereTilStede = "";
        for (var i = 0; i < listOfPossibleUserCheckboxes.length; i++) {
            if (listOfPossibleUserCheckboxes[i].checked) {
                if (brukereTilStede.length === 0) {
                    brukereTilStede = listOfPossibleUserCheckboxes[i].id;
                }else {
                    brukereTilStede = brukereTilStede + "," + listOfPossibleUserCheckboxes[i].id;
                }
            }
        }
        window.location.href = "../HentOvelse?brukereTilStede=" + brukereTilStede;
    };
}());