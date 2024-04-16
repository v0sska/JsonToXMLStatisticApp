import interfaces.IXMLService;
import xml.XMLService;

import javax.xml.bind.JAXBException;
import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);

    private static IXMLService xmlService = new XMLService();

    public static void main(String[] args) throws JAXBException {

        boolean isOpen = true;


        System.out.println("Select one option:");

        System.out.println("1.Parse Json file and create XML statistic and read in console");
        System.out.println("2.Close program");

        while (isOpen) {

            int variant = scanner.nextInt();

            switch (variant) {
                case 1:
                    readJsonAndCreateXmlStatisticChoice();
                    break;
                case 2:
                    isOpen = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    private static void readJsonAndCreateXmlStatisticChoice() throws JAXBException {

        System.out.println("For which attribute you want to get statistic?");

        System.out.println("1.Statistic by label");
        System.out.println("2.Statistic by genre");
        System.out.println("3.Statistic by year of foundation");

        int variant = scanner.nextInt();

        switch (variant) {
            case 1:
                xmlService.createXmlStatisticByLabel();
                break;
            case 2:
                xmlService.createXmlStatisticByGenre();
                break;
            case 3:
                xmlService.createXmlStatisticByFoundationYear();
                break;
            default:
                System.out.println("Invalid input");
                break;
        }
    }
}
