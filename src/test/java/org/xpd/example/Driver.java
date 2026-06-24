package org.xpd.example;

public record Driver(String firstName, String lastName, int age) {
    public boolean Drive(Car car) {
        car.setDriver(this);
        return car.run();
    }
}
