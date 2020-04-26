import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PredictLineChart extends Application {
	
	@Override 
	public void start(Stage stage) {
        stage.setTitle("Stock Price Predictor");
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Past and Future Days");
        //creating the chart
        final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Stock Price Predictor");
        //defining a series
        XYChart.Series seriesH = new XYChart.Series();
        seriesH.setName("Historical Stock Price (Last 30 Days)");
        //populating the series with data
        DataController dc = new DataController();
        double[] historicalData = dc.gethistoricalClosePrice();
        for(int i = -29; i<= 0; i++) {
        	seriesH.getData().add(new XYChart.Data(i, historicalData[historicalData.length + i - 1]));
        }
        
        XYChart.Series seriesT = new XYChart.Series();
        seriesT.setName("Test Predict Stock Price (Last 7 Days)");
        double[] testData = dc.forecastTestPrice();
        for(int i = -6; i<= 0; i++) {
        	seriesT.getData().add(new XYChart.Data(i, testData[i + 6]));
        }
        
        XYChart.Series seriesP = new XYChart.Series();
        seriesP.setName("Predicted Stock Price (Next 7 Days)");
        double[] predictData = dc.forecastClosePrice();
        for(int i = 1; i<= 7; i++) {
        	seriesP.getData().add(new XYChart.Data(i, predictData[i-1]));
        }
        
        Scene scene  = new Scene(lineChart,800,600);
        lineChart.getData().addAll(seriesH, seriesT, seriesP);
       
        stage.setScene(scene);
        stage.show();
    }

	public void show() {
		launch();
	}
	
}
