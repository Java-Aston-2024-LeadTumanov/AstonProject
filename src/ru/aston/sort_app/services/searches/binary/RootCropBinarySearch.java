package ru.aston.sort_app.services.searches.binary;

import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.services.comparators.rootcrop_comparators.RootCropComparator;

public class RootCropBinarySearch extends BinarySearch<RootCrop> {
    public RootCropBinarySearch() {
        this.comparator = new RootCropComparator();
    }
}
