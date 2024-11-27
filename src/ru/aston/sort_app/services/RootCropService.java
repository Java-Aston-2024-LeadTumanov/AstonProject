
import ru.aston.sort_app.dao.FileDAO;
import ru.aston.sort_app.dao.MemoryDAO;

import ru.aston.sort_app.services.searches.SearchStrategy;
import ru.aston.sort_app.services.sorts.SortStrategy;
import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.services.Service;
import ru.aston.sort_app.core.UserInputChoice;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.List;
import java.util.ArrayList;


public class RootCropService extends Service<RootCrop> {
    private final FileDAO<RootCrop> fileDao;
    private final MemoryDAO<RootCrop> memoryDAO;

    // Constructor to inject dependencies
    public RootCropService(FileDAO<RootCrop> fileDao,
                           MemoryDAO<RootCrop> memoryDAO,
                           SortStrategy<RootCrop> sortStrategy,
                           SearchStrategy<RootCrop> searchStrategy) {
        super(searchStrategy, sortStrategy); // Pass strategies to parent class constructor
        this.fileDao = fileDao;
        this.memoryDAO = memoryDAO;
    }

    // This method generates a list of RootCrops based on user input choice

    @Override
    public List<RootCrop> generate(UserInputChoice generateType, int size) {
        List<RootCrop> rootCrops = new ArrayList<>();
        switch (generateType) {
            case UserInputChoice.ACTION_ROOTCROP_FILE_GENERATED:
                rootCrops = fileDAO.get(size);
                break;
            case UserInputChoice.ACTION_ROOTCROP_RANDOM_GENERATED:
                rootCrops = generateRandomRootCrops(size);
                break;
            case UserInputChoice.ACTION_ROOTCROP_MANUAL_GENERATED:
                rootCrops = memoryDAO.get(size);
                break;
        }
        return rootCrops; 
    }


    // Validation method for RootCrop objects
    private List<RootCrop> validateRootCrops(List<RootCrop> rootCrops) {
        return rootCrops.stream()
            .filter(this::isValidRootCrop)
            .collect(Collectors.toList());
    }

    // Validation rules for a single RootCrop
    private boolean isValidRootCrop(RootCrop rootCrop) {
        boolean isTypeValid = rootCrop.getType() != null && !rootCrop.getType().isEmpty()&& isAlphabetic(rootCrop.getType());;
        boolean isColorValid = rootCrop.getColor() != null && !rootCrop.getColor().isEmpty()&& isAlphabetic(rootCrop.getColor());;
        boolean isWeightValid = rootCrop.getWeight() > 0;

        if (!isTypeValid || !isColorValid || !isWeightValid) {
            System.err.println("Invalid RootCrop found: " + rootCrop);
        }

        return isTypeValid && isColorValid && isWeightValid;
      
    }

    private boolean isAlphabetic(String input) {
          // This regex will allow both Latin and Cyrillic alphabetic characters
    return input.matches("^[a-zA-Zа-яА-ЯёЁ]+$");
    }

    //sorting, searching and adding
    @Override
    public List<RootCrop> find(List<RootCrop> rootCrops, RootCrop rootCrop) {
        return super.getSearchStrategy().find(RootCrops, rootCrop);
    }


    @Override
    public void sort(List<RootCrop> list) {
        super.getSortStrategy().sort(list);
    }

    @Override
    public void add(RootCrop rootCrop) {
        memoryDAO.add(rootCrop);
    }


    //Build a list of random rootCrops

    private static final Random random = new Random();
    
    private static final String[] rootCropTypes = {
        "Морковь", "Картофель", "Свекла", "Редька", "Топинамбур", "Батат"
    };

    private static final String[] rootCropColors = {
        "Оранжевый", "Коричневый", "Красный", "Белый", "Желтый", "Зеленый"
    };

     private List<RootCrop> generateRandomRootCrops(int count) {
        List<RootCrop> rootCrops = new ArrayList<>();

        for (int i = 0; i < count; i++){

        // Pick a random root crop type from the array
            String type = rootCropTypes[random.nextInt(rootCropTypes.length)];
        
            // Generate a random weight between 100 and 1100 grams
            int weight = random.nextInt(1000) + 100;

            // Pick a random color from the array
            String color = rootCropColors[random.nextInt(rootCropColors.length)];

            RootCrop rootCrop = new RootCrop.Builder()
                .setType(type)
                .setWeight(weight)
                .setColor(color)
                .build();
            
            rootCrops.add(rootCrop);

        }
        return validateRootCrops(rootCrops);//validation step
    }
}