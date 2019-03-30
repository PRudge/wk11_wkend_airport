import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    private Airport airport;
    private Hangar hangar1;
    private Hangar hangar2;
    private Hangar hangar3;
    private Plane plane1;
    private Plane plane2;
    private Plane plane3;
    private Plane plane4;

    private Flight flight;

    @Before
    public void before() {
        airport = new Airport(Code.GLA);

        hangar1 = new Hangar("Wilson");
        hangar2 = new Hangar("MacMillan");
        hangar3 = new Hangar("Thatcher");

        plane1 = new Plane(Type.A330, AirlineName.AIRCANADA );
        plane2 = new Plane(Type.BOEING757, AirlineName.DELTAAIRLINES);
        plane3 = new Plane(Type.BOEING777, AirlineName.LUFTHANSA);
        plane4 = new Plane(Type.A380, AirlineName.LUFTHANSA);


        Passenger passenger1 = new Passenger("John", "Smith");
        Passenger passenger2 = new Passenger("Jane", "Jones");
        Passenger passenger3 = new Passenger("Brogan", "Rudge");

        for(int i = 0; i < 10; i++) {
            plane1.addPassenger(passenger1);
        }

        for(int i = 0; i < 200; i++) {
            plane2.addPassenger(passenger2);
        }

        for(int i = 0; i < 50; i++) {
            plane3.addPassenger(passenger3);
        }

        hangar1.addPlane(plane1);
        hangar1.addPlane(plane2);
        hangar1.addPlane(plane3);
        hangar2.addPlane(plane1);
        hangar2.addPlane(plane2);
        hangar3.addPlane(plane4);

//        airport.addHangar(hangar1);
//        airport.addHangar(hangar2);
//        airport.addHangar(hangar3);
    }

    @Test
    public void canGetAirportCodeName(){


        assertEquals(Code.GLA, airport.getCode());

    }

    @Test
    public void canCountFlights(){

        assertEquals(0, airport.countFlights());
    }

    @Test
    public void canCreateFlight(){ // this assigns a plane to the flight

        // createFlight assigns a plane
        Flight newFlight = airport.createFlight("EZ100", Destination.MALAGA, hangar1);
        assertEquals("EZ100", newFlight.getFlightNum());

        Plane plane = newFlight.getPlane();

        assertEquals(Type.A330, plane.getType() );
        assertEquals(AirlineName.AIRCANADA, plane.getName());
    }

    @Test
    public void canGetNewPlane(){ // this assigns a plane to the flight

        Flight flight = new Flight(plane1,"EZ100", Destination.MALAGA);
        Plane brokenPlane = plane1; // replace plane
        int capacity = flight.avCapForFlight(); // get average capacity for MALAGA flight;

        Plane replacementPlane = hangar1.findBestPlane(capacity, brokenPlane);

        assertEquals(Type.BOEING777, replacementPlane.getType() );
        assertEquals(AirlineName.LUFTHANSA, replacementPlane.getName());

    }

    @Test
    public void canAmendFlight(){
        Flight flight = new Flight(plane1,"EZ100", Destination.MALAGA);
        Plane brokenPlane = plane1; // replace plane
        int capacity = flight.avCapForFlight(); // get average capacity for MALAGA flight;

        Plane replacementPlane = hangar1.findBestPlane(capacity, brokenPlane);

        // assign new plane to flight
        flight.setPlane(replacementPlane);

        Plane newPlane = flight.getPlane();

        assertEquals(Type.BOEING777, newPlane.getType() );
        assertEquals(AirlineName.LUFTHANSA, newPlane.getName());
    }


    @Test
    public void canAddFlight(){
        Flight newFlight =  new Flight(plane1, "EZ100", Destination.ABERDEEN);
        airport.addFlight(newFlight);
        assertEquals(1, airport.countFlights() );
    }

    @Test
    public void canCountHangars(){
        assertEquals(0, airport.countHangars());
    }

    @Test
    public void canAddHangar(){
        airport.addHangar(hangar1);
        assertEquals(1, airport.countHangars());
        airport.addHangar(hangar2);
        assertEquals(2, airport.countHangars());
        airport.addHangar(hangar3);
        assertEquals(3, airport.countHangars());
    }

    @Test
    public void canGenerateTickets() {
        Flight newFlight;

        newFlight = new Flight(plane4, "EZ100", Destination.ABERDEEN);
        newFlight.setPlane(plane4);
        airport.createTickets(newFlight, 45);
        assertEquals(2, airport.countTickets());
    }

    @Test
    public void canSellTickets(){
        Flight newFlight = new Flight(plane4, "EZ100", Destination.ABERDEEN);
        airport.createTickets(newFlight, 45);
        airport.sellTickets();
        assertEquals(1, airport.countTickets());
        airport.sellTickets();
        assertEquals(0, airport.countTickets()); // zero fully booked
        airport.sellTickets();
        assertEquals(0, airport.countTickets());
    }

    @Test
    public void canFindNumberOfPeopleOnFlight(){
        Flight newFlight = new Flight(plane1, "EZ100", Destination.ABERDEEN);
        int numPassenger = newFlight.getPlane().getPassengerCount();
        assertEquals(10, numPassenger);
    }

    @Test
    public void canKeepTrackOfPeopleOnFlights(){
        Flight newFlight = new Flight(plane1, "EZ100", Destination.ABERDEEN);
        int numPassenger = newFlight.getPlane().getPassengerCount();

        HashMap<String, Integer> passengersOnFlightsCounts = airport.trackPassengers(newFlight.getFlightNum(), numPassenger);
        int flightEZ100count = passengersOnFlightsCounts.get("EZ100");
        assertEquals(10, flightEZ100count);


        newFlight = new Flight(plane3, "AC99", Destination.ABERDEEN);
        numPassenger = newFlight.getPlane().getPassengerCount();

        passengersOnFlightsCounts = airport.trackPassengers(newFlight.getFlightNum(), numPassenger);
        int flightAC99count = passengersOnFlightsCounts.get("AC99");
        assertEquals(50, flightAC99count);
        flightEZ100count = passengersOnFlightsCounts.get("EZ100");
        assertEquals(10, flightEZ100count);
    }
}
