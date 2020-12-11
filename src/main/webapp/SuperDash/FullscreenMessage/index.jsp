<%@ page import="java.util.ArrayList" %>
<%@ page import="models.bruker.Trener" %>
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
    <div class="centerObjects">
        <img src = "">
        <h1>Fullført</h1>
    </div>
</div>

<div class="container">
    <center>
        <h1><%=request.getAttribute("doneMessage")%></h1>
        <hr/>
    </center>
    <h3></h3>
    <center>
        <a href = "../../SuperDash"><div class = "footerButton">Ferdig</div></a>
    </center>
</div>
<footer>

</footer>
</body>