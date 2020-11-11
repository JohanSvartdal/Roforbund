<%@ page import="servlets.Test" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Resultater</title>
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
        <img src = "../../images/ikoner/blokk.png">
        <h1>Resultater</h1>
    </div>
</div>

<div class="container">
    <div class = "row">
        <div class = "col-sm"><b>Dato</b></div>
        <div class = "col-sm"><b>Antall øvelser</b></div>
        <div class = "col-sm"><b>Notater</b></div>
    </div>
    <hr/>
    <%
        ArrayList<Test> testListe = (ArrayList<Test>) request.getAttribute("testliste");
        for(int i = 0; i < testListe.size(); i++) {
    %>
    <div class = "row">
        <div class = "col-sm" ><div class = "rowFirst"><a href = "Resultat?TestID=<%=testListe.get(i).getTest_id()%>"><%= testListe.get(i).getDato()%></a></div></div>
        <div class = "col-sm" ><%= testListe.get(i).getAntallOvelser()%></div>
        <div class = "col-sm" ><%= testListe.get(i).getKommentar()%></div>
    </div>
    <%
        }
    %>
</div>
</body>