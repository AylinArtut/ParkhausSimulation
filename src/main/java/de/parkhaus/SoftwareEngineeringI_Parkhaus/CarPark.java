package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.util.Random;

public class CarPark implements CarParkInterface {

    private String carParkName;
    public Car[] parkingSlots;
    public int leftCarSize = 0;
    public Car[] leftCars = new Car[100];
    private Random number = new Random();
    private int value;
    private double pricePerHour;
    public int parkedCars;

    public CarPark(String carParkName, int parkingSlotSizes, int pricePerHour){
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
            parkingSlots[this.value].setEnterTime(setTimeStamp());
            parkedCars += 1;
        }
    }

    public String putCarToCarPark(Car car){
        parkingCar(car);

        String defaultString = String.format("Im Parkhaus sind nun %d Autos.", parkedCars);
        String limitString = "Das Limit ist erreicht, keine Parkplätze frei.";

        if(parkedCars == parkingSlots.length){
            return String.format("%s %s", defaultString, limitString);

        }else{
            return defaultString;
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
            parkingSlots[this.value].setLeaveTime(setTimeStamp());
            parkedCars -= 1;
            leftCarSize += 1;
            Car car = parkingSlots[this.value];
            car.setPrice(calculatePrice(car));
            for(int j = 0; j < leftCarSize; j++) {
                if(leftCars[j] == null){
                    leftCars[j] = car;
                    break;
                }
            }
            parkingSlots[this.value] = null;
        }
        return String.format("Im Parkhaus sind nun %d Autos.", parkedCars);
    }

    private double calculatePrice(Car car){
        long durationTime = car.getLeaveTime().getTime() - car.getEnterTime().getTime();
        durationTime = (int) (durationTime / 1000);
        return durationTime * pricePerHour;
    }
}