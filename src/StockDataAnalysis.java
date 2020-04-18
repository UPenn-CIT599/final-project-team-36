import java.time.LocalDate;

public class StockDataAnalysis {

    public StockDataAnalysis() {
        
    }
    
    LocalDate date = LocalDate.now();
    LocalDate ninetyDate = date.minusDays(90);
    LocalDate oneEightyDate = date.minusDays(180);
    LocalDate oneYearDate = date.minusDays(365);
    
    /**
     * This method calculates the performance of the stock using the current price
     * and starting price as inputs.  This returns the percentage performance.
     * @param currentPrice
     * @param startingPrice
     * @return
     */
    public double calculatePerformance(double currentPrice, double startingPrice) {
        double difference = currentPrice - startingPrice;
        double percentPerformance = (difference / startingPrice) * 100;
        
        return percentPerformance;
        
    }
}