package by.minsk.epam.kozlova.task2.java.saxparser.impl;

import by.minsk.epam.kozlova.task2.java.entity.Appliance;
import by.minsk.epam.kozlova.task2.java.main.SAXMain;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ApplianceCatalogXMLParserImpl implements ApplianceCatalogParser {

    @Override
    public List<Appliance> readCatalogFromFile(String fileName) {
        List<Appliance> catalog;
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = null;
        try {
            parser = factory.newSAXParser();
            catalog = new ArrayList<>();
            ApplianceCatalogXMLHandler handler = new ApplianceCatalogXMLHandler(catalog);
            File xmlDbFileName = new File(Objects.requireNonNull(SAXMain.class.getClassLoader().getResource(fileName)).getFile());
            parser.parse(xmlDbFileName, handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
        return catalog;
    }
}