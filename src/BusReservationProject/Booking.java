package BusReservationProject;
/*
 * this class is responsible for passengers information of bookings
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String Passenger_Name;
    int BusNo;
    Date date;
    String From;
    String To;
    int Booking_id;

    public Booking() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter passenger name: ");
        Passenger_Name = in.next();
        System.out.println("Enter the bus no. you want to book: ");
        BusNo = in.nextInt();
        System.out.println("Enter booking date in this format(dd/MM/yyyy): ");
        String tempDate = in.next();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            date = sdf.parse(tempDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        if(BusNo == 1){
            System.out.println("Enter from city(Chennai/Coimbatore): ");
            From = in.next();
            if(From.equals("Chennai")){
                System.out.println("Enter to city(Coimbatore): ");
                To = in.next();
            }else{
                System.out.println("Enter to city(Chennai): ");
                To = in.next();
            }
        }
        else if(BusNo == 2){
            System.out.println("Enter from city(Chennai/Bangalore): ");
            From = in.next();
            if(From.equals("Chennai")){
                System.out.println("Enter to city(Bangalore): ");
                To = in.next();
            }else{
                System.out.println("Enter to city(Chennai): ");
                To = in.next();
            }
        }else{
            System.out.println("Enter from city(Chennai/Madurai): ");
            From = in.next();
            if(From.equals("Chennai")){
                System.out.println("Enter to city(Madurai): ");
                To = in.next();
            }else{
                System.out.println("Enter to city(Chennai): ");
                To = in.next();
            }
        }
    }

    public boolean isAvailable() throws Exception {
        BusDataAccessObject busdao = new BusDataAccessObject();
        BookingDAO bookdao = new BookingDAO();
        int capacity = busdao.getCapacity(BusNo);
        int booked = bookdao.getBooked(BusNo,date,From,To);
        return booked < capacity;
    }
}

