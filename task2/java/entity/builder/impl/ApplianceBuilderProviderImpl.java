package by.minsk.epam.kozlova.task2.java.entity.builder.impl;
public final class ApplianceBuilderProviderImpl implements ApplianceBuilderProvider {
    private final static ApplianceBuilderProviderImpl INSTANCE = new ApplianceBuilderProviderImpl();
    private ApplianceBuilderProviderImpl(){
    }

    public static ApplianceBuilderProvider getInstance(){
        return INSTANCE;
    }

    Map<String, Class<? extends ApplianceBuilder<? extends Appliance>>> builderMap = new HashMap<>();
    {
        builderMap.put(Laptop.class.getSimpleName().toLowerCase(), LaptopBuilderImpl.class);
        builderMap.put(Oven.class.getSimpleName().toLowerCase(), OvenBuilderImpl.class);
        builderMap.put(Refrigerator.class.getSimpleName().toLowerCase(), RefrigeratorBuilderImpl.class);
        builderMap.put(Speakers.class.getSimpleName().toLowerCase(), SpeakersBuilderImpl.class);
        builderMap.put(TabletPC.class.getSimpleName().toLowerCase(), TabletPCBuilderImpl.class);
        builderMap.put(VacuumCleaner.class.getSimpleName().toLowerCase(), VacuumCleanerBuilderImpl.class);
    }

    @Override
    public ApplianceBuilder<? extends Appliance> getApplianceBuilder(String applianceClassName) {
        Class<? extends ApplianceBuilder<? extends Appliance>> builderClass = builderMap.get(applianceClassName);
        try {
            return builderClass.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

