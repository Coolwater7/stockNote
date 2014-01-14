package com.stocknote.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stocknote.db.DBConnection;
import com.stocknote.vo.StockPage;

public class StockPageService {
	
	/**
	 * findStockPageListByAccountNo
	 * @param accountNo
	 * @return
	 */
	public List<StockPage> findStockPageListByAccountNo(int accountNo) {
		List<StockPage> stockPageList = new ArrayList<StockPage>();
		
		//TODO : MAKE A QUERY
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			
			ResultSet rSet = pstmt.executeQuery();
			StockPage page = null;
			while(rSet.next()) {
				page = new StockPage(accountNo);
				page.setPageNo(rSet.getInt("page_no"));
				List<String> stockNoList = new ArrayList<String>();
				stockNoList.add(rSet.getString("stock_no1"));
				stockNoList.add(rSet.getString("stock_no2"));
				stockNoList.add(rSet.getString("stock_no3"));
				stockNoList.add(rSet.getString("stock_no4"));
				stockNoList.add(rSet.getString("stock_no5"));
				stockNoList.add(rSet.getString("stock_no6"));
				stockNoList.add(rSet.getString("stock_no7"));
				stockNoList.add(rSet.getString("stock_no8"));
				stockNoList.add(rSet.getString("stock_no9"));
				stockNoList.add(rSet.getString("stock_no10"));
				stockNoList.add(rSet.getString("stock_no11"));
				stockNoList.add(rSet.getString("stock_no12"));
				page.setStockNoList(stockNoList);
				stockPageList.add(page);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}		
		
		return stockPageList;
	}
	
	/**
	 * findStockPageByAccountNoAndPageNo 
	 * @param accountNo
	 * @param pageNo
	 * @return
	 */
	public StockPage findStockPageByAccountNoAndPageNo(int accountNo, int pageNo) {
		
		StockPage page = null;

		//TODO :MAKE A QUERY
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, accountNo);
			
			ResultSet rSet = pstmt.executeQuery();
			
			if(rSet.next()) {
				page = new StockPage(accountNo);
				page.setPageNo(rSet.getInt("page_no"));
				List<String> stockNoList = new ArrayList<String>();
				stockNoList.add(rSet.getString("stock_no1"));
				stockNoList.add(rSet.getString("stock_no2"));
				stockNoList.add(rSet.getString("stock_no3"));
				stockNoList.add(rSet.getString("stock_no4"));
				stockNoList.add(rSet.getString("stock_no5"));
				stockNoList.add(rSet.getString("stock_no6"));
				stockNoList.add(rSet.getString("stock_no7"));
				stockNoList.add(rSet.getString("stock_no8"));
				stockNoList.add(rSet.getString("stock_no9"));
				stockNoList.add(rSet.getString("stock_no10"));
				stockNoList.add(rSet.getString("stock_no11"));
				stockNoList.add(rSet.getString("stock_no12"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}		

		return page;
	}
	/**
	 */
	public boolean createStockPage(int accountNo) {
		//TODO : MAKE A QUERY 
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < StockPage.MAX_PAGE_SIZE; i++) {
				pstmt.setInt(1, accountNo);
				pstmt.setInt(2, i+1);		//pageSize
				pstmt.executeUpdate();
			}
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
		return false;
	}
	
	/**
	 * updateStock
	 * @param accountNo
	 * @param pageNo
	 * @param index
	 * @param stockNo
	 * @return
	 */
	public boolean updateStock(int accountNo, int pageNo, int index, String stockNo) {

		if(pageNo > StockPage.MAX_PAGE_SIZE || pageNo < 1) return false;
		if(index > StockPage.NUMBER_OF_STOCK_IN_PAGE || index < 1) return false;
		
		StockPage thisPage = findStockPageByAccountNoAndPageNo(accountNo, pageNo);
		if(thisPage == null) return false;
		List<String> stockNoList = thisPage.getStockNoList();
		
		stockNoList.set(index-1, stockNo);
		
		//TODO : MAKE A QUERY 
		String updSql = "";
		Connection conn = DBConnection.getConnection();
		try {
			
			if(stockNoList.size() != StockPage.NUMBER_OF_STOCK_IN_PAGE) throw new Exception();
				
			PreparedStatement pstmt = conn.prepareStatement(updSql);
			int i = 0;
			for (; i < stockNoList.size(); i++) {
				pstmt.setString(i+1, stockNoList.get(i));
			}
			pstmt.setInt(i++, accountNo);
			pstmt.setInt(i++, pageNo);
			
			if(pstmt.executeUpdate() == 1) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
		
		return false;
	}
	
	/**
	 * deleteStock
	 * @param accountNo
	 * @param pageNo
	 * @param index
	 * @return
	 */
	public boolean deleteStock(int accountNo, int pageNo, int index) {
		return updateStock(accountNo, pageNo, index, "");
	}
}
