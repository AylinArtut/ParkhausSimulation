package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Car{
    String enterTime;
    String leaveTime;


    public Car(){

    }

    public String enterCarPark(){
        // Saving the date & time, when the car entered the car park:
        this.enterTime = getTimeStamp();
        return enterTime;
    }

    public String leaveCarPark() {
        // Saving the date & time, when the car wants to leave the car park:
        this.leaveTime = getTimeStamp();

        // Calculating how long the car was parked in the car park: leaveTime - enterTime (in hours)

        // Calculating the price, the driver has to pay for parking due to parking duration: pricePerHour + (leaveTime - enterTime)

        return leaveTime;
    }

    public String getTimeStamp(){
        return new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
    }
}