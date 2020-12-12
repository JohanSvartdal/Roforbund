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
<form action='' method='POST'>
    <div class="container">
        <%System.out.println("Nå skal jeg hente");%>
        <h1> Legge inn resultater til <b>øvelse <%=(int)request.getAttribute("currentOvelseIndex") + 1%></b> - <%=request.getAttribute("currentOvelsesNavn")%></h1>
        <div class = "row">
            <div class = "col-sm-3"><b>Navn:</b></div>
            <div class = "col-sm-2"><b>Watt:</b></div>
            <div class = "col-sm-2"><b>Tid:</b></div>
            <div class = "col-sm-3"><b>Notater:</b></div>
        </div>
        <%
            String[] brukerIDs = (String[]) request.getAttribute("brukerIDs");
            String[] brukerNavn = (String[]) request.getAttribute("brukerNavn");
            for (int i = 0; i < brukerNavn.length; i++) {
        %>
        <div class = "row">
            <div class = "col-sm-4"><%=brukerNavn[i]%></div>
            <div class = "col-sm-2"><input name="<%=brukerIDs[i]%>Watt" type = "number" class="textField" value="456"/></div>
            <div class = "col-sm-2"><input name="<%=brukerIDs[i]%>Tid" type = "number" class="textField" value="13"/></div>
            <div class = "col-sm-3"><input name="<%=brukerIDs[i]%>Notater" type = "text" class="textField" value="Vonde knær."/></div>
        </div>
        <%}%>
    </div>
    <input type = "text" name="brukereTilStede" value="<%=request.getParameter("brukereTilStede")%>" class="hidden">
    <input type = "text" name = "ovelserValgt" value="<%=request.getParameter("ovelserValgt")%>" class="hidden">
    <input type = "number" name = "currentOvelseIndex" value="<%=request.getAttribute("currentOvelseIndex")%>" class="hidden">
    <input type = "number" name = "testID" value="<%=request.getAttribute("testID")%>" class="hidden">
    <footer>
        <a href = "../../">
            <div class = "footerButton" id ="footerLeft">
                <img src = "../../../images/ikoner/avbryt.png">
                <h2>Avbryt test</h2>
            </div>
        </a>
        <div class = "footerButton" id ="footerRight">
            <img src = "../../../images/ikoner/forward_button.png">
            <input type="submit" value = "<%=request.getAttribute("nesteKnapp")%>"/>
        </div>
    </footer>
</form>
</body>