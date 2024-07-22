import java.math.BigInteger;

public class Ticket {
    private  long pnr;
    private int BusNumber;
    private String PassangerName;
    private final int age;
    public Ticket(long pnr, int busNumber, String passangerName,int age) {
        super();
        this.pnr = pnr;
        BusNumber = busNumber;
        PassangerName = passangerName;
        this.age=age;
    }
    @Override
    public String toString(){
        return "PNR number : "+pnr+"\n Bus Number: "+BusNumber+"\n Name of the passenger:"+PassangerName+" \n age of passanger is: "+age;
    }
    public long getPnr() {
        return pnr;
    }
    public int getAge(){
        return age;
    }
    public int getBusNumber() {
        return BusNumber;
    }
    public String getPassangerName() {
        return PassangerName;
    }

}
