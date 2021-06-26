package a1Proj2;

import java.io.Serializable;
public class Ticket implements Serializable, TicketFunctions {

    private int seatNumber;
    private String passengerName;
    private boolean isBooked;

    //don't need a copy constructor here
    public Ticket(int seatNumber) {
        // Not initializing passengerName  and isBooked, because they will be initialized to null by default.
        this.seatNumber = seatNumber;
    }
    public Ticket(Ticket t) { //Copy constructor
        this.seatNumber = t.seatNumber;
        this.passengerName = t.passengerName;
        this.isBooked = t.isBooked;
    }
        // every method's name is specifying exactly what the method will do
    @Override
    public void book(String passengerName){
        if(isBooked)//already booked
            System.out.println("ticket for seat "+seatNumber+" not available");
        else{
            this.passengerName = passengerName;
            this.isBooked=true;
            System.out.println("Ticket for seat "+seatNumber+" has been booked, for passenger "+passengerName+ ", successfully!");
        }
    }
    @Override
    public void unBook(){
        if(!isBooked)
            System.out.println("Ticket for seat "+seatNumber+" already available");
        else{
            this.passengerName = null;
            this.isBooked=false;
            System.out.println("Ticket for seat "+seatNumber+" has been unbooked successfully!");
        }
    }
    public int getSeatNumber() {
        return seatNumber;
    }
    public String getPassengerName() {
        return passengerName;
    }
    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
    @Override
    public boolean isBooked() {
        return isBooked;
    }
    public void setBooked(boolean booked) {
        isBooked = booked;
    }
    @Override
    public String toString() {
        if(isBooked()) return  " Seat Number:" + seatNumber +
                "\n Passenger Name:" + passengerName  +
                "\n Status: Booked";
         return  " Seat Number:" + seatNumber +
                "\n Passenger Name:" + passengerName  +
                "\n Status: Not Booked";
    }
}
