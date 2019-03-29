import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {

    private Plane plane;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    @Before
    public void before(){
        passenger1 = new Passenger("John", "Smith");
        passenger2 = new Passenger("Jane", "Jones");
        passenger3 = new Passenger("Brogan", "Rudge");

        plane = new Plane(Type.BOEING747, AirlineName.AIRCANADA);
    }

    @Test
    public void canGetPlaneType(){
        assertEquals(Type.BOEING747, plane.getType());
    }

    @Test
    public void canGetAirline(){
        assertEquals(AirlineName.AIRCANADA, plane.getName());
    }

    @Test
    public void boeing747HasCap420(){
        plane = new Plane(Type.BOEING747, AirlineName.AIRCANADA);
//       Type[] types = Type.values();
        assertEquals(420, plane.getValueFromType());
    }

    @Test
    public void americanAirlinesHasAC(){
        plane = new Plane(Type.BOEING747, AirlineName.AIRCANADA);
//       Type[] types = Type.values();
        assertEquals("AC", plane.getValueFromEnum());
    }

    @Test
    public void canCountPassengers(){
        assertEquals(0, plane.getPassengerCount());
    }

    @Test
    public void canAddPassenger(){
        plane.addPassenger(passenger1);
        assertEquals(1, plane.getPassengerCount());
        plane.addPassenger(passenger2);
        assertEquals(2, plane.getPassengerCount());
    }


}

