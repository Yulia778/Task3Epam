package by.minsk.epam.kozlova.task2.java.matcher.impl;

import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.entity.TabletPC;
import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;
import by.minsk.epam.kozlova.task2.java.entity.factory.ValueParser;

public class TabletPCMatcher implements ApplianceMatcher<TabletPC> {
    @Override
    public Boolean matchAppliance(Appliance appliance, Criteria criteria) {
        TabletPC tabletPC = (TabletPC) appliance;
        boolean result = true;
        for (String searchCriteria : criteria.searchCriteries()) {
            switch (searchCriteria) {
                case "BATTERY_CAPACITY":
                    result = result && tabletPC.getBatteryCapacity().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "DISPLAY_INCHES":
                    result = result && tabletPC.getDisplayInches().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
                case "MEMORY_ROM":
                    result = result && tabletPC.getMemoryRom().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "FLASH_MEMORY_CAPACITY":
                    result = result && tabletPC.getFlashMemoryCapacity().equals(ValueParser.parseInteger(String.valueOf(criteria.getValue(searchCriteria))));
                    break;
                case "COLOR":
                    result = result && tabletPC.getColor().equals(String.valueOf(criteria.getValue(searchCriteria)));
                    break;
            }
        }
        return result;
    }
}
