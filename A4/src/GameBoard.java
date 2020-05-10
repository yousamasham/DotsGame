package src;

import java.util.ArrayList;

/**
 * @file GameBoard.java
 * @author Yousam Asham
 * @brief An module that is a model for the state of a digital board game grid
 * @date Sunday March 29th 2020
 */

/**
 * @brief The class to intialize and modify an abstract object representing a
 *        game board.
 */
public class GameBoard<Type> implements RandomElem {
	protected final static int SIZE = 6;
	protected ArrayList<ArrayList<Type>> g;
	protected static int score;
	protected static int moves;
	protected static int targetMoves;
	protected static int targetScore;
	protected Type targetElement;

	/**
	 * @brief A method to initalize a game board object.
	 * @param s  the lists that will be used to represent the board.
	 * @param tm the integer representing the target moves to win the game.
	 * @param ts the integer representing the target score to win the game.
	 * @param te represents the type to target to win the game.
	 */
	public void init(ArrayList<ArrayList<Type>> s, int tm, int ts, Type te) {
		g = s;
		score = 0;
		moves = 0;
		targetMoves = tm;
		targetScore = ts;
		targetElement = te;
	}

	/**
	 * @brief A getter method to retrieve the game board.
	 * @details The ArrayList to be returned has to be a new ArrayList to preserve
	 *          the principle of information hiding
	 * @return A 2D sequence of type Type
	 */
	public ArrayList<ArrayList<Type>> getBoard() {
		ArrayList<ArrayList<Type>> output = new ArrayList<ArrayList<Type>>();
		ArrayList<Type> layer;
		PointT p;
		for (int i = 0; i < SIZE; i++) {
			layer = new ArrayList<Type>();
			for (int j = 0; j < SIZE; j++) {
				p = new PointT(i, j);
				layer.add(getElem(p));
			}
			output.add(layer);
		}
		return output;
	}

	/**
	 * @brief A getter method to retrieve an element in the grid using a PointT
	 *        object.
	 * @param p a co-ordinate represented by a PointT object
	 * @return An element in the 2D sequence of type T
	 */
	public Type getElem(PointT p) {
		return g.get(p.row()).get(p.col());
	}

	/**
	 * @brief A getter method for the score.
	 * @return The score state variable.
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @brief A getter method for the number of moves.
	 * @return The moves state variable.
	 */
	public int getMoves() {
		return moves;
	}

	/**
	 * @brief A getter method for the target moves.
	 * @return The targetMoves state variable.
	 */
	public int getTargetMoves() {
		return targetMoves;
	}

	/**
	 * @brief A getter method for the target score.
	 * @return The targetScore state variable.
	 */
	public int getTargetScore() {
		return targetScore;
	}

	/**
	 * @brief A getter method for the target type.
	 * @return The targetElement state variable.
	 */
	public Type getTargetType() {
		return targetElement;
	}

	/**
	 * @brief Performs a move on the board grid.
	 * @details Updates the score and updates the number of moves.
	 * @param s represents the list of points of the grid to have the move performed
	 *          on them.
	 * @throws IndexOutOfBoundsException if the input list contains points that *
	 *                                   are out of bounds of the game board.
	 * @throws IllegalArgumentException  if the input list cannot be connected, has
	 *                                   a length equal to or greater than two, or
	 *                                   if the elements to be popped are not of the
	 *                                   same type.
	 * @throws ArithmeticException       if the player has ran out of moves.
	 */
	public void popElems(ArrayList<PointT> s) {
		for (PointT p : s)
			if (!validPoint(p))
				throw new IndexOutOfBoundsException("Input contains points that are out of bound.");
		if (s.size() < 2)
			throw new IllegalArgumentException("Input list must be 2 points or longer.");
		if (!isAdjList(s))
			throw new IllegalArgumentException("Points cannot be connected with one line.");
		if (!sameElem(s))
			throw new IllegalArgumentException("Elements to be popped are not of the same Type");
		if (this.getMoves() == this.getTargetMoves())
			throw new ArithmeticException("You have no more moves left");
		moves++;
		if (g.get(s.get(0).row()).get(s.get(0).col()) == targetElement)
			score = score + s.size();

	}

	/**
	 * @brief Removes elements on the game board grid by setting them to null.
	 * @param s represents a list of PointT objects corresponding to the elements of
	 *          the grid to be deleted.
	 */
	public void remove(ArrayList<PointT> s) {
		for (PointT p : s)
			if (!validPoint(p))
				throw new IndexOutOfBoundsException("Input conatins points that are out of bound.");
		for (PointT p : s)
			g.get(p.row()).set(p.col(), null);
	}

	/**
	 * @brief Gets rid of the null elements in a 2D sequence by rebasing the columns
	 *        of the game board grid, and then repopulating with random elements
	 */
	public void rebase() {
		PointT p, pAbove;
		for (int r = 0; validRowCol(r); r++)
			for (int j = 0; validRowCol(j); j++)
				for (int i = 1; validRowCol(i); i++) {
					p = new PointT(i, j);
					pAbove = new PointT(i - 1, j);
					if (getElem(p) == null && getElem(pAbove) != null) {
						g.get(p.row()).set(p.col(), getElem(pAbove));
						g.get(pAbove.row()).set(pAbove.col(), null);
					}
				}
		for (int k = 0; validRowCol(k); k++)
			for (int l = 0; validRowCol(l); l++) {
				p = new PointT(k, l);
				if (getElem(p) == null)
					setRandElem(p);
			}
	}

	/**
	 * @brief A private method that acts as a local
	 * function that helps with the randomization of the
	 * selection.
	 * @param p represents a point that corresponds to the
	 * point in the grid to be changed.
	 * @throws IndexOutOfBoundsException if the point inputted is out of the bounds of the grid.
	 */
	public void setRandElem(PointT p) {
		if (!validPoint(p))
			throw new IndexOutOfBoundsException("Input is out of bounds.");
		g.get(p.row()).set(p.col(), null);
	}

	/**
	 * @brief a method that returns a boolean corresponding if the user has won.
	 * @return a boolean corresponding if the user has won.
	 */
	public boolean has_won() {
		return (moves <= targetMoves) && (score >= targetScore);
	}

	private static boolean validPoint(PointT p) {
		return (validRowCol(p.row()) && validRowCol(p.col()));
	}

	private static boolean validRowCol(int i) {
		return (0 <= i && i < GameBoard.SIZE);
	}

	private static boolean isAdjList(ArrayList<PointT> s) {
		boolean output = false;
		for (int i = 0; i <= s.size() - 2; i++) {
			if (s.get(i).row() == s.get(i + 1).row() - 1 || s.get(i).row() == s.get(i + 1).row() + 1
					|| s.get(i).col() == s.get(i + 1).col() + 1 || s.get(i).col() == s.get(i + 1).col() - 1) {
				if (!(s.get(i).row() == s.get(i + 1).row() + 1 && s.get(i).col() == s.get(i + 1).col() + 1)
						&& !(s.get(i).row() == s.get(i + 1).row() - 1 && s.get(i).col() == s.get(i + 1).col() - 1))
					output = true;
				else
					return false;
			} else
				return false;
		}
		return output;
	}

	private boolean sameElem(ArrayList<PointT> s) {
		for (int i = 0; i <= s.size() - 2; i++) {
			if (!(g.get(s.get(i).row()).get(s.get(i).col()) == g.get(s.get(i + 1).row()).get(s.get(i + 1).col())))
				return false;
		}
		return true;
	}
}
