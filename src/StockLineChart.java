import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.awt.BorderLayout;
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.stage.Stage;

import yahoofinance.Stock;

public class StockLineChart {

	
	private String symbol;
	
	public StockLineChart(String symbol) {
		this.symbol = symbol;
	}

  public void display() {

    // Create Chart
    final XYChart chart =
        new XYChartBuilder()
            .width(1000)
            .height(400)
            .title("Historical Stock Price Line Chart")
            .xAxisTitle("Date")
            .yAxisTitle("Price")
            .build();

    // Customize Chart
    //chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
    //chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);

    // Series
    
    StockChartData stockData = new StockChartData(symbol);
    double[] dataY = stockData.getHistoricalData();
    double[] dataX = new double[dataY.length];
    for(int i = dataY.length - 1; i >= 0; i--) {
    	dataX[i] = i - (dataY.length - 1);
    }
    chart.addSeries("Stock Performance of Last 3 Year", dataX, dataY);

    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(
        new Runnable() {

          @Override
          public void run() {

            // Create and set up the window.
            JFrame frame = new JFrame("chart");
            frame.setLayout(new BorderLayout());
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // chart
            JPanel chartPanel = new XChartPanel<XYChart>(chart);
            frame.add(chartPanel, BorderLayout.CENTER);

            // label
            JLabel label = new JLabel("", SwingConstants.CENTER);
            frame.add(label, BorderLayout.SOUTH);

            // Display the window.
            frame.pack();
            frame.setVisible(true);
          }
        });
  }
  
////    String stock = null;
//    /*String stock = null;
//    LocalDate date = LocalDate.now();
//    LocalDate ninetyDate = date.minusDays(90);
//    LocalDate oneEightyDate = date.minusDays(180);
//    LocalDate oneYearDate = date.minusDays(365);
//    */
//    
////    public StockLineChart() {
////        
////    }
//    
//   @Override public void start(Stage stage) {
//        stage.setTitle("90 Day Line Chart");
//        final NumberAxis xAxis = new NumberAxis();
//        final NumberAxis yAxis = new NumberAxis();
//        xAxis.setLabel("Date");
//        yAxis.setLabel("Price");
//        //YahooController stockCheck = new YahooController();
//        //System.out.println(stockCheck.historicalStockDayWise("APPL", 1));
//        
//        final LineChart<Number,Number> lineChart = 
//                new LineChart<Number,Number>(xAxis, yAxis);
//        
//        lineChart.setTitle("90 Day Line Chart");
//        XYChart.Series series = new XYChart.Series();
//        series.setName("chart");
//        //YahooController controller = new YahooController();
//        //StockView sv = new StockView(stock);
//        //List<ManageRecordTransactionBean> listOfHistoricalDataDaywise = controller.historicalStockDayWise(stock, 90);
//        
//        StockChartData stockData = new StockChartData();
//        double[] historicalData = stockData.getHistoricalData();
//        
//        for(int i = historicalData.length - 1; i >= 0; i--) {
//        	series.getData().add(new XYChart.Data((historicalData.length - i), historicalData[i]));
//        }
//        Scene scene = new Scene(lineChart,800,600);
//        lineChart.getData().add(series);
//        
//        stage.setScene(scene);
//        stage.show();
//    }
//    
////   public StockLineChart(String stock) {
////       this.stock = stock;
////   }
//   
//   //Double.parseDouble(listOfHistoricalDataDaywise.get(0).getClose().toString()))
//   
//    public void display() {
//        Platform.setImplicitExit(false);
//        launch();
//    }
}
