package ru.aston.sort_app.dao;

import ru.aston.sort_app.core.RootCrop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import ru.aston.sort_app.dao.FileDAO;



public class RootCropDAO implements FileDAO<RootCrop>{
    
    private static final String FILE_PATH =  "src/resources/rootcrops.txt";

    // Save RootCrops to a file (or database)

    @Override
    public List<RootCrop> get(int amount){

        List<RootCrop> rootCrops = new ArrayList<>();

        // read from file up to "amount" lines
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            int count = 0;
            while ((line = br.readLine()) != null) {
                RootCrop rootCrop = parseLine(line);
                if (rootCrop != null) {
                    rootCrops.add(rootCrop);
                    count++;
                }
                if (count >= amount) {
                    break; // Stop after reading the required amount
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        }
    
        return rootCrops;
    }


    public void save(List<RootCrop> rootCrops) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            for (RootCrop rootCrop : rootCrops) {
                writer.write(rootCrop.getType() + "," + rootCrop.getWeight() + "," + rootCrop.getColor());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // Helper method to parse a line into a RootCrop object
    private RootCrop parseLine(String line) {
        // Split the line by commas to extract the values
        String[] parts = line.split(",");
        
        if (parts.length != 3) {
            // If the line doesn't have exactly 3 parts (type, weight, color), skip it
            System.err.println("Skipping invalid line: " + line);
            return null;
        }
        
        String type = parts[0].trim();
        int weight = Integer.parseInt(parts[1].trim());
        String color = parts[2].trim();
        
        // Create and return a new RootCrop object
        return new RootCrop.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
    }

    // Method to print the list of root crops to the console
    public void printRootCrops(List<RootCrop> rootCrops) {
        if (rootCrops.isEmpty()) {
            System.out.println("No root crops found.");
            return;
        }

        for (RootCrop rootCrop : rootCrops) {
            System.out.println(rootCrop);  // RootCrop's toString method will be used to print
        }
    }
}
    
  
