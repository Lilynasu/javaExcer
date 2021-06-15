package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.GetBookLogic;

@WebServlet("/GetBook")
public class GetBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		try {
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String isbn = request.getParameter("isbn");
		
		//本の検索を依頼
		GetBookLogic logic = new GetBookLogic();
		Book book = logic.process(isbn);
		request.setAttribute("book", book);
		
		//HTMLの出力を依頼
		request.getRequestDispatcher("WEB-INF/GetBook.jsp").forward(request, response);			
		
		}catch(SQLException e) {
			request.getRequestDispatcher("WEB-INF/SystemError.jsp").forward(request, response);			
		}
	}

}
