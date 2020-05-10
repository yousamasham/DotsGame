import java.util.Arrays;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import src.DotsBoardT;
import src.GameBoard;
import src.ColourT;
import src.PointT;

public class TestDotsBoardT{
	private ArrayList<ArrayList<ColourT>> s;
	private ArrayList<PointT> pointList;
	private DotsBoardT board = new DotsBoardT();

    @Before
    public void setup(){
		s = new ArrayList<ArrayList<ColourT>>();
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange,
				ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		board.init(s, 5, 5, ColourT.blue);
		pointList = new ArrayList<PointT>();
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testPopElemEx1(){
        pointList.add(new PointT(9,9));
        board.popElems(pointList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPopElemEx2(){
        pointList.add(new PointT(0,0));
        board.popElems(pointList);
    }
    @Test (expected = IllegalArgumentException.class)
    public void testPopElemEx3(){
        pointList.add(new PointT(0,0));
        pointList.add(new PointT(1,1));
        board.popElems(pointList);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testPopElemEx4(){
        pointList.add(new PointT(0,0));
        pointList.add(new PointT(0,1));
        board.popElems(pointList);
    }

    @Test (expected = ArithmeticException.class)
    public void testPopElemEx5(){
        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i, 0));
        board.popElems(pointList);
        pointList = new ArrayList<PointT>();


        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i, 1));
        board.popElems(pointList);
        pointList = new ArrayList<PointT>();


        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i, 2));
        board.popElems(pointList);
        pointList = new ArrayList<PointT>();


        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i, 3));
        board.popElems(pointList);
        pointList = new ArrayList<PointT>();


        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i, 4));
        board.popElems(pointList);
        pointList = new ArrayList<PointT>();


        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i, 5));
        board.popElems(pointList);
    }

    @Test
    public void testPopElem(){
        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i,0));
        board.popElems(pointList);
        assertEquals(board.getScore(), 6);
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void testRemoveEx1(){
        pointList.add(new PointT(9,9));
        pointList.add(new PointT(10,9));
        board.remove(pointList);
    }

    @Test
    public void testRemove(){
        PointT p;
        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i,0));
        board.popElems(pointList);
        board.remove(pointList);
        for (int i = 0 ; i < 6 ; i++)
            assertEquals(board.getElem(pointList.get(i)), null);
    }

    @Test
    public void testRebase(){
        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i,0));
        board.popElems(pointList);
        board.remove(pointList);
        board.rebase();
        for (int i = 0; i < 6; i++)
            for (int j = 0; j < 6; j++)
                assertFalse(board.getElem(new PointT(i, j)) == null);
    }

    @Test
    public void testHas_won(){
        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i, 0));
        board.popElems(pointList);
        board.remove(pointList);
        board.rebase();
        pointList = new ArrayList<PointT>();
        for (int i = 0; i < 6; i++)
            pointList.add(new PointT(i, 5));
        board.popElems(pointList);
        board.remove(pointList);
        board.rebase();
        assertTrue(board.has_won());
    }
}
