import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AirportTest {

    private Airport airport;
    private Hangar hangar1;
    private Hangar hangar2;
    private Hangar hangar3;
    private Plane plane1;
    private Plane plane2;
    private Plane plane3;

    private Flight flight;

    private Flight flight1;
    private Flight flight2;
    private Flight flight3;

    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    @Before
    public void before() {
        airport = new Airport(AirportNames.GLA);

        hangar1 = new Hangar("Wilson");
        hangar2 = new Hangar("MacMillan");
        hangar3 = new Hangar("Thatcher");

        plane1 = new Plane(Type.A380, AirlineName.AIRCANADA );
        plane2 = new Plane(Type.BOEING757, AirlineName.DELTAAIRLINES);
        plane3 = new Plane(Type.A380, AirlineName.LUFTHANSA);

        passenger1 = new Passenger("John", "Smith");
        passenger2 = new Passenger("Jane", "Jones");
        passenger3 = new Passenger("Brogan", "Rudge");

        for(int i = 0; i < 10; i++) {
            plane1.addPassenger(passenger1);
        }


        hangar1.addPlane(plane1);
        hangar1.addPlane(plane2);
        hangar1.addPlane(plane3);


        flight1 = new Flight (plane1, "AC101", "Rome");

    }

    @Test
    public void canGetName(){
        assertEquals(AirportNames.GLA, airport.getName());

    }

    @Test
    public void canGetPlane(){
        Plane plane = airport.getPlane(hangar1);
        assertEquals(2, hangar1.countPlanes());
    }

    @Test
    public void canCountFlights(){
        assertEquals(0, airport.countFlights());
    }

    @Test
    public void canCreateFlight(){ // this assigns a plane to the flight
        Plane plane = airport.getPlane(hangar1);
        Flight newFlight = airport.createFlight(plane, "EZ100", "Inverness");
        assertEquals("EZ100", newFlight.getFlightNum());

    }

    @Test
    public void canAddFlight(){
        Flight newFlight =  airport.createFlight(plane1, "EZ100", "Inverness");
        airport.addFlight(newFlight);
        assertEquals(1, airport.countFlights() );
    }

    @Test
    public void canMakeTickets() {
        Flight newFlight = airport.createFlight(plane1, "EZ100", "Inverness");
        airport.createTickets(newFlight);
        assertEquals(2, airport.countTickets());
    }

    @Test
    public void canSellTickets(){
        Flight newFlight = airport.createFlight(plane1, "EZ100", "Inverness");
        airport.createTickets(newFlight);
        airport.sellTickets();
        assertEquals(1, airport.countTickets());
        airport.sellTickets();
        assertEquals(0, airport.countTickets()); // zero fully booked
        airport.sellTickets();
        assertEquals(0, airport.countTickets());
    }

    @Test
    public void canFindNumberOfPeopleOnFlight(){
        Flight newFlight = airport.createFlight(plane1, "EZ100", "Inverness");
        int numPassenger = newFlight.getPlane().getPassengerCount();
        assertEquals(10, numPassenger);
    }

//    @Test
//    public void canKeepTrackOfPeopleOnFlights(){
//        Flight newFlight = airport.createFlight(plane1, "EZ100", "Inverness");
//        int numPassenger = newFlight.getPlane().getPassengerCount();
//
//        airport.trackPassengers(newFlight.getFlightNum(), numPassenger);
//
//
//
//    }


}
