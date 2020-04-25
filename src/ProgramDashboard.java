import java.util.Scanner;

import javafx.application.Application;
import javafx.stage.Stage;

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
    StockLineChart chart = new StockLineChart();

    /**
     * Constructs a new StockMarket Program - sets up the summary values and
     * displays the summary view to the user with the program options
     */
    public ProgramDashboard() {
        this.summary = new StockView();

        System.out.println("Welcome to Team 36 Stock Market Program");
        System.out.println("");
        System.out.println(
                "We have many excellent features in this program that we hope that you will enjoy, including:");
        System.out
                .println("    -Connection to the YahooFinance API so you enjoy the most up to date price information");
        System.out.println("    -A machine learning price prediction algorithm for the S&P500");
        System.out.println("    -Default price performance summary information");
        System.out.println("    -Stock 90 day performance line chart");
        System.out.println("");

    }

    /**
     * the launch program method starts the program and runs through the user
     * requested steps until the user decides to exit the program.
     */
    void launchProgram() {
        Scanner userOption = new Scanner(System.in);
        String stock = "S&P 500";
        for (int i = 0; i < 1000; i++) {
            System.out.println();
            summary.displayStockView(stock);
            summary.displayUserActions(stock);
            String choice1 = userOption.nextLine();
            checkExit(choice1);
            int whichOption = 0;

            if (choice1.equals("1")) {
                // Scanner stockPick = new Scanner(System.in);
                for (int j = 0; j < 1; j++) {

                    System.out.println("Which Stock would you like to view?");
                    // call display method for the list of available stocks
                    // displayStockList();
                    /*
                     * Hard-coding options but this will display the stocks that are in the dataset
                     */
                    if (whichOption == 0) {
                        summary.displayStockChoices();
                        whichOption++;
                    } else {
                        summary.displayUserActions(stock);
                    }

                    String choice2 = userOption.nextLine();
                    checkExit(choice2);
                    // checkInt(choice2);
                    // choice2.toUpperCase()
                    if (choice2.equals("1")) {
                        System.out.println("Apple Stock View");
                        stock = "APPL";
                    } else if (choice2.equals("2")) {
                        summary.displayStockView("Google");
                        System.out.println("Google Stock View");
                        stock = "Google";

                    } else if (choice2.equals("3")) {
                        summary.displayStockView("Microsoft");
                        System.out.println("Microsoft Stock View");
                        stock = "Microsoft";
                    } else if (choice2.equals("4")) {
                        for (int l = 0; l < 1; l++) {
                            System.out.println("Please enter the stock symbol you wish to view");
                            System.out.println("Example - Type 'GE' to view General Electric");
                            String choice3 = userOption.nextLine();
                            checkExit(choice3);
                            stock = choice3;
                        }

                    } else if (choice2.equals("5")) {
                        //
                        System.out.println("Return to summary");
                        stock = "S&P 500";
                    } else {
                        System.out.println("Invalid response - please try again");
                        choice2 = userOption.next();
                    }
                }
            } else if (choice1.equals("3")) {
                StockLineChart graphic = new StockLineChart("S&P500");
                Application.launch(StockLineChart.class, stock);
                
            } else if (choice1.equals("X") || choice1.equals("x")) {
                System.out.println("Thank you for using our program, have a great day!");
                userOption.close();
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
