import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Plane plane;
    private Flight flight;


    @Before
    public void before(){
        plane = new Plane(Type.BOEING757, AirlineName.AMERICANAIRLINES);
        flight = new Flight(plane, "AC101", Destination.LONDON);
    }

    @Test
    public void canGetPlane(){
        plane = flight.getPlane();
        assertEquals(Type.BOEING757, plane.getType());
        assertEquals(AirlineName.AMERICANAIRLINES, plane.getName());
    }

    @Test
    public void canGetFlightCapForFLight(){
        int cap = flight.avCapForFlight();
        assertEquals(200, cap);

    }

    @Test
    public void canGetFlightNum(){
        assertEquals("AC101", flight.getFlightNum());
    }

    @Test
    public void canGetDestinatiion(){
        assertEquals(Destination.LONDON, flight.getDestination());
    }


    @Test
    public void canSetPlane(){
        Plane newPlane = new Plane(Type.BOEING747, AirlineName.AMERICANAIRLINES);
        flight.setPlane(newPlane);
        plane = flight.getPlane();
        assertEquals(Type.BOEING747, plane.getType());
        assertEquals(AirlineName.AMERICANAIRLINES, plane.getName());
    }
}
