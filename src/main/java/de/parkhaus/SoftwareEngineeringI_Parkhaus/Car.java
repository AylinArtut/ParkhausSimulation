package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.util.Random;

public class Car{
    public Timestamp enterTime;
    public Timestamp leaveTime;

    public String carColor;

    public Car(){
        setCarColor();
    }

    public String setCarColor(){
        Random obj = new Random();
        this.carColor = String.format("#%06x", obj.nextInt(0xffffff + 1));
        return this.carColor;
    }
}