(function() {
    //SKRIV JAVASCRIPT KODE HER

    const knapp = document.getElementById("showPopup");

    knapp.onclick = function() {
        if (confirm("Press a button!")) {
            //her trykkes OK
            //Linjen under tar deg videre til google hvis du fjerner de to skråstrekene
            //window.location.href = "www.google.com";
        } else {
            //her trykkes cancel
        }
    }
}());