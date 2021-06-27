
import java.util.Scanner;

public class Menu {
    // when we use -> in switch, we don't need to use break statement.
    public void showMenu() {
        Scanner input = new Scanner(System.in);
        TrainManager tm1 = TrainManager.loadData();
        while (true) {
            try {
                int choice;

                while (true) {
                    try {
                        System.out.println("\n1. Add a new train\n"
                                + "2. View trains\n"
                                + "3. Manage trains/tickets\n"
                                + "4. Remove a train\n"
                                + "5. Save\n"
                                + "6. Exit\n"
                                + "\nEnter your choice: ");

                        choice = Integer.parseInt(input.nextLine());
                        break;
                    } catch (NumberFormatException e) {// will stop the program from crashing, in case of invalid output
                        System.out.println("Invalid entry, please try again");
                    }
                }

                switch (choice) {
                    //adding a new train
                    case 1 -> {
                        if (tm1.addTrain()) { //else part is handeled but the method itself
                            System.out.println("The train has been successfully added.");
                        }
                        break;
                    }
                    case 2 -> {
                        //viewing the trains
                        
                        System.out.println(tm1);
                        break;
                    }
                    case 3 -> {
                        //managing the trains/tickets
                        //char choice1 = 'c', choice2 = 'c';
                        int choice1 = 1;
                        System.out.println("Please enter the train's name to manage: ");
                        String tname = input.nextLine();
                        Train train1 = tm1.get(tname);
                        while (choice1 != 0) {
                            try {

                                if (train1 != null) {

                                    while (true) {
                                        try {
                                            System.out.println("\n0. Back\n"
                                                    + "1. Add a new passenger car\n"
                                                    + "2. View passenger cars\n"
                                                    + "3. Remove a passenger car\n"
                                                    + "4. Manage tickets\n"
                                                    + "\nEnter your choice: ");
                                            choice1 = Integer.parseInt(input.nextLine());
                                            break;
                                        } catch (Exception e) {
                                            // will stop the program from crashing, in case of invalid output
                                            System.out.println("Invalid entry,please try again");
                                        }
                                    }

                                    switch (choice1) {
                                        case 1 -> {
                                            System.out.println("\nPlease select one: \n1. Economy class\n2. Business class\n");
                                            int option = 0;
                                            while (true) {
                                                try {
                                                    option = Integer.parseInt(input.nextLine());
                                                    break;
                                                } catch (NumberFormatException e) {// will stop the program from crashing, in case of invalid output

                                                    System.out.println("Invalid entry, try again!");;
                                                }
                                            }
                                            try {
                                                switch (option) {
                                                    case 1 -> {
                                                        if (train1.addEconomyPassengerCar()) {
                                                            System.out.println("Economy class Passenger Car added successfully.\n");
                                                        } else {
                                                            System.out.println("Could not add passenger car... Try a different name");
                                                        }
                                                        break;
                                                    }
                                                    case 2 -> {
                                                        if (train1.addBusinessPassengerCar()) {
                                                            System.out.println("Business class Passenger Car added successfully.\n");
                                                        } else {
                                                            System.out.println("Could not add passenger car... Try a different name");
                                                        }
                                                        break;
                                                    }
                                                    default -> {
                                                        System.out.println("Invalid entry");
                                                    }
                                                }
                                            } catch (Exception e) {//If some unknown exception occurs, this catch will handel it and won't let the program crash
                                                System.out.println("Some unknown error occured! But, it was handeled by the program! ");
                                            }
                                        }
                                        case 2 -> {
                                            //viewing the passenger cars                                 
                                            System.out.println(train1);
                                        }
                                        case 3 -> {
                                            //removing a passenger car
                                            if (train1.removePassengerCar()) {
                                                System.out.println("Removal successful");
                                            } else {
                                                System.out.println("The passenger car name does not exist");
                                            }
                                        }
                                        case 4 -> {
                                            PassengerCar pc = null;
                                            //booking the tickets
                                            System.out.println("\nEnter the name of passenger car whose tickets you want to manage: ");
                                            try {
                                                String pname = input.nextLine();
                                                pc = train1.get(pname);

                                            } catch (Exception e) { // if user inputs something invalid, this catch will handel the eception, and won't let the program crash
                                                System.out.println("Invalid entry, try again");
                                            }
                                            int choice2 = 1;
                                            while (choice2 != 0) {

                                                if (pc != null) {
                                                    while (true) {
                                                        try {
                                                            System.out.println("\n0. Back\n"
                                                                    + "1. Book a ticket\n"
                                                                    + "2. View all tickets\n"
                                                                    + "3. Unbook a ticket\n"
                                                                    + "4. Display all available tickets\n"
                                                                    + "5. Display all booked tickets\n"
                                                                    + "\nEnter your choice: ");
                                                            choice2 = Integer.parseInt(input.nextLine());
                                                            break;
                                                        } catch (NumberFormatException e) {// will stop the program from crashing, in case of invalid output
                                                            System.out.println("Invalid entry,please try again");
                                                        }
                                                    }

                                                    switch (choice2) {
                                                        case 1 -> {
                                                            //viewing the tickets

                                                            try {
                                                                if (pc.ticketsAreAvailable()) {
                                                                    pc.displayAvailableTickets();
                                                                    pc.bookTicket();
                                                                } else {
                                                                    System.out.println("There are no more tickets available to book!");
                                                                }

                                                            } catch (Exception e) {//If some unknown exception occurs, this catch will handel it and won't let the program crash
                                                                System.out.println("Some unknown error occured! But, it was handeled by the program! ");
                                                            }
                                                            break;
                                                        }
                                                        case 2 -> {
                                                            //viewing the tickets

                                                            pc.displayAllTickets();

                                                            break;
                                                        }
                                                        case 3 -> {
                                                            //unbooking the tickets
                                                            try {
                                                                if (pc.haveBookedtickets()) {
                                                                    pc.displayBookedTickets();
                                                                    pc.unBookTicket();
                                                                } else {
                                                                    System.out.println("No tickets are booked, so you can't unbook them!");
                                                                }

                                                            } catch (Exception e) {//If some unknown exception occurs, this catch will handel it and won't let the program crash
                                                                System.out.println("Some unknown error occured! But, it was handled by the program! ");
                                                            }
                                                            break;
                                                        }
                                                        case 4 -> {
                                                            if( pc.ticketsAreAvailable()) pc.displayAvailableTickets();
                                                            else System.out.println("No tickets available to book");
                                                            break;
                                                        }

                                                        case 5 -> {
                                                            if (pc.haveBookedtickets()) {
                                                                pc.displayBookedTickets();
                                                            } else {
                                                                System.out.println("No tickets are booked");
                                                            }
                                                            break;
                                                        }

                                                        case 0 -> {
                                                            System.out.println("\nExiting...");
                                                            break;
                                                        }
                                                        default -> {
                                                            System.out.println("Invalid entry, try again!");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Passanger car with this name doesn't exist");
                                                    break;
                                                }
                                            }
                                        }
                                        case 0 -> {
                                            System.out.println("\nExiting...");
                                        }
                                        default -> {

                                            System.out.println("Invalid entry, try again!");
                                        }
                                    }
                                } else {
                                    System.out.println("Train with this name doesn't exist");
                                    break;
                                }
                            } catch (Exception e) {// if any unknown exception occurs, this catch will handel it and won't let the program crash
                                System.out.println("Some unknown error occured! But, the program handled it!");
                            }
                        }
                        break;
                    }
                    case 4 -> {
                        //when the condition is true
                        if (tm1.removeTrain()) {
                            System.out.println("The train has been successfully removed.");
                        } //when the condition is false
                        else {
                            System.out.println("Sorry, the train name does not exist");
                        }
                        break;
                    }
                    case 5 -> {
                        //saving the file
                        tm1.save();
                    }
                    case 6 -> {
                        //exiting the program
                        System.exit(0);
                    }
                    default -> {
                        System.out.println("Invalid entry, try again!");
                    }
                }
            } catch (Exception e) {// if any unknown exception occurs, this catch will handel it and won't let the program crash
                System.out.println("Something went wrong, please try again...!");
            }
        }
    }
}
