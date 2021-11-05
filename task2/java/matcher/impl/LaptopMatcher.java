package by.minsk.epam.kozlova.task2.java.matcher.impl;

import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.entity.Laptop;
import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

public class LaptopMatcher implements ApplianceMatcher<Laptop> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        Laptop laptop = (Laptop) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "BATTERY_CAPACITY":
                    result = result && laptop.getBatteryCapacity().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "OS":
                    result = result && laptop.getOperationSystem().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "SYSTEM_MEMORY":
                    result = result && laptop.getSystemMemory().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "CPU":
                    result = result && laptop.getCpu().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "DISPLAY_INCHS":
                    result = result && laptop.getDisplayInchs().equals(ValueParser.parseFloat(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
            }
        }
        return result;
    }

    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        return null;
    }
}
