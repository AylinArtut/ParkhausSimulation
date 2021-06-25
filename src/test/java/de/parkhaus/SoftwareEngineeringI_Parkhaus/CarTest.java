package de.parkhaus.SoftwareEngineeringI_Parkhaus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;
import java.sql.Timestamp;
import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    Car car = null;
    CarPark carPark = null;
    Timestamp timestamp;

    @BeforeEach
    void setUp() {
        carPark = new CarPark("TraumParkhaus", 10, 1);
        car = new Car();
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    @Test
    void getRegistrationNumber() {
        assertNotNull(car.getRegistrationNumber());
    }

    @Test
    void getEnterTime() {
        assertNull(car.getEnterTime());
        carPark.putCarToCarPark(car);
        assertNotNull(car.getEnterTime());
    }

    @Test
    void getLeaveTime() {
        assertNull(car.getLeaveTime());
        carPark.putCarToCarPark(car);
        carPark.leaveCarPark();
        assertNotNull(car.getLeaveTime());
    }

    @Test
    void getCarColor() {
        assertNotNull(car.getCarColor());
    }

    @Test
    void getPrice() {
        assertEquals(car.getPrice(), 0.0);
    }

    @Test
    void setEnterTime() {
        car.setEnterTime(timestamp);
        assertEquals(car.getEnterTime(), timestamp);
    }

    @Test
    void setLeaveTime() {
        car.setLeaveTime(timestamp);
        assertEquals(car.getLeaveTime(), timestamp);
    }

    @Test
    void setPrice() throws InterruptedException {
        carPark.putCarToCarPark(car);
        TimeUnit.SECONDS.sleep(1);
        carPark.leaveCarPark();
        assertTrue(car.getPrice() > 0.0);
    }

    @Test
    void setRegistrationNumber() {
    }

    @Test
    void setCarColor() {
    }

    @Test
    void formatDate() {
    }
}