import java.util.List;

/**
 * This class pulls the data to pass to the line chart
 * class for the specified Stock
 */
public class StockChartData {
    private double[] priceData;
    int fromLastdays;
    
    
    public StockChartData(String symbol) {
    	YahooController controller=new YahooController();
        List<ManageRecordTransactionBean> listOfHistoricalDataDaywise=controller.historicalStockDayWise(symbol, 800);
        priceData = new double[listOfHistoricalDataDaywise.size()];
        int i = 0;
        for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalDataDaywise) {
            //System.out.println(manageRecordTransactionBean.getClose());
            priceData[i++] = Double.parseDouble(manageRecordTransactionBean.getClose());
        }
        
    }
    

    public int getFromLastdays() {
        return fromLastdays;
    }


    public double[] getHistoricalData() {
        return priceData;
    }
}