import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import static org.junit.Assert.assertEquals;

public class HangarTest {

    private Hangar hangar;
    private Plane plane1;
    private Plane plane2;
    private Plane plane3;

    @Before
    public void before() {
        hangar = new Hangar("Wilson");
        plane1 = new Plane(Type.BOEING777, AirlineName.AIRCANADA );
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
        hangar.removePlane();
        assertEquals(1, hangar.countPlanes());
    }

    @Test
    public void canGetBackBestPlane(){
        hangar.addPlane(plane1);
        hangar.addPlane(plane2);
        hangar.addPlane(plane3);
        Plane bestPlane = hangar.findBestPlane(410);
        assertEquals(Type.BOEING747, bestPlane.getType());

        bestPlane = hangar.findBestPlane(183);
        assertEquals(Type.BOEING757, bestPlane.getType());
        bestPlane = hangar.findBestPlane(430);
        assertEquals(Type.BOEING777, bestPlane.getType());
    }
}