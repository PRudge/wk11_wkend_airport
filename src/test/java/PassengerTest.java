import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void before(){
        passenger = new Passenger("Pauline", "Rudge");
    }

    @Test
    public void canGetFirstName(){
        assertEquals("Pauline", passenger.getFirstName());
    }

    @Test
    public void canGetLastName(){
        assertEquals("Rudge", passenger.getLastName());
    }

    @Test
    public void canSetFirstName(){
        passenger.setFirstName("Suzy");
        assertEquals("Suzy", passenger.getFirstName());
    }

    @Test
    public void canSetLastName(){
        passenger.setLastName("Smith");
        assertEquals("Smith", passenger.getLastName());
    }

    @Test
    public void canSetTicket(){
        Ticket ticket;
        ticket = new Ticket(45, "EZ100", Destination.MALAGA);
        assertEquals(Destination.MALAGA, ticket.getDestination());
        assertEquals("EZ100", ticket.getFlightNum());
    }





}
