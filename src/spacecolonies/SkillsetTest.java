// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at 
// all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- danila
package spacecolonies;

import student.TestCase;
/**
 * Test Skillset class 
 * 
 * @author danila
 * @version 10.11.2022
 */
public class SkillsetTest extends TestCase {
    
    private Skillset skill;
    /**
     * Set up the skill
     * with 10, 20, 30 points
     * for agri, med, tech  respectively
     */
    public void setUp() {
        skill = new Skillset(10, 20, 30);

    }
    /**
     * Test that getter methods
     * return right values
     * 
     */
    public void testGetters() {
        assertEquals(10, skill.getAgriculture());
        assertEquals(20, skill.getMedicine());
        assertEquals(30, skill.getTechnology());
    }
    /**
     * Test LessThanOrEqualTo
     */
    public void testLessThanOrEqualTo() {
        assertTrue(skill.isLessThanOrEqualTo(skill));
        assertFalse(skill.isLessThanOrEqualTo(new Skillset(10, 10, 10)));
        assertFalse(skill.isLessThanOrEqualTo(new Skillset(10, 20, 10)));
        assertFalse(skill.isLessThanOrEqualTo(new Skillset(0, 20, 30)));
        assertTrue(skill.isLessThanOrEqualTo(new Skillset(20, 20, 50)));
        assertTrue(skill.isLessThanOrEqualTo(new Skillset(20, 30, 40)));
    }
    /**
     * Test that equals method
     * behaves in a right way in any
     * situation
     */
    public void testEquals() {
        assertTrue(skill.equals(skill));
        assertFalse(skill.equals(null));
        assertFalse(skill.equals("amogus"));
        assertTrue(skill.equals(new Skillset(10, 20, 30)));
        assertFalse(skill.equals(new Skillset(11, 20, 30)));
        assertFalse(skill.equals(new Skillset(10, 21, 30)));
        assertFalse(skill.equals(new Skillset(10, 20, 31)));
        
    }
    /**
     * Test that toString returns right
     * string representation
     */
    public void testToString() {
        assertEquals("A:10 M:20 T:30", skill.toString());
    }
    /**
     * Make sure compareTo method returns
     * right values when compared to other skills
     */
    public void testCompareTo() {
        assertEquals(1, skill.compareTo(new Skillset(5, 5, 5)));
        assertEquals(0, skill.compareTo(new Skillset(10, 20, 30)));
        assertEquals(-1, skill.compareTo(new Skillset(50, 50, 50)));
    }
    

}
