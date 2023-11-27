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
 * Test person class
 * 
 * @author danila
 * @version 10.11.2022
 */
public class PersonTest 
    extends TestCase {
    
    private Person person;

    /**
     * Runs before each test case
     */
    public void setUp() {
        
        person = new Person("Josh", 2, 3, 5, "Mars");
    }
    /**
     * Test getters    
     */
    public void testGetters() {
        assertEquals("Josh", person.getName());
        assertEquals(new Skillset(2, 3, 5), person.getSkills());
        assertEquals("Mars", person.getPlanetPreference());
    }
    /**
     * Test that toString() returns
     * the string as specified in the task
     */
    public void testToString() {
        assertEquals("Josh A:2 M:3 T:5 Wants: Mars", person.toString());
        Person personNoPlanet = new Person("Josh", 2, 3, 5, "");
        assertEquals("No-Planet Josh A:2 M:3 T:5", personNoPlanet.toString());
    }
    /**
     * Test every equals() method outcome
     */
    public void testEquals() {
        assertTrue(person.equals(person));
        assertTrue(person.equals(new Person("Josh", 2, 3, 5, "Mars")));
        assertFalse(person.equals(null));
        assertFalse(person.equals(""));
        assertFalse(person.equals(new Person("Josh", 2, 4, 5, "Mars")));
        assertFalse(person.equals(new Person("Josh", 2, 4, 5, "Meme")));
        assertFalse(person.equals(new Person("Joe", 2, 3, 5, "Mars")));
        assertFalse(person.equals(new Person("Josh", 2, 3, 5, "Puto")));
    }
        
        
        
}


    

