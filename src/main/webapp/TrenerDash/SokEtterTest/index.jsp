<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.Klubb" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Trener Dashboard</title>
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
        <h1>Administrer klubber</h1>
    </div>
</div>

<a href = "NyKlubb">
    <div class = "sideButton" id = "addKlubb">
        <img src = "../../images/ikoner/add_button.png">
        <b>Legg til</b> ny klubb
    </div>
</a>

<div class = "sideButton" id = "removeKlubb">
    <b>Fjern</b> eksisterende klubb
    <img src = "../../images/ikoner/remove_button.png">
</div>

<div class = "container">
    <center>
        <div class = "searchBar">
            <label for="sokefelt">Søk etter tester:</label>
            <input type="text" placeholder="Søk" id = "sokefelt"/>
        </div>
    </center>
    <div class = "row">
        <div class = "col-sm-3"><b>Test ID</b></div>
        <div class = "col-sm-4"><b>Klubb ID</b></div>
        <div class = "col-sm-2"><b>Dato</b></div>
        <div class = "col-sm-3"><b>Trener ID</b></div>
        <div class = "col-sm3"><b>Godkjent</b></div>
    </div>
    <hr/>
    <%
        ArrayList<Klubb> testListe = (ArrayList<Klubb>) request.getAttribute("klubbListe");
        for(int i = 0; i < testListe.size(); i++) {
    %>
    <div class = "row">
        <div class = "col-sm-3" ><div class = "rowFirst"><%=testListe.get(i).getTest_id()%></div></div>
        <div class = "col-sm-4" ><%=testListe.get(i).getKlubb_id()%></div>
        <div class = "col-sm-2" ><%=testListe.get(i).getDato()%></div>
        <div class = "col-sm-3" ><%=testListe.get(i).getTrener_id()%></div>
        <div class = "col-sm-3" ><%=testListe.get(i).getGodkjent()%></div>
    </div>
    <%
        }
    %>
</div>
</body>