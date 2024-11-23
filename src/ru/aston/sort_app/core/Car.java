package ru.aston.sort_app.core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;


public class Car{
    private final int power;
    private final String model;
    private final int year;

    //Private constructor for builder

    private Car(Builder builder){
        this.power = builder.power;
        this.model = builder.model;
        this.year = builder.year;
    }

    //Getters for fields

    public int getPower(){
        return power;
    }
    public String getModel(){
        return model;
    }
    public int getYear(){
        return year;
    }

    @Override
    public String toString(){
        return "Car{" +
        "power=" + power +
        ", model='" + model + '\'' +
        ", year=" + year +
        '}';
    }

    // Builder Class
    public static class Builder{
        private int power;
        private String model;
        private int year;

        public Builder setPower(int power){
            this.power = power;
            return this;
        }
        public Builder setModel(String model){
            this.model = model;
            return this;
        }
        public Builder setYear(int year){
            this.year = year;
            return this;
        }

        public Car build(){
            return new Car(this);
        }
    }

    //Comparators 

    public static final Comparator<Car> byPower = Comparator.comparingInt(Car::getPower);
    public static final Comparator<Car> byModel = Comparator.comparing(Car::getModel);
    public static final Comparator<Car> byYear = Comparator.comparingInt(Car::getYear);
    public static final Comparator<Car> byPowerThenModelThenYear =
        byPower.thenComparing(byModel).thenComparing(byYear);


    
    
    //Example usage

    // public static void main(String[] args) {
    //     List<Car> cars = new ArrayList<>();
    //     cars.add(new Car.Builder().setPower(150).setModel("BMW").setYear(2015).build());
    //     cars.add(new Car.Builder().setPower(180).setModel("Audi").setYear(2018).build());
    //     cars.add(new Car.Builder().setPower(150).setModel("Ford").setYear(2017).build());
    //     cars.add(new Car.Builder().setPower(180).setModel("BMW").setYear(2020).build());

    //     // Sort by power
    //     Collections.sort(cars, Car.byPower);
    //     System.out.println("Sorted by power:");
    //     cars.forEach(System.out::println);

    //     // Sort by model
    //     Collections.sort(cars, Car.byModel);
    //     System.out.println("\nSorted by model:");
    //     cars.forEach(System.out::println);

    //      // Sort by All
    //      Collections.sort(cars, Car.byPowerThenModelThenYear);
    //      System.out.println("\nSorted by all:");
    //      cars.forEach(System.out::println);
    // }
}

