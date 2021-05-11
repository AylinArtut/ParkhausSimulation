package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;

public class CarPark{

    public String carParkName;
    public static int parkingSlotSize = 10;

    public static Car[] parkingSlots = new Car[parkingSlotSize];

    double pricePerHour;

    public static int parkedCars = 0;

    public CarPark(String carParkName, int parkingSlotSizes, double pricePerHour){
        this.carParkName = carParkName;
        parkingSlotSize = parkingSlotSizes;
        this.pricePerHour = pricePerHour;
    }

    private Timestamp setTimeStamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    private void parkingCar(Car car){
        for(int i = 0; i < parkingSlots.length; i++){
            if(parkingSlots[i] == null){
                parkingSlots[i] = car;
                parkedCars += 1;
                break;
            }
        }
    }

    public String putCarToCarPark(Car car){
        parkingCar(car);

        car.setCarColor();

        car.enterTime = setTimeStamp();

        if(parkedCars == parkingSlotSize){
            return "Im Parkhaus sind nun: " + parkedCars + " Autos. LIMIT IST ERREICHT; GEH ANDERES PARKHAUS SUCHEN!";
        }

        return "Im Parkhaus sind nun: " + parkedCars + " Autos.";
    }

    private void leaveCarPark(Car car){
        for(int i = 0; i < parkingSlots.length; i++){
            if(parkingSlots[i].carRegistrationNumber == car.carRegistrationNumber){
                parkingSlots[i] = null;
                break;
            }
        }
    }

    private void calculatePrice(Car car){
        long parkingTime = car.leaveTime.getTime() - car.enterTime.getTime();
        if(parkingTime >= pricePerHour){
            double parkingPrice = (parkingTime / pricePerHour) * pricePerHour;
        }else{
            double parkingPrice = 0;
        }
    }

    public void kickCarOutOfCarPark(Car car){
        leaveCarPark(car);

        car.leaveTime = setTimeStamp();

        calculatePrice(car);
    }
}