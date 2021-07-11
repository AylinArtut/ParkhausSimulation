package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;

// Interface for my "Car" class:
public interface ICar {
    public String getCarColor();
    public String getRegistrationNumber();

    public Timestamp getEnterTime();
    public Timestamp getLeaveTime();

    public double getPrice();

    public void setRegistrationNumber(String registrationNumber);
    public void setCarColor(String carColor);

    public void setEnterTime(Timestamp enterTime);
    public void setLeaveTime(Timestamp leaveTime);

    public void setPrice(double price);
}