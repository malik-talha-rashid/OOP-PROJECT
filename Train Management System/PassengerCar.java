package a1Proj2;

import java.io.InputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public abstract class PassengerCar implements Serializable , PassengerClassFunctions {

    private String name;
    protected int numberOfSeats;
    protected Ticket[] tickets; // the size won't be changing. So, an array is more suitable than an arraylist
    public static transient Scanner input;
    public boolean ticketsAreAvailable(){
        for (Ticket t: tickets) {
            if (!(t.isBooked())) return true;
        }
        return false;
    }
    public boolean haveBookedtickets(){
        for (Ticket t: tickets) {
            if (t.isBooked()) return true;
        }
        return false;
    }
    PassengerCar() {
        this.input = new Scanner(System.in);
        boolean success = false;
        while (!success) {
            try {
                System.out.println("Enter the name of the Passenger car: ");
                this.name = input.nextLine();
                if(!(this.name.length()>0)) {
                    System.out.println("Name too short, try again!");
                    continue;
                }
                System.out.println("Enter the number of seats: ");
                this.numberOfSeats = Integer.parseInt(input.nextLine());
                // if the input is not a number, an exception will occur here, which will handled by catch
                this.tickets = new Ticket[numberOfSeats];
                success = true;
            } 
            catch (Exception ex) {
                System.out.println("Invalid entry! try again!");
            }
        }
    }
    PassengerCar(PassengerCar o){ //copy constructor
            this.name=o.name;
            this.numberOfSeats=o.numberOfSeats;
            this.tickets = new Ticket[o.tickets.length];
        }
    // every method's name is specifying exactly what the method will do
    public void bookTicket(){
        boolean success=false;
        while(!success) {
            try {
                System.out.println("Enter the name of the Passenger: ");
                String passengerName = input.nextLine();
                System.out.println("Enter the number of seat you want to book: ");
                int seatNumber = Integer.parseInt(input.nextLine());
                // if the input is not a number, an exception will occur here, which will handled by catch
                if (seatNumber <= this.tickets.length && seatNumber > 0) {
                    tickets[seatNumber - 1].book(passengerName);
                    success = true;
                }
                else {
                    System.out.println("Invalid Seat number");
                    System.out.println("If you want to book a ticket, press 1, else press any other key");
                    String key = input.nextLine();
                    if (!(key.equals("1"))) {
                        success = true;
                    }
                }
            } catch (Exception ex) {
                System.out.println("Invalid entry! try again!");
            }
        }
    }
    public void unBookTicket( ){
        boolean success=false;
        while(!success) {
            try {
                System.out.println("Enter the seat number you want to unbook");
                int seatNumber = Integer.parseInt(input.nextLine());
                if(seatNumber<=this.tickets.length && seatNumber>0)
                    tickets[seatNumber-1].unBook();
                else System.out.println("Invalid Seat number");
                success=true;
            } catch (Exception ex){ // if the user enters an invalid seat number, this catch will handel the exception!
                System.out.println("Invalid entry! try again!");
            }
        }

    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\n\t\t\tName: "+getName()+"\n\t\t\tNumber of Seats: "+numberOfSeats+"\n";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof PassengerCar)) return false;
        PassengerCar that = (PassengerCar) o;
        return numberOfSeats == that.numberOfSeats &&
                name.equals(that.name) &&
                Arrays.equals(tickets, that.tickets);
    } //overloaded equals function, since we needed it
    public boolean equals(String s) {
        return this.name.equals(s);
    }
}
