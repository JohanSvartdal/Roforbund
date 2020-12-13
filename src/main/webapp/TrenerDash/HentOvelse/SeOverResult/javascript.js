(function () {
    const sendInnKnapp = document.getElementById('footerRight');
    const backgroundDimmer = document.getElementById('backgroundDimmer');
    const bekreftInnsending = document.getElementById('bekreftInnsending');
    const closeDialog = document.getElementById("closeDialog");

    sendInnKnapp.onclick = function () {
        backgroundDimmer.classList.remove("hidden");
        bekreftInnsending.classList.remove("hidden");
    }

    closeDialog.onclick = function () {
        backgroundDimmer.classList.add("hidden");
        bekreftInnsending.classList.add("hidden");
    }
}());