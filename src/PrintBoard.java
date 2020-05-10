package src;

import java.util.ArrayList;

/**
 * @file PrintBoard.java
 * @author Yousam Asham
 * @brief An module that acts as a view module for a dots game grid
 * @date Sunday March 29th 2020
 */

/**
 * @brief The class that houses the PrintBoard type object.
 */
public class PrintBoard {

	protected static ArrayList<ArrayList<String>> g = new ArrayList<ArrayList<String>>();
	protected static DotsBoardT d;

    /**
     * @brief A constructor for a PrintBoard type object.
     * @details the character 2D sequence is initialized here.
     * @param d a dots game board type object
     * @throws IllegalArgumentException if the inputted sequence does not
     * consist of ColourT objects.
     */
	public PrintBoard(DotsBoardT d) {
		ArrayList<ArrayList<ColourT>> g = d.getBoard();
		PrintBoard.d = d;
		ArrayList<String> n = null;
		PointT p = null;
		for (int i = 0; i < 6; i++) {
			n = new ArrayList<String>();
			for (int j = 0; j < 6; j++)
				p = new PointT(i, j);
			if (g.get(p.row()).get(p.col()) == ColourT.blue)
				n.add("b");
			else if (g.get(p.row()).get(p.col()) == ColourT.green)
				n.add("g");
			else if (g.get(p.row()).get(p.col()) == ColourT.purple)
				n.add("p");
			else if (g.get(p.row()).get(p.col()) == ColourT.orange)
				n.add("o");
			else if (g.get(p.row()).get(p.col()) == ColourT.red)
				n.add("r");
			else
				throw new IllegalArgumentException("Sequence does not consist of ColourT types.");
		}
		PrintBoard.g.add(n);
	}

    /**
     * @brief A getter method that uses the character 2D list.
     * @param p represents the point we would like to retrieve, represented by
     * a PointT object.
     * @return A string of one letter that is representative of the colour
     * present at the inputted point of the grid.
     */
	public String getElem(PointT p) {
		return g.get(p.row()).get(p.col());
	}

    /**
     * @brief A method to facilitate the printing of the dots game board as
     * well as the score, moves, and target state variables of the dots game
     * board type object.
     */
	public void print() {
		PointT p;
		System.out.println();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 6; j++) {
				p = new PointT(i, j);
				System.out.print(getElem(p));
			}
			System.out.println(d.getScore() + "/" + d.getTargetScore() + "\t" + d.getMoves() + "/" + d.getTargetMoves()
					+ "\tTarget:" + d.getTargetType().toString());
		}
	}
}
