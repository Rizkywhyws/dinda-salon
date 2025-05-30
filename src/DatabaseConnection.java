import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DatabaseConnection {
    private static Connection conn = null;
    
    // Database configuration
    private static final String DB_URL = "jdbc:mysql://localhost:3306/dinda_salon";
    private static final String DB_USER = "root";
    private static final String DB_PASS = "";

    public static Connection getConnection() {
        if (conn == null) {
            try {
                // Load MySQL JDBC Driver
                Class.forName("com.mysql.cj.jdbc.Driver");
                
                // Establish connection
                conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                System.out.println("Database connected successfully!");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, 
                    "MySQL JDBC Driver not found!", 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Failed to connect to database: " + ex.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
        }
        return conn;
    }
    
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
                conn = null;
                System.out.println("Database connection closed.");
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, 
                    "Error while closing connection: " + ex.getMessage(), 
                    "Database Error", 
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}