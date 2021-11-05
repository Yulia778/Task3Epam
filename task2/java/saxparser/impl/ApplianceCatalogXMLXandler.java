package by.minsk.epam.kozlova.task2.java.saxparser.impl;
import by.minsk.epam.kozlova.task2.java.entity.*;
import by.minsk.epam.kozlova.task2.java.entity.builder.ApplianceBuilder;
import by.minsk.epam.kozlova.task2.java.entity.builder.impl.ApplianceBuilderProvider;
import by.minsk.epam.kozlova.task2.java.entity.builder.impl.ApplianceBuilderProviderImpl;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class ApplianceCatalogXMLHandler extends DefaultHandler {
    private static final ApplianceBuilderProvider applianceBuilderProvider = ApplianceBuilderProviderImpl.getInstance();
    Map<String, Object> properties = new HashMap<>();
    private StringBuilder text;
    private final Set<String> applianceTagSet = new TreeSet<>();
    private List<Appliance> catalog;

    {
        applianceTagSet.add(Oven.class.getSimpleName().toLowerCase());
        applianceTagSet.add(Laptop.class.getSimpleName().toLowerCase());
        applianceTagSet.add(Refrigerator.class.getSimpleName().toLowerCase());
        applianceTagSet.add(Speakers.class.getSimpleName().toLowerCase());
        applianceTagSet.add(TabletPC.class.getSimpleName().toLowerCase());
        applianceTagSet.add(VacuumCleaner.class.getSimpleName().toLowerCase());
    }

    public ApplianceCatalogXMLHandler(List<Appliance> catalog) {
        this.catalog = catalog;
    }

    private boolean isApplianceTag(String tag) {
        return applianceTagSet.contains(tag);
    }

    @Override
    public void startDocument() throws SAXException {
        // Тут будет логика реакции на начало документа
    }

    @Override
    public void endDocument() throws SAXException {
        // Тут будет логика реакции на конец документа
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text = new StringBuilder();
        if (isApplianceTag(qName)){
            properties.clear();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (isApplianceTag(qName)){
            ApplianceBuilder<? extends Appliance> applianceBuilder = applianceBuilderProvider.getApplianceBuilder(qName);
            catalog.add(applianceBuilder.properties(properties).build());
        } else {
            String tag = qName.toUpperCase().replace("-", "_");
            properties.put(tag, text);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        text.append(ch, start, length);
    }

    @Override
    public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
    }
}
