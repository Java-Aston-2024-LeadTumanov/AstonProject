package ru.aston.sort_app.dao;

import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.services.utils.RootCropInputHandler;
import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class RootCropDAO {

    private static final String FILE_PATH = "rootcrops.txt";

    // Save RootCrops to a file (or database)
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

    // Retrieve all RootCrops (for example, from a file)
    public List<RootCrop> getAll() {
        List<RootCrop> rootCrops = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                rootCrops.add(RootCropInputHandler.parseRootCropFromFile(line));
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
        return rootCrops;
    }
}