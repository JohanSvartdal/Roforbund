<!DOCTYPE html>
<html lang="en">
<head>
    <title>Administrer klubber</title>
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
    <div class = "backButton">
        <a href = "../">
            <img src = "../../../images/ikoner/back_button.png">
            <h3>Administrer klubber</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "">
        <h1>Innstillinger for klubb</h1>
    </div>
</div>

<div class="container">
    <h1>Arendal roklubb (placeholder)</h1>
    <center><hr/></center>

    <div class = "centerObjects">
        <a href = "">
            <div class="resultButton" id = "klubbInfo">
                Administrer klubb informasjon
            </div>
        </a>
        <a href = "">
            <div class="resultButton" id = "adminTrenere">
                Administrer trenere
            </div>
        </a>
        <a href = "AdminUtovere?klubbID=<%=request.getParameter("klubbID")%>">
            <div class="resultButton" id = "adminUtovere">
                Administrer utøvere
            </div>
        </a>
    </div>
</div>
</body>