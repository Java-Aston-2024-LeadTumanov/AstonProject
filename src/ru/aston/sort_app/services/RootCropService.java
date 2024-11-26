package ru.aston.sort_app.services;

import java.util.List;
import java.util.stream.Collectors;

import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.core.UserInputChoice;
import ru.aston.sort_app.dao.FileDAO;
import ru.aston.sort_app.dao.RootCropDAO;
import utils.UserInputChoice;
import utils.InputMode;
import utils.RootCropInputHandler;


import java.util.List;
import java.util.stream.Collectors;

public class RootCropService {
    private RootCropDAO rootCropDAO;

    public RootCropService(RootCropDAO rootCropDAO) {
        this.rootCropDAO = rootCropDAO;
    }

    // This method generates a list of RootCrops based on user input choice
    public List<RootCrop> generateRootCrops(InputMode mode, String filepath) {
        List<RootCrop> rootCrops = UserInputChoice.handleInput(
            mode,
            RootCropInputHandler::randomRootCrop,
            filepath,
            RootCropInputHandler::userInputRootCrop
        );
        return validateRootCrops(rootCrops); // Add validation step
    }

    // This method saves generated RootCrops using DAO
    public void saveRootCrops(List<RootCrop> rootCrops) {
        List<RootCrop> validatedRootCrops = validateRootCrops(rootCrops); // Validate before saving
        rootCropDAO.save(validatedRootCrops);
    }

    // Return the list of RootCrops from DAO
    public List<RootCrop> getRootCrops() {
        return rootCropDAO.getAll();
    }

    // Validation method for RootCrop objects
    private List<RootCrop> validateRootCrops(List<RootCrop> rootCrops) {
        return rootCrops.stream()
            .filter(this::isValidRootCrop)
            .collect(Collectors.toList());
    }

    // Validation rules for a single RootCrop
    private boolean isValidRootCrop(RootCrop rootCrop) {
        boolean isTypeValid = rootCrop.getType() != null && !rootCrop.getType().isEmpty();
        boolean isColorValid = rootCrop.getColor() != null && !rootCrop.getColor().isEmpty();
        boolean isWeightValid = rootCrop.getWeight() > 0;

        if (!isTypeValid || !isColorValid || !isWeightValid) {
            System.err.println("Invalid RootCrop found: " + rootCrop);
        }

        return isTypeValid && isColorValid && isWeightValid;
    }
}
