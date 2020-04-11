import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class JunitTestor {

	DataController dc = new DataController("GSPC.csv");

    /**
     * daily price store for the prediction, check the price of the 1st day of the data, and tht total length of the data Array.
     */
    @Test
    public void getPriceData() {
        double[] priceData = dc.getPriceData();
        assertEquals(17.66, priceData[0], "Error with data reading!");
        assertEquals(23166, priceData.length, "Error with data reading!");
    }
    /**
     * test of daily price read, check the data: year - month - day
     */
    @Test
    public void getDateOfData() {
        ArrayList<ClosePriceDailyData> closePrice =  dc.getDailyPrices();
        assertEquals(1927, closePrice.get(0).getYear(), "Error with time of year");
        assertEquals(12, closePrice.get(0).getMonth(), "Error with time of Month");
        assertEquals(30, closePrice.get(0).getDay(), "Error with time of Month");
    }

    /**
     * use the Fibonacci sequence and numbers increasing by 1 to check the accuracy of the prediction, with delta 0.1
     */
    @Test
    public void getPrediction() {
        double[] data1 = new double[]{0,1,1,2,3,5,8,13,21,34,55,89,144};
        double[] data2 = new double[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        ArimaForecaster testResult1 = new ArimaForecaster(data1, 4, 1, 3, 1);
        ArimaForecaster testResult2 = new ArimaForecaster(data2, 4, 1, 3, 1);
        assertEquals(233, testResult1.forcast().get(0)[0], 0.1, "prediction of fibonacci is wrong!");
        assertEquals(17, testResult2.forcast().get(0)[0], 0.1,"prediction of increasing by 1 is wrong!");
    }

}
