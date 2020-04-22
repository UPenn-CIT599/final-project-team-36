package org.fin;

import java.util.List;

import yahoofinance.Stock;

public class Start {
	public static void main(String[] args) {
		YahooController controller=new YahooController();
		String symbol="^GSPC";
		System.out.println("#####################TRY TO GET REAL TIME DATA BY SINGLE SYMBOL############");
		
		List<Stock> listOfRealTimeData=controller.fetchRealTimeData(symbol);
		for (Stock stock : listOfRealTimeData) {
			//System.out.println(symbol +" - "+stock.getQuote().toString());
			System.out.println(symbol +" Close - "+stock.getQuote().getPreviousClose());
		}
		System.out.println("#####################TRY TO GET HISTORCAL DATA  YEAR WISE############");
		int fromLastYear=5;	
		 
		List<ManageRecordTransactionBean> listOfHistoricalData=controller.historicalStock(symbol,fromLastYear);
		System.out.println("STOCK      DATE        LOW           HIGH         OPEN         CLOSE        ADJCLOSE"); 
		for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalData) {
			System.out.println(manageRecordTransactionBean.getStockName()+"     "+manageRecordTransactionBean.getDate()+"   "+manageRecordTransactionBean.getLow()+"  "+manageRecordTransactionBean.getHigh()+"   "+manageRecordTransactionBean.getOpen()+"  "+manageRecordTransactionBean.getClose()+"  "+manageRecordTransactionBean.getAdjClose());
		}
		
		System.out.println("#####################TRY TO GET HISTORCAL DATA  Day WISE############");
		int fromLastdays=30;	
		 
		List<ManageRecordTransactionBean> listOfHistoricalDataDaywise=controller.historicalStockDayWise(symbol,fromLastdays);
		System.out.println("STOCK       Date          CLOSE"); 
		for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalDataDaywise) {
			System.out.println(manageRecordTransactionBean.getStockName()+"     "+manageRecordTransactionBean.getDate()+"     "+manageRecordTransactionBean.getClose());
		}
	}
}
