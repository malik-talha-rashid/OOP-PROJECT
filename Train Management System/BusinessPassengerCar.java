public class BusinessPassengerCar extends PassengerCar { // since parent class is implementing Serializable
 //interface, child class will also be serializable.
//so, Serializable wasn't implemented
    BusinessPassengerCar() {
        super();
        for (int i = 0; i < numberOfSeats; i++) {
            tickets[i] = new BusinessClassTicket(i+1);
        }
    }
    BusinessPassengerCar(BusinessPassengerCar o) { //copy conductor, Because we can have passenger cars of same names in different trains.
        super(o);
        for (int i = 0; i < numberOfSeats; i++) {
            tickets[i] = new BusinessClassTicket(i+1);
        }
    }
    // every method's name is specifying exactly what the method will do
    //implemented abstract method from superclass
    @Override
    public void displayBookedTickets() {
        System.out.println("---------------------Business Passenger car "+getName()+"-------------------");
        if(!haveBookedtickets()) {
            System.out.println("<------- No Tickets are booked ------->");
            return;
        }
        System.out.println("----------------Following tickets are available---------------");
        for (Ticket t: tickets) {
            if(t.isBooked()) System.out.println(t);
        }  }

    //implemented abstract method from superclass
    @Override
    public void displayAvailableTickets() {
        System.out.println("---------------------Business Passenger car" +getName()+"-------------------");
        if(!(ticketsAreAvailable())) {
            System.out.println("<------- No Tickets are available ------->");
            return;
        }System.out.println("----------------Following tickets are available---------------");
        for (int i = 0; i < tickets.length; i++) {
            if (!tickets[i].isBooked()) {
                System.out.printf("%4d",tickets[i].getSeatNumber() );
                System.out.print(" ");
            }
            if ((i + 1) % 20 == 0) System.out.println();
        }
        System.out.println();

    }

    //implemented abstract method from superclass
    @Override
    public void displayAllTickets() {
        displayBookedTickets();
        displayAvailableTickets();
    }

    @Override
    public String toString() {
        return "\n\t\tBusiness Class Passenger Car:"+ super.toString();
    }
}
