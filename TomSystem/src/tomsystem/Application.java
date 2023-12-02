package tomsystem;

import java.sql.SQLException;

public class Application {

	public static void main(String[] args) {

		DB db = new DB();
		try {
			db.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
