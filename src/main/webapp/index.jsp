<%@ page import="de.parkhaus.SoftwareEngineeringI_Parkhaus.Car" %>
<%@ page import="de.parkhaus.SoftwareEngineeringI_Parkhaus.CarPark" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>

    <title>Parkhaus Simulation</title>

    <style>
        .parkingSlot{
            margin-top: 15px;
            margin-left: 10px;
            background-color: lightgray;
            height: 140px;
            width: 110px;
            border: 2px solid black;
            display: inline-block;
        }

        .car{
            visibility: hidden;
            margin-top: 24px;
            margin-left: 20px;
            height: 85px;
            width: 60px;
            border: 2px solid black;
            border-radius: 25px;
        }

        #test{
            padding-left: 8px;
            padding-top: 30px;
            padding-bottom: 30px;
            font-size: 25px;
        }
    </style>

</head>
<body>

    <h1> Das Traum-Parkhaus! ♡ </h1>
    <br/>

    <form action="index.jsp" method="get">
        <input type="submit" name="spawnCar" value="Spawn Car & in Parkhaus reinstopfen" />
        <input type="submit" name="kickCar" value="Car aus Parkhaus rausschmeißen" />
    </form>

    <%
        Car car = new Car();
        CarPark carPark = new CarPark("TraumParkhaus", 10, 0);

        for(int i = 0; i < CarPark.parkingSlots.length; i++){
    %>

     <div class="parkingSlot"> <div class="car" id="<%="car" + i%>"> </div> </div>

    <%
        }

        if (request.getParameter("kickCar") != null) {
    %>
    <h1> <%= carPark.leaveCarPark(car) %> </h1>
    <%
        }

        if (request.getParameter("spawnCar") != null) {
    %>

            <div id="test"> <%= carPark.putCarToCarPark(car) %> </div>

    <%
        }
    %>

    <%
        for(int j = 0; j < CarPark.parkingSlots.length; j++){
            if(CarPark.parkingSlots[j] != null){
    %>

    <style>
        #car<%=j%>{
            visibility: visible;
            background-color: <%= CarPark.parkingSlots[j].carColor %>;
        }
    </style>

    <%
            }else{
    %>
    <style>
        #car<%=j%>{
            visibility: hidden;
        }
    </style>
    <%
            }
        }
        %>

</body>
</html>