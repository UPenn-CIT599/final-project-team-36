
import com.workday.insights.timeseries.arima.Arima;
import com.workday.insights.timeseries.arima.struct.ArimaParams;
import com.workday.insights.timeseries.arima.struct.ForecastResult;

import java.util.ArrayList;

public class ArimaForecaster {
    /**
     * Prepare input timeseries data.
     */
    private double[] dataArray;

    /**
     * Set ARIMA model parameters.
     */
    private int p;
    private int d;
    private int q;
    private int P;
    private int D;
    private int Q;
    private int m;
    private int forecastSize;

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

    public ArrayList<double[]> forcast(){
        /**
         * Obtain forecast result. The structure contains forecasted values and performance metric etc.
         */
        ArimaParams params = new ArimaParams(p, d, q, P, D, Q, m);

        ForecastResult forecastResult = Arima.forecast_arima(dataArray, forecastSize, params);
        /**
         * Read forecast values
         */
        double[] forecastData = forecastResult.getForecast(); // in this example, it will return { 2 }

        /**
         * You can obtain upper- and lower-bounds of confidence intervals on forecast values.
         * By default, it computes at 95%-confidence level. This value can be adjusted in ForecastUtil.java
         */
        double[] uppers = forecastResult.getForecastUpperConf();
        double[] lowers = forecastResult.getForecastLowerConf();

        /**
         * You can also obtain the root mean-square error as validation metric.
         */
        double rmse = forecastResult.getRMSE();

        /**
         * It also provides the maximum normalized variance of the forecast values and their confidence interval.
         */
        double maxNormalizedVariance = forecastResult.getMaxNormalizedVariance();

        /**
         * Finally you can read log messages.
         */
        String log = forecastResult.getLog();
        /**
         * build the output information with StringBuilder
         */

        ArrayList<double[]> result = new ArrayList<>();
        result.add(forecastData);
        result.add(uppers);
        result.add(lowers);
        result.add(new double[]{rmse});
        result.add(new double[]{maxNormalizedVariance});

        return result;
    }
}
