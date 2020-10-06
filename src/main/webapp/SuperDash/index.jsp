<!DOCTYPE html>
<html lang="en">
<head>
    <title>Superuser homepage</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../style.css">
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <div id = "loginBox">
        <h1> <%= request.getAttribute("WelcomeMessage") %> </h1>
        <a href = "linkTilSiden">
            <div class = "knapp" id = "adminklubber">
                <div class = "knappbilde"> <img src = "Ikoner/Hus.jpg"></div>
                Administrere klubber
            </div>

        </a>


        <a href = "linkTilSiden">
            <div class = "knapp" id = "adminutøvere">
                <div class = "knappbilde"> <img src = "Ikoner/Hus.jpg"></div>
                Administrere utovere
            </div>

        </a>


        <a href = "linkTilSiden">
            <div class = "knapp" id = "godkjenneresults">
                <div class = "knappbilde"> <img src = "Ikoner/Hus.jpg"></div>
                Godkjenne resultater
            </div>

        </a>
    </div>
    
</body>
</html>
