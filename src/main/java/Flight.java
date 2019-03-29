public class Flight{

    private Plane plane;
    private String flightNum;
    private String destination;



    public Flight(Plane plane, String flightNum, String destination ) {
        this.plane = plane;
        this.flightNum = flightNum;
        this.destination = destination;

    }

    public Plane getPlane(){
        return this.plane;
    }

    public String getFlightNum() {
        return this.flightNum;
    }

    public String getDestination() {
        return this.destination;
    }
}

