package za.ac.cput.SmallProgramTest;

import org.junit.jupiter.api.Test;
import za.ac.cput.SmallProgram.Car;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    @Test
    public static void main(String[] args) {
        Car ca = new Car("Benz", 200, 400000);
        System.out.println(ca.toString());
        ca.show();
        ca.setMake("Toyota");
        ca.setYearModel(1976);
        ca.setPrice(670000);
        System.out.println(ca.toString());
    }
}