
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Administrer utøvere</title>
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
        <img src = "../../images/ikoner/hus.png">
        <h1>Administrer utøvere</h1>
    </div>
</div>

<a href = "NyUtøver">
    <div class = "sideButton" id = "addUtøver">
        <img src = "../../images/ikoner/add_button.png">
        <b>Legg til</b> ny utøver
    </div>
</a>

<a href = "FjernUtøver">
<div class = "sideButton" id = "removeUtøver">
    <b>Fjern</b> eksisterende utøver
    <img src = "../../images/ikoner/remove_button.png">
</div>
</a>

<div class = "container">
    <center>
        <div class = "searchBar">
            <label for="sokefelt">Søk etter utøver:</label>
            <input type="text" placeholder="Søk" id = "sokefelt"/>
        </div>
    </center>

    <div class = "row">
        <div class = "col-sm"><b>Navn:</b></div>
        <div class = "col-sm"><b>E-post:</b></div>
        <div class = "col-sm"><b>Mobil:</b></div>
        <div class = "col-sm"><b>Adresse:</b></div>
        <div class = "col-sm"><b>Gruppe:</b></div>
    </div>
    <hr/>
    <div class = "row">
        <div class = "col-sm"><u>Elina W. Antonsen</u></div>
        <div class = "col-sm">elina99@live.no</div>
        <div class = "col-sm">92233443</div>
        <div class = "col-sm">Arenfeldt 20</div>
        <div class = "col-sm">Junior 20</div>
    </div>
</div>
</body>