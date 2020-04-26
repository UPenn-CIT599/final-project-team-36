import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JunitTest {

	@Test
	void testPerfCalc() {
		StockDataAnalysis SD = new StockDataAnalysis();
		double performance = SD.calculatePerformance(10, 5);
		assertEquals(performance, 100);
	}

	@Test
	void testDeltaCalc() {
		StockDataAnalysis SD = new StockDataAnalysis();
		double delta = SD.calculateDelta(10, 5);
		assertEquals(delta, 5);
	}

	/**
	 * Tests that the program starts off with the correct default value of the
	 * S&P500 symbol
	 */
	@Test
	void defaultStockValue() {
		ProgramDashboard PD = new ProgramDashboard();
		assertEquals("^GSPC", PD.getStock());
	}

	@Test
	public void getFirstDayPreditionPrice() {
		DataController dc = new DataController("^GSPC");
		assertEquals(dc.gethistoricalClosePrice(), 0);
	}
}
