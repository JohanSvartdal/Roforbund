<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.Klubb" %>
<%@ page import="servlets.Utover" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Administrer klubber</title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../../style.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class =  "titleBar">
    <div class = "backButton">
        <a href = "../?klubbID=<%=request.getParameter("klubbID")%>">
            <img src = "../../../../images/ikoner/back_button.png">
            <h3>Administrer klubben</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "../../../../images/ikoner/hus.png">
        <h1>Administrer <%=request.getAttribute("rolestring")%></h1>
    </div>
</div>

<a href = "NyBruker?role=<%=request.getParameter("role")%>&klubbID=<%=request.getParameter("klubbID")%>">
    <div class = "sideButton" id = "addKlubb">
        <img src = "../../../../images/ikoner/add_button.png">
        <b>Legg til</b> ny <%=request.getAttribute("rolestring")%>
    </div>
</a>

<div class = "sideButton" id = "removeKlubb">
    <b>Fjern</b> eksisterende <%=request.getAttribute("rolestring")%>
    <img src = "../../../../images/ikoner/remove_button.png">
</div>

<div class = "container">
    <center>
        <div class = "searchBar">
            <label for="sokefelt">Søk etter <%=request.getAttribute("rolestring")%>:</label>
            <input type="text" placeholder="Søk" id = "sokefelt"/>
        </div>
    </center>
    <div class = "row">
        <div class = "col-sm-3"><b>Navn</b></div>
        <div class = "col-sm-4"><b>Epost</b></div>
        <div class = "col-sm-2"><b>Telefon</b></div>
        <div class = "col-sm-3"><b>Klasse</b></div>
    </div>
    <hr/>
    <%
        ArrayList<Utover> utoverListe = (ArrayList<Utover>) request.getAttribute("utoverListe");
        for(int i = 0; i < utoverListe.size(); i++) {
    %>
    <div class = "row listRow">
        <div class = "col-sm-3" ><div class = "rowFirst"><a href = "NyBruker?role=<%=request.getParameter("role")%>&klubbID=<%=request.getParameter("klubbID")%>&brukerID=<%=utoverListe.get(i).getBrukerID()%>"><%=utoverListe.get(i).getFornavn() + " " + utoverListe.get(i).getEtternavn()%></a></div></div>
        <div class = "col-sm-4" ><%=utoverListe.get(i).getEpost()%></div>
        <div class = "col-sm-2" ><%=utoverListe.get(i).getTlf()%></div>
        <div class = "col-sm-3" ><%=utoverListe.get(i).getKlasseNavn()%></div>
    </div>
    <%
        }
    %>
</div>
</body>