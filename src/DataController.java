
import java.util.ArrayList;
import java.util.Arrays;

public class DataController {
    private ArrayList<ClosePriceDailyData> dailyPrices;

    private double[] priceData;

    /**
     * read prices data from csv file, while we don't use it for the prediction for this time, which still need to tune the parameters.
     * several double Array will be use for the forecast test.
     * dailyPrices is used to store the data read from csv, which contains the close prices and the date.
     * Array priceData is used to store the close prices of the stock, which will be used in the prediction.
     */
    public DataController(String filename){
        DataReader dr = new DataReader(filename);
        dailyPrices = dr.read();
        priceData = new double[dailyPrices.size()];
        for(int i = 0; i < dailyPrices.size(); i ++){
            priceData[i] = dailyPrices.get(i).getClosePrice();
            //System.out.println(priceData[i]);
        }
    }
	/**
	 * run the forecast, then store the return result in StringBuilder, then convert to String for display;
	 * may use Array / ArrayList in the future work.
	 * @param data
	 * @param p
	 * @param d
	 * @param q
	 * @param forecastSize
	 * @return
	 */
    public String forecastControl(double[] data, int p, int d, int q, int forecastSize){
        ArimaForecaster af = new ArimaForecaster(data, p, d, q, forecastSize);
        ArrayList<double[]> forecastResult = af.forcast();
        StringBuilder sb = new StringBuilder();
        sb.append("The predicted data is: ");
        sb.append(Arrays.toString(forecastResult.get(0)) + ".\n");
        sb.append("The root mean-square error is: ");
        sb.append(Arrays.toString(forecastResult.get(3)) + ".\n");
        sb.append("The maximum normalized variance is: ");
        sb.append(Arrays.toString(forecastResult.get(4)) + ".");
        return sb.toString();
    }

    public ArrayList<ClosePriceDailyData> getDailyPrices() {
        return dailyPrices;
    }

    public double[] getPriceData() {
        return priceData;
    }

}
