import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hangar {
    private String name;
    private ArrayList<Plane> planes;

    public Hangar(String name){
        this.name = name;
        this.planes = new ArrayList<Plane>();

    }

    public String getName(){
        return this.name;
    }

    public int countPlanes(){
        return this.planes.size();
    }

    public void addPlane(Plane plane){
        planes.add(plane);
    }

    public ArrayList<Plane> getPlanes(){
        return new ArrayList<>(this.planes);
    }


    public void removePlane(Plane plane){
        this.planes.remove(plane);
    }


    public Plane findBestPlane(int capacity, Plane brokenPlane) {

        ArrayList<Plane> suitablePlanes;
        suitablePlanes = new ArrayList<>();

        Plane bestPlane = new Plane();

        int minVal = Integer.MAX_VALUE;

        for (Plane plane : this.planes) {
            if (plane != brokenPlane) {
                if (plane.getValueFromType() >= capacity) {

                    if (plane.getValueFromType() < minVal){
                        bestPlane = plane;
                        minVal = plane.getValueFromType();
                    }

                }
            }
        }

        return bestPlane;

    }
}





