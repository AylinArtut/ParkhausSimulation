package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

// A helper class:
public class CarHelper {
    // This method to format date doesn't belong logically to any class, so I've decided to put it here:
    public static String formatDate(Timestamp timeStamp){
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd.MM.yy, HH:mm");
        return sdf3.format(timeStamp);
    }
}