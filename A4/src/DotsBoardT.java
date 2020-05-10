package src;

import java.util.ArrayList;
import java.util.Random;

/**
 * @file DotsBoardT.java
 * @author Yousam Asham
 * @brief An module that is a model for the state of a dots game grid.
 * @date Saturday March 28th 2020
 */

/**
 * @brief The class to represent a Dots game board, inherits from GameBoard.
 */
public class DotsBoardT extends GameBoard<ColourT> implements RandomElem {

	/**
	 * @brief A constructor for the dots game board, uses the GameBoard init()
	 *        method
	 * @param s  the grid.
	 * @param tm the target number of moves.
	 * @param ts the target score to be achieved.
	 * @param te the target element to win the game.
	 */
	public void init(ArrayList<ArrayList<ColourT>> s, int tm, int ts, ColourT te) {
		super.init(s, tm, ts, te);
	}

	/**
	 * @brief a method to override the setRandElem method from GameBoard to make it
	 *        more suitable for the ColourT type dots game board.
	 * @param p a pointT object to set in the grid to a random element.
	 */
	public void setRandElem(PointT p) {
		ColourT c;
		Random rnd = new Random();
		int w = rnd.nextInt(5);
		if (w == 0)
			c = ColourT.blue;
		else if (w == 1)
			c = ColourT.green;
		else if (w == 2)
			c = ColourT.purple;
		else if (w == 3)
			c = ColourT.orange;
		else
			c = ColourT.red;
		g.get(p.row()).set(p.col(), c);
	}
}
