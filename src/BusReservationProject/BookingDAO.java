package BusReservationProject;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class BookingDAO {

    public int getBooked(int id, Date date, String from, String to) throws Exception {
        String query = "select count(pname) from Booking where bno = ? and tdate = ? and pfrom = ? and pto = ?";
        Connection con = DBConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        pst.setInt(1,id);
        pst.setDate(2,sqlDate);
        pst.setString(3,from);
        pst.setString(4,to);
        ResultSet rs = pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws Exception {
        String query = "insert into Booking(pname,bno,tdate,pfrom,pto) values(?,?,?,?,?)";
        Connection con = DBConnection.getConnection();
        java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());
        PreparedStatement pst = con.prepareStatement(query);
        pst.setString(1, booking.Passenger_Name);
        pst.setInt(2, booking.BusNo);
        pst.setDate(3, sqlDate);
        pst.setString(4, booking.From);
        pst.setString(5, booking.To);
        pst.executeUpdate();
    }

    public int getBookingNumber() throws Exception {
        String query = "select booking_id from Booking order by booking_id desc limit 1";
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        rs.next();
        return rs.getInt(1);
    }

    public int Cancellation(int id) throws Exception {
        String query = "delete from Booking where booking_id = "+id;
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeUpdate(query);
    }
}
