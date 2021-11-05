package by.minsk.epam.kozlova.task2.java.service.validation.impl;

import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class BaseCriteriaValidator implements CriteriaValidator {
    protected Map<String, Predicate<Object>> parameterValidators  = new HashMap<>();

    @Override
    public Boolean validate(Criteria criteria) {
        boolean result = true;
        for (String searchCriteriaName : criteria.searchCriteries()) {
            Object searchCriteriaValue = criteria.getValue(searchCriteriaName);
            result = result && parameterValidators.get(searchCriteriaName).test(searchCriteriaValue);
        }
        return result;
    }
}
