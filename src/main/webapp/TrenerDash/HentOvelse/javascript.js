(function () {
    const nextButton = document.getElementById('footerRight');
    const backButton = document.getElementById('footerLeft');

    const listOfPossibleOvelser = document.getElementsByClassName('possibleOvelseCheckBox');

    nextButton.onclick = function() {
        var ovelserValgt = "";
        for (var i = 0; i < listOfPossibleOvelser.length; i++) {
            if (listOfPossibleOvelser[i].checked) {
                if (ovelserValgt.length === 0) {
                    ovelserValgt = listOfPossibleOvelser[i].id;
                }else {
                    ovelserValgt = ovelserValgt + "," + listOfPossibleOvelser[i].id;
                }
            }
        }
        const oldParams = window.location.href.split("?")[1];
        window.location.href = "RegTestResult?" + oldParams + "&ovelserValgt=" + ovelserValgt;
    };

    backButton.onclick = function () {
        window.location.href = "../OpprettTest"
    }
}());