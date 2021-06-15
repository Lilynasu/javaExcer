package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Book;
import model.SearchBooksLogic;

@WebServlet("/SearchBooks")
public class SearchBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			//リクエストパラメータを取得
			request.setCharacterEncoding("UTF-8");
			String keyword = request.getParameter("keyword");

			//本の検索を依頼
			SearchBooksLogic logic = new SearchBooksLogic();
			List<Book> books = logic.process(keyword);
			
			//リクエストスコープに格納します
			request.setAttribute("books", books);

			//HTMLの出力を依頼（フォワード）
			request.getRequestDispatcher("WEB-INF/SearchBooks.jsp").forward(request, response);
			
		} catch (SQLException e) {
			request.getRequestDispatcher("WEB-INF/SystemError.jsp").forward(request, response);
		}

	}

}
