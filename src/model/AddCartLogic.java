package model;

import java.sql.SQLException;

import dao.BookDAO;

public class AddCartLogic {
	public Cart process(String isbn, Cart cart) throws SQLException {
		
		BookDAO dao = new BookDAO();
		Book book = dao.selectByKey(isbn);
		
		cart.add(book);
		
		return cart;
	}
}
