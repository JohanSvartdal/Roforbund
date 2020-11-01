<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.Klubb" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Superuser homepage</title>
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
        <h1>Administrer klubber</h1>
    </div>
</div>

<a href = "NyKlubb">
    <div class = "sideButton leftSideButton">
        <img src = "../../images/ikoner/add_button.png">
        <b>Legg til</b> ny klubb
    </div>
</a>

<div class = "sideButton rightSideButton">
    <b>Fjern</b> eksisterende klubb
    <img src = "../../images/ikoner/remove_button.png">
</div>

<div class = "container">
    <center>
        <div class = "searchBar">
            <label for="sokefelt">Søk etter klubb:</label>
            <input type="text" placeholder="Søk" id = "sokefelt"/>
        </div>
    </center>
    <div class = "row">
        <div class = "col-sm-3"><b>Klubb</b></div>
        <div class = "col-sm-4"><b>Adresse</b></div>
        <div class = "col-sm-2"><b>Telefon</b></div>
        <div class = "col-sm-3"><b>Antall medlemmer</b></div>
    </div>
    <hr/>
    <%
        ArrayList<Klubb> klubbListe = (ArrayList<Klubb>) request.getAttribute("klubbListe");
        for(int i = 0; i < klubbListe.size(); i++) {
    %>
    <div class = "row listRow">
        <div class = "col-sm-3" ><div class = "rowFirst"><a href = "KlubbInnstillinger?klubbID=<%=klubbListe.get(i).getKlubbID()%>"><%=klubbListe.get(i).getNavn()%></a></div></div>
        <div class = "col-sm-4" ><%=klubbListe.get(i).getAdresse()%></div>
        <div class = "col-sm-2" ><%=klubbListe.get(i).getTlf()%></div>
        <div class = "col-sm-3" ><%=klubbListe.get(i).getAntallMedlemmer()%></div>
    </div>
    <%
        }
    %>
</div>
</body>