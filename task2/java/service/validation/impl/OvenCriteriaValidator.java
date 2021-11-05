package by.minsk.epam.kozlova.task2.java.service.validation.impl;

import by.minsk.epam.kozlova.task2.java.entity.criteria.SearchCriteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

public class OvenCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {
    {
        parameterValidators.put(SearchCriteria.Oven.POWER_CONSUMPTION.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 1000;
        });

        parameterValidators.put(SearchCriteria.Oven.WEIGHT.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 5 && integerValue < 50;
        });

        parameterValidators.put(SearchCriteria.Oven.CAPACITY.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 10 && integerValue < 200;
        });

        parameterValidators.put(SearchCriteria.Oven.DEPTH.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 20 && floatValue < 100;
        });

        parameterValidators.put(SearchCriteria.Oven.HEIGHT.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 20 && floatValue < 100;
        });

        parameterValidators.put(SearchCriteria.Oven.WIDTH.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 20 && floatValue < 100;
        });
    }
}
