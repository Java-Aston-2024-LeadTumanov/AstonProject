package ru.aston.sort_app.services.sorts.shell;

import ru.aston.sort_app.core.RootCrop;
import ru.aston.sort_app.services.comparators.rootcrop_comparators.RootCropComparator;

public class RootCropShellSort extends ShellSort<RootCrop> {
    public RootCropShellSort() {
        this.comparator = new RootCropComparator();
    }
}
