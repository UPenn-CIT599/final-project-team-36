
/**
 * Print the predict result information and display the lineChart according to the user's choice in dash board.
 * @author Dongchao Xu
 *
 */
public class PredictorRunner {
	
	private DataController dc;
	private String symbol;

	/**
	 * Get the symbol from user's choice in dash board.
	 * For DataController to create predict information or lineChart.
	 * @param symbol
	 */
	public PredictorRunner(String symbol) {
		this.symbol = symbol;
		dc = new DataController(symbol);
	}
	/**
	 * Display the result information in the dash board.
	 * @return
	 */
	public String printInformation() {
		String forcastPrintInfomation = dc.forecastPrintInformation();
		return forcastPrintInfomation;
	}
	
	/**
	 * Display the prediction lineChart with user's choice.
	 */
	public void lineChart() {
		PredictLineChart plc = new PredictLineChart(symbol);
		plc.show();
	}
}
