package org.xpd.example;


public class Wheel{
    private final Double size;
    private final Long weight;

    public Wheel(Double size, Long weight) {
        this.size = size;
        this.weight = weight;
    }

    public Double getSize() {
        return size;
    }

    public Long getWeight() {
        return weight;
    }
}
