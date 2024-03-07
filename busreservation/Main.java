import busreserv.Booking;
import busreserv.Bus;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<>();
        buses.add(new Bus(1,true,2));
        buses.add(new Bus(2,false,2));
        buses.add(new Bus(3,true,2));
        ArrayList<Booking> bookings =new ArrayList<>();

        int userdata = 1;
        Scanner sc = new Scanner(System.in);
        while (userdata==1) {
            System.out.print("Enter 1 to Book and 2 to exit  ");
            userdata=sc.nextInt();
            if(userdata==1){
                Booking booking = new Booking();
                if(booking.isAvailable(buses,bookings)){
                    bookings.add(booking);
                    System.out.println("Your Booking is confirmed....");

                }
                else{
                    System.out.println("Sorry.Bus is full.Try another bus or date");
                }
            }

        }

    }
}
