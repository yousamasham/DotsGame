import org.junit.*;
import static org.junit.Assert.*;
import src.PointT;

public class TestPointT{
    private PointT test0 = new PointT(-1,-1);
    private PointT test1 = new PointT(0,0);
    private PointT test2 = new PointT(1,1);
    private PointT test3 = new PointT(2,1);
    private PointT test4 = new PointT(9,10);

    @Test
    public void testRow(){
        assertEquals(test0.row(), -1);
        assertEquals(test1.row(), 0);
        assertEquals(test2.row(), 1);
        assertEquals(test3.row(), 2);
        assertEquals(test4.row(), 9);
        assertFalse(test0.row() == 0);
    }

    @Test
    public void testCol(){
        assertEquals(test0.col(), -1);
        assertEquals(test1.col(), 0);
        assertEquals(test2.row(), 1);
        assertEquals(test3.col(), 1);
        assertEquals(test4.col(), 10);
        assertFalse(test0.col() == 0);
    }
}
