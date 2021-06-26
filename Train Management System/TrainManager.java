package a1Proj2;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainManager {
    public static transient Scanner input; 
    //we will be using nextLine() functions for all data types, because for if we use nextInt() , nextFloat() etc, they accept the value but don't accept the enter key, the enter key get accepted as soon as we use the scanner object again, as a result one input gets skipped!
    
    private ArrayList<Train> trains; 
    //arraylist, because the number of passenger
    // cars will be changing, so an arraylist is more suitable than an array
    
    // Don't need a copy, or any other, constructor here. Because we can't have two trains with the same names.
    
    
    public TrainManager() {
        input=new Scanner(System.in);
        trains = new ArrayList<Train>();
    }
        // every method's name is specifying exactly what the method will do
    public boolean addTrain() {
        String trainName = "";
        Train t = null;
        while (trainName.length()<1 ) { // this loops ends when the name of the train has one or more characters i.e. it's not null or empty
            System.out.println("Please enter the name of the train you want to add: ");
            trainName = input.nextLine();
            if (trainName.length()>0) {
                t = new Train(trainName);
                for (Train T : trains) {
                    if (T.getName().equals(t.getName())) {
                        System.out.println("A train already exists with this name");
                        return false;
                    }
                }
            } else System.out.println("Invalid train name, try again!");
        }
        return trains.add(t);
        
    }
    public boolean removeTrain() {
        System.out.println("Enter the name of the train you want to remove: ");
        String name = input.nextLine();
        for (Train t: trains) {
            if(t.getName().equals(name)){
                return trains.remove(t);
            }
        }
        return false;
    }
    
    public ArrayList<Train> getTrains(){
        return trains;
    }
    
    public Train get(String name) {
        for (Train t: trains) {
            if(t.getName().equals(name)){
                return t;
            }
        } 
        return null;
    }
    @Override
    public String toString() {
        
        return trains.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || !(o instanceof Train)) return false;
        TrainManager train = (TrainManager) o;
        return trains.equals(train.trains);
    }
    public void save() {

        //this function is final because we don't want any class (or it's sub classes to change this function, which we won't be making)

        // we designed the project in such a way that we can store and read all the information by storing a
        // and reading a single object. It will save us a lot time and will help reduce the number of lines.

        ObjectOutputStream s;
        try {
            s = new ObjectOutputStream(new FileOutputStream("data.txt"));
            // every time this function will run, it will override the existing data, including the previous
            //output stream header.
            s.writeObject(trains);
            s.close();
            System.out.println("The file has been successfully saved");
        } catch (IOException e) {
            System.out.println("File didn't get saved because of error "+e.getMessage());;
        }
    }
    public static TrainManager loadData() {
        // we designed the project in such a way that we can store and read all the information by storing a
        // and reading a single object. It will save us a lot time and will help reduce the number of lines.

        ObjectInputStream s;

            try {
                s = new ObjectInputStream(new FileInputStream("data.txt"));
                TrainManager obj = new TrainManager();
                obj.trains=(ArrayList<Train>) s.readObject();
                PassengerCar.input = new Scanner(System.in);// since there will be no scanner object in input(data field)
                // ,due to the transient keyword, so we are initializing it here, so we can run the objects of passenger
                // car class properly. Since, they are expecting inout to have a scanner object.
                Train.input = new Scanner(System.in);// same reason as above
                s.close();
                return obj;

            } catch (Exception e) { // this catch will return a new TrainManager object, if, there is no data in the file, or if the file doesn't exist
                return new TrainManager();
            }

    }

}