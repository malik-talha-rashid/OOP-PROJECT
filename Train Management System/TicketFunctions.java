public interface TicketFunctions {

    boolean isBooked();
    void book(String passengerName);
    void unBook();
}