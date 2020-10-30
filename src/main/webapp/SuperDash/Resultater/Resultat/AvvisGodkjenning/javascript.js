(function () {
    const commentBox = document.getElementById('commentBox');

    const nextButton = document.getElementById('footerRight');

    nextButton.onclick = function() {
        window.location.href = "../../LeggTilTrenere?Navn=" + klubbnavn.value + "&Tlf=" + klubbtlf.value + "&Gatenavn=" + gatenavn.value + "&Husnummer=" + husnummer.value + "&Postnummer=" + postnummer.value + "&Poststed=" + poststed.value;
    };
}());