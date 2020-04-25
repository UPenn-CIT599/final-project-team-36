

import com.workday.insights.timeseries.arima.*;
import com.workday.insights.timeseries.arima.struct.*;
import java.util.ArrayList;

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
     * Prepare input timeseries data.
     * Set ARIMA model parameters.
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
     * Obtain forecast result. The structure contains forecasted values and performance metric etc.
     * Read forecast values, We can obtain upper- and lower-bounds of confidence intervals on forecast values. By default, it computes at 95%-confidence level.
     * The root mean-square error and the maximum normalized variance of the forecast values and their confidence interval are provided.
     * The output information are build with StringBuilder
     */
    public ArrayList<double[]> forecast(){

        ArimaParams params = new ArimaParams(p, d, q, P, D, Q, m);

        ForecastResult forecastResult = Arima.forecast_arima(dataArray, forecastSize, params);

        double[] forecastData = forecastResult.getForecast();
        double[] uppers = forecastResult.getForecastUpperConf();
        double[] lowers = forecastResult.getForecastLowerConf();
        double rmse = forecastResult.getRMSE();
        double maxNormalizedVariance = forecastResult.getMaxNormalizedVariance();
        //String log = forecastResult.getLog();

        ArrayList<double[]> result = new ArrayList<>();
        result.add(forecastData);
        result.add(uppers);
        result.add(lowers);
        result.add(new double[]{rmse});
        result.add(new double[]{maxNormalizedVariance});
        return result;
    }
}
