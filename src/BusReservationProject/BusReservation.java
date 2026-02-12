package BusReservationProject;
/*
 * this class is where the project is going to run, bus creation and display and booking logics
 */
import java.util.Scanner;

public class BusReservation {
    public static void main() {
        BusDataAccessObject busdao = new BusDataAccessObject();
        try {
            busdao.display();
            int UserOpt = 1;
            Scanner in = new Scanner(System.in);
            while (UserOpt == 1) {
                System.out.println("Enter 1 for booking 2 for exit and 3 for cancellation");
                UserOpt = in.nextInt();
                if (UserOpt == 1) {
                    Booking booking = new Booking();
                    if (booking.isAvailable()) {
                        BookingDAO bookingdao = new BookingDAO();
                        bookingdao.addBooking(booking);
                        booking.Booking_id = bookingdao.getBookingNumber();
                        System.out.println(booking.Booking_id + " is your Booking number. Booking confirmed... Happy journey !!! ");
                    } else {
                        System.out.println("Sorry, seat is full, choose another bus or date... ");
                    }
                }else if(UserOpt == 3){
                    System.out.println("Enter your Booking Number for cancellation of your booking... ");
                    int id = in.nextInt();
                    BookingDAO bookingdao = new BookingDAO();
                    int count = bookingdao.Cancellation(id);
                    if(count == 1){
                        System.out.println("Booking cancelled successfully... ");
                    }else{
                        System.out.println("Booking Number invalid, try again... ");
                    }
                    UserOpt = 1;
                }
            }
            in.close();
        }catch(Exception e){
            System.out.println(e); // here we use try catch instead of throws exception cox,
            // the later will give error to the developers like us, which will be helpful
            // in dealing with the code during developing the application
            // the former try catch will give the exception ,and they won't understand the errors
            // so we can give try catch and may be with the message like server try again later
            // ,and also we can save the errors and when it occurred in a log for easy debugging
        }
    }
}

