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

        table {
            width:100%;
        }
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
        th, td {
            padding: 15px;
            text-align: left;
        }
    </style>

</head>
<body>

<h1> Das Traum-Parkhaus! ♡ </h1>
<br/>

<form action="carParkServlet" method="POST">
    <input type="submit" name="spawnCar" value="Spawn Car & in Parkhaus reinstopfen" />
    <input type="submit" name="kickCar" value="Car aus Parkhaus rausschmeißen" />
</form>

<%
    CarPark carPark = ((CarPark) request.getAttribute("carPark"));

    for(int i = 0; i < carPark.parkingSlots.length; i++){
%>
<div class="parkingSlot"> <div class="car" id="<%="car" + i%>"> </div> </div>
<%
    }
%>

<h1> <%= request.getAttribute("information") %> </h1>

<table>
    <tr>
        <th>Auto, Nr.</th>
        <th>Preis</th>
        <th>EnterTime</th>
        <th>LeaveTime</th>
    </tr>
<%
        carPark = ((CarPark) request.getAttribute("carPark"));
        for(int i = 0; i < carPark.leftCarSize; i++){
%>
    <tr>
            <td><%= i %></td>
            <td><%= carPark.leftCars[i].price %></td>
            <td><%= carPark.leftCars[i].enterTime %></td>
            <td><%= carPark.leftCars[i].leaveTime %></td>
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
    #car<%=j%>{
        visibility: visible;
        background-color: <%= carPark.parkingSlots[j].carColor %>;
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