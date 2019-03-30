public class Passenger {
    private String firstName;
    private String lastName;
    private Ticket ticket;

    public Passenger(String firstName, String lastName, Ticket ticket){
        this.firstName = firstName;
        this.lastName = lastName;
        this.ticket = ticket;

    }

    public Passenger(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setFirstName(String name){
        this.firstName = name;
    }

    public void setLastName(String name){
        this.lastName = name;
    }

    public Ticket buyTicket(Flight flight){


        //check tickets available
        // buy a ticket for a flight
        Ticket ticket = new Ticket();
        return ticket;
    }

    public void setTicket(Ticket ticket){
        this.ticket = ticket;
    }





}

