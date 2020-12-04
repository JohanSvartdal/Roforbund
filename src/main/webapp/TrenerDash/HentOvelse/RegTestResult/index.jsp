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
    <%System.out.println("Nå skal jeg hente");%>
    <h1> Legge inn resultater til <b>øvelse <%=request.getAttribute("currentOvelseIndex")%></b> - <%=request.getAttribute("currentOvelsesNavn")%>>:</h1>
</div>
        <div class = "row">
            <div class = "col-sm-3"><b>Navn:</b></div>
            <div class = "col-sm-2"><b>Watt:</b></div>
            <div class = "col-sm-2"><b>Tid:</b></div>
            <div class = "col-sm-3"><b>Notater:</b></div>
        </div>

        <div class = "row">
            <div class = "col-sm-4">Svartdal Johan</div>
            <div class = "col-sm-2"><input type = "number" class="textField" value="456"/></div>
            <div class = "col-sm-2"><input type = "number" class="textField" value="12:34"/></div>
            <div class = "col-sm-3"><input type = "text" class="textField" value="Vonde knær."/></div>
        </div>
    </div>
<footer>
    <a href = "../../">
        <div class = "footerButton" id ="footerLeft">
            <img src = "../../../images/ikoner/avbryt.png">
            <h2>Avbryt test</h2>
        </div>
    </a>
    <a href = "../RegTestResult1">
    <div class = "footerButton" id ="footerRight">
        <img src = "../../../images/ikoner/forward_button.png">
        <form action='RegTestResult' method='POST'>
            <button type="submit">
                Neste øvelse
            </button>
        </form>
    </div>
    </a>
</footer>
</body>