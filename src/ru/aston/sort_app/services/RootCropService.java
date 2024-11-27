import java.util.List;
import java.util.stream.Collectors;
import ru.aston.sort_app.dao.RootCropDAO;
import ru.aston.sort_app.services.SearchStrategy;
import ru.aston.sort_app.services.SortStrategy;
import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.core.UserInputChoice;

import java.util.Random;



public class RootCropService extends Service{
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


    private static final Random random = new Random();
    
    private static final String[] rootCropTypes = {
        "Морковь", "Картофель", "Свекла", "Редька", "Топинамбур", "Батат"
    };

    private static final String[] rootCropColors = {
        "Оранжевый", "Коричневый", "Красный", "Белый", "Желтый", "Зеленый"
    };


    // Generate a single random RootCrop
    public static RootCrop randomRootCrop() {

        // Pick a random root crop type from the array
        String type = rootCropTypes[random.nextInt(rootCropTypes.length)];
    
        // Generate a random weight between 100 and 1100 grams
        int weight = random.nextInt(1000) + 100;

        // Pick a random color from the array
        String color = rootCropColors[random.nextInt(rootCropColors.length)];

        return new RootCrop.Builder()
            .setType(type)
            .setWeight(weight)
            .setColor(color)
            .build();

    }
}