package busreserv;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
public class Booking {
    String passenger_name;
    int bus_no;
    Date date;
    public Booking(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your Name: ");
        passenger_name = sc.next();
        System.out.print("Enter Bus No: ");
        bus_no = sc.nextInt();
        System.out.print("Enter Date dd-MM-yyyy ");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date=dateFormat.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }


    public boolean isAvailable(ArrayList<Bus> buses, ArrayList<Booking> bookings) {

        int capacity = 0;

        for(Bus bus:buses){
           if(bus.getBus_no()==bus_no){
               capacity = bus.getCapacity();
           }
        }
        int booked =0;
        for (Booking b:bookings){
            if(b.bus_no==bus_no && b.date.equals(date)){
                booked++;
            }

        }
        return  booked<capacity?true:false;
    }

}
