package by.minsk.epam.kozlova.task2.java.service.validation.impl;

import by.minsk.epam.kozlova.task2.java.entity.criteria.SearchCriteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

import java.util.Objects;


public class LaptopCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {
    {
        parameterValidators.put(SearchCriteria.Laptop.BATTERY_CAPACITY.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 0 && floatValue < 1000;
        });
        parameterValidators.put(SearchCriteria.Laptop.OS.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.Laptop.MEMORY_ROM.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 32768;
        });

        parameterValidators.put(SearchCriteria.Laptop.SYSTEM_MEMORY.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 32768;
        });

        parameterValidators.put(SearchCriteria.Laptop.CPU.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.Laptop.DISPLAY_INCHS.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 7 && floatValue < 32;
        });
    }
}