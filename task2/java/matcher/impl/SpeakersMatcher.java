package by.minsk.epam.kozlova.task2.java.matcher.impl;

import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.entity.Speakers;
import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

public class SpeakersMatcher implements ApplianceMatcher<Speakers> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        Speakers speakers = (Speakers) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && speakers.getPowerConsumption().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "NUMBER_OF_SPEAKERS":
                    result = result && speakers.getNumberOfSpeakers().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FREQUENCY_RANGE":
                    result = result && speakers.getFrequencyRange().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "CORD_LENGTH":
                    result = result && speakers.getCordLength().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}
