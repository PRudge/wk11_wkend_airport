import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    private Plane plane;
    private Flight flight;


    @Before
    public void before(){
        plane = new Plane(Type.BOEING757, AirlineName.AMERICANAIRLINES);
        flight = new Flight(plane, "AC101", "Rome");
    }

    @Test
    public void canGetPlane(){
        plane = flight.getPlane();
        assertEquals(Type.BOEING757, plane.getType());
        assertEquals(AirlineName.AMERICANAIRLINES, plane.getName());
    }

    @Test
    public void canGetFlightNum(){
        assertEquals("AC101", flight.getFlightNum());
    }

    @Test
    public void canGetDestinatiion(){
        assertEquals("Rome", flight.getDestination());
    }
}
