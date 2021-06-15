package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Book;

public class BookDAO {
	private DBUtil db;

	public BookDAO() {
		this.db = new DBUtil();
	}

	public Book selectByKey(String isbn) throws SQLException {
		Connection con = null;
		try {
			con = this.db.getConnection();

			String sql = "select * from BOOK where ISBN=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, isbn);
			ResultSet rs = pstmt.executeQuery();
			Book book = null;
			if (rs.next()) {
				book = new Book(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5));
			}
			pstmt.close();
			return book;

		} finally {
			this.db.closeConnection(con);
		}
	}
	
	public List<Book> selectByTitle(String title) throws SQLException{
		Connection con = null;
		
		try {
			con = this.db.getConnection();
			
			String sql = "select * from BOOK where TITLE LIKE ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, "%" + title + "%");
			ResultSet rs = pstmt.executeQuery();
			List<Book> list = new ArrayList<Book>();
			while(rs.next()) {
				Book book = new Book(rs.getString(1), rs.getString(2), rs.getInt(3),
						rs.getString(4), rs.getString(5));
				list.add(book);
			}
			pstmt.close();
			return list;
			
		} finally {
			this.db.closeConnection(con);
		}
	}
	
	public int insert(Book book) throws SQLException {
		Connection con = null;
		
		try {
			con = this.db.getConnection();
			
			String sql = "insert into BOOK values (?,?,?,?,?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setInt(3, book.getPrice());
			pstmt.setString(4, book.getAuthor());
			pstmt.setString(5, book.getFeature());
			
			int r = pstmt.executeUpdate();
			pstmt.close();
			return r;
		} finally {
			this.db.closeConnection(con);
		}
		
	}
}
