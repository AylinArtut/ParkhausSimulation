<%@ page import="de.parkhaus.SoftwareEngineeringI_Parkhaus.CarPark" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="Style.css">
    <title> Parkhaus Simulation </title>
    <style>
        body{
            background-color: #ffe4e14d;
        }

        #information{
            margin-left: 10px;
        }

        #information{
            margin-left: 10px;
        }

        #spawnCar, #kickCar{
            margin-left: 10px;
            margin-top: 10px;
            width: 140px;
            height: 38px;
            font-weight: bold;
            font-size: 15px
        }

        table{
            margin-left: 10px;
            width: 1267px;
            background-color: white;
        }

        td, th{
            text-align: center;
        }
    </style>
</head>
<body>
    <form action="carParkServlet" method="POST">
        <input type="submit" name="spawnCar" id="spawnCar" value="Auto reinlassen"/>
        <input type="submit" name="kickCar" id="kickCar" value="Auto rauslassen"/>
    </form>
    <%
        CarPark carPark = ((CarPark) request.getAttribute("carPark"));
        for(int i = 0; i < carPark.parkingSlots.length; i++){
    %>
    <div class="parkingSlot">
        <div class="car" id="<%="car" + i%>"></div>
    </div>
    <%
        }
    %>
    <h2 id="information"> <%= request.getAttribute("information") %> </h2>
    <table>
        <tr>
            <th> Auto, Nr. </th>
            <th> Preis </th>
            <th> EnterTime </th>
            <th> LeaveTime </th>
        </tr>
    <%
        carPark = ((CarPark) request.getAttribute("carPark"));
        for(int i = 0; i < carPark.leftCarSize; i++){
    %>
            <tr>
                <td> <%= i+1 %> </td>
                <td> <%= carPark.leftCars[i].getPrice() %> </td>
                <td> <%= carPark.leftCars[i].getEnterTime() %> </td>
                <td> <%= carPark.leftCars[i].getLeaveTime() %> </td>
            </tr>
    <%
        }
    %>
    </table>
    <%
    for(int j = 0; j < carPark.parkingSlots.length; j++){
        if(carPark.parkingSlots[j] != null){
    %>
    <style>
        #car<%= j %>{
            visibility: visible;
            background-color: <%= carPark.parkingSlots[j].getCarColor() %>;
        }
    </style>
    <%
        }else{
    %>
    <style>
        #car<%= j %>{
            visibility: hidden;
        }
    </style>
    <%
            }
        }
    %>
</body>
</html>