package by.minsk.epam.kozlova.task2.java.entity.builder;
    import java.util.Map;

    public interface ApplianceBuilder<E> {
        ApplianceBuilder<E> properties(Map<String, Object> properties);
        E build();
    }
}
