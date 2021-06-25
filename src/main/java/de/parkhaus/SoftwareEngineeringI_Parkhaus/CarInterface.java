package de.parkhaus.SoftwareEngineeringI_Parkhaus;
import java.sql.Timestamp;

public interface CarInterface {
    public String getRegistrationNumber();
    public Timestamp getEnterTime();
    public Timestamp getLeaveTime();
    public String getCarColor();
    public double getPrice();
    public void setEnterTime(Timestamp enterTime);
    public void setLeaveTime(Timestamp leaveTime);
    public void setPrice(double price);
    public void setRegistrationNumber(String registrationNumber);
    public void setCarColor(String carColor);
    public String formatDate(Timestamp timeStamp);
}