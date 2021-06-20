<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <style>
        body{
            background-image: url("gras.png");
        }

        #car {
            width: 200px;
            height: 150px;
            background-image: url("princessCar.png");
            background-repeat: no-repeat;
        }

        #carPark {
            width: 810px;
            height: 540px;
            background-image: url("pinkCastle.png");
            background-repeat: no-repeat;
            margin: auto;
            display: block;
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
    <div id="car"></div>
    <div id="carPark"></div>

    <form action="carParkServlet" method="POST" name="form">
        <input type="submit" name="skipGame" value="Ohne Spiel zum Parkhaus" />
    </form>
</body>
</html>