<%@ page import="de.parkhaus.SoftwareEngineeringI_Parkhaus.CarPark" %>
<%@ page import="de.parkhaus.SoftwareEngineeringI_Parkhaus.CarHelper" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<html>
<head>
    <link rel="stylesheet" href="CarPark.css">
    <title> Parkhaus Simulation </title>
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
        <div class="car" id="<%= "car" + i %>"></div>
    </div>
    <%
        }
    %>
    <div id="information">
        <ul>
            <li> Steigender Preis pro Sekunde </li>
            <li> Maximale Parkgebühr beträgt 25 € (Bezahlung erfolgt automatisch) </li>
            <li> Beim direkten Verlassen muss man nichts bezahlen </li>
        </ul>
    </div>
    <h2 id="information"> <%= request.getAttribute("information") %> </h2>
    <table>
        <tr>
            <th> Auto, Nr. </th>
            <th> Kennzeichen </th>
            <th> Preis </th>
            <th> Einfahrtszeit </th>
            <th> Ausfahrtszeit </th>
        </tr>
    <%
        carPark = ((CarPark) request.getAttribute("carPark"));
        for(int i = 0; i < carPark.leftCarSize; i++){
    %>
            <tr>
                <td> <%= i+1 %> </td>
                <td> <%= carPark.leftCars[i].getRegistrationNumber() %> </td>
                <td> <%= carPark.leftCars[i].getPrice() %> € </td>
                <td> <%= CarHelper.formatDate(carPark.leftCars[i].getEnterTime()) %> Uhr </td>
                <td> <%= CarHelper.formatDate(carPark.leftCars[i].getLeaveTime()) %> Uhr </td>
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