import java.util.List;
import java.util.Scanner;

import yahoofinance.Stock;

/**
 * Represents the Stock Market program. This class will display the initial
 * summary and options to the user and will call other methods to navigate user
 * through program
 * 
 * @author chase
 */
public class ProgramDashboard {

    StockView summary = new StockView();
    public int chartOpened = 0;

    public String stock = "^GSPC";
    StockLineChart chart = new StockLineChart(stock);

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
        System.out.println("    -A machine learning price prediction algorithm for the selected stock");
        System.out.println("    -Default price performance summary information");
        System.out.println("    -Stock 3 years performance line chart");
        System.out.println("");

    }

    /**
     * the launch program method starts the program and runs through the user
     * requested steps until the user decides to exit the program.
     */
    public void launchProgram() {
        Scanner userOption = new Scanner(System.in);
        YahooController controller = new YahooController();

        String stock = "^GSPC";

        for (int i = 0; i < 1000; i++) {
            System.out.println();
            try {
                summary.displayStockView(stock);
            } catch (Exception e) {
                System.out.println("Stock is not valid, please enter new stock symbol");
                stock = userOption.nextLine().toUpperCase();
                continue;
            }
            summary.displayUserActions(stock, chartOpened);
            String choice1 = userOption.nextLine();
            checkExit(choice1);

            if (choice1.equals("1")) {
                // Scanner stockPick = new Scanner(System.in);
                for (int j = 0; j < 1; j++) {

                    System.out.println("Which Stock would you like to view?");
                    summary.displayStockChoices();
                    String choice2 = userOption.nextLine();
                    checkExit(choice2);
                    if (choice2.equals("1")) {
                        System.out.println("Apple Stock View");
                        stock = "AAPL";
                    } else if (choice2.equals("2")) {
                        System.out.println("Google Stock View");
                        stock = "GOOGL";

                    } else if (choice2.equals("3")) {
                        System.out.println("Microsoft Stock View");
                        stock = "MSFT";
                    } else if (choice2.equals("4")) {
                        for (int l = 0; l < 1; l++) {
                            System.out.println("Please enter the stock symbol you wish to view");
                            System.out.println("Example - Type 'GE' to view General Electric");
                            String choice3 = userOption.nextLine().toUpperCase();
                            checkExit(choice3);
                            stock = choice3;
                        }

                    } else if (choice2.equals("5")) {
                        System.out.println("Return to summary");
                        stock = "^GSPC";
                        //summary.displayStockView("^GSPC");
                    } else {
                        System.out.println("Invalid response - please try again");
                        choice2 = userOption.next();
                    }
                }
            } else if (choice1.equals("2")) {
                StockLineChart slc = new StockLineChart(stock);
                slc.display();
                chartOpened = 1;
            } else if (choice1.equals("3")) {
                String symbol = stock;
                System.out.println("#####################TRY TO GET REAL TIME DATA BY SINGLE SYMBOL############");

                List<Stock> listOfRealTimeData = controller.fetchRealTimeData(symbol);
                for (Stock stock1 : listOfRealTimeData) {
                    // System.out.println(symbol +" - "+stock.getQuote().toString());
                    System.out.println(symbol + " Close - " + stock1.getQuote().getPreviousClose());
                }
                System.out.println("#####################TRY TO GET HISTORCAL DATA  YEAR WISE############");
                int fromLastYear = 5;

                List<ManageRecordTransactionBean> listOfHistoricalData = controller.historicalStock(symbol,
                        fromLastYear);
                System.out.println(
                        "STOCK      DATE        LOW           HIGH         OPEN         CLOSE        ADJCLOSE");
                for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalData) {
                    System.out.println(manageRecordTransactionBean.getStockName() + "     "
                            + manageRecordTransactionBean.getDate() + "   " + manageRecordTransactionBean.getLow()
                            + "  " + manageRecordTransactionBean.getHigh() + "   "
                            + manageRecordTransactionBean.getOpen() + "  " + manageRecordTransactionBean.getClose()
                            + "  " + manageRecordTransactionBean.getAdjClose());
                }

                System.out.println("#####################TRY TO GET HISTORCAL DATA  Day WISE############");
                int fromLastdays = 30;

                List<ManageRecordTransactionBean> listOfHistoricalDataDaywise = controller
                        .historicalStockDayWise(symbol, fromLastdays);
                System.out.println("STOCK       Date          CLOSE");
                for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalDataDaywise) {
                    System.out.println(manageRecordTransactionBean.getStockName() + "     "
                            + manageRecordTransactionBean.getDate() + "     " + manageRecordTransactionBean.getClose());
                }

            } else if (choice1.equals("4")) {
                PredictorRunner pr = new PredictorRunner(stock);
                pr.lineChart();
                chartOpened = 1;
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
     * Method to get the stock as a string
     * 
     * @return
     */
    public String getStock() {
        return stock;
    }

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
