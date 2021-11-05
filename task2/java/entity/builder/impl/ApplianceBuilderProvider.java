package by.minsk.epam.kozlova.task2.java.entity.builder.impl;

public interface ApplianceBuilderProvider {
    ApplianceBuilder<? extends Appliance> getApplianceBuilder(String applianceClassName);
}
