package src;
/**
 * @file ColourTypes.java
 * @author Yousam Asham
 * @brief A module to define the Colour types (aqua, green, magenta, red,
 * tangerine)
 * @date Saturday March 28th 2020
 */

/**
 * @brief The enumeration class representing the Colour type.
 */
public enum ColourT {

	blue, green, purple, orange, red;

    /**
     * @brief A method that maps each ColourT to its corresponding string.
     * @return A string.
     */
	public String toString() {
		switch (this) {
		case blue:
			return "Blue";
		case green:
			return "Green";
		case purple:
			return "Purple";
		case orange:
			return "Orange";
		case red:
			return "Red";
		default:
			throw new IllegalArgumentException();
		}
	}
}
