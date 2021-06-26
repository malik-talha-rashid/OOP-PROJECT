package a1Proj2;

public class EconomyPassengerCar extends PassengerCar {// since parent class is implementing Serializable interface,
//child class will also be serializable.
//so, Serializable wasn't implemented

    EconomyPassengerCar() {
        super();
        for (int i = 0; i < numberOfSeats; i++) {
            tickets[i] = new EconomyClassTicket(i+1);
        }
    }
    EconomyPassengerCar(EconomyPassengerCar o) {//copy conductor, Because we can have passenger cars of 
        //same names in different trains.
        super(o);
        for (int i = 0; i < numberOfSeats; i++) {
            tickets[i] = new EconomyClassTicket(i+1);
        }
    }
        // every method's name is specifying exactly what the method will do
    
    
    //implemented abstract method from superclass
    @Override
    public void displayBookedTickets() {
        System.out.println("----------------------Economy Passenger car "+getName()+"------------------------");
        if(!haveBookedtickets()) {
            System.out.println("<------- No Tickets are booked ------->");
            return;
        }
        System.out.println("--------------------Following tickets are booked-------------------");
        for (Ticket t: tickets) {
            if(t.isBooked()) System.out.println(t);
        }    }
    //implemented abstract method from superclass
    @Override
    public void displayAvailableTickets() {
        System.out.println("----------------------Economy Passenger car "+getName()+"------------------------");
        if(!(ticketsAreAvailable())) {
            System.out.println("<------- No Tickets are available ------->");
            return;
        }
        System.out.println("--------------------Following tickets are available-------------------");
        int j=0;
        for(int i = 0; i < tickets.length; i++) {
            if (!tickets[i].isBooked()) {
                System.out.printf("%4d",tickets[i].getSeatNumber() );
                System.out.print(" ");j++;
            }
            if ((j + 1) % 10 == 0) System.out.println();
        }
        System.out.println();

    }
    //implemented abstract method from superclass
    @Override
    public void displayAllTickets() {
        System.out.println("All Economy Passenger car tickets:");
        displayBookedTickets();
        displayAvailableTickets();

    }
    @Override
    public String toString() {
        return "\n\t\tEconomy Class Passenger Car:"+ super.toString();
    }
}
