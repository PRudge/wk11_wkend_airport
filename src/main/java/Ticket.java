public class Ticket{

    private int price;
    private Passenger passenger;
    private String name;
    private Destination destination;
    private String flightNum;


//    public Ticket(int price, Passenger passenger, String flightNum,  Destination destination){
//        this.price = price;
//        this.flightNum = flightNum;
//        this.destination = destination;
//        this.passenger = passenger;
//    }

    public Ticket(int price, String flightNum,  Destination destination){
        this.price = price;
        this.flightNum = flightNum;
        this.destination = destination;
    }

    public Ticket(){

    }


    public int getPrice(){
        return this.price;
    }

    public String getFlightNum(){
        return this.flightNum;
    }

    public Destination getDestination(){
        return this.destination;
    }

//    public Passenger getPassenger(){
//        return this.passenger;
//    }




}
