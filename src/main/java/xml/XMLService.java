package xml;

import entity.Item;
import entity.Statistic;
import interfaces.IStatisticCalculator;
import interfaces.IXMLService;
import statistic.StatisticCalculator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class XMLService implements IXMLService {

    private IStatisticCalculator calculator = new StatisticCalculator();

    @Override
    public void createXmlStatisticByLabel() throws JAXBException, IOException {

        Map<String, Integer> labelCount = calculator.countByLabel();

        List<Item> items = new ArrayList<>();


       createXmlFile(labelCount, items, "labels");

    }

    @Override
    public void createXmlStatisticByGenre() throws JAXBException, IOException {

        Map<String, Integer> genreCount = calculator.countByGenre();

        List<Item> items = new ArrayList<>();

       createXmlFile(genreCount, items, "genres");

    }

    @Override
    public void createXmlStatisticByFoundationYear() throws JAXBException, IOException {

        Map<String, Integer> foundationYearCount = calculator.countByYearOfFoundation();

         List<Item> items = new ArrayList<>();

        createXmlFile(foundationYearCount, items, "year_foundation");

    }

    private void createXmlFile(Map<String, Integer> statisticCountMap, List<Item> items, String nameFile) throws JAXBException, IOException {

        for(Map.Entry<String, Integer> entry : statisticCountMap.entrySet()){
            Item item = new Item(entry.getKey(), entry.getValue());
            items.add(item);
        }

        Path statisticFolder = Paths.get("src/main/resources/written_files");

        Files.createDirectories(statisticFolder);

        Statistic statistics = new Statistic(items);

        File statisticFile = new File(statisticFolder + "/statistic_by_" + nameFile + ".xml");

        JAXBContext context = JAXBContext.newInstance(Statistic.class);

        Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(statistics, statisticFile);

        marshaller.marshal(statistics, System.out);

    }

}
