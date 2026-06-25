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

    public Car(int id, String model, String color, Wheel[] wheels) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.wheels = wheels;
    }

    public Car(int id, String model, String color, Driver driver) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.driver = driver;
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
}
