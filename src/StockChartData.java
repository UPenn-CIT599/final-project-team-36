import java.util.List;

public class StockChartData {
    private static double[] priceData;
    int fromLastdays;
    
    

    public StockChartData() {
        
    }
    
    public static double[] getPriceData() {
        return priceData;
    }




    public int getFromLastdays() {
        return fromLastdays;
    }




    public void setPriceData(String symbol) {
        YahooController controller=new YahooController();
        List<ManageRecordTransactionBean> listOfHistoricalDataDaywise=controller.historicalStockDayWise(symbol, 90);
        priceData = new double[listOfHistoricalDataDaywise.size()];
        int i = 0;
        for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalDataDaywise) {
            //System.out.println(manageRecordTransactionBean.getClose());
            priceData[i++] = Double.parseDouble(manageRecordTransactionBean.getClose());
        }
    }
    public double[] getHistoricalData() {
        return priceData;
    }
}