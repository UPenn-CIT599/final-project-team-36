import java.time.LocalDate;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class StockLineChart extends Application {

    String stock = null;
    /*String stock = null;
    LocalDate date = LocalDate.now();
    LocalDate ninetyDate = date.minusDays(90);
    LocalDate oneEightyDate = date.minusDays(180);
    LocalDate oneYearDate = date.minusDays(365);
    */
    
    public StockLineChart() {
        
    }
    
   @Override public void start(Stage stage) {
        stage.setTitle("90 Day Line Chart");
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Date");
        yAxis.setLabel("Price");
        YahooController stockCheck = new YahooController();
        System.out.println(stockCheck.historicalStockDayWise("APPL", 1));
        
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis, yAxis);
        
        lineChart.setTitle("90 Day Line Chart");
        XYChart.Series series = new XYChart.Series();
        series.setName("chart");
        for(int i = 90; i > 0; i--) {
        series.getData().add(new XYChart.Data((91 - i), 100));
        }
        Scene scene = new Scene(lineChart,800,600);
        lineChart.getData().add(series);
        
        stage.setScene(scene);
        stage.show();
    }
    
   public StockLineChart(String stock) {
       this.stock = stock;
   }
   
   
   
    public static void main(String[] args) {
        launch(args);
    }
}
