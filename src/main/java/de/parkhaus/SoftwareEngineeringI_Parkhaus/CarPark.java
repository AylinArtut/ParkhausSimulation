package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.util.Random;

public class CarPark{

    public String carParkName;

    public Car[] parkingSlots;

    public Random number = new Random();
    public int value;

    double pricePerHour = 1.0;

    public int parkedCars;

    public CarPark(String carParkName, int parkingSlotSizes, double pricePerHour){
        this.carParkName = carParkName;
        this.pricePerHour = pricePerHour;

        parkingSlots = new Car[parkingSlotSizes];
    }

    private Timestamp setTimeStamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    private void parkingCar(Car car){
         do{
             if(parkedCars < parkingSlots.length) {
                 this.value = number.nextInt(parkingSlots.length);
             }else{
                 break;
             }
         }while(parkingSlots[this.value] != null);

        if((parkedCars < parkingSlots.length) && (parkingSlots[this.value] == null)){
            parkingSlots[this.value] = car;
            parkingSlots[this.value].enterTime = setTimeStamp();
            parkedCars += 1;
        }
    }

    public String putCarToCarPark(Car car){
        parkingCar(car);

        car.setCarColor();

        if(parkedCars == parkingSlots.length){
            return "Im Parkhaus sind nun: " + parkedCars + " Autos. LIMIT IST ERREICHT; GEH ANDERES PARKHAUS SUCHEN!";
        }else{
            return "Im Parkhaus sind nun: " + parkedCars + " Autos.";
        }
    }

    public String leaveCarPark(){
        do{
            if(parkedCars >= 1) {
                this.value = number.nextInt(parkingSlots.length);
            }else{
                break;
            }
        }while(parkingSlots[this.value] == null);

        if(parkingSlots[this.value] != null){
            parkedCars -= 1;
            parkingSlots[this.value] = null;
        }

        return "Im Parkhaus sind nun: " + parkedCars + " Autos.";
    }
}