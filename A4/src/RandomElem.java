package src;
/**
 * @file Random.java
 * @author Yousam Asham
 * @brief An module to define a java interface.
 * @date Sunday March 30th 2020
 */
 /**
  * @brief an interface aiming to generate a random type from an enumeration
  * set.
  */
public interface RandomElem{
    /**
     * @brief a method aiming to set a 2D sequence entry corresponding to a
     * PointT object to a random element from an enumeration set.
     * @param p represents the point in the 2D sequence to be set.
     * @throws IndexOutOfBoundsException if the point lies outside the 2D
     * sequence.
     */
    void setRandElem(PointT p);
}
