package com.stocknote.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stocknote.db.DBConnection;
import com.stocknote.vo.StockInfo;

public class StockInfoService {

	public List<StockInfo> findByStockName(String stockName) {
		List<StockInfo> stockInfoList = new ArrayList<StockInfo>();
		
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stockName+"%");
			
			ResultSet rSet = pstmt.executeQuery();
			StockInfo info = null;
			while(rSet.next()) {
				info = new StockInfo();

				info.setStockNo(rSet.getString(""));
				info.setStockName(rSet.getString(""));
				info.setStockDept(rSet.getString(""));
				info.setStockType(rSet.getInt(""));
				
				stockInfoList.add(info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}		
		
		return stockInfoList;
	}
	
	public StockInfo findByStockNo(String stockNo) {
		StockInfo info = null;
		
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, stockNo);
			
			ResultSet rSet = pstmt.executeQuery();
			if(rSet.next()) {
				info = new StockInfo();

				info.setStockNo(rSet.getString(""));
				info.setStockName(rSet.getString(""));
				info.setStockDept(rSet.getString(""));
				info.setStockType(rSet.getInt(""));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}		
		return info;
	}
}
