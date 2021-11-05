package by.minsk.epam.kozlova.task2.java.matcher.impl;

import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;

public interface ApplianceMatcher<T extends Appliance> {
    Boolean matchAppliance(Appliance appliance, Criteria criteria);
}
