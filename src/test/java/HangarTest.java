import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HangarTest {

    private Hangar hangar;
    private Plane plane;

    @Before
    public void before() {
        hangar = new Hangar("Wilson");
        plane = new Plane(Type.BOEING777, AirlineName.AIRCANADA );
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
        hangar.addPlane(plane);
        hangar.addPlane(plane);
        assertEquals(2, hangar.countPlanes());
    }

    @Test
    public void canRemovePlane(){
        hangar.addPlane(plane);
        hangar.addPlane(plane);
        assertEquals(2, hangar.countPlanes());
        hangar.removePlane();
        assertEquals(1, hangar.countPlanes());
    }
}