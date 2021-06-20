package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.util.Random;

public class CarPark{

    private String carParkName;

    public Car[] parkingSlots;

    public int leftCarSize = 0;
    public Car[] leftCars = new Car[100];

    private Random number = new Random();
    private int value;

    private int pricePerHour = 2;

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
        Car car = null;

        do{
            if(parkedCars >= 1) {
                this.value = number.nextInt(parkingSlots.length);
            }else{
                break;
            }
        }while(parkingSlots[this.value] == null);

        if(parkingSlots[this.value] != null){
            parkingSlots[this.value].leaveTime = setTimeStamp();
            parkedCars -= 1;
            leftCarSize += 1;
            car = parkingSlots[this.value];
            for(int j = 0; j < leftCarSize; j++) {
                if(leftCars[j] == null){
                    leftCars[j] = car;
                    calculatePrice(car);
                    break;
                }
            }
            parkingSlots[this.value] = null;
        }

        return "Im Parkhaus sind nun: " + parkedCars + " Autos.";
    }

    public double calculatePrice(Car car){
        long durationTime = car.leaveTime.getTime() - car.enterTime.getTime();
        durationTime = (int) ((durationTime / (1000*60*60)) % 24);
        car.price = durationTime * pricePerHour;
        return car.price;
    }
}