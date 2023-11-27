// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at 
// all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- danila
package spacecolonies;
/**
 * Data Exception
 * @author danila
 * @version 10.11.2022
 */
public class SpaceColonyDataException
    extends Exception {
    /**
     * Constructor 
     * @param s
     *         String message
     */
    public SpaceColonyDataException(String s) {
        super(s);
    }

}
