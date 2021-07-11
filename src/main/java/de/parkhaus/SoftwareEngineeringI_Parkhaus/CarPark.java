package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import java.sql.Timestamp;
import java.util.Random;

public class CarPark implements ICarPark {
    private String carParkName;
    // "per second" in my simulation (to not wait so long):
    private double pricePerHour;

    // My parking spaces, where I store car-objects:
    public Car[] parkingSlots;
    // Storage for cars, who left the car park for history table:
    public Car[] leftCars = new Car[100];

    // I'm counting parked cars:
    public int parkedCars = 0;
    // I did it a bit dirty - here I'm counting my cars, who left the car park (see above for reason):
    public int leftCarSize = 0;

    // Little storage for a value, which I'm using in several methods:
    private int value;

    // I just wanted only one instance of "Random" in this class, which I can use everywhere:
    private Random number = new Random();

    // Whenever a car park is spawned, it gets a name, price per hour (seconds in my simulation) & amount of parking space:
    public CarPark(String carParkName, int parkingSlotSizes, int pricePerHour){
        this.carParkName = carParkName;
        this.pricePerHour = pricePerHour;
        parkingSlots = new Car[parkingSlotSizes];
    }

    // Method for setting a timestamp (I'm using this for "enterTime" & "leaveTime"):
    private Timestamp setTimeStamp(){
        return new Timestamp(System.currentTimeMillis());
    }

    // For parking cars in a "random" & "free" parking space:
    private void parkingCar(Car car){
        // I'm checking with a random generated number if a parking space is free:
         do{
             if(parkedCars < parkingSlots.length) {
                 this.value = number.nextInt(parkingSlots.length);
             }else{
                 break;
             }
         }while(parkingSlots[this.value] != null);

         // Some more checks (can't get enough, yayy!):
        if((parkedCars < parkingSlots.length) && (parkingSlots[this.value] == null)){
            // Storing car-object to that free slot:
            parkingSlots[this.value] = car;
            // Giving that parked car an "enterTime" (time, when it entered the car park):
            parkingSlots[this.value].setEnterTime(setTimeStamp());
            // Increasing "parkedCars" by one:
            parkedCars += 1;
        }
    }

    // This uses "parkingCar" method + handles the information, shown to clients:
    public String putCarToCarPark(Car car){
        parkingCar(car);

        // Let's get fancy with "String.format" (^_^):
        String defaultString = String.format("Im Parkhaus sind %d Autos.", parkedCars);
        String limitString = "Das Limit ist erreicht, keine Parkplätze frei.";

        // To types of information can shown to clients:
        if(parkedCars == parkingSlots.length){
            return String.format("%s %s", defaultString, limitString);
        }else{
            return defaultString;
        }
    }

    // Calculates the price for cars, when they leave the car park:
    private double calculatePrice(Car car){
        // Getting the difference (how long car was in car park):
        long durationTime = car.getLeaveTime().getTime() - car.getEnterTime().getTime();
        // Price increases in this simulation in seconds (to not wait so long):
        durationTime = (int) (durationTime / 1000);
        double price = durationTime * pricePerHour;
        // There's a maximum price, you can reach:
        if(price >= 25){
            price = 10;
        }
        // Entered car has to pay nothing, when it leaves immediately (it's just a simulation):
        return price;
    }

    // When a car wants to leave the car park (when he's kicked out after I click button, hihi ^_- *evil laugh*):
    public String leaveCarPark(){
        // Leaving also happens "randomly", so the same procedure like by entering the car park:
        do{
            if(parkedCars >= 1) {
                this.value = number.nextInt(parkingSlots.length);
            }else{
                break;
            }
        }while(parkingSlots[this.value] == null);

        if(parkingSlots[this.value] != null){
            // Car gets a "leaveTime" (time, when it leaved the car park for history):
            parkingSlots[this.value].setLeaveTime(setTimeStamp());
            // Some up- & down counting happens, which is obvious:
            parkedCars -= 1;
            leftCarSize += 1;
            // Getting the car, which has to leave now:
            Car car = parkingSlots[this.value];
            // Price for car, who wants to leave the car park (it is automatically paid):
            car.setPrice(calculatePrice(car));
            for(int j = 0; j < leftCarSize; j++) {
                if(leftCars[j] == null){
                    // Left car goes to the array for left cars (for history):
                    leftCars[j] = car;
                    break;
                }
            }
            // Parking space is now free:
            parkingSlots[this.value] = null;
        }
        return String.format("Im Parkhaus sind %d Autos.", parkedCars);
    }
}