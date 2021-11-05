package by.minsk.epam.kozlova.task2.java.service.validation.impl;


import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceService {
    List<Appliance> find(Criteria criteria);
}
