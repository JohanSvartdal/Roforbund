<!DOCTYPE html>
<html lang="en">
<head>
    <title>Ny <%=request.getAttribute("rolestring")%></title>
    <meta charset="UTF-8">
    <%@ page contentType="text/html; charset=UTF-8" %>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../../../../../style.css">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
<div class =  "titleBar">
    <div class = "backButton">
        <a href = "../?klubbID=<%=request.getParameter("klubbID")%>&role=<%=request.getParameter("role")%>">
            <img src = "../../../../../images/ikoner/back_button.png">
            <h3>Administrer <%=request.getAttribute("rolestring")%>e</h3>
        </a>
    </div>
    <div class="centerObjects">
        <img src = "">
        <h1>Legg til ny <%=request.getAttribute("rolestring")%></h1>
    </div>
</div>
<form action="../NyBruker/" method="post">
    <div class="container">
        <h1>Fyll inn <b>informasjonen</b> om <%=request.getAttribute("rolestring")%>en her</h1>
        <center><hr/></center>

        <div class="fieldContainers">
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "fornavn">Fornavn:</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "fornavn" id = "fornavn" class="textField" placeholder="Ola" value="<%=request.getAttribute("Fornavn")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "etternavn">Etternavn:</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "etternavn" id = "etternavn" class="textField" placeholder="Nordmann" value="<%=request.getAttribute("Etternavn")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "fodselsdato">Fødselsdato (dd.mm.åååå):</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "fodselsdato" id = "fodselsdato" class="textField" placeholder="dd.mm.åååå" value="<%=request.getAttribute("Fodseldato")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "tlf">Telefon</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "tlf" id = "tlf" class="textField" placeholder="40640382" value="<%=request.getAttribute("Tlf")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "email">E-post</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "email" id = "email" class="textField" placeholder="ola.nordmann@gmail.com" value="<%=request.getAttribute("Epost")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "gatenavn">Gatenavn</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "gatenavn" id = "gatenavn" class="textField" placeholder="Abborveien" value="<%=request.getAttribute("Gatenavn")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "husnummer">Husnummer:</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "husnummer" id = "husnummer" class="textField smallText" placeholder="29" value="<%=request.getAttribute("Husnummer")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "postnummer">Postnummer:</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "postnummer" id = "postnummer" class="textField smallText" placeholder="3298" value="<%=request.getAttribute("Postnummer")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "poststed">Poststed:</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "poststed" id = "poststed" class="textField" placeholder="Stenseth" value="<%=request.getAttribute("Poststed")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "hoyde">Høyde (cm):</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "hoyde" id = "hoyde" class="textField smallText" placeholder="183" value="<%=request.getAttribute("Hoyde")%>"/>
                </div>
            </div>
            <div class = "row">
                <div class = "col-sm-4">
                    <label for = "vekt">Vekt:</label>
                </div>
                <div class = "col-sm-8">
                    <input type = "text" name = "vekt" id = "vekt" class="textField smallText" placeholder="83" value="<%=request.getAttribute("Vekt")%>"/>
                </div>
            </div>
            <br/>
            <center>
                <div class = "bigButton" id ="deleteButton">
                    Slett brukeren
                </div>
            </center>
            <input type="text" name="role" value="<%=request.getParameter("role")%>" class="hidden">
            <input type="text" name="klubbID" value="<%=request.getParameter("klubbID")%>" class="hidden">
            <input type="text" name="brukerID" value="<%=request.getParameter("brukerID")%>" class="hidden">
            <%
                if (request.getAttribute("errormessage") != null) {
            %>
            <div class="errorMessage">
                <p><%=request.getAttribute("errormessage")%></p>
            </div>
            <%
                }
            %>
        </div>
    </div>

    <footer>
        <a href = "../">
            <div class = "footerButton" id ="footerLeft">
                <img src = "../../../../../images/ikoner/back_button.png">
                <h2>Gå tilbake</h2>
            </div>
        </a>

        <input type = "submit" class = "footerButton" id ="footerRight" value="Opprett <%=request.getAttribute("rolestring")%>"/>

        <script src = "javascript.js" type="text/javascript"></script>
    </footer>
</form>
</body>