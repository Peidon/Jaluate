package org.xpd.example;

import java.util.Map;

public class CarShop {

    private static final Map<Integer, Car> cars = Map.ofEntries(
            Map.entry(1, new Car(1, "sedan", "red", new Driver("Jason", "Han", 3))),
            Map.entry(2, new Car(2, "suv", "blue",
                    new Wheel[]{new Wheel(4.0, 12L),new Wheel(4.0, 12L),new Wheel(4.0, 12L),new Wheel(4.0, 12L)})),
            Map.entry(3, new Car(3, "coupe", "black")),
            Map.entry(4, new Car(4, "hatchback", "white")),
            Map.entry(5, new Car(5, "wagon", "silver")),
            Map.entry(6, new Car(6, "convertible", "yellow")),
            Map.entry(7, new Car(7, "pickup", "green")),
            Map.entry(8, new Car(8, "minivan", "gray")),
            Map.entry(9, new Car(9, "roadster", "orange")),
            Map.entry(10, new Car(10, "crossover", "purple")),
            Map.entry(11, new Car(11, "limousine", "black"))
    );

    public static Car get(int id) {
        return cars.get(id);
    }

    public static String getModelByID(int id) {
        return cars.get(id).getModel();
    }

    public static String getColorByID(int id) {
        return cars.get(id).getColor();
    }

    public static int checkModelAndColor(String model, String color) {
        for  (Car car : cars.values()) {
            if(car.getModel().equals(model) && car.getColor().equals(color)) {
                return car.getId();
            }
        }
        return -1;
    }
}
