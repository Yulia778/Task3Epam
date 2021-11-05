package by.minsk.epam.kozlova.task2.java.dao.impl;

public class ApplianceDAO {
    import java.util.List;

    public interface ApplianceDAO {
        List<Appliance> find(Criteria criteria);
    }
}
