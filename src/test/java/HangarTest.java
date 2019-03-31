import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class HangarTest {

    private Hangar hangar;
    private Plane plane1;
    private Plane plane2;
    private Plane plane3;

    @Before
    public void before() {
        hangar = new Hangar("Wilson");
        plane1 = new Plane(Type.BOEING777, AirlineName.LUFTHANSA );
        plane2 = new Plane(Type.BOEING757, AirlineName.AIRCANADA );
        plane3 = new Plane(Type.BOEING747, AirlineName.AIRCANADA );
    }

    @Test
    public void canGetName() {
        assertEquals("Wilson", hangar.getName());
    }

    @Test
    public void canCountPlanes(){
        assertEquals(0, hangar.countPlanes());
    }


    @Test
    public void canAddPlanes(){
        hangar.addPlane(plane1);
        hangar.addPlane(plane2);
        assertEquals(2, hangar.countPlanes());
    }

    @Test
    public void canRemovePlane(){
        hangar.addPlane(plane1);
        hangar.addPlane(plane2);
        assertEquals(2, hangar.countPlanes());
        hangar.removePlane(plane1);
        assertEquals(1, hangar.countPlanes());
    }

    @Test
    public void canGetPlanes(){
        ArrayList<Plane> array;

        hangar.addPlane(plane1);
        hangar.addPlane(plane2);

        array = hangar.getPlanes();
        Plane plane = array.get(0);
        assertEquals(Type.BOEING777, plane.getType());
        assertEquals(AirlineName.LUFTHANSA, plane.getName());
    }

    @Test
    public void canGetBackBestPlaneNoBrokenPlanes(){
        hangar.addPlane(plane1);
        hangar.addPlane(plane2);
        hangar.addPlane(plane3);
        Plane brokenPlane = new Plane(); //
        Plane bestPlane = hangar.findBestPlane(293, brokenPlane);
        assertEquals(Type.BOEING747, bestPlane.getType());

        bestPlane = hangar.findBestPlane(183, brokenPlane);
        assertEquals(Type.BOEING757, bestPlane.getType());

        bestPlane = hangar.findBestPlane(430, brokenPlane);
        assertEquals(Type.BOEING777, bestPlane.getType());
    }

    @Test
    public void canGetBackBestPlaneBrokenPlane(){
        hangar.addPlane(plane1);
        hangar.addPlane(plane2);
        hangar.addPlane(plane3);
        Plane brokenPlane = plane2; // can't use plane2
        Plane bestPlane = hangar.findBestPlane(293, brokenPlane);
        assertEquals(Type.BOEING747, bestPlane.getType());

        bestPlane = hangar.findBestPlane(183, brokenPlane);
        assertEquals(Type.BOEING747, bestPlane.getType());

        bestPlane = hangar.findBestPlane(430, brokenPlane);
        assertEquals(Type.BOEING777, bestPlane.getType());
    }
}