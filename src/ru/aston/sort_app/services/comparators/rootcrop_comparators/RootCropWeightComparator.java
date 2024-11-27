package ru.aston.sort_app.services.comparators.rootcrop_comparators;

import ru.aston.sort_app.core.RootCrop;

import java.util.Comparator;

public class RootCropWeightComparator implements Comparator<RootCrop> {
    @Override
    public int compare(RootCrop crop1, RootCrop crop2) {
        if (crop1.getWeight() == crop2.getWeight())
            return 0;
        else return crop1.getWeight() < crop2.getWeight() ? -1 : 1;
    }
}
