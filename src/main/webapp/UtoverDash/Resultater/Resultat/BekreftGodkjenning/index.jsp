<%
    String godkjentStatus = (String) request.getAttribute("GodkjentStatus");
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><%=godkjentStatus%></title>
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
        <a href = "../../">
            <img src = "../../../../images/ikoner/back_button.png">
            <h3>Resultater</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "../../../../images/ikoner/blokk.png">
        <h1> <%=godkjentStatus%></h1>
    </div>
</div>
<div class="container">
    <center>
        <h2>Testen er markert som <b class = "<%=godkjentStatus%>"><%=godkjentStatus%></b></h2>
        <br/>
        <p>
            Treneren vil få varsel på sin side om at testen er <%=godkjentStatus%>
        </p>
        <br/>
        <div class="buttonHolder">
            <a href = "../../">
                <div class="bigButton" id = "avvisKnapp">
                    Gå tilbake til alle resultater
                </div>
            </a>
            <a href = "../../../Resultater?mode=1">
                <div class="bigButton" id = "godkjennKnapp">
                    Godkjenn flere resultater
                </div>
            </a>
        </div>
    </center>

</div>
</body>