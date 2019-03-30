import java.util.ArrayList;
import java.util.HashMap;

public class Airport {

    private ArrayList<Hangar> hangars;
    private ArrayList<Flight> flights;
    private ArrayList<Ticket> tickets;

    private HashMap<String, Integer> passengerTrackingHashMap;

    private Code name;

    public Airport(Code name){
        this.passengerTrackingHashMap = new HashMap<>();
        this.hangars =  new ArrayList<>();
        this.flights = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.name = name;
}

    public Code getName() {
        return this.name;
    }

    public Plane getPlane(Hangar hangar){
        Plane plane = hangar.removePlane();
        return plane;
    }

    public int countFlights(){

        return flights.size();
    }


    public Flight createFlight(Plane plane, String flightNum, Destination destination, Hangar hangar){


        Flight flight = new Flight(plane, flightNum, destination);
        return flight;
    }

    public void addFlight(Flight flight){

        flights.add(flight);
    }

    public void createTickets(Flight flight, int price){
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

    public void sellTickets(){
        if (this.tickets.size() > 0){ // doesn't sell tickets when they are all booked
            tickets.remove(0);
        }
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
