package BusReservationProject;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static final String url = "jdbc:mysql://localhost:3306/busreservation";
    public static final String userName = "root";
    public static final String password = "KaLaI@312";

    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(url,userName,password);
    }
}
