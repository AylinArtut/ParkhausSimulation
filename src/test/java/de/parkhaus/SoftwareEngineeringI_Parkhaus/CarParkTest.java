package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarParkTest {
    Car car = null;
    CarPark carPark = null;

    @BeforeEach
    void setUp() {
        carPark = new CarPark("TraumParkhaus", 10, 1);
        car = new Car();
    }
    
    @Test
    void putCarToCarPark() {
        carPark.putCarToCarPark(car);
        assertNotNull(carPark.parkingSlots);
    }

    @Test
    void leaveCarPark() {
        carPark.putCarToCarPark(car);
        assertEquals(1, carPark.parkedCars);
        carPark.leaveCarPark();
        assertEquals(0, carPark.parkedCars);
    }
}