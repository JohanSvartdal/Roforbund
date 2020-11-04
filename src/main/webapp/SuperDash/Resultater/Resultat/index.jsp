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
    <link rel="stylesheet" href="../../../style.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<%
    String godkjentStatus = (String) request.getAttribute("GodkjentStatus");
%>
<div class =  "titleBar">
    <div class = "backButton">
        <a href = "../">
            <img src = "../../../images/ikoner/back_button.png">
            <h3>Resultater</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "../../../images/ikoner/blokk.png">
        <h1> <%=request.getAttribute("Dato")%></h1>
    </div>
</div>
<div class="container">
    <%
        ArrayList<OvelsesResultat> ovelsesResultatList = (ArrayList<OvelsesResultat>) request.getAttribute("ovelsesresultatlist");
        for(int i = 0; i < ovelsesResultatList.size(); i++) {
    %>
    <h2><%= ovelsesResultatList.get(i).getOvelsesNavn()%></h2>
    <div class="ovelsesBox <%=godkjentStatus%>">
        <div class = "row">
            <div class = "col-sm"><b>Navn</b></div>

            <% if (ovelsesResultatList.get(i).getResultater().get(0).getTid() != 0) {%>
            <div class = "col-sm"><b>Tid</b></div>
            <% } %>

            <% if (ovelsesResultatList.get(i).getResultater().get(0).getWatt() != 0) {%>
            <div class = "col-sm"><b>Watt</b></div>
            <% } %>

            <% if (ovelsesResultatList.get(i).getResultater().get(0).getRepetisjoner() != 0) {%>
            <div class = "col-sm"><b>Rep</b></div>
            <% } %>

            <% if (ovelsesResultatList.get(i).getResultater().get(0).getKg() != 0) {%>
            <div class = "col-sm"><b>KG</b></div>
            <% } %>

            <div class = "col-sm"><b>Notater</b></div>
        </div>
        <hr/>

        <% for (int b = 0; b < ovelsesResultatList.get(i).getResultater().size(); b++) {%>


        <div class = "row listRow">
            <div class = "col-sm" ><div class = "rowFirst"><%= ovelsesResultatList.get(i).getResultater().get(b).getBrukerNavn()%></div></div>

            <% if (ovelsesResultatList.get(i).getResultater().get(0).getTid() != 0) {%>
            <div class = "col-sm"><%= ovelsesResultatList.get(i).getResultater().get(b).getTid()%></div>
            <% } %>

            <% if (ovelsesResultatList.get(i).getResultater().get(0).getWatt() != 0) {%>
            <div class = "col-sm"><%= ovelsesResultatList.get(i).getResultater().get(b).getWatt()%></div>
            <% } %>

            <% if (ovelsesResultatList.get(i).getResultater().get(0).getRepetisjoner() != 0) {%>
            <div class = "col-sm"><%= ovelsesResultatList.get(i).getResultater().get(b).getRepetisjoner()%></div>
            <% } %>

            <% if (ovelsesResultatList.get(i).getResultater().get(0).getKg() != 0) {%>
            <div class = "col-sm"><%= ovelsesResultatList.get(i).getResultater().get(b).getKg()%></div>
            <% } %>

            <div class = "col-sm" ><%= ovelsesResultatList.get(i).getResultater().get(b).getTestID()%></div>
        </div>
        <%
        }
        %>
    </div>
    <%
        }
    %>

    <%
        if (godkjentStatus.equals("GodkjenningKlar")) {

    %>
    <center>
        <a href = "BekreftGodkjenning?testID=<%=request.getAttribute("TestID")%>&godkjenne=ja">
            <div class="bigButton" id = "godkjennKnapp">
                Godkjenn
            </div>
        </a>
        <br/>
        <a href = "AvvisGodkjenning?testID=<%=request.getAttribute("TestID")%>">
            <div class="bigButton" id = "avvisKnapp">
                Ikke godkjenn
            </div>
        </a>
    </center>
    <%
        }
    %>
</div>
</body>