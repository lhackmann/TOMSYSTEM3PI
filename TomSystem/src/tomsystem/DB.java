package tomsystem;

import java.sql.Statement;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DB {
	
private static Connection conn = null;
	
	public static Connection getConnection() throws SQLException {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
				System.out.println("Connected!");
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
	}
	
	private static Properties loadProperties() throws SQLException {
		try (FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		} catch (IOException e) {
			throw new SQLException(e.getMessage());
		}
	}
	
	public static void closeStatement(Statement st) throws SQLException {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) throws SQLException {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new SQLException(e.getMessage());
			}
		}
	}

}
