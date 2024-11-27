package ru.aston.sort_app.core;

import java.time.Year;

public class Car {
    private final int power;
    private final String model;
    private final int year;

    private Car(Builder builder) {
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    public int getPower() {
        return power;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "\nCar{" +
                "power=" + power +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (power != car.power) return false;
        if (year != car.year) return false;
        return model.equals(car.model);
    }

    @Override
    public int hashCode() {
        int result = power;
        result = 31 * result + model.hashCode();
        result = 31 * result + year;
        return result;
    }

    public static class Builder {
        private int power;
        private String model;
        private int year;

        public Builder setPower(int power) {
            if (power <= 0) {
                throw new IllegalArgumentException("Мощность должна быть положительным числом.");
            }
            this.power = power;
            return this;
        }

        public Builder setModel(String model) {
            if (model == null || model.isBlank()) {
                throw new IllegalArgumentException("Модель не может быть пустой.");
            }
            this.model = model;
            return this;
        }

        public Builder setYear(int year) {
            int currentYear = Year.now().getValue();
            if (year < 1900 || year > currentYear) {
                throw new IllegalArgumentException("Недопустимый год производства: " + year);
            }
            this.year = year;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}