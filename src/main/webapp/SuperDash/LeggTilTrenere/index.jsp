<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.Trener" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Legg til trenere</title>
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
        <img src = "">
        <h1>Legg til trenere</h1>
    </div>
</div>

<div class="container">
    <h1><b>Legg til trenere</b> uten tilføring til klubb eller legg til ny. Dette kan du også gjøre senere…</h1>
    <center><hr/></center>

    <center>
        <div class = "searchBar">
            <label for="sokefelt">Søk etter trener:</label>
            <input type="text" placeholder="Søk" id = "sokefelt"/>
        </div>
    </center>
    <div class = "row">
        <div class = "col-sm-3"><b>Navn</b></div>
        <div class = "col-sm-4"><b>Adresse</b></div>
        <div class = "col-sm-2"><b>Telefon</b></div>
        <div class = "col-sm-3"><b>Legg til</b></div>
    </div>
    <hr/>
    <%
        ArrayList<Trener> trenerListe = (ArrayList<Trener>) request.getAttribute("trenerListe");
        for(int i = 0; i < trenerListe.size(); i++) {
    %>
    <div class = "row">
        <div class = "col-sm-3" ><div class = "rowFirst"><%=trenerListe.get(i).getFornavn() + " " + trenerListe.get(i).getEtternavn()%></div></div>
        <div class = "col-sm-4" ><%=trenerListe.get(i).getAdresse()%></div>
        <div class = "col-sm-2" ><%=trenerListe.get(i).getTlf()%></div>
        <div class = "col-sm-3" ><input type = "checkbox" class = "checker" id = "<%=trenerListe.get(i).getID()%>"></div>
    </div>
    <%
        }
    %>
</div>
<footer>
    <a href = "../AdminKlubber/NyKlubb">
        <div class = "footerButton" id ="footerLeft">
            <img src = "../../images/ikoner/back_button.png">
            <h2>Klubb detaljer</h2>
        </div>
    </a>

    <div class = "footerButton" id ="footerRight">
        <img src = "../../images/ikoner/forward_button.png">
        <h2>Opprett klubb</h2>
    </div>

    <script src = "javascript.js" type="text/javascript"></script>
</footer>
</body>