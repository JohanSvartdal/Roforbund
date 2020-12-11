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
</div>

<div class = "container">
    <h3> Resultater til <b>øvelse 1</b>- 3000m: </h3>
</div>

<div id ="resultBox">
    <div class = "row">
        <div class = "col-sm" > <b>Navn:</b> </div>
        <div class = "col-sm" > <b>Tid:</b> </div>
        <div class = "col-sm" > <b> Watt: </b> </div>
        <div class = "col-sm" > <b>Notater:</b></div>
    </div>
</div>


<footer>
    <a href ="../RegTestResult1">
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