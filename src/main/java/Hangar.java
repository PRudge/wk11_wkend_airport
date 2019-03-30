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


//    public void removePlane(Plane plane){
//
//        return this.planes.remove(0);
//        this.planes.remove(plane);
//    }

    public Plane removePlane(){

        return this.planes.remove(0);
    }

    public Plane findBestPlane(int capacity) {
        int x = 0;
        int justAbove = Integer.MAX_VALUE;


        ArrayList<Plane> suitablePlanes;
        suitablePlanes = new ArrayList<>();

        Plane bestPlane = new Plane();

        for (Plane plane : this.planes) {
            if (plane.getValueFromType() >= capacity) {
                suitablePlanes.add(plane);
            }
            bestPlane = getBestPlane(suitablePlanes);

        }
        return bestPlane;

    }

    public Plane getBestPlane(ArrayList<Plane> suitablePlanes) {
        Plane bestPlane;
        bestPlane = new Plane();
        int minVal = Integer.MAX_VALUE;

        for (Plane plane : suitablePlanes){
            if (plane.getValueFromType() < minVal){
                bestPlane = plane;
                minVal = plane.getValueFromType();
            }
        }
        return bestPlane;
    }



}





