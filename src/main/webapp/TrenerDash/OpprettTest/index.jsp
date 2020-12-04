<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.Utover" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>OpprettTest homepage</title>
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
            <a href = "../NyPåbegyntTest">
                <img src = "../../images/ikoner/back_button.png">
                <h3>Tilbake</h3>
            </a>
        </div>

        <div class="centerObjects">
            <img src = "../../images/ikoner/klokke.png">
            <h1>Opprett ny test</h1>
        </div>
    </div>

    <div class="container">
        <h1>Velg deltakere til ny test:</h1>
    </div>

    <center>
        <div class = "searchBar">
            <label for="sokefelt">Sorter etter gruppe:</label>
            <input type="text" placeholder="Søk" id = "sokefelt"/>
        </div>
    </center>

    <div class = "row">
        <div class = "col-sm-4"><b>Navn:</b></div>
        <div class = "col-sm-4"><b>Gruppe:</b></div>
        <div class = "col-sm-4"><b>Til stede:</b></div>
    </div>

    <%ArrayList<Utover> utoverListe = (ArrayList<Utover>) request.getAttribute("utoverListe");
        for(int i = 0; i < utoverListe.size(); i++) {
    %>

    <div class = "row">
        <div class = "col-sm-4" ><%=utoverListe.get(i).getEtternavn() + " " + utoverListe.get(i).getFornavn()%></div>
        <div class = "col-sm-4" ></div>
        <div class = "col-sm-4" ><input type = "checkbox" class="possibleUserCheckBox" id="<%=utoverListe.get(i).getBrukerID()%>"></div>
    </div>

    <%}%>

    <footer>
        <div class = "footerButton" id ="footerRight">
            <img src = "../../images/ikoner/forward_button.png">
            <h2>Gå til øvelser</h2>
        </div>
    </footer>
<script src = "javascript.js" type="text/javascript"></script>
</body>
