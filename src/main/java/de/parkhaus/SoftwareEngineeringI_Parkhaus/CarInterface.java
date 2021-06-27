package de.parkhaus.SoftwareEngineeringI_Parkhaus;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

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
    public static String formatDate(Timestamp timeStamp){
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yy, HH:mm");
        return sdf3.format(timeStamp);
    }
}