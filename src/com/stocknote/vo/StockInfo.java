package com.stocknote.vo;

public class StockInfo {
	private String stockNo;
	private String stockName;
	private String stockDept;
	private int stockType;		//1:KOSPI, 2:KOSDAQ

	public String getStockNo() {
		return stockNo;
	}
	public void setStockNo(String stockNo) {
		this.stockNo = stockNo;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public String getStockDept() {
		return stockDept;
	}
	public void setStockDept(String stockDept) {
		this.stockDept = stockDept;
	}
	public int getStockType() {
		return stockType;
	}
	public void setStockType(int stockType) {
		this.stockType = stockType;
	}
	public String getStockTypeStr() {
		if(stockType == 1) {
			return "KOSPI";
		} else if(stockType == 2) {
			return "KOSDAQ";
		} else {
			return "";
		}
	}
}
