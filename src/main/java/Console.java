import interfaces.IXMLService;
import xml.XMLService;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Scanner;

public class Console {

    static Scanner scanner = new Scanner(System.in);
    private static IXMLService xmlService = new XMLService();

    public static void main(String[] args) throws JAXBException, IOException {

        boolean isOpen = true;

        while (isOpen) {
            System.out.println("Select one option:");
            System.out.println("1.Parse Json file and create XML statistic and read in console");
            System.out.println("2.Close program");

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

    private static void readJsonAndCreateXmlStatisticChoice() throws JAXBException, IOException {

        boolean backToMenu = true;

        while (backToMenu) {
            System.out.println("For which attribute you want to get statistic?");
            System.out.println("1.Statistic by label");
            System.out.println("2.Statistic by genre");
            System.out.println("3.Statistic by year of foundation");
            System.out.println("4.Back to main menu");

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
                case 4:
                    backToMenu = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }
}

