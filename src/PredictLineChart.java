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

/**
 * LineChart Created in running according to user's choice.
 * Close the GUI will stop the program running.
 * @author Dongchao Xu
 *
 */
public class PredictLineChart {
	private String symbol;
	/**
	 * Pass symbol the field in the class, to pass and get data from DataContoller.
	 * @param symbol
	 */
	public PredictLineChart(String symbol) {
		this.symbol = symbol;
	}

	/**
	 * Obtain data from DataController.
	 * Create chart and data series.
	 * Historical data, test predict data and predict data are displayed in the lineChart.
	 * Schedule a job for the event-dispatching thread.
	 * Creating and showing this application's GUI.
	 */
	public void show(){
		final XYChart chart =
				new XYChartBuilder()
				.width(1000)
				.height(400)
				.title("Predict Stock Price")
				.xAxisTitle("Past and Future Days")
				.yAxisTitle("Stock Close Price")
				.build();

		DataController dc = new DataController(symbol);
		//historical stock price of the past 60 days.
		double[] historicalData = dc.gethistoricalClosePrice();
		double[] histDataY = Arrays.copyOfRange(historicalData, historicalData.length - 60, historicalData.length);
		double[] histDataX = new double[histDataY.length];
		for(int i = -59; i<= 0; i++) {
			histDataX[59 + i] = i;
		}
		chart.addSeries("Price of Past 60 Days", histDataX, histDataY);
		//test prediction stock price of the past 7 days.
		double[] testDataY = dc.forecastTestPrice();
		double[] testDataX = new double[testDataY.length];
		for(int i = -6; i<= 0; i++) {
			testDataX[i + 6] = i;
		}
		chart.addSeries("Test Predict Price of Past 7 Days", testDataX, testDataY);
		//prediction stock price of the next 7 days.
		double[] predictDataY = dc.forecastClosePrice();
		double[] predictDataX = new double[predictDataY.length];
		for(int i = 1; i<= 7; i++) {
			predictDataX[i - 1] = i;
		}
		chart.addSeries("Predict Price of Next 7 Days", predictDataX, predictDataY);
		//create and show the application's GUI
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
						JLabel label = new JLabel("", SwingConstants.CENTER);
						frame.add(label, BorderLayout.SOUTH);
						// Display the window.
						frame.pack();
						frame.setVisible(true);
					}
				});
	}
}