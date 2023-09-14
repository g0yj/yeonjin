package controller.stock;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StockInfo
 */
@WebServlet("/StockInfo")
public class StockInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public StockInfo() {
        super();
    }

  
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    }

	
	
 // 주식 종목 가져오기 
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	
    
    
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
