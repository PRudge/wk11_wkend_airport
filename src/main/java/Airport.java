import java.util.ArrayList;
import java.util.HashMap;

public class Airport {

    private ArrayList<Hangar> hangars;
    private ArrayList<Flight> flights;
    private ArrayList<Ticket> tickets;

    private HashMap<String, Integer> passengerTrackingHashMap;

    private Code code;

    public Airport(Code code){

        this.code = code;
        this.hangars =  new ArrayList<>();
        this.flights = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.passengerTrackingHashMap = new HashMap<>();
    }

    public Code getCode() {
        return this.code;
    }


    public int countFlights(){ return flights.size(); }


    // capacity of plane is the average for the destination, which is the value in destination enum
    public Flight createFlight(String flightNum, Destination destination, Hangar hangar){

        int capacity = destination.getValue();
        Plane brokenPlane = new Plane(); // no broken plane first time through
        // should be able to loop through all the hangars but it can't...
        // for (Hangar hangar : this.hangars) {
            Plane plane = hangar.findBestPlane(capacity, brokenPlane);
        //}

        Flight newFlight = new Flight(plane, flightNum, destination); // set up the new flight with plane
        hangar.removePlane(plane); //remove the plane from the hangar
        return newFlight;
    }


    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void createTickets(Flight flight, int price){
        //  Type holds the plane capacity, this is number of tickets created to sell
        Plane plane = flight.getPlane();
        Ticket ticket = new Ticket(price, flight.getFlightNum(),flight.getDestination());

        int numTickets = plane.getValueFromType();
        for (int i = 0; i < numTickets; i++){
            this.tickets.add(ticket);
        }
    }

    public int countTickets(){
        return this.tickets.size();
    }

    public Ticket sellTickets(){
        Ticket nullTicket = new Ticket();
        if (this.tickets.size() > 0) { // doesn't sell tickets when they are all booked

            return tickets.remove(0);
      }
        return nullTicket;
    }


    public HashMap<String, Integer> trackPassengers(String flightNum, int numPassengers) {


        this.passengerTrackingHashMap.put(flightNum, numPassengers);

        return this.passengerTrackingHashMap;
    }

    public int countHangars(){
        return hangars.size();
    }

    public void addHangar(Hangar hangar){
        this.hangars.add(hangar);

    }




}
