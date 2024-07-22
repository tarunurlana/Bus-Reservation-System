
import java.util.InputMismatchException;
import java.util.Scanner;

public class Bus {

    Scanner sc = new Scanner(System.in);
    private int BusNo;
    private String BusName;
    private String Source;
    private String Destination;
    private int Seats;
    private String ArrivalTime;
    private String DepartureTime;

    public Bus() {
        super();
    }
    public Bus(int busNo,String busName, String source, String destination,
               int seats, String arrivalTime, String departureTime) {
        super();
        BusNo=busNo;
        BusName = busName;
        Source = source;
        Destination = destination;
        Seats = seats;
        ArrivalTime = arrivalTime;
        DepartureTime = departureTime;
    }

    public void CreateBus(){
        try {
            System.out.println("Enter Bus Number: ");
            this.BusNo=sc.nextInt();

            System.out.println("Enter BusName: ");
            this.BusName = sc.next();

            System.out.println("Enter Source: ");
            this.Source = sc.next();

            System.out.println("Enter Destination: ");
            this.Destination = sc.next();

            System.out.println("Enter Seats Avilable: ");
            this.Seats = sc.nextInt();

            System.out.println("Enter ArrivalTime: ");
            this.ArrivalTime = sc.next();

            System.out.println("Enter DepartureTime: ");
            this.DepartureTime = sc.next();
        }catch(InputMismatchException e){
            System.out.println("Invalid input! Please enter valid details.");
            sc.next();
        }
    }
    public String display(){
        return BusNo+" "+BusName+" "+Source+" "+
                Destination+" "+Seats+" "+
                ArrivalTime+" "+DepartureTime;
    }
    @Override
    public String toString() {
        return " [ BusNo = " + BusNo + ", BusName = " + BusName
                + ", Source = " + Source + ", Destination = " + Destination
                + ", Seats = " + Seats + ", ArrivalTime = " + ArrivalTime
                + ", DepartureTime = " + DepartureTime + " ]";
    }
    public  int getBusNo() {
        return BusNo;
    }
    public int getSeats() {
        return Seats;
    }
    public void DropSeat(){
        Seats--;
    }
    public void IncrementSeat(){
        Seats++;
    }
}
