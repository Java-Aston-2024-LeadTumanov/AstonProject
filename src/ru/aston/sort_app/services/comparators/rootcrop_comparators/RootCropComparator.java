package ru.aston.sort_app.services.comparators.rootcrop_comparators;

import ru.aston.sort_app.core.RootCrop;

import java.util.Comparator;

public class RootCropComparator implements Comparator<RootCrop> {
    Comparator<RootCrop> rootCropTypeComparator = new RootCropTypeComparator(),
            rootCropWeightComparator = new RootCropWeightComparator(),
            rootCropColorComparator = new RootCropColorComparator();

    @Override
    public int compare(RootCrop crop1, RootCrop crop2) {
        return rootCropTypeComparator
                .thenComparing(rootCropWeightComparator)
                .thenComparing(rootCropColorComparator)
                .compare(crop1, crop2);
    }
}
