import java.util.Scanner;

/**
 * Represents the Stock Market program. This class will display the initial
 * summary and options to the user and will call other methods to navigate user
 * through program
 * 
 * @author chase
 *
 */
public class ProgramDashboard {

    StockView summary = new StockView();

    /**
     * Constructs a new StockMarket Program - sets up the summary values and
     * displays the summary view to the user with the program options
     */
    public ProgramDashboard() {
        this.summary = new StockView();

        System.out.println("Welcome to Team 36 Stock Market Program");
        System.out.println("");

    }

    /**
     * the launch program method starts the program and runs through the user
     * requested steps until the user decides to exit the program.
     */
    void launchProgram() {
        Scanner userOption = new Scanner(System.in);
        int exitProgram = 0;
        String stock = "S&P 500";
        while (exitProgram == 0) {
            System.out.println();
            summary.displayStockView(stock);
            System.out.println("Please enter the option on how you would like to proceed:");
            System.out.println("1: Navigate to individual stock view");
            System.out.println("2: Calculate performance of S&P 500 based on entered dates");
            if (stock.equals("S&P 500")) {
                System.out.println("3: View the price predictor for S&P 500");
            }
            System.out.println("X: Exit the program");
            String choice1 = userOption.next();
            checkExit(choice1);
            userOption.nextLine();

            /*
             * while (!userOption.hasNextInt()) {
             * System.out.println("Input is not a number, try again");
             * userOption.nextLine(); }
             */
            if (choice1.equals("1")) {
                // Scanner stockPick = new Scanner(System.in);
                System.out.println("Which Stock would you like to view?");
                // call display method for the list of available stocks
                // displayStockList();
                /*
                 * Hard-coding options but this will display the stocks that are in the dataset
                 */
                System.out.println("1: Apple (APPL)");
                System.out.println("2: Google (GOOGL)");
                System.out.println("3: Microsoft (M)");
                System.out.println("4: General Electric (GE)");
                System.out.println("5: Back to S&P500");
                System.out.println("X: Exit Program");
                String choice2 = userOption.next();
                checkExit(choice2);
                // checkInt(choice2);
                // choice2.toUpperCase()
                if (choice2.equals("1")) {
                    // displayStockView("Apple");
                    System.out.println("Apple Stock View");
                    stock = "Apple";

                } else if (choice2.equals("2")) {
                    // displayStockView("Google");
                    System.out.println("Google Stock View");
                    stock = "Google";

                } else if (choice2.equals("3")) {
                    // displayStockView("Microsoft");
                    System.out.println("Microsoft Stock View");
                    stock = "Microsoft";
                } else if (choice2.equals("4")) {
                    // displayStockView("GE");
                    System.out.println("GE Stock View");
                    stock = "General Electric";
                } else if (choice2.equals("5")) {
                    // displayStockView("S&P500");
                    System.out.println("Return to summary");
                    stock = "S&P 500";
                } else {
                    System.out.println("Invalid response - please try again");
                    choice2 = userOption.next();
                }

            } else if (choice1.equals("X") || choice1.equals("x")) {
                System.out.println("Thank you for using our program, have a great day!");
                return;
            } else {
                System.out.println("Invalid response - please try again");
            }

        }
        userOption.close();
    }

    /**
     * This method checks whether user entered an integer
     * 
     * @param userInput
     */
    /*
     * void checkInt(String userInput) { while (!userInput.par) {
     * System.out.println("Input is not a number, try again"); userInput.nextLine();
     * } }
     */
    /**
     * This method will check if user enters exit command and exit the program
     * 
     * @param userInput
     */
    void checkExit(String userInput) {
        if (userInput.equals("X") || userInput.equals("x")) {
            System.out.println("Thank you for using our program, have a great day!");
            System.exit(0);
        }

    }

}
