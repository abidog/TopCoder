package primitivetypes;
import org.junit.Test;
import static org.junit.Assert.*;

public class RectangleIntersectTest {



    @Test
    public void rectangleIntersectTest() {
        RectangleIntersect rect = new RectangleIntersect();
        Rectangle rect1 = new Rectangle(0,0,4,4);
        Rectangle rect2 = new Rectangle(2,2,13,13);
        Rectangle expected = new Rectangle(2,2,4,4);
        assertEquals(expected, rect.intersect(rect1, rect2));


    }
}
