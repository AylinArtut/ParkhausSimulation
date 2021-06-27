<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="index.css">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="index.js" async></script>
</head>
<body>
    <h1 id="princessParkhouse">Ein für Frauen konzipiertes Parkhäusschen ❤</h1>
    <p id="description">
        Helfen Sie der Dame unfallfrei zum schlossartigen Parkhaus zu gelangen
        indem Sie ihr Auto per Drag & Drop drüber ziehen.
    </p>

    <audio controls autoplay hidden id="audio">
        <source src="Music/SNES_Super_Mario_Kart.mp3" type="audio/ogg">
    </audio>

    <div id="background">
        <div id="car">
            <img src="Images/princessCar.png">
        </div>
        <div id="carPark">
            <img src="Images/pinkCastle.png">
        </div>
    </div>

    <form action="carParkServlet" method="POST" name="form" id="form">
        <input type="submit" name="skipGame" id="skipGame" value="Ohne Spiel zum Parkhaus" />
    </form>
</body>
</html>