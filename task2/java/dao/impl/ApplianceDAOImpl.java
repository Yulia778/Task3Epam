package by.minsk.epam.kozlova.task2.java.dao.impl;

import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;
import by.minsk.epam.kozlova.task2.java.matcher.impl.ApplianceMatcher;
import by.minsk.epam.kozlova.task2.java.matcher.impl.ApplianceMatcherProvider;

import java.util.ArrayList;
import java.util.List;

public class ApplianceDAOImpl {
    import java.util.ArrayList;
import java.util.List;

    public class ApplianceDAOImpl implements ApplianceDAO {
        private static final String DB_FILE_NAME = "bd.xml";
        ApplianceCatalogParser applianceCatalogParser = new ApplianceCatalogXMLParserImpl();
        ApplianceMatcherProvider applianceMatcherProvider = ApplianceMatcherProvider.getInstance();

        @Override
        public List<Appliance> find(Criteria criteria) {
            List<Appliance> appliances;
            List<Appliance> result = new ArrayList<>();
            appliances = applianceCatalogParser.readCatalogFromFile(DB_FILE_NAME);
            for (Appliance appliance : appliances) {
                Boolean isPassed = false;
                ApplianceMatcher<? extends Appliance> applianceMatcher = applianceMatcherProvider.getApplianceMatcher(appliance.getClass());
                if (applianceMatcher.matchAppliance(appliance, criteria)) {
                    result.add(appliance);
                }
            }
            return result;
        }
    }
}
