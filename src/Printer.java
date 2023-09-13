
import java.util.Scanner;

public class Printer {
    Execution ex = new Execution();
    FileMatrix f = new FileMatrix();
    RandomMatrix r = new RandomMatrix();
    Menu menu = new Menu();
    Scanner in = new Scanner(System.in);
    ConsoleMatrix c = new ConsoleMatrix();

    public void go() {
        menu.printMenu();
        String userInput = in.nextLine().trim();
        while (!userInput.equals("0")) {
            switch (userInput) {
                case "1":
                    ex.execute(c.readConsoleDate());
                    menu.printMenu();
                    userInput = in.nextLine().trim();
                    break;
                case "2":
                    ex.execute(f.readFileDate());
                    menu.printMenu();
                    userInput = in.nextLine().trim();
                    break;
                case "3":
                    ex.execute(r.readRandomDate());
                    menu.printMenu();
                    userInput = in.nextLine().trim();
                    break;
                default:
                    System.out.println("Номер введен неверно");
                    menu.printMenu();
                    userInput = in.nextLine().trim();
            }
        }
    }
}

