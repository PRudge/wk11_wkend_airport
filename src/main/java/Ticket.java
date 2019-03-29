public class Ticket{

    private int price;
    private Passenger passenger;
    private String name;
    private String destination;
    private String flightNum;


    public Ticket(int price, Passenger passenger, String flightNum,  String destination){
        this.price = price;
        this.flightNum = flightNum;
        this.destination = destination;
        this.passenger = passenger;
    }


    public int getPrice(){
        return this.price;
    }

    public String getFlightNum(){
        return this.flightNum;
    }

    public String getDestination(){
        return this.destination;
    }

    public Passenger getPassenger(){
        return this.passenger;
    }




}
