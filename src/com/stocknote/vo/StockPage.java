package com.stocknote.vo;

import java.util.List;

public class StockPage {

	public static int MAX_PAGE_SIZE = 10;
	public static int NUMBER_OF_STOCK_IN_PAGE = 12;

	private int accountNo;
	private int pageNo;
	private List<String> stockNoList;
	
	public StockPage() {
	}
	public StockPage(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public List<String> getStockNoList() {
		return stockNoList;
	}
	public void setStockNoList(List<String> stockNoList) {
		this.stockNoList = stockNoList;
	}
}
