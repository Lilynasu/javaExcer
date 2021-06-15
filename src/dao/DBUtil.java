package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	public DBUtil() {
		loadDriver();
	}

	private void loadDriver() {
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			throw new IllegalStateException("JDBCドライバのロードに失敗しました");
		}
	}

	public Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/mydb", "sa", "");
		return con;
	}

	public void closeConnection(Connection con) {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}