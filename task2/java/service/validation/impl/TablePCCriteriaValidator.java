package by.minsk.epam.kozlova.task2.java.service.validation.impl;

import by.minsk.epam.kozlova.task2.java.entity.criteria.SearchCriteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

import java.util.Objects;

public class TabletPCCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {
    {
        parameterValidators.put(SearchCriteria.TabletPC.BATTERY_CAPACITY.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 100;
        });

        parameterValidators.put(SearchCriteria.TabletPC.DISPLAY_INCHES.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.TabletPC.MEMORY_ROM.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 32768;
        });

        parameterValidators.put(SearchCriteria.TabletPC.FLASH_MEMORY_CAPACITY.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 65536;
        });

        parameterValidators.put(SearchCriteria.TabletPC.COLOR.toString(), Objects::nonNull);
    }
}
