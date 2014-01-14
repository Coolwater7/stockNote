package com.stocknote.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.stocknote.service.AccountService;
import com.stocknote.service.StockPageService;
import com.stocknote.util.StringUtil;
import com.stocknote.vo.Account;

/**
 * Servlet implementation class AccountManagerServlet
 */
public class AccountManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private AccountService service;   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountManagerServlet() {
        super();
        service = new AccountService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if("join".equals(action)) {
			Account account = new Account();
			account.setEmail(request.getParameter("email"));
			account.setPasswd(request.getParameter("passwd1"));
			account.setRegDate(StringUtil.getToday());
			
			JSONObject obj = new JSONObject();
			if(service.createAccount(account)) {
				int accountNo = service.findAccountByEamil(account.getEmail()).getAccountNo();
				StockPageService stockService = new StockPageService();
				stockService.createStockPage(accountNo);
				obj.put("isSuccess", "true");	
			} else {
				obj.put("isSuccess", "false");
			}
			response.setContentType("application/json");
			response.getWriter().write(obj.toString());
			
		} else if("login".equals(action)) {
			Account account = new Account();
			account.setEmail(request.getParameter("email"));
			account.setPasswd(request.getParameter("passwd"));
			
			JSONObject obj = new JSONObject();
			if(service.loginAccount(account)) {
				request.getSession().setAttribute(Account.class.getName(), account);
				obj.put("isSuccess", "true");	
			} else {
				obj.put("isSuccess", "false");
			}
			response.setContentType("application/json");
			response.getWriter().write(obj.toString());
			
		} else if("logout".equals(action)) {
			request.getSession().removeAttribute(Account.class.getName());
			response.sendRedirect("login.jsp");
		}
	}
}
