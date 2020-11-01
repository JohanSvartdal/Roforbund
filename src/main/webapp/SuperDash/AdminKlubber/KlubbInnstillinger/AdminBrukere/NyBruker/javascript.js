(function () {
    const klubbnavn = document.getElementById('klubbnavn');
    const klubbtlf = document.getElementById('klubbtlf');
    const gatenavn = document.getElementById('gatenavn');
    const husnummer = document.getElementById('husnummer');
    const postnummer = document.getElementById('postnummer');
    const poststed = document.getElementById('poststed');

    const nextButton = document.getElementById('footerRight');

    nextButton.onclick = function() {
        window.location.href = "../../LeggTilTrenere?Navn=" + klubbnavn.value + "&Tlf=" + klubbtlf.value + "&Gatenavn=" + gatenavn.value + "&Husnummer=" + husnummer.value + "&Postnummer=" + postnummer.value + "&Poststed=" + poststed.value;
    };
}());