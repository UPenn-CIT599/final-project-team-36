import java.text.DecimalFormat;

public class StockView {

    public StockView() {

    }

    private static DecimalFormat rounded = new DecimalFormat("0.00");

    /**
     * This method displays a summary view for the input stock including the
     * performance metrics over the past 90, 180, and 365 days
     * 
     * @param whichStock
     */
    public void displayStockView(String whichStock) {
        System.out.println("Current Stock: " + whichStock);
        StockDataAnalysis analysis = new StockDataAnalysis();
        double currentPrice = 30.2;// getStockData(whichStock, 0); //method to be replaced by Anna method for data
                                   // return
        double ninetyDayPrice = 35.1;// getStockData(whichStock, 90); //method to be replaced by Anna method for data
                                     // return
        double oneEightyPrice = 22;// getStockData(whichStock, 180); //method to be replaced by Anna method for
                                   // data return
        double threeSixtyFivePrice = 5.99;// getStockData(whichStock, 365); //method to be replaced by Anna method for
                                          // data return

        System.out.println("Current Price: " + currentPrice); // displayCurrentPrice(whichStock)); this method will need
                                                              // to be added with data class
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Time Period", "Start Price", "Current Price", "Delta",
                "Performance");
        System.out.println();
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        // System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Past 90 Days", ninetyDayPrice, currentPrice,
                rounded.format(analysis.calculateDelta(currentPrice, ninetyDayPrice)),
                rounded.format(analysis.calculatePerformance(currentPrice, ninetyDayPrice)) + "%");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Past 180 Days", oneEightyPrice, currentPrice,
                rounded.format(analysis.calculateDelta(currentPrice, oneEightyPrice)),
                rounded.format(analysis.calculatePerformance(currentPrice, oneEightyPrice)) + "%");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Past 365 Days", threeSixtyFivePrice, currentPrice,
                rounded.format(analysis.calculateDelta(currentPrice, threeSixtyFivePrice)),
                rounded.format(analysis.calculatePerformance(currentPrice, threeSixtyFivePrice)) + "%");
        System.out.println();
        System.out.println();

    }

    /**
     * This displays what the user actions are in the program using the stock as an
     * input. The price predictor option is only enabled for S&P500
     * 
     * @param whichStock
     */
    public void displayUserActions(String whichStock) {
        System.out.println("Please enter the option on how you would like to proceed:");
        System.out.println("1: Choose an individual stock to view");
        System.out.println("2: Show 90 day line chart");
        System.out.println("3: Print out stock price daily history");
        if (whichStock.equals("S&P 500")) {
            System.out.println("4: View the price predictor for S&P 500");
        }
        System.out.println("X: Exit the program");
    }

    /**
     * This displays the user options for choosing an individual stock - there are
     * default choices provided and user also has the option to enter a specific
     * stock ticker symbol
     */
    public void displayStockChoices() {
        System.out.println("1: Apple (APPL)");
        System.out.println("2: Google (GOOGL)");
        System.out.println("3: Microsoft (M)");
        System.out.println("4: I want to choose a stock (please use ticker symbol - example: APPL)");
        System.out.println("5: Back to S&P500");
        System.out.println("X: Exit Program");
    }
}
