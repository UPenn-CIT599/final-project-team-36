
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataController {
	
    
    private int p;
    private int d;
    private int q;
    private int forecastSize;
    //private ArrayList<HistoricalDailyPriceData> historicalDailyPrices;
    private static double[] priceData;
    int fromLastdays;

	/**
     * read prices data from csv file, while we don't use it for the prediction for this time, which still need to tune the parameters.
     * several double Array will be use for the forecast test.
     * dailyPrices is used to store the data read from csv, which contains the close prices and the date.
     * Array priceData is used to store the close prices of the stock, which will be used in the prediction.
     */
    public DataController(){
		p = 1;
		d = 0;
		q = 1;
		forecastSize = 7;
<<<<<<< HEAD
        DataReader dr = new DataReader("GSPC.csv");
        historicalDailyPrices = dr.read();
        priceData = new double[historicalDailyPrices.size()];
        for(int i = 0; i < historicalDailyPrices.size(); i ++){
            priceData[i] = historicalDailyPrices.get(i).getClosePrice();
        }
        
=======
        //DataReader dr = new DataReader("src/GSPC.csv");
//        historicalDailyPrices = dr.read();
//        priceData = new double[historicalDailyPrices.size()];
//        for(int i = 0; i < historicalDailyPrices.size(); i ++){
//            priceData[i] = historicalDailyPrices.get(i).getClosePrice();
//        }	
		fromLastdays = 1000;
		//String symbol="^GSPC";
    }
    
    public void setPriceData(String symbol) {
    	YahooController controller=new YahooController();
    	List<ManageRecordTransactionBean> listOfHistoricalDataDaywise=controller.historicalStockDayWise(symbol,fromLastdays);
		priceData = new double[listOfHistoricalDataDaywise.size()];
		int i = 0;
		for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalDataDaywise) {
			//System.out.println(manageRecordTransactionBean.getClose());
			priceData[i++] = Double.parseDouble(manageRecordTransactionBean.getClose());
		}
>>>>>>> d195468a80a69fab7699960ab2ae464168cf8b1c
    }
    
    public ArrayList<double[]> forecast(){
        ArimaForecaster af = new ArimaForecaster(priceData, p, d, q, forecastSize);
        ArrayList<double[]> forecastResult = af.forecast();
        return forecastResult;
    }
    
    public ArrayList<double[]> forecastTest(){
    	double[] testData = Arrays.copyOfRange(priceData, 0, priceData.length - forecastSize);
        ArimaForecaster af = new ArimaForecaster(testData, p, d, q, forecastSize);
        ArrayList<double[]> forecastResult = af.forecast();
        return forecastResult;
    }

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
    
    public double[] forecastClosePrice(){
        double[] closePrice = forecast().get(0);
        return closePrice;
    }
    
    public double[] forecastTestPrice() {
    	return forecastTest().get(0);
    }
    
    public double[] gethistoricalClosePrice(){
    	return priceData;
    }

    
}
