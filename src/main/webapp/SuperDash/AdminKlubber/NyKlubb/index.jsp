<!DOCTYPE html>
<html lang="en">
<head>
    <title>Administrer klubber</title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../style.css">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class =  "titleBar">
    <div class = "backButton">
        <a href = "../">
            <img src = "../../../images/ikoner/back_button.png">
            <h3>Administrer klubber</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "">
        <h1>Legg til ny klubb</h1>
    </div>
</div>

<div class="container">
    <h1>For å opprette en ny klubb må du først legge inn <b>grunnleggende informasjon</b> om klubben</h1>
    <center><hr/></center>

    <form>
        <div class = "row">
            <div class = "col-sm-4">
                <label for = "klubbnavn">Klubbnavn:</label>
            </div>
            <div class = "col-sm-8">
                <input type = "text" name = "klubbnavn" id = "klubbnavn" class="textField" value=""/>
            </div>
        </div>
        <div class = "row">
            <div class = "col-sm-4">
                <label for = "klubbtlf">Klubbtlf:</label>
            </div>
            <div class = "col-sm-8">
                <input type = "text" name = "klubbtlf" id = "klubbtlf" class="textField smallText" value=""/>
            </div>
        </div>
        <div class = "row">
            <div class = "col-sm-4">
                <label for = "adresse">Adresse:</label>
            </div>
            <div class = "col-sm-8">
                <input type = "text" name = "adresse" id = "adresse" class="textField" value=""/>
            </div>
        </div>
        <div class = "row">
            <div class = "col-sm-4">
                <label for = "postnummer">Postnummer:</label>
            </div>
            <div class = "col-sm-8">
                <input type = "text" name = "postnummer" id = "postnummer" class="textField smallText" value=""/>
            </div>
        </div>
        <div class = "row">
            <div class = "col-sm-4">
                <label for = "poststed">Poststed:</label>
            </div>
            <div class = "col-sm-8">
                <input type = "text" name = "poststed" id = "poststed" class="textField" value=""/>
            </div>
        </div>
    </form>
</div>

<footer>
    <a href = "../">
        <div class = "footerButton" id ="footerLeft">
            <img src = "../../../images/ikoner/back_button.png">
            <h2>Gå tilbake</h2>
        </div>
    </a>

    <a href = "../../LeggTilTrenere">
        <div class = "footerButton" id ="footerRight">
            <img src = "../../../images/ikoner/forward_button.png">
            <h2>Gå videre</h2>
        </div>
    </a>
</footer>
</body>