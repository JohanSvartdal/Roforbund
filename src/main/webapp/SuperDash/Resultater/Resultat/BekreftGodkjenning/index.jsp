<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.OvelsesResultat" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Resultat - <%= request.getAttribute("Dato")%></title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../../style.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String godkjentStatus = (String) request.getAttribute("GodkjentStatus");
%>
<div class =  "titleBar">
    <div class = "backButton">
        <a href = "../">
            <img src = "../../../../images/ikoner/back_button.png">
            <h3>Resultater</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "../../../../images/ikoner/blokk.png">
        <h1> <%=request.getAttribute("Dato")%></h1>
    </div>
</div>
<div class="container">
    <%
        if (godkjentStatus.equals("GodkjenningKlar")) {
    %>
    <center>
        <div class="resultButton" id = "godkjennKnapp">
            Godkjenn
        </div>
        <br/>
        <div class="resultButton" id = "avvisKnapp">
            Ikke godkjenn
        </div>
    </center>
    <%
        }
    %>
</div>
</body>