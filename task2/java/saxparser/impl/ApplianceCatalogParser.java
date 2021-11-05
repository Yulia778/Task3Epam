package by.minsk.epam.kozlova.task2.java.saxparser.impl;

import by.minsk.epam.kozlova.task2.java.entity.Appliance;

import java.util.List;

public interface ApplianceCatalogParser {
    List<Appliance> readCatalogFromFile(String fileName);
}
