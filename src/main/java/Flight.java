public class Flight{

    private Plane plane;
    private String flightNum;
    private Destination destination;



    public Flight(Plane plane, String flightNum, Destination destination ) {
        this.plane = plane;
        this.flightNum = flightNum;
        this.destination = destination;

    }

    public Flight(String flightNum, Destination destination ) {
        this.flightNum = flightNum;
        this.destination = destination;

    }

    public Plane getPlane(){
        return this.plane;
    }

    public String getFlightNum() {
        return this.flightNum;
    }

    public Destination getDestination() {
        return this.destination;
    }

    public int avCapForFlight(){
        return this.destination.getValue();
    }





    public void setPlane(Plane plane){
        this.plane = plane;
    }
}

