<%@ page import="de.parkhaus.SoftwareEngineeringI_Parkhaus.CarPark" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <link rel="stylesheet" href="Style.css">
    <title> Parkhaus Simulation </title>
</head>
<body>
    <h1> Das Traum-Parkhaus! ♡ </h1>
    <br/>
    <form action="carParkServlet" method="POST">
        <input type="submit" name="spawnCar" value="Spawn Car & in Parkhaus reinstopfen"/>
        <input type="submit" name="kickCar" value="Car aus Parkhaus rausschmeißen"/>
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
    <h1> <%= request.getAttribute("information") %> </h1>
    <table>
        <tr>
            <th> Auto, Nr. </th>
            <th> Kennzeichen </th>
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
                <td> <%= carPark.leftCars[i].getRegistrationNumber() %> </td>
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