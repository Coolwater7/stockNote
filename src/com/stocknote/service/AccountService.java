package com.stocknote.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.stocknote.db.DBConnection;
import com.stocknote.vo.Account;

public class AccountService {

	public boolean createAccount(Account account) {
		
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getEmail());
			pstmt.setString(2, account.getPasswd());
			pstmt.setString(3, account.getRegDate());
			
			if(pstmt.executeUpdate() == 1) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
		
		return false;
	}
	
	public boolean removeAccount(Account account) {
		
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getEmail());
			pstmt.setString(2, account.getPasswd());
			
			if(pstmt.executeUpdate() == 1) return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
		
		return false;
	}
	
	public Account findAccountByEamil(String email) {
		Account account = null;
		
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			ResultSet rSet = pstmt.executeQuery();
			if(rSet.next()) {
				account = new Account();
				account.setAccountNo(rSet.getInt(""));
				account.setEmail(rSet.getString(""));
				account.setRegDate(rSet.getString(""));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
		return account;
	}

	public boolean loginAccount(Account account) {
		String sql = "";
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account.getEmail());
			pstmt.setString(2, account.getPasswd());
			ResultSet rSet = pstmt.executeQuery();
			if(rSet.next()) return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(conn != null)	try {conn.close();	} catch (SQLException e) {	e.printStackTrace();	}
		}
		return false;
	}
}
