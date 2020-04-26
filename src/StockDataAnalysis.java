
/**
 * This class performs the stock calculations for Team36 Stock Market program
 * 
 * @author chase
 *
 */
public class StockDataAnalysis {

    public StockDataAnalysis() {

    }

    /**
     * This method calculates the performance of the stock using the current price
     * and starting price as inputs. This returns the percentage performance.
     * 
     * @param currentPrice
     * @param startingPrice
     * @return
     */
    public double calculatePerformance(double currentPrice, double startingPrice) {
        double difference = currentPrice - startingPrice;
        double percentPerformance = (difference / startingPrice) * 100;

        return percentPerformance;

    }

    /**
     * This method calculated the change in price for the specified current price
     * and starting price. This method returns a double value
     * 
     * @param currentPrice
     * @param startingPrice
     * @return
     */
    public double calculateDelta(double currentPrice, double startingPrice) {
        double delta = currentPrice - startingPrice;
        return delta;
    }
}