<!DOCTYPE html>
<html lang="en">
<head>
    <title>Superuser homepage</title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../SuperDash/style.css">
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
            <a href = "../SuperDash/AdminKlubber">
                <div class = "knapp">
                    <div class = "knappbilde" id = "adminklubber"> <img src = "../images/ikoner/hus.png"></div>
                    Administrere klubber
                </div>
            </a>
        </div>
        <div class = "col-sm" >
            <a href = "../SuperDash/Resultater">
                <div class = "knapp">
                    <div class = "knappbilde" id = "resultater"> <img src = "../images/ikoner/blokk.png"></div>
                    Resultater
                </div>
            </a>
        </div>
        <div class = "col-sm" >
            <a href = "../SuperDash/MinProfil">
                <div class = "knapp">
                    <div class = "knappbilde" id = "minprofil"> <img src = "../images/ikoner/person.png"></div>
                    Min profil
                </div>
            </a>
        </div>
    </div>
</div>
<footer>
    <div class = "container">
        <div class = "row">
            <div class = "col-sm" > 10.02.2020: Krs Roklubb </div>
            <div class = "col-sm" > 23.01.2020: Osl Roklubb</div>
            <div class = "col-sm" > 18.01.2020: Brg Roklubb</div>
        </div>
        <div class="row">
            <div class = "col-sm" > Status: Venter på godkjenning</div>
            <div class = "col-sm" > Status: Venter på godkjenning</div>
            <div class = "col-sm" > Status: Godkjent</div>
        </div>
    </div>
</footer>
</body>