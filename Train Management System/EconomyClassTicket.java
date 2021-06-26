package a1Proj2;

//Since we don't need to make child class of this class, so we declared it as final!
public final class EconomyClassTicket extends Ticket {// since parent class is implementing Serializable interface, child class will also be serializable.
    //so, Serializable wasn't implemented
    public final static int price=1000;// Use of final and static keywords, which was required here
    // Don't need a copy  constructor here
    public EconomyClassTicket(int seatNumber) {
        super(seatNumber);
    }

    @Override
    public String toString() {
        return "-------------------\n"+super.toString()+"\n price: "+price+"\n-------------------";
    }
}