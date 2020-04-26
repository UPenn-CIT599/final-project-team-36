import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class StockMarketDashboardTest {

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
    
}