import java.util.ArrayList;

public class Plane {

    private Type type;
    private AirlineName airlineName;
    private ArrayList<Passenger> passengers;

    public Plane(Type type, AirlineName airlineName) {
        this.type = type;
        this.airlineName = airlineName;
        this.passengers = new ArrayList<>();
    }

    public Type getType(){
        return this.type;
    }

    public AirlineName getName(){
        return this.airlineName;
    }

    public int getValueFromType(){
        return this.type.getValue();
    }

    public String getValueFromEnum(){
        return this.airlineName.getValue();
    }

    public int getPassengerCount(){
        return this.passengers.size();
    }

    public void addPassenger(Passenger passenger){
        this.passengers.add(passenger);
    }


}
