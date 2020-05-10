package src;
/**
 * @file PointT.java
 * @author Yousam Asham
 * @brief An module that represents a point in the cartesian plane
 * @date Saturday March 28th 2020
 */

/**
 * @brief The ADT to create and modify the pointT object
 */
public class PointT{
    protected int r;
    protected int c;

    /**
     * @brief A constructor for the Point ADT
     * @details Initializes a PointT object's state variables with the passed
     * in parameters
     * @param r row
     * @param c column
     */
    public PointT(int r, int c){
        this.r = r;
        this.c = c;
    }

    /**
     * @brief A getter method for the row state variable
     * @return The row state variable which is of type integer
     */
    public int row(){
        return this.r;
    }

    /**
     * @brief A getter method for the column state variable
     * @return The column state variable which is of type integer
     */
    public int col(){
        return this.c;
    }
}
