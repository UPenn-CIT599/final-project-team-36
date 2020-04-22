package org.fin;

import java.util.List;

import yahoofinance.Stock;

public class Start {
	public static void main(String[] args) {
		YahooController controller=new YahooController();
		String symbol="INTC";
		System.out.println("#####################TRY TO GET REAL TIME DATA BY SINGLE SYMBOL############");
		
		List<Stock> listOfRealTimeData=controller.fetchRealTimeData(symbol);
		for (Stock stock : listOfRealTimeData) {
			System.out.println(symbol +" - "+stock.getQuote().toString());
		}
		System.out.println("#####################TRY TO GET HISTORCAL DATA ############");
		int fromLastYear=10;	
		//System.out.println("STOCK      DATE    LOW        HIGH       OPEN       CLOSE     ADJCLOSE"); 
		List<ManageRecordTransactionBean> listOfHistoricalData=controller.historicalStock(symbol,fromLastYear);
		System.out.println("STOCK      DATE        LOW           HIGH         OPEN         CLOSE     ADJCLOSE"); 
		for (ManageRecordTransactionBean manageRecordTransactionBean : listOfHistoricalData) {
			System.out.println(manageRecordTransactionBean.getStockName()+"     "+manageRecordTransactionBean.getDate()+"   "+manageRecordTransactionBean.getLow()+"  "+manageRecordTransactionBean.getHigh()+"   "+manageRecordTransactionBean.getOpen()+"  "+manageRecordTransactionBean.getClose()+"  "+manageRecordTransactionBean.getAdjClose());
		}
	}
}
