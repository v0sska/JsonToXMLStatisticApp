import java.util.Scanner;

public class Console {

    public static void main(String[] args) {
        boolean isOpen = true;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select one option:");

        System.out.println("1.Read Json file and create XML statistic");
        System.out.println("2.Read XML file statistic in app");
        System.out.println("3.Close program");

        int variant = scanner.nextInt();

        while (isOpen){

            switch (variant){
                case 1:

                    break;
                case 2:

                    break;
                case 3:
                    isOpen = false;
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }

        }
    }

    //TODO зробити сьогодні сутність для парсингу json і запис її статистики в xml!!!!
}
