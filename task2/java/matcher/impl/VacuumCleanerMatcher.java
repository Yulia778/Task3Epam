package by.minsk.epam.kozlova.task2.java.matcher.impl;

import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.entity.VacuumCleaner;
import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

public class VacuumCleanerMatcher implements ApplianceMatcher<VacuumCleaner> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        VacuumCleaner vacuumCleaner = (VacuumCleaner) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "POWER_CONSUMPTION":
                    result = result && vacuumCleaner.getPowerConsumption().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FILTER_TYPE":
                    result = result && vacuumCleaner.getFilterType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "BAG_TYPE":
                    result = result && vacuumCleaner.getBagType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "WAND_TYPE":
                    result = result && vacuumCleaner.getWandType().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "MOTOR_SPEED_REGULATION":
                    result = result && vacuumCleaner.getMotorSpeedRegulation().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "CLEANING_WIDTH":
                    result = result && vacuumCleaner.getCleaningWidth().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }
}
