package tomsystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BD {
    public Connection con = null;
    public PreparedStatement st = null;
    public ResultSet rs = null;

    private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String DATABASE_NAME = "TOMS";
    // Usando autenticação do Windows; não há necessidade de login e senha na URL
    private final String URL = "jdbc:sqlserver://localhost:1433;databasename=" + DATABASE_NAME + ";"
    		+ "trustServerCertificate=true;"
    		+ "encrypt=false";

    public boolean getConnection() {
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL,"sa","123456");
            System.out.println("Conectou...");
            return true;
        } catch (SQLException e) {
            System.out.println("Falha na conexão " + e);
            e.printStackTrace();
            
        } catch (ClassNotFoundException e) {
            System.out.println("Driver não encontrado!");
        }
        return false;
    }

    public void close() {
        try {
            if (rs != null) rs.close();
        } catch (SQLException e) {}
        try {
            if (st != null) st.close();
        } catch (SQLException e) {}
        try {
            if (con != null) {
                con.close();
                System.out.println("Desconectou...");
            }
        } catch (SQLException e) {}
    }

    public static void main(String[] args) {
        BD bd = new BD();
        bd.getConnection();
        //executar uma ação
        bd.close();
    }
}
