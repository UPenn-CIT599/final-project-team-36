
public class StockView {
    
    public StockView() {
        
    }
    
    /**
     * This method displays a summary view for the input stock
     * @param whichStock
     */
    public void displayStockView(String whichStock) {
        System.out.println(whichStock);
        /*
         * I hard-coded values to start but will be pulling from the data analysis class to get each of the inputs
         */
        System.out.println("Current Price: " + 36); //displayCurrentPrice(whichStock)); this method will need to be added with data class
        System.out.println("--------------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Time Period", "Start Price", "End Price", "Delta", "Performance");
        System.out.println();
        System.out.println("--------------------------------------------------------------------------------------------------");
        //System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Last 3 Months", "30.02", "34.52", "4.50", "15%");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Last 6 Months", "30.02", "34.52", "4.50", "15%");
        System.out.println();
        System.out.printf("%-20s %-20s %-20s %-10s %-20s", "Last 12 Months", "30.02", "34.52", "4.50", "15%");
        System.out.println();
        System.out.println();
        
    }
}
