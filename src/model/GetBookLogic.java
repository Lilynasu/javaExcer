package model;

import java.sql.SQLException;

import dao.BookDAO;

public class GetBookLogic {
	public Book process(String isbn) throws SQLException {
		
		BookDAO dao = new BookDAO();
		Book book = dao.selectByKey(isbn);
		return book;
		
	}
}
