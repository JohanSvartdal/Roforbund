<%@ page import="java.util.ArrayList" %>
<%@ page import="servlets.Ovelse" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>OpprettTest homepage</title>
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
        <img src = "../../images/ikoner/klokke.png">
        <h1>Opprett ny test</h1>
    </div>
</div>

    <div class="container">
        <h1>Velg øvelser:</h1>

        <div class = "row">
            <div class = "col-sm-6"><b>Øvelse:</b></div>
            <div class = "col-sm-6"><b>Velg:</b></div>
        </div>
        <%ArrayList<Ovelse> ovelseList = (ArrayList<Ovelse>) request.getAttribute("ovelseList");
            for(int i = 0; i < ovelseList.size(); i++) {     %>

        <div class = "row">
            <div class = "col-sm-6" ><%=ovelseList.get(i).getOvelseNavn()%></div>
            <div class = "col-sm-6" ><input class = "possibleOvelseCheckBox" id = "<%=ovelseList.get(i).getOvelseID()%>" type = "checkbox"></div>
        </div>
        <%}%>
    </div>

    <footer>
        <div class = "footerButton" id ="footerLeft">
            <img src = "../../images/ikoner/back_button.png">
            <h2>Tilbake</h2>
        </div>
        <div class = "footerButton" id ="footerRight">
            <img src = "../../images/ikoner/forward_button.png">

            <h2>Start test</h2>
            <!--
            <form action='RegTestResult' method='POST'>
                <button type="submit">

                </button>
            </form>
            -->

        </div>
    </footer>
    <script src = "javascript.js" type="text/javascript"></script>
</body>
