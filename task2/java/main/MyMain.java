package by.minsk.epam.kozlova.task2.java.main;

import by.minsk.epam.kozlova.task2.java.entity.criteria.Criteria;

public class MyMain {
    public static void main(String[] args) {
        ApplianceService applianceService = new ApplianceServiceImpl();


        Criteria criteriaOven = new Criteria(SearchCriteria.Oven.class.getSimpleName());
        //criteriaOven.add(SearchCriteria.Oven.HEIGHT.toString(), 45);
        criteriaOven.add("SearchCriteria.Oven.DEPTH.toString()", 60);

        List<Appliance> applianceList = applianceService.find(criteriaOven);

        for (Appliance appliance : applianceList) {
            PrintApplianceInfo.print(appliance);
        }
    }
}


