<!DOCTYPE html>
<html lang="en">
<head>
    <title>UtoverDash minprofil</title>
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
        <img src = "../../images/ikoner/MinProfil.png">
        <h1>Min profil</h1>
     </div>
    </div>
    <div class="container">
        <h1>Line Pettersen</h1>
        <center><hr/></center>
    </div>
    <div id ="mininfoBox">
        <div class = "row">
            <div class = "col-sm" > <b>Fødselsdato:</b> </div>
            <div class = "col-sm" > <%=request.getAttribute("fodseldato")%> </div>
        </div>
        <div class = "row">
            <div class = "col-sm" > <b> Adressse: </b> </div>
            <div class = "col-sm" > Skøyerlia 19, Kristiansand </div>
        </div>
        <div class = "row">
            <div class = "col-sm" > <b>E-post:</b> </div>
            <div class = "col-sm" > line.p@roing.no </div>
        </div>
        <div class = "row">
            <div class = "col-sm" > <b>Mobil:</b> </div>
            <div class = "col-sm" > 909 09 090 </div>
        </div>
        <div class = "row">
            <div class = "col-sm" > <b>Type bruker:</b> </div>
            <div class = "col-sm" > Superbruker </div>
        </div>
        </div>
    </div>
    <div class = "endreBox">
        <div class = "endreBox1">
            <img src = "../../images/ikoner/blyant.png">
            <h4>Endre personalia</h4>
        </div>
    </div>
</body>