package ru.aston.sort_app.core;


public class RootCrop {
    private final String type;
    private final double weight;
    private final String color;

    // Private constructor for Builder
    private RootCrop(Builder builder) {
        this.type = builder.type;
        this.weight = builder.weight;
        this.color = builder.color;
    }

    // Getters
    public String getType() {
        return type;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    // Override toString
    @Override
    public String toString() {
        return "\nRootCrop{" +
                "type='" + type + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }

    // Builder class
    public static class Builder {
        private String type;
        private double weight;
        private String color;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }

}