<%@ page import="java.util.ArrayList" %>
<%@ page import="models.test.Ovelse" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>OpprettTest homepage</title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../style.css">
    <link rel="stylesheet" href="style.css">
</head>

<body>
<div class =  "titleBar">
    <div class="centerObjects">
        <img src = "../../../images/ikoner/klokke.png">
        <h1>Opprett ny test</h1>
    </div>
</div>

<div class="container">
    <h1><b>Se over resultatene før du sender inn. Rediger et felt ved å trykke på blyanten.</b></h1>
    <h3> Resultater til <b>øvelse 1</b>- 3000m: </h3>

    <div class ="resultBox">
        <div class = "row">
            <div class = "col-sm"><b>Navn:</b></div>
            <div class = "col-sm"><b>Tid:</b></div>
            <div class = "col-sm"><b>Watt:</b></div>
            <div class = "col-sm"><b>Notater:</b></div>
        </div>
        <hr/>
        <div class = "row">
            <div class = "col-sm"><b>Johan Svartdal</b></div>
            <div class = "col-sm">13 min</div>
            <div class = "col-sm">2000</div>
            <div class = "col-sm"></div>
        </div>

        <div class = "row">
            <div class = "col-sm"><b>Oscar Pedersen</b> </div>
            <div class = "col-sm">19 min</div>
            <div class = "col-sm">1000</div>
            <div class = "col-sm"><i>Skadet fot</i></div>
        </div>

        <div class = "row">
            <div class = "col-sm"><b>Rita Henriksen</b></div>
            <div class = "col-sm">17 min</div>
            <div class = "col-sm">1290</div>
            <div class = "col-sm"><i>Glemt astmamedisin</i></div>
        </div>
    </div>



    <h3> Resultater til <b>øvelse 2</b>- 1000m roing: </h3>
    <div class ="resultBox">
        <div class = "row">
            <div class = "col-sm"><b>Navn:</b></div>
            <div class = "col-sm"><b>Tid:</b></div>
            <div class = "col-sm"><b>Watt:</b></div>
            <div class = "col-sm"><b>Notater:</b></div>
        </div>
        <hr/>
        <div class = "row">
            <div class = "col-sm"><b>Johan Svartdal</b></div>
            <div class = "col-sm">17 min</div>
            <div class = "col-sm">20</div>
            <div class = "col-sm"><i>Mistet arm under øvelse</i></div>
        </div>

        <div class = "row">
            <div class = "col-sm"><b>Oscar Pedersen</b> </div>
            <div class = "col-sm">11 min</div>
            <div class = "col-sm">10</div>
            <div class = "col-sm"></div>
        </div>

        <div class = "row">
            <div class = "col-sm"><b>Rita Henriksen</b></div>
            <div class = "col-sm">6 min</div>
            <div class = "col-sm">15</div>
            <div class = "col-sm"><i>Lettere robåt</i></div>
        </div>
    </div>



    <h3> Resultater til <b>øvelse 3</b>- spensthopp: </h3>
    <div class ="resultBox">
        <div class = "row">
            <div class = "col-sm"><b>Navn:</b></div>
            <div class = "col-sm"><b>Tid:</b></div>
            <div class = "col-sm"><b>Antall:</b></div>
            <div class = "col-sm"><b>Notater:</b></div>
        </div>
        <hr/>
        <div class = "row">
            <div class = "col-sm"><b>Johan Svartdal</b></div>
            <div class = "col-sm">17 min</div>
            <div class = "col-sm">68</div>
            <div class = "col-sm"><i>Ingen arm</i></div>
        </div>

        <div class = "row">
            <div class = "col-sm"><b>Oscar Pedersen</b> </div>
            <div class = "col-sm">11 min</div>
            <div class = "col-sm">54</div>
            <div class = "col-sm"><i>Skadet fot</i></div>
        </div>

        <div class = "row">
            <div class = "col-sm"><b>Rita Henriksen</b></div>
            <div class = "col-sm">6 min</div>
            <div class = "col-sm">56</div>
            <div class = "col-sm"></div>
        </div>
    </div>
</div>

<div class = "backgroundDimmer">

</div>

<div class = "bekreftInnsending">
    <h2>Er du sikker på at du vil sende inn resultater?</h2>
    <h3>OBS! Etter at resultatene er sendt inn vil de ikke være
        mulige å redigere. Denne handlingen kan ikke angres. </h3>
    <div class = "bigButton" style="margin-top: 40px;background-color: lightgray;">
        Tilbake til test
    </div>
    <div class = "bigButton" style="background-color: palegreen;">
        Send inn test
    </div>
</div>

<footer>
    <a href ="../RegTestResult">
        <div class = "footerButton" id ="footerLeft">
            <img src = "../../../images/ikoner/back_button.png">
            <h2>Tilbake</h2>
        </div> </a>
    <a href = "../SendtGod">
        <div class = "footerButton" id ="footerRight">
            <img src = "../../../images/ikoner/forward_button.png">
            <h2>Send inn</h2>
        </div> </a>
</footer>
</body>