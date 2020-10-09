<!DOCTYPE html>
<html lang="en">
<head>
    <title>Superuser homepage</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" integrity="sha384-JcKb8q3iqJ61gNV9KGb8thSsNjpSL0n8PARn9HuZOnIxN0hoP+VmmDGMN5t9UJ0Z" crossorigin="anonymous">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="../SuperDash/style.css">
</head>
<body>
    <div class = "container">
        <h1> <%= request.getAttribute("WelcomeMessage") %> </h1>
        <div class = "row">
            <div class = "col-sm" >
                <a href = "linkTilSiden">
                    <div class = "knapp">
                        <div class = "knappbilde" id = "adminklubber"> <img src = "../SuperDash/Ikoner/resultat.png"></div>
                        Administrere klubber
                    </div>
                </a>
            </div>
            <div class = "col-sm" >
                <a href = "linkTilSiden">
                    <div class = "knapp">
                        <div class = "knappbilde" id = "godkjenneresults"> <img src = "../SuperDash/Ikoner/resultat.png"></div>
                        Godkjenne resultater
                    </div>
                </a>
            </div>
            <div class = "col-sm" >
                <a href = "linkTilSiden">
                    <div class = "knapp">
                        <div class = "knappbilde" id = "minprofil"> <img src = "../SuperDash/Ikoner/resultat.png"></div>
                        Min profil
                    </div>
                </a>
            </div>
        </div>
    </div>
    <footer>
        <div class = "container">
            <div class = "row">
                <div class = "col-sm" > Hei </div>
                <div class = "col-sm" > Hei </div>
                <div class = "col-sm" > Hei </div>
            </div>
        </div>
    </footer>
</body>