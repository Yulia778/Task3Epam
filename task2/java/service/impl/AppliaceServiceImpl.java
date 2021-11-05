package by.minsk.epam.kozlova.task2.java.service.impl;

import by.minsk.epam.kozlova.task2.java.dao.impl.ApplianceDAO;
import by.minsk.epam.kozlova.task2.java.dao.impl.DAOFactory;
import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;
import by.minsk.epam.kozlova.task2.java.service.validation.impl.ApplianceService;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {
    private final CriteriaValidatorProvider criteriaValidatorProvider = CriteriaValidatorProvider.getInstance();

    @Override
    public List<Appliance> find(Criteria criteria) {


        if (!criteriaValidatorProvider.getCriteriaValidator(criteria.getGroupSearchName()).validate(criteria)) {
            return null;
        }

        DAOFactory factory = DAOFactory.getInstance();
        ApplianceDAO applianceDAO = factory.getApplianceDAO();

        List<Appliance> appliances = applianceDAO.find(criteria);



        return appliances;
    }

}
