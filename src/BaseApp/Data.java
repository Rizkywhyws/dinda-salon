package BaseApp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Data {
    public static Connection Conn;
    public static Connection configDB(){
            try {
                String url ="jdbc:mysql://localhost:3306/dinda_salon";
                String user ="root";
                String password ="";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                Conn =DriverManager.getConnection(url, user, password);
            }catch (Exception e) {
                System.err.println("koneksi gagal" +e.getMessage());
            }
            return Conn; 
}
}
