<!DOCTYPE html>
<html lang="en">
<head>
    <title>Utover homepage</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../UtoverDash/style.css">
</head>
<body>
    <div class = "container">
        <h1> <%= request.getAttribute("WelcomeMessage") %> </h1>
        <div class = "row">
            <div class = "col-sm" >
                <a href = "../UtoverDash/Resultater">
                    <div class = "knapp">
                        <div class = "knappbilde" id = "resultater"><img src = "../UtoverDash/Ikoner/resultat.png"></div>
                        Resultater
                    </div>
                </a>
            </div>

            <div class = "col-sm" >
                <a href = "MinProfil">
                    <div class = "knapp">
                        <div class = "knappbilde" id = "minprofil"> <img src = "../UtoverDash/Ikoner/person.png"></div>
                        Min profil
                    </div>
                </a>
            </div>
        </div>
    </div>
    <footer>
        <div class = "container">
            <div class = "row">
                <div class = "col-sm">10.02.2020</div>
                <div class = "col-sm">23.01.2020</div>
                <div class = "col-sm">18.01.2020</div>
            </div>
            <div class="row">
                <div class = "col-sm">Placeholder</div>
                <div class = "col-sm">Placeholder</div>
                <div class = "col-sm">Placeholder</div>
            </div>
        </div>
    </footer>
</body>