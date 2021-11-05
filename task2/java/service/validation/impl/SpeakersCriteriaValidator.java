package by.minsk.epam.kozlova.task2.java.service.validation.impl;

import by.minsk.epam.kozlova.task2.java.entity.criteria.SearchCriteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

import java.util.Objects;

public class SpeakersCriteriaValidator extends BaseCriteriaValidator implements CriteriaValidator {
    {
        parameterValidators.put(SearchCriteria.Speakers.POWER_CONSUMPTION.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 100;
        });

        parameterValidators.put(SearchCriteria.Speakers.NUMBER_OF_SPEAKERS.toString(), value -> {
            Integer integerValue = ValueParser.parseInteger(String.valueOf(value));
            return integerValue > 0 && integerValue < 11;
        });

        parameterValidators.put(SearchCriteria.Speakers.FREQUENCY_RANGE.toString(), Objects::nonNull);

        parameterValidators.put(SearchCriteria.Speakers.CORD_LENGTH.toString(), value -> {
            Float floatValue = ValueParser.parseFloat(String.valueOf(value));
            return floatValue > 2 && floatValue < 40;
        });
    }
}
