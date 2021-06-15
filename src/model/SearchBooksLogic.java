package model;

import java.sql.SQLException;
import java.util.List;

import dao.BookDAO;

public class SearchBooksLogic {

	public List<Book> process(String keyword) throws SQLException {
		
		BookDAO dao = new BookDAO();
		List<Book> books = dao.selectByTitle(keyword);
		return books;
		
	}
}
