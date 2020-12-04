<!DOCTYPE html>
<html lang="en">
<head>
    <title>Trener dashboard</title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../../style.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class =  "titleBar">
    <div class = "backButton">
        <a href = "../">
            <img src = "../../images/ikoner/back_button.png">
            <h3>Hjem</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "../../images/ikoner/blokk.png">
        <h1>Tester</h1>
    </div>
</div>
<div class = "container">
    <h1> Har du allerede startet en test? </h1>
    <div class = "row">
        <div class = "col-sm" >
            <div class = "knapp">
                <div class = "knappbilde" id = "paabegynt"> <img src = "../../TrenerDash/Ikoner/blokk.png"></div>
                Påbegynte tester
            </div>
        </div>
        <div class = "col-sm" >
            <a href = "../../TrenerDash/OpprettTest">
                <div class = "knapp">
                    <div class = "knappbilde" id = "nytest"> <img src = "../../TrenerDash/Ikoner/klokke.png"></div>
                    Opprett ny test
                </div>
            </a>
        </div>
    </div>
</div>
</body>