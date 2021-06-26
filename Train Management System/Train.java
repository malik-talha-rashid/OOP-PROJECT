package a1Proj2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public class Train implements Serializable{
    public static transient Scanner input; //we will be using nextLine() functions for all data types,
    // because for if we use nextInt() , nextFloat() etc, they accept the value
    // but don't accept the enter key, the enter key get accepted as soon as we use the scanner object again, 
    // as a result one input gets skipped!
    private String  trainName;
    private ArrayList<PassengerCar> PassengerCars; //arraylist, because the number of passenger
    // cars will be changing, so an arraylist be more suitable as compared to an array
    // Don't need a copy, or any other, constructor here. Because we can't have two trains with the same names.
    
    public Train(String trainName) {
        this.trainName=trainName;
        input=new Scanner(System.in);
        PassengerCars = new ArrayList<PassengerCar>();
    }
    // every method's name is specifying exactly what the method will do
    public boolean addBusinessPassengerCar(){
        PassengerCar Pc=new BusinessPassengerCar();
        for (PassengerCar p : PassengerCars) {
            if (p.getName().equals(Pc.getName())) {
                System.out.println("A passenger car already exists with this name..");
                return false;
            }
        }
        PassengerCars.add(Pc); 
        return true;
    }
    public boolean addEconomyPassengerCar(){
        PassengerCar Pc=new EconomyPassengerCar();
        for (PassengerCar p: PassengerCars ) {
                if(p.getName().equals(Pc.getName())){
                    System.out.println("A passenger car already exists with this name..");
                    return false;
                }
        }
        PassengerCars.add(Pc); 
        return true;
    }
    public boolean removePassengerCar() {
        System.out.println("Enter the name of the passenger car you want to remove: ");
        String name = input.nextLine();
        for (PassengerCar p: PassengerCars) {
            if(p.getName().equals(name)) {
                return PassengerCars.remove(p);
            }
        }
        return false;
    }
    
   
    
    public PassengerCar get(String name) {
        for (PassengerCar p:PassengerCars) {
            if(p.getName().equals(name)) {
                return p;
            }
        } 
        return null;
    }
    @Override
    public String toString() {
        return "\nTrain Name: "+trainName + "\n\tPassenger Cars: "+PassengerCars.toString() ;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Train)){
            return false;
        }
        Train train = (Train) o;
        return train.PassengerCars.equals(PassengerCars) && train.trainName.equals(trainName);
    }

    public String getName() { 
        return trainName;
    }
}