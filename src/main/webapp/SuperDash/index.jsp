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
        <h1> <% = request.getAttribute("WelcomeMessage") %> </h1>
            <input type = "submit" id = "klubbBox" class = "smallButton" value = "Administrere klubber"/>
        </form>
    </div>
    
</body>
</html>
