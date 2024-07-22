
import java.util.*;

@SuppressWarnings("InfiniteLoopStatement")
public class Main {
    public static void main(String[] args) {
        //ArrayList<Admin> admins = new ArrayList<>();
        HashMap<String, Admin> admins= new HashMap<>();
        admins.put("shreeya",new Admin("shreeya","12345"));
        admins.put("tarun",new Admin("tarun","asdf"));


        List<Bus> buses = new ArrayList<>();
        buses.add(new Bus(1,"Orange travels","pune","Mumbai",38,"11:30 AM","6:30 PM"));
        buses.add(new Bus(2,"Red Bus","hyderabad","bangalore",27,"8:00 PM","10:00 AM"));
        buses.add(new Bus(3,"Abhi Bus","Delhi","kolkata",50,"11:00 AM","9:30 PM"));
        buses.add(new Bus(4,"Nalandha travels","pune","hyderabad",75,"6:00 AM","4:00 PM"));
        buses.add(new Bus(5,"amdocs travels","pune","gurgoan",40,"5:30 PM","6:30 AM"));


        List<Ticket> Tickets = new ArrayList<>();
        Tickets.add(new Ticket(1720670721,1,"tarun",22));
        Tickets.add(new Ticket(1720670652,3,"shreeya",27));
        Tickets.add(new Ticket(1720670546,4,"kiran",29));
        Tickets.add(new Ticket(1720670209,3,"umesh",15));
        Tickets.add(new Ticket(1720670123,3,"vinay",27));
        Tickets.add(new Ticket(1720670378,5,"sanjay",35));
        while(true) {
            System.out.println("========================================");
            System.out.println("Welcome To Bus Ticket Reservation System");
            System.out.println("========================================");
            System.out.println();
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println();
        try{
            System.out.println("Enter your choice:");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    //handleAdminOperations(sc, admins, buses, tickets);
                    try {
                        System.out.println();
                        System.out.println("Enter Admin username: ");
                        String username = sc.next();

                        System.out.println("Enter Admin Password: ");
                        String password = sc.next();
                        if (!admins.containsKey(username) || !admins.get(username).getPassword().equals(password)) {
                            throw new AuthenticationException("Invalid Credentials");
                        }

                            System.out.println("Hello " + username + " !");
                            System.out.println("1. Insert Bus Details");
                            System.out.println("2. Delete the Bus Details");
                            System.out.println("3. Show Customers booked based on Bus");
                            System.out.println("4. exit");

                            System.out.println();
                            System.out.println("Enter your choice:");
                            int choice1 = sc.nextInt();

                            switch (choice1) {
                                case 1:
                                    Bus newbus = new Bus();
                                    newbus.CreateBus();
                                    buses.add(newbus);
                                    System.out.println("Bus added successfully");
                                    break;
                                case 2:
                                    try {
                                        System.out.println("here are the buses list:");
                                        System.out.println("BUS NO  BUS_NAME  SOURCE DESTINATION SEATS TYPE ARRIVAL_TIME DEPARTURE_TIME \n");
                                        buses.forEach(System.out::println);
                                        System.out.println();
                                        System.out.println("Enter the bus number: ");
                                        int busID = sc.nextInt();
                                        if (buses.removeIf(bus -> bus.getBusNo() == busID)) {
                                            System.out.println("Bus has been removed!");
                                        } else {
                                            throw new BusNotFoundException("Bus number is invalid!");
                                        }
                                    } catch (BusNotFoundException e) {
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case 3:
                                    try {
                                        System.out.println("Enter the bus number: ");
                                        int busID1 = sc.nextInt();
                                        boolean flag = false;
                                        for (Ticket ticket : Tickets) {
                                            if (ticket.getBusNumber() == busID1) flag = true;
                                        }
                                        if (flag) {
                                            System.out.println("Customers who booked Bus ID " + busID1 + ":");
                                            Tickets.stream()
                                                    .filter(ticket -> ticket.getBusNumber() == busID1)
                                                    .forEach(ticket -> System.out.println("PNR No: " + ticket.getPnr() + ", Name: " + ticket.getPassangerName() + ", Age: " + ticket.getAge()));

                                        } else {
                                            throw new BusNotFoundException("The bus Number is invalid");
                                        }
                                    }catch (BusNotFoundException e){
                                        System.out.println(e.getMessage());
                                    }
                                    break;
                                case 4:
                                    System.out.println("Exiting admin menu.");
                                    break;
                                default:
                                    System.out.println("Invalid choice! Please enter a valid option.");
                            }


                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                        sc.next(); // clear the invalid input
                    }catch (AuthenticationException e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 2:
                    try {
                        System.out.println();
                        System.out.println("1. Book Ticket");
                        System.out.println("2. Cancel Ticket");
                        System.out.println("3. Show Ticket Details");
                        System.out.println("4. Exit");

                        System.out.println();
                        System.out.println("Enter your choice: ");
                        int BookorNot = sc.nextInt();

                        switch (BookorNot) {
                            case 1:
                                System.out.println("here are the buses list:");
                                System.out.print("BUS NO  BUS_NAME  SOURCE DESTINATION SEATS TYPE ARRIVAL_TIME DEPARTURE_TIME \n");
                                for (Bus bus : buses) {
                                    System.out.println(bus.display());
                                }
                                System.out.println();
                                System.out.println("Enter the bus number: ");
                                int busID = sc.nextInt();

                                System.out.println("Enter Your Name: ");
                                String name = sc.next();

                                System.out.println("Enter Your Age: ");
                                int age = sc.nextInt();
                                Optional<Bus> newBus = buses.stream().filter(p -> p.getBusNo() == busID).findFirst();
                                if (newBus.isPresent()) {
                                    if (newBus.get().getSeats() > 0) {
                                        newBus.get().DropSeat();
                                        Ticket test = new Ticket(System.currentTimeMillis()/1000, busID, name, age);
                                        Tickets.add(test);
                                        System.out.println("your ticket has been generated successfully.");
                                        System.out.println("Your PNR number is: " + test.getPnr());
                                    } else {
                                        System.out.println("Sorry Seats are Full!");
                                    }
                                } else {
                                    System.out.println("Invalid Bus Number");
                                }
                                break;
                            case 2:
                                try {
                                    System.out.println("enter the PNR number to cancel the ticket:");
                                    long pnr = sc.nextLong();
                                    Optional<Ticket> foundTicket = Tickets.stream().filter(p -> p.getPnr() == pnr).findFirst();
                                    if(foundTicket.isPresent()){
                                        buses.stream()
                                                .filter(bus -> bus.getBusNo() == foundTicket.get().getBusNumber()).forEach(Bus::IncrementSeat);
                                        Tickets.remove(foundTicket.get());
                                        System.out.println("Your Ticket has been cancelled");
                                    }
                                    else{
                                        throw new TicketNotFoundException("No match found, please check your PNR number.");
                                    }
                                }catch (TicketNotFoundException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 3:
                                try {
                                    System.out.println("enter the PNR number: ");
                                    long pnr2 = sc.nextLong();
                                    Optional<Ticket> newticket = Tickets.stream()
                                            .filter(ticket -> ticket.getPnr() == pnr2)
                                            .findFirst();
                                    if (newticket.isPresent()) {
                                        System.out.println(newticket.get().toString());
                                        buses.stream().filter(bus -> bus.getBusNo() == newticket.get().getBusNumber())
                                                .forEach(p -> System.out.println(p.toString()));

                                    } else {
                                        throw new TicketNotFoundException("No match found, please check your PNR number.");
                                    }
                                }catch (TicketNotFoundException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case 4:
                                System.out.println("Exiting customer menu.");
                                break;
                            default:
                                System.out.println("Invalid choice! Please enter a valid option.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input! Please enter a valid number.");
                        sc.next(); // clear the invalid input
                    }
                    break;
                default:
                    System.out.println("Invalid choice! Please enter 1 for Admin or 2 for Customer.");
            }
        }catch (InputMismatchException e) {
            System.out.println("Invalid input! Please enter a number.");
            sc.next(); // clear the invalid input
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
           }
        }
    }
}