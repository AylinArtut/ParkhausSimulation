package de.parkhaus.SoftwareEngineeringI_Parkhaus;

// Notiz: Alle Parkplätze sind automatisch als "null" befüllt, insofern kein Auto im Slot sind.

public class CarPark{
    // Anzahl möglicher Parkplätze im Parkhaus:
    public int parkingSlots_size = 10;

    // Parkplätze als Array:
    public Car[] parkingSlots = new Car[parkingSlots_size];

    // Method for parking a car in that car park:
    public void parkingCar(Car car){
        for(int i = 0; i < parkingSlots.length; i++){
            // Geht von Anfang bis Ende durch & findet einen freien Slot:
            if(parkingSlots[i] == null){
                parkingSlots[i] = car;
            }
        }
    }
}