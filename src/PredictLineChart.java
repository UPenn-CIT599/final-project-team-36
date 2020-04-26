import java.awt.BorderLayout;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries.XYSeriesRenderStyle;
import org.knowm.xchart.style.Styler.LegendPosition;


public class PredictLineChart {
	
	private String symbol;
	
	public PredictLineChart(String symbol) {
		this.symbol = symbol;
	}

  public void show() {

    // Create Chart
    final XYChart chart =
        new XYChartBuilder()
            .width(1000)
            .height(400)
            .title("Predict Stock Price")
            .xAxisTitle("Past and Future Days")
            .yAxisTitle("Stock Close Price")
            .build();

    // Customize Chart
    //chart.getStyler().setLegendPosition(LegendPosition.InsideNE);
    //chart.getStyler().setDefaultSeriesRenderStyle(XYSeriesRenderStyle.Area);

    // Series
    
    DataController dc = new DataController(symbol);
    
    double[] historicalData = dc.gethistoricalClosePrice();
    double[] histDataY = Arrays.copyOfRange(historicalData, historicalData.length - 60, historicalData.length);
    double[] histDataX = new double[histDataY.length];
    
    for(int i = -59; i<= 0; i++) {
    	histDataX[59 + i] = i;
    }
    chart.addSeries("Price of Past 30 Days", histDataX, histDataY);
    
    double[] testDataY = dc.forecastTestPrice();
    double[] testDataX = new double[testDataY.length];
    for(int i = -6; i<= 0; i++) {
    	testDataX[i + 6] = i;
    }
    chart.addSeries("Test Predict Price of Past 7 Days", testDataX, testDataY);
    
    double[] predictDataY = dc.forecastClosePrice();
    double[] predictDataX = new double[predictDataY.length];
    for(int i = 1; i<= 7; i++) {
    	predictDataX[i - 1] = i;
    }
    chart.addSeries("Predict Price of the Future 7 Days", predictDataX, predictDataY);

    // Schedule a job for the event-dispatching thread:
    // creating and showing this application's GUI.
    javax.swing.SwingUtilities.invokeLater(
        new Runnable() {

          @Override
          public void run() {

            // Create and set up the window.
            JFrame frame = new JFrame("Predict Stock Price");
            frame.setLayout(new BorderLayout());
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            // chart
            JPanel chartPanel = new XChartPanel<XYChart>(chart);
            frame.add(chartPanel, BorderLayout.CENTER);

            // label
            JLabel label = new JLabel("ARIMA PREDICTOR", SwingConstants.CENTER);
            frame.add(label, BorderLayout.SOUTH);

            // Display the window.
            frame.pack();
            frame.setVisible(true);
          }
        });
  }
}