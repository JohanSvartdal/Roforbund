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
    </div>
        <div class = "row">
            <div class = "col-sm-3"><b>Øvelse:</b></div>
            <div class = "col-sm-3"><b>Velg:</b></div>
        </div>
            <%ArrayList<Ovelse> ovelseList = (ArrayList<Ovelse>) request.getAttribute("ovelseList");
                for(int i = 0; i < ovelseList.size(); i++) {     %>

                    <div class = "row">
                         <div class = "col-sm-3" ><%=ovelseList.get(i).getOvelseNavn()%></div>
                         <div class = "col-sm-3" ><input type = "checkbox"></div>
                    </div>
                <%}%>
            <footer>
                <a href ="../OpprettTest">
                    <div class = "footerButton" id ="footerLeft">
                        <img src = "../../images/ikoner/back_button.png">
                        <h2>Tilbake</h2>
                    </div> </a>
                <a href = "../HentOvelse/RegTestResult">
                <div class = "footerButton" id ="footerRight">
                    <img src = "../../images/ikoner/forward_button.png">
                    <h2>Gå til test</h2>
                </div> </a>
            </footer>
</body>
