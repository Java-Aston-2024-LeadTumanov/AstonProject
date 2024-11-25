package ru.aston.sort_app.services.comparators.rootcrop_comparators;

import ru.aston.sort_app.core.RootCrop;

import java.util.Comparator;

public class RootCropTypeComparator implements Comparator<RootCrop> {
    @Override
    public int compare(RootCrop crop1, RootCrop crop2) {
        return crop1.getType().compareTo(crop2.getType());
    }
}
