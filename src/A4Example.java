package src;

import java.util.ArrayList;
import java.util.Arrays;

public class A4Example {
	public static void main(String args[]) {
		ArrayList<ArrayList<ColourT>> s = new ArrayList<ArrayList<ColourT>>();
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(Arrays.asList(ColourT.green, ColourT.green, ColourT.purple, ColourT.orange,
				ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		s.add(new ArrayList<ColourT>(
				Arrays.asList(ColourT.blue, ColourT.green, ColourT.purple, ColourT.orange, ColourT.red, ColourT.blue)));
		DotsBoardT board = new DotsBoardT();
		board.init(s, 10, 5, ColourT.red);
		PrintBoard print = new PrintBoard(board);
		print.print();
		ArrayList<PointT> pointList = new ArrayList<PointT>();
		pointList.add(new PointT(1, 0));
		pointList.add(new PointT(1, 1));
		board.popElems(pointList);
		board.remove(pointList);
		board.rebase();
		PrintBoard print1 = new PrintBoard(board);
		print1.print();
	}
}
