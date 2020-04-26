
import com.workday.insights.timeseries.arima.*;
import com.workday.insights.timeseries.arima.struct.*;
import java.util.ArrayList;

/**
 * Run ARIMA model, and get the result.
 * @author Dongchao Xu
 *
 */
public class ArimaForecaster {
    
    private double[] dataArray;
    private int p;
    private int d;
    private int q;
    private int P;
    private int D;
    private int Q;
    private int m;
    private int forecastSize;
    
    /**
     * Set ARIMA model parameters. All parameters are tuned with test data.
     * @param dataArray
     * @param p
     * @param d
     * @param q
     * @param forecastSize
     */
    public ArimaForecaster(double[] dataArray, int p, int d, int q, int forecastSize){
        this.dataArray = dataArray;
        this.p = p;
        this.d = d;
        this.q = q;
        this.forecastSize = forecastSize;
        this.P = 0;
        this.D = 0;
        this.Q = 0;
        this.m = 0;
    }

    /**
     * Obtain forecast result. 
     * Result contains forecasted close price values and performance metric etc.
     * Read forecast values, We can obtain upper- and lower-bounds of confidence intervals on forecast values. By default, it computes at 95%-confidence level.
     * The root mean-square error and the maximum normalized variance of the forecast values are provided.
     * The output information are in the ArrayList<double[]> for the usage of prediction.
     * @return
     */
    public ArrayList<double[]> forecast(){
        ArimaParams params = new ArimaParams(p, d, q, P, D, Q, m);
        ForecastResult forecastResult = Arima.forecast_arima(dataArray, forecastSize, params);
        double[] forecastData = forecastResult.getForecast();
        double[] uppers = forecastResult.getForecastUpperConf();
        double[] lowers = forecastResult.getForecastLowerConf();
        double rmse = forecastResult.getRMSE();
        double maxNormalizedVariance = forecastResult.getMaxNormalizedVariance();
        ArrayList<double[]> result = new ArrayList<>();
        
        result.add(forecastData);
        result.add(uppers);
        result.add(lowers);
        result.add(new double[]{rmse});
        result.add(new double[]{maxNormalizedVariance});
        return result;
    }
}
