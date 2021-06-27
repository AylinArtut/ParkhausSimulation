<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <style>
        body{
            background-color: #f2f2f2;
        }

        #car{
            width: 100px;
            height: 150px;
            background-repeat: no-repeat;
            position: relative;
            left: 20px;
            top: 300px;
        }

        #carPark{
            width: auto;
            height: 540px;
            background-repeat: no-repeat;
            float: right;
            margin-right: 100px;
            margin-top: 89px;
        }

        #background{
            width: 1260px;
            height: 571px;
            background-image: url("Images/div-background.jpg");
            margin-bottom: 30px;
            margin-left: 51px;
            margin-top: 30px;
        }

        #form{
            margin-left: 50px;
        }

        #skipGame{
            width: 215px;
            height: 38px;
            font-weight: bold;
            font-size: 15px
        }

        #audio{
            margin-left: 50px;
            margin-top: 20px;
        }

        #princessParkhouse{
            margin-top: 20px;
            margin-left: 50px;
            color: #d27892;
            font-weight: bold;
        }

        #description{
            margin-top: 20px;
            margin-left: 50px;
            font-weight: bold;
            font-size: 21px;
        }
    </style>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#car" ).draggable();
            $( "#carPark" ).droppable({
                drop: function( event, ui ) {
                    $( this )
                    $('form').submit();
                }
            });
        } );
    </script>
</head>
<body>
    <h1 id="princessParkhouse">Ein für Frauen konzipiertes Parkhäusschen ❤</h1>
    <p id="description">
        Helfen Sie der Dame unfallfrei zum schlossartigen Parkhaus zu gelangen
        indem Sie ihr Auto per Drag & Drop drüber ziehen.
    </p>

    <audio controls autoplay id="audio">
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