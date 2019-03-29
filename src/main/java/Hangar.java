import java.util.ArrayList;

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

    public Plane removePlane(){
        return this.planes.remove(0);
    }



}

