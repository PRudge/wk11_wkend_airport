import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TicketTest {

    private Ticket ticket;
    private Passenger passenger;

    @Before
    public void before() {
        passenger = new Passenger("Paul", "Rudge");

        ticket = new Ticket(45, passenger, "EZ100", Destination.ABERDEEN);
    }

    @Test
    public void canGetPrice() {
        assertEquals(45, ticket.getPrice());
    }

    @Test
    public void canGetPassenger(){
        Passenger passenger = ticket.getPassenger();
        assertEquals("Paul", passenger.getFirstName());
        assertEquals("Rudge", passenger.getLastName());
    }


    @Test
    public void canGetFlightNum() {
        assertEquals("EZ100", ticket.getFlightNum());
    }


    @Test
    public void canGetDestination() {
        assertEquals(Destination.ABERDEEN, ticket.getDestination());
    }


}