/**
 * the class to set and get info needed
 * stockname, date, low, high, open, close and adjclose data
 * @author anna
 *
 */
public class ManageRecordTransactionBean {
	 private String stockName; 
	 private String date;
	 private String low;
	 private String high;	 
	 private String open;
	 private String close;
	 private String adjClose;
	
	 /**
	  * get StockName
	  * @return
	  */
	public String getStockName() {
		return stockName;
	}
	
	/**
	 * set StockName
	 * @param stockName
	 */
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	
	 /**
	  * get Date of the stock price 
	  * @return
	  */
	public String getDate() {
		return date;
	}
	
	/**
	 * set Date we want to run the stock price
	 * @param date
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	 /**
	  * get Low prie
	  * @return
	  */
	public String getLow() {
		return low;
	}
	
	/**
	 * set Low
	 * @param low
	 */
	public void setLow(String low) {
		this.low = low;
	}
	
	 /**
	  * get High price
	  * @return
	  */
	public String getHigh() {
		return high;
	}
	
	/**
	 * set High
	 * @param high
	 */
	public void setHigh(String high) {
		this.high = high;
	}
	
	 /**
	  * get stock open price 
	  * @return
	  */
	public String getOpen() {
		return open;
	}
	
	/**
	 * set open stock price
	 * @param open
	 */
	public void setOpen(String open) {
		this.open = open;
	}
	
	 /**
	  * get stock close price 
	  * @return
	  */
	public String getClose() {
		return close;
	}
	
	/**
	 * set close price
	 * @param close
	 */
	public void setClose(String close) {
		this.close = close;
	}
	
	 /**
	  * get AdjClose price for the stock
	  * @return
	  */
	public String getAdjClose() {
		return adjClose;
	}
	
	/**
	 * set AdjClose price for the stock
	 * @param AdjClose
	 */
	public void setAdjClose(String adjClose) {
		this.adjClose = adjClose;
	}
	 
	 	 
}
