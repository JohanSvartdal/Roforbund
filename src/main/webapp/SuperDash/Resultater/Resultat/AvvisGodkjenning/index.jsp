<!DOCTYPE html>
<html lang="en">
<head>
    <title>Avvise godkjenning</title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../../style.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>

<div class =  "titleBar">
    <div class = "backButton">
        <a href = "../../">
            <img src = "../../../../images/ikoner/back_button.png">
            <h3>Resultater</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "../../../../images/ikoner/blokk.png">
        <h1>Ikke godkjenn</h1>
    </div>
</div>
<div class="container">
    <center>
        <h2>Hvorfor er den <b class = "ikke">ikke godkjent</b>?</h2>
        <br/>
        <p>
            Vennligst legg ved en kommentar
        </p>
        <form action="../AvvisGodkjenning/" method="post">
            <textarea name="comment" id = "commentBox" class="commentBox" placeholder="Skriv kommentar her"></textarea>
            <br/>
            <div class="buttonHolder">
                <a href = "../../../Resultater?mode=1">
                    <div class="resultButton" id = "avvisKnapp">
                        Avbryt
                    </div>
                </a>
                <input type = "submit"  class="resultButton" id = "godkjennKnapp" value="Avvis"/>
            </div>
        </form>
    </center>
    <script src = "javascript.js" type="text/javascript"></script>
</div>
</body>