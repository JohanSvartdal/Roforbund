<!DOCTYPE html>
<html lang="en">
<head>
    <title>Trener dashboard</title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../TrenerDash/style.css">
</head>
<body>
<div class =  "titleBar">
    <div class = "bellButton">
        <a href = "../">
            <img src = "../images/ikoner/bell.png">
        </a>
    </div>
</div>
<div class = "container">
    <% //TODO her må det legges inn sånn at den loader riktig navn, selvom man kommer tilbake til denne siden fra en annen side. (IKKE BARE CHECKLOGIN) %>
    <h1> <%= request.getAttribute("WelcomeMessage") %> </h1>
    <div class = "row">
        <div class = "col-sm" >
            <a href = "../TrenerDash/AdminUtøvere">
                <div class = "knapp">
                    <div class = "knappbilde" id = "administreutøvere"> <img src = "../TrenerDash/Ikoner/roer.png"></div>
                    Administrere utøvere
                </div>
            </a>
        </div>
        <div class = "col-sm" >
            <a href = "../TrenerDash/OpprettTest">
                <div class = "knapp">
                    <div class = "knappbilde" id = "opprettnytest"> <img src = "../TrenerDash/Ikoner/klokke.png"></div>
                    Opprett ny test
                </div>
            </a>
        </div>
        <div class = "col-sm" >
            <a href = "../TrenerDash/Resultater">
                <div class = "knapp">
                    <div class = "knappbilde" id = "resultater"> <img src = "../TrenerDash/Ikoner/blokk.png"></div>
                    Resultater
                </div>
            </a>
        </div>
        <div class = "col-sm" >
            <a href = "../TrenerDash/MinProfil">
                <div class = "knapp">
                    <div class = "knappbilde" id = "minprofil"> <img src = "../TrenerDash/Ikoner/person.png"></div>
                    Min profil
                </div>
            </a>
        </div>
    </div>
</div>
<footer>
    <div class = "container">
        <div class = "row">
            <div class = "col-sm" > 13.09.2020: 3000m </div>
            <div class = "col-sm" > 09.09.2020: 1000m </div>
            <div class = "col-sm" > 28.08.2020: Benkpress </div>
        </div>
        <div class="row">
            <div class = "col-sm" > Kari Nord - 12:03</div>
            <div class = "col-sm" > Kari Nord - 05:12</div>
            <div class = "col-sm" > Kari Nord - 70 kg</div>
        </div>
    </div>
</footer>
</body>