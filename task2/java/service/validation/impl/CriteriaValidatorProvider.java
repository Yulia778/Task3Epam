package by.minsk.epam.kozlova.task2.java.service.validation.impl;

import by.minsk.epam.kozlova.task2.java.entity.*;

import java.util.Map;
import java.util.TreeMap;

public class CriteriaValidatorProvider {
    private final static CriteriaValidatorProvider INSTANCE = new CriteriaValidatorProvider();
    private final Map<String, CriteriaValidator> validatorMap;

    {
        validatorMap = new TreeMap<>();
        validatorMap.put(Laptop.class.getSimpleName(), new LaptopCriteriaValidator());
        validatorMap.put(Oven.class.getSimpleName(), new OvenCriteriaValidator());
        validatorMap.put(Refrigerator.class.getSimpleName(), new RefrigeratorCriteriaValidator());
        validatorMap.put(Speakers.class.getSimpleName(), new SpeakersCriteriaValidator());
        validatorMap.put(TabletPC.class.getSimpleName(), new TabletPCCriteriaValidator());
        validatorMap.put(VacuumCleaner.class.getSimpleName(), new VacuumCleanerCriteriaValidator());
    }

    private CriteriaValidatorProvider() {
    }

    public static CriteriaValidatorProvider getInstance() {
        return INSTANCE;
    }

    public CriteriaValidator getCriteriaValidator(String ApplianceClassName) {
        return validatorMap.get(ApplianceClassName);
    }

    public CriteriaValidator getCriteriaValidator(Class<? extends Appliance> cl) {
        return validatorMap.get(cl.getSimpleName());
    }
}
