import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;

import java.awt.BorderLayout;

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
}
