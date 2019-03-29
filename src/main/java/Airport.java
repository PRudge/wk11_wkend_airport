import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Airport {

    private ArrayList<Hangar> hangars;
    private ArrayList<Flight> flights;
    private ArrayList<Ticket> tickets;

    private Plane plane;
    private Passenger passenger;
    private Flight flight;
    private Ticket ticket;

    private AirportNames name;

    public Airport(AirportNames name){
        this.hangars =  new ArrayList<>();
        this.flights = new ArrayList<>();
        this.tickets = new ArrayList<>();
        this.name = name;
        this.passenger = new Passenger("John", "Smith");
        this.ticket = new Ticket(45, passenger, "ez200", "Rome");
    }

    public AirportNames getName() {
        return this.name;
    }

    public Plane getPlane(Hangar hangar){
        Plane plane = hangar.removePlane();
        return plane;
    }

    public int countFlights(){
        return flights.size();
    }

    public Flight createFlight(Plane plane, String flightNum, String destination){
        flight = new Flight(plane, flightNum, destination);
        return flight;
    }

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void createTickets(Flight flight){
        Plane plane = flight.getPlane();
        int numTickets = plane.getValueFromType();
        for (int i = 0; i < numTickets; i++){
            this.tickets.add(ticket);
        }
    }

    public int countTickets(){
        return this.tickets.size();
    }

    public void sellTickets(){
        if (this.tickets.size() > 0){
            tickets.remove(0);
        }
    }


    public void trackPassengers(String flightNum, int numPassengers){
        Map<String, Integer> passengerTracking = new HashMap<>();
        passengerTracking.put(flightNum, numPassengers);
    }

//    public void trackPassengersSize(){
//        passengerTracking.size();
//    }

}
