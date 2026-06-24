package org.xpd.example;

public class Wheel {
    private Double size;
    private Long weight;
    public Wheel(Double size, Long weight) {
        this.size = size;
        this.weight = weight;
    }
    public Double getSize() {
        return size;
    }
    public void setSize(Double size) {
        this.size = size;
    }
    public Long getWeight() {
        return weight;
    }
    public void setWeight(Long weight) {
        this.weight = weight;
    }
}
