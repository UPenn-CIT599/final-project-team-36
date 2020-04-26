import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Collect data, run the forecast, and store the data.
 * @author Dongchao Xu
 *
 */
public class DataController {

    private int p;
    private int d;
    private int q;
    private int forecastSize;
    private double[] priceData;
    private int fromLastdays;

	/**
	 * Pass the symbol to YahooController to collect the stock information we want.
	 * Model parameters are tuned here.
	 * @param symbol
	 */
    public DataController(String symbol){
		p = 1;
		d = 0;
		q = 1;
		forecastSize = 7;
		fromLastdays = 1000;
		YahooController controller=new YahooController();
    	List<ManageRecordTransactionBean> listOfHistoricalDataDaywise=controller.historicalStockDayWise(symbol,fromLastdays);
		priceData = new double[listOfHistoricalDataDaywise.size()];
		int i = 0;
		for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalDataDaywise) {
			priceData[i++] = Double.parseDouble(manageRecordTransactionBean.getClose());
		}
    }
    
    /**
     * Run the ArimaForecaster to predict the future stock price. 
     * Store the result in forecastRsult.
     * @return
     */
    public ArrayList<double[]> forecast(){
        ArimaForecaster af = new ArimaForecaster(priceData, p, d, q, forecastSize);
        ArrayList<double[]> forecastResult = af.forecast();
        return forecastResult;
    }
    
    /**
     * Run the ArimaForecaster to predict test stock price (which is the historical price with the past (forecastSize) days.
     * Store the result in forecastRsult.
     * @return
     */
    public ArrayList<double[]> forecastTest(){
    	double[] testData = Arrays.copyOfRange(priceData, 0, priceData.length - forecastSize);
        ArimaForecaster af = new ArimaForecaster(testData, p, d, q, forecastSize);
        ArrayList<double[]> forecastResult = af.forecast();
        return forecastResult;
    }

    /**
     * Get the forecastResult and store in StringBuilder.
     * Output String for the display at frontside.
     * @return
     */
    public String forecastPrintInformation(){
        ArrayList<double[]> forecastResult = forecast();
        StringBuilder sb = new StringBuilder();
        sb.append("The predicted stock price for the next 7 days: ");
        sb.append(Arrays.toString(forecastResult.get(0)) + ".\n");
        sb.append("The root mean-square error is: ");
        sb.append(Arrays.toString(forecastResult.get(3)) + ".\n");
        sb.append("The maximum normalized variance is: ");
        sb.append(Arrays.toString(forecastResult.get(4)) + ".");
        return sb.toString();
    }
    
    /**
     * Get the predicted close price from the forecast result.
     * @return
     */
    public double[] forecastClosePrice(){
        double[] closePrice = forecast().get(0);
        return closePrice;
    }
    
    /**
     * Get the predicted test close price from the test result.
     * @return
     */
    public double[] forecastTestPrice() {
    	return forecastTest().get(0);
    }
    
    /**
     * Get the historical price data for the comparing showing in lineChart.
     * @return
     */
    public double[] gethistoricalClosePrice(){
    	return priceData;
    }

    
}
