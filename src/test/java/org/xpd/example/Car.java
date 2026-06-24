package org.xpd.example;

public class Car {
    private final int id;
    private final String model;
    private final String color;
    private Wheel[] wheels;
    private Driver driver;

    public Car(int id, String model, String color) {
        this.id = id;
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }
    public String getModel() {
        return model;
    }
    public String getColor() {
        return color;
    }

    public Wheel[] getWheels() {
        return wheels;
    }
    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setWheels(Wheel[] wheels) {
        this.wheels = wheels;
    }

    public boolean run() {
        return driver != null;
    }
}
