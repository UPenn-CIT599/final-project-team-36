import java.text.DecimalFormat;
import java.util.List;

import yahoofinance.Stock;

/**
 * This stock displays the stock information and user options for Team36 stock
 * market program
 * 
 * @author chase
 *
 */
public class StockView {

    public String stock = null;

    public StockView(String stock) {
        this.stock = stock;
    }

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

        double currentPrice = 0;
        double ninetyDayPrice = 0;
        double oneEightyPrice = 0;
        double threeSixtyFivePrice = 0;
        StockDataAnalysis analysis = new StockDataAnalysis();
        YahooController controller = new YahooController();
        List<Stock> listOfRealTimeData = controller.fetchRealTimeData(whichStock);
        for (Stock stock : listOfRealTimeData) {
            currentPrice = stock.getQuote().getPreviousClose().doubleValue();
        }
        List<ManageRecordTransactionBean> listOfHistoricalDataDaywise = controller.historicalStockDayWise(whichStock,
                90);
        ninetyDayPrice = Double.parseDouble(listOfHistoricalDataDaywise.get(0).getClose().toString());

        List<ManageRecordTransactionBean> listOfHistoricalDataDaywise1 = controller.historicalStockDayWise(whichStock,
                180);
        oneEightyPrice = Double.parseDouble(listOfHistoricalDataDaywise1.get(0).getClose().toString());
        /*
         * for (ManageRecordTransactionBean manageRecordTransactionBean :
         * listOfHistoricalDataDaywise1) { oneEightyPrice =
         * Double.parseDouble(manageRecordTransactionBean.getClose().toString()); }
         */
        List<ManageRecordTransactionBean> listOfHistoricalDataDaywise2 = controller.historicalStockDayWise(whichStock,
                365);
        threeSixtyFivePrice = Double.parseDouble(listOfHistoricalDataDaywise2.get(0).getClose().toString());
        // List<ManageRecordTransactionBean> listOfHistoricalData =
        // controller.historicalStock(whichStock,1);
        // = Double.parseDouble(listOfHistoricalData.get(0).getClose().toString());

        System.out.println("Current Stock: " + whichStock);
        System.out.println("Last Close Price: " + currentPrice); // displayCurrentPrice(whichStock)); this method will
                                                                 // need
                                                                 // to be added with data class
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Time Period", "Start Price", "Current Price", "Delta",
                "Performance");
        System.out.println();
        System.out.println(
                "--------------------------------------------------------------------------------------------------");
        // System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Past 90 Days", rounded.format(ninetyDayPrice), currentPrice,
                rounded.format(analysis.calculateDelta(currentPrice, ninetyDayPrice)),
                rounded.format(analysis.calculatePerformance(currentPrice, ninetyDayPrice)) + "%");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Past 180 Days", rounded.format(oneEightyPrice),
                currentPrice, rounded.format(analysis.calculateDelta(currentPrice, oneEightyPrice)),
                rounded.format(analysis.calculatePerformance(currentPrice, oneEightyPrice)) + "%");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Past 365 Days", rounded.format(threeSixtyFivePrice),
                currentPrice, rounded.format(analysis.calculateDelta(currentPrice, threeSixtyFivePrice)),
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
    public void displayUserActions(String whichStock, int chartOpen) {
        System.out.println("Please enter the option on how you would like to proceed:");
        System.out.println("1: Choose an individual stock to view");
        System.out.println("2: Show Stock line chart");
        System.out.println("3: Print out stock price daily history");
        // if (whichStock.equals("S&P 500")) {
        System.out.println("4: View the price predictor for " + whichStock);
        // }
        System.out.println("X: Exit the program");
        if (chartOpen > 0) {
            System.out.println("NOTE: If you exit the chart the program will terminate");
        }
    }

    /**
     * This displays the user options for choosing an individual stock - there are
     * default choices provided and user also has the option to enter a specific
     * stock ticker symbol
     */
    public void displayStockChoices() {
        System.out.println("1: Apple (AAPL)");
        System.out.println("2: Google (GOOGL)");
        System.out.println("3: Microsoft (MSFT)");
        System.out.println("4: I want to choose a stock (please use ticker symbol - example: GE)");
        System.out.println("5: Back to S&P500");
        System.out.println("X: Exit Program");
    }
}
