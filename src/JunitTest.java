import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class JunitTest {

    /**
     * Tests the performance calculation method of our stock market program
     */
    @Test
    void testPerfCalc() {
        StockDataAnalysis SD = new StockDataAnalysis();
        double performance = SD.calculatePerformance(10, 5);
        assertEquals(performance, 100);
        }
    
    /**
     * Tests the delta calculation method of our stock market program
     */
    @Test
    void testDeltaCalc() {
        StockDataAnalysis SD = new StockDataAnalysis();
        double delta = SD.calculateDelta(10, 5);
        assertEquals(delta, 5);
        }
    
    /**
     * Tests that the program starts off with the correct default value
     * of the S&P500 symbol
     */
    @Test
    void defaultStockValue() {
      ProgramDashboard PD = new ProgramDashboard();
      assertEquals("^GSPC", PD.getStock());
    }
    
    /**
     * Tests the check exit method of the program to make sure that the program does
     * not exit given integers as input
     */
    @Test
    void checkExitTest() {
      ProgramDashboard PD = new ProgramDashboard();
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      PD.checkExit("1");
      String expectedOutput = "";
      assertEquals(expectedOutput, outContent.toString());
      PD.checkExit("2");
      assertEquals(expectedOutput, outContent.toString());
      PD.checkExit("3");
      assertEquals(expectedOutput, outContent.toString());
    }
    
    /**
     * Tests the check exit method of the program to make sure that the program does
     * not exit given letters as input
     */
    @Test
    void checkExitTestLetters() {
      ProgramDashboard PD = new ProgramDashboard();
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      PD.checkExit("f");
      String expectedOutput = "";
      assertEquals(expectedOutput, outContent.toString());
      PD.checkExit("e");
      assertEquals(expectedOutput, outContent.toString());
      PD.checkExit("exit");
      assertEquals(expectedOutput, outContent.toString());
    }
    
    /**
     * Tests the options displayUserActions method to ensure the correct options are
     * printed out for the user
     */
    @Test
    void checkOptionsDisplay() {
      ProgramDashboard PD = new ProgramDashboard();
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      PD.summary.displayUserActions("AAPL", 0);
      String expectedOutput = "Please enter the option on how you would like to proceed:\r\n" + 
              "1: Choose an individual stock to view\r\n" + 
              "2: Show Stock line chart\r\n" + 
              "3: Print out stock price daily history\r\n" + 
              "4: View the price predictor for AAPL\r\n" + 
              "X: Exit the program\r\n" +
              "";
      assertEquals(expectedOutput, outContent.toString());
    }
    
    /**
     * Tests the options displayUserActions method after a chart has been launched - the
     * user should see a NOTE letting them know if they exit the chart they will terminate the 
     * program
     */
    @Test
    void checkOptionsDisplayAfterChart() {
      ProgramDashboard PD = new ProgramDashboard();
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      PD.summary.displayUserActions("AAPL", 1); //this changes to 1 signifying chart has been launched
      String expectedOutput = "Please enter the option on how you would like to proceed:\r\n" + 
              "1: Choose an individual stock to view\r\n" + 
              "2: Show Stock line chart\r\n" + 
              "3: Print out stock price daily history\r\n" + 
              "4: View the price predictor for AAPL\r\n" + 
              "X: Exit the program\r\n" +
              "NOTE: If you exit the chart the program will terminate\r\n" +
              "";
      assertEquals(expectedOutput, outContent.toString());
    }
    
    /**
     * Tests the options display method to ensure the correct options are
     * printed out for the user
     */
    @Test
    void checkStockDisplay() {
      ProgramDashboard PD = new ProgramDashboard();
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      PD.summary.displayStockChoices();
      String expectedOutput = "1: Apple (AAPL)\r\n" + 
              "2: Google (GOOGL)\r\n" + 
              "3: Microsoft (MSFT)\r\n" + 
              "4: I want to choose a stock (please use ticker symbol - example: GE)\r\n" + 
              "5: Back to S&P500\r\n" + 
              "X: Exit Program\r\n" +
              "";
      assertEquals(expectedOutput, outContent.toString());
    }
    
    /**
     * Tests the program to check whether the open statements are printed out
     * to display for the user
     */
    @Test
    void checkOpenStatement() {
      
      ByteArrayOutputStream outContent = new ByteArrayOutputStream();
      System.setOut(new PrintStream(outContent));
      ProgramDashboard PD = new ProgramDashboard();
      String expectedOutput = "Welcome to Team 36 Stock Market Program\r\n" + 
              "\r\n" + 
              "We have many excellent features in this program that we hope that you will enjoy, including:\r\n" + 
              "    -Connection to the YahooFinance API so you enjoy the most up to date price information\r\n" + 
              "    -A machine learning price prediction algorithm for the selected stock\r\n" + 
              "    -Default price performance summary information\r\n" + 
              "    -Stock 3 years performance line chart\r\n" + 
              "\r\n";
      assertEquals(expectedOutput, outContent.toString());
    }
    
    /**
     * Check prediction of Arima model with Fibonacci sequence. The next number should be 233.
     */
    @Test
    public void getFibonacciPrediction() {
        double[] data = new double[]{0,1,1,2,3,5,8,13,21,34,55,89,144};
        ArimaForecaster testResult = new ArimaForecaster(data, 4, 1, 3, 1);
        assertEquals(233, testResult.forecast().get(0)[0], 0.1, "Prediction of Fibonacci Error!");
    }
    
    /**
     * Double check prediction with more square sequence. 
     */
    @Test
    public void getSquarePrediction() {
        double[] data = new double[]{0, 1, 4, 9, 16, 25, 36, 49, 64, 81, 100, 121, 144, 169, 196};
        ArimaForecaster testResult = new ArimaForecaster(data, 4, 1, 3, 1);
        assertEquals(225, testResult.forecast().get(0)[0], 0.1,"Prediction of Square Sequence Erro!");
    }
    
    /**
     * Check the prediction results, with the predict data, lower bound and upper bound.
     */
    @Test
    public void getStockPredictionBoudary() {
    	DataController dc = new DataController("^GSPC");
    	double[] data = dc.gethistoricalClosePrice(); 
    	ArimaForecaster forcastResult = new ArimaForecaster(data, 1, 0, 1, 1);
    	assertTrue(forcastResult.forecast().get(0)[0] < forcastResult.forecast().get(1)[0], "Result Larger Than Upper Bound!");
    	assertTrue(forcastResult.forecast().get(0)[0] > forcastResult.forecast().get(2)[0], "Result Lower Than Lower Bound.");
    }
    
    /**
     * Check the obtained real time data of last day. The price will vary everyday, so you need to input the correct real time price.
     */
    @Test
    public void getLastDayPrice() {
    	DataController dc = new DataController("^GSPC");
    	double[] price = dc.gethistoricalClosePrice();
    	double realTimePrice = 2878.48;
    	assertEquals(realTimePrice, price[price.length-1], 1.0, "Close Price Collection Error; May Cause by Daily Stock Update.");
    }
    
    /**
     * Check the size of the output close price array.
     */
    @Test
    public void getPriceDataSize() {
    	DataController dc = new DataController("GOOGL");
    	double[] price = dc.gethistoricalClosePrice();
    	assertEquals(689, price.length, "Close Price Collection Error");
    }
    
    /**
     * Check the predicted data size.
     */
    @Test
    public void getForecastSize() {
    	DataController dc = new DataController("GOOGL");
    	double[] price = dc.forecastClosePrice();
    	assertEquals(7, price.length, "Predicted Close Price Collection Error");
    	double[] forecastTest = dc.forecastClosePrice();
    	assertEquals(7, forecastTest.length, "Predicted Close Price Collection Error");
    }

    /**
     * Check the output information to show detials about prediction.
     */
    @Test
    public void getResultInformation() {
    	DataController dc = new DataController("GOOGL");
    	String str1 = "The predicted stock price for the next 7 days: ";
    	String str2 = "The root mean-square error is: ";
    	String str3 = "The maximum normalized variance is: ";
    	assertEquals(str1, dc.forecastPrintInformation().get(0));
    	assertEquals(str2, dc.forecastPrintInformation().get(2));
    	assertEquals(str3, dc.forecastPrintInformation().get(4));
    }
    
}