package by.minsk.epam.kozlova.task2.java.service.validation.impl;

import by.minsk.epam.kozlova.task2.java.entity.criteria.SearchCriteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

import java.util.Objects;

public class VacuumCleanerCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {
    {
        parameterValidators.put(SearchCriteria.VacuumCleaner.POWER_CONSUMPTION.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 300;
        });

        parameterValidators.put(SearchCriteria.VacuumCleaner.FILTER_TYPE.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.VacuumCleaner.BAG_TYPE.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.VacuumCleaner.WAND_TYPE.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.VacuumCleaner.MOTOR_SPEED_REGULATION.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 1 && integerValue < 32;
        });

        parameterValidators.put(SearchCriteria.VacuumCleaner.CLEANING_WIDTH.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 10;
        });
    }
}