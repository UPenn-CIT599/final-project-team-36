import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;


import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;
import yahoofinance.quotes.query1v7.StockQuotesQuery1V7Request;

/**
this class is to fetch rela time data from YahooFinance
@author anna
*/


public class YahooController {
	
	public List<Stock> fetchRealTimeData(String symbol) {
		List<Stock> st=null;
		try{			
			StockQuotesQuery1V7Request sr=new StockQuotesQuery1V7Request(symbol);			
			st=sr.getResult();					
		}catch(Exception e) {
			
		}
		return st;
	}
	
	
/**
get stock name and calendar year
*/
	
	
public List<ManageRecordTransactionBean>  historicalStock(String stockName,int lastYear) {
	
	List<ManageRecordTransactionBean> list=new LinkedList<ManageRecordTransactionBean>();
	try {
	
	Calendar from = Calendar.getInstance();
	Calendar to = Calendar.getInstance();
	from.add(Calendar.YEAR, -lastYear); // from lastYear year ago
	Stock stock = YahooFinance.get(stockName);
	List<HistoricalQuote> HistQuotes = stock.getHistory(); // this line was messed up?
	ManageRecordTransactionBean bean=new ManageRecordTransactionBean();
	for (HistoricalQuote historicalQuote : HistQuotes) {
		 bean=new ManageRecordTransactionBean();
		//System.out.println(historicalQuote.toString());
		bean.setStockName(historicalQuote.getSymbol());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(historicalQuote.getDate().getTime());
		bean.setDate(dateStr);
		bean.setLow(historicalQuote.getLow().toString());
		bean.setHigh(historicalQuote.getHigh().toString());
		bean.setOpen(historicalQuote.getOpen().toString());
		bean.setClose(historicalQuote.getClose().toString());
		bean.setAdjClose(historicalQuote.getAdjClose().toString());
		list.add(bean);
	}
	
	//String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	return list;
}
public List<ManageRecordTransactionBean>  historicalStockDayWise(String stockName,int lastDays) {
	
	List<ManageRecordTransactionBean> list=new LinkedList<ManageRecordTransactionBean>();
	try {
	
	Calendar from = Calendar.getInstance();
	Calendar to = Calendar.getInstance();
	from.add(Calendar.DAY_OF_YEAR, -lastDays); // from lastDay year ago
	Stock stock = YahooFinance.get(stockName);
	List<HistoricalQuote> HistQuotes = stock.getHistory(from,to,Interval.DAILY);
	ManageRecordTransactionBean bean=new ManageRecordTransactionBean();
	for (HistoricalQuote historicalQuote : HistQuotes) {
		 bean=new ManageRecordTransactionBean();
		//System.out.println(historicalQuote.toString());
		bean.setStockName(historicalQuote.getSymbol());
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		System.out.println("from days------------------------------------");
		
/** setup date format and get Low,High,Open,Close, AdjClose price
		
		
*/
		
		
        String dateStr = dateFormat.format(historicalQuote.getDate().getTime());
		bean.setDate(dateStr);
		bean.setLow(historicalQuote.getLow().toString());
		bean.setHigh(historicalQuote.getHigh().toString());
		bean.setOpen(historicalQuote.getOpen().toString());
		bean.setClose(historicalQuote.getClose().toString());
		bean.setAdjClose(historicalQuote.getAdjClose().toString());
		list.add(bean);
	}
	
	//String[] symbols = new String[] {"INTC", "BABA", "TSLA", "AIR.PA", "YHOO"};
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	return list;
}
}
