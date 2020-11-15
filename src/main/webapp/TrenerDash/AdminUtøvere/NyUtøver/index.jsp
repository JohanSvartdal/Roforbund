<!DOCTYPE html>
<html lang="en">
<head>
    <title>Administrer utøvere</title>
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
            <h3>Administrer utøvere</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "">
        <h1>Legg til ny utøver</h1>
    </div>
</div>

<div class="container">
    <h1><b>Finn en utøver uten klubb!</b></h1>
</div>

<div class = "container">
    <center>
        <div class = "searchBar">
            <label for="sokefelt">Søk etter navn:</label>
            <input type="text" placeholder="Søk" id = "sokefelt"/>
        </div>
    </center>
</div>

<div id ="finnutBox">
    <div class = "row">
        <div class = "col-sm" > <b>Navn:</b> </div>
        <div class = "col-sm" > <b>E-post:</b> </div>
        <div class = "col-sm" > <b> Mobil: </b> </div>
        <div class = "col-sm" > <b>Legg til: </b></div>
</div>

    <div class = "row">
        <div class = "col-sm" > Nora Jakobsen </div>
        <div class = "col-sm" > nora@live.no</div>
        <div class = "col-sm" > 90989098  </div>
        <div class = "col-sm" ><input type = "checkbox"></div>
    </div>
</div>

<div class = "container">
    <div class = "row">
        <div class = "col-sm" >
            <a href = "../../AdminUtøvere/LeggtUtøver">
                <div class = "knapp">
                    <div class = "knappbilde" id = "leggtilu"> Legg til </div>
                </div>
            </a>
        </div>
</div>
</div>
</body>