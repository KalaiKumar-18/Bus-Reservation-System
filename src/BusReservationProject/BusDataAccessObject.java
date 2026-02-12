package BusReservationProject;

import java.sql.*;

public class BusDataAccessObject {
    public void display() throws Exception {
        String query = "select * from Bus";
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        while(rs.next()){
            System.out.print("Bus no. "+rs.getInt(1));
            if(rs.getInt(2)==0){
                System.out.print(" having AC? - No");
            }else {
                System.out.print(" having AC? - Yes");
            }
            System.out.print(" it's capacity: " + rs.getInt(3));
            System.out.print(" from: " + rs.getString(4));
            System.out.print(" to: " + rs.getString(5));
            System.out.println();
        }
    }

    public int getCapacity(int id) throws Exception {
        String query = "select capacity from bus where id = " + id;
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }
}
