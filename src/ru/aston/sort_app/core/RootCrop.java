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
            if (type == null || type.isBlank() || !(type instanceof String)){
                throw new IllegalArgumentException("Тип не может быть пустым иили числом");
            }

            this.type = type;
            return this;
        }

        public Builder setWeight(double weight) {
            if (weight<=0){
                throw new IllegalArgumentException("Вес должен превышать ноль");
            }
            this.weight = weight;
            return this;
        }

        public Builder setColor(String color) {
            if (color == null || color.isBlank()|| !(color instanceof String)){
                throw new IllegalArgumentException("Цвет не может быть пустым или числом");
            }
            this.color = color;
            return this;
        }

        public RootCrop build() {
            return new RootCrop(this);
        }
    }

}