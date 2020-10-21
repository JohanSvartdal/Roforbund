<!DOCTYPE html>
<html lang="en">
<head>
    <title>Legge inn resultat i test</title>
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
    <div class="centerObjects">
        <img src = "../../Ikoner/klokke.png">
        <h1>Opprett ny test</h1>
    </div>
</div>

<div class="container">
    <h1> Legge inn resultater til <b>øvelse 2</b>- 1000m roing:</h1>
</div>
        <div class = "row">
            <div class = "col-sm-3"><b>Navn:</b></div>
            <div class = "col-sm-2"><b>Watt:</b></div>
            <div class = "col-sm-2"><b>Tid:</b></div>
            <div class = "col-sm-3"><b>Notater:</b></div>
        </div>

        <div class = "row">
            <div class = "col-sm-4">Svartdal Johan </div>
            <div class = "col-sm-2"><input type = "int" class="textField" value="367"/></div>
            <div class = "col-sm-2"><input type = "int" class="textField" value="5:34"/></div>
            <div class = "col-sm-3"><input type = "text" class="textField" value=""/></div>
        </div>

        <div class = "row">
            <div class = "col-sm-4">Ramsey Gordon </div>
            <div class = "col-sm-2"><input type = "int" class="textField" value="435"/></div>
            <div class = "col-sm-2"><input type = "int" class="textField" value="7:23"/></div>
            <div class = "col-sm-3"><input type = "text" class="textField" value=""/></div>
        </div>

        <div class = "row">
            <div class = "col-sm-4"></div>
            <div class = "col-sm-2"><input type = "int" class="textField" value=""/></div>
            <div class = "col-sm-2"><input type = "int" class="textField" value=""/></div>
            <div class = "col-sm-3"><input type = "text" class="textField" value=""/></div>
        </div>

        <div class = "row">
            <div class = "col-sm-4"></div>
            <div class = "col-sm-2"><input type = "int" class="textField" value=""/></div>
            <div class = "col-sm-2"><input type = "int" class="textField" value=""/></div>
            <div class = "col-sm-3"><input type = "text" class="textField" value=""/></div>
        </div>
    </div>
<footer>
    <a href ="../RegTestResult">
        <div class = "footerButton1" id ="footerLeft">
            <img src = "../../../images/ikoner/back_button.png">
            <h2>Forrige øvelse</h2>
        </div> </a>
    <a href = "../SeOverResult">
        <div class = "footerButton" id ="footerRight">
            <img src = "../../../images/ikoner/forward_button.png">
            <h2>Se over resultater</h2>
        </div> </a>
</footer>
</body>