package ru.aston.sort_app.dao;

import ru.aston.sort_app.core.RootCrop;

import java.util.ArrayList;
import java.util.List;

public class RootCropMemoryDAO implements MemoryDAO<RootCrop> {
    private final List<RootCrop> rootCrops = new ArrayList<>();

    @Override
    public List<RootCrop> get(int amount) {
        return rootCrops.subList(0, Math.min(amount, rootCrops.size()));
    }

    public void add(RootCrop rootCrop) {
        rootCrops.add(rootCrop);
    }
}