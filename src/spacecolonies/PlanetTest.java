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
 * Test case for planet
 * @author danila
 * @version 09.11.2022
 */
public class PlanetTest extends TestCase {
    
    private Planet planet;
    /**
     * Run before each test case
     */
    public void setUp() {
        planet = new Planet("Earth", 2, 3, 4, 8);
    }
    /**
     * Test getters
     */
    public void testGetters() {
        assertEquals("Earth", planet.getName());
        assertEquals(new Skillset(2, 3, 4), planet.getSkills());
        assertEquals(8, planet.getCapacity());
        assertEquals(8, planet.getAvailability());
        assertEquals(0, planet.getPopulationSize());
    }
    /**
     * Test addPerson()
     */
    public void testAddPerson() {
        planet.addPerson(new Person("Josh", 5, 5, 5, "Earth"));
        assertEquals(planet.getPopulation()[0], 
            new Person("Josh", 5, 5, 5, "Earth"));
        assertEquals(1, planet.getPopulationSize());
        assertFalse(planet.addPerson(new Person("Gamer", 1, 1, 1, "")));
    }
    /**
     * Test toString()
     */
    public void testToString() {
        assertEquals("Earth, population 0 (cap: 8), "
            + "Requires: A >= 2, M >= 3, T >= 4", planet.toString());
    }
    /**
     * Test compareTo();
     */
    public void testCompareTo() {
        Planet planet2 = new Planet("Jupiter", 4, 2, 2, 9);
        Planet planet3 = new Planet("Mercury", 1, 3, 5, 7);
        Planet planet4 = new Planet("Kronos", 1, 2, 5, 8);
        Planet planet5 = new Planet("Chad", 5, 5, 5, 8);
        Planet a = new Planet("Abbada", 1, 3, 3, 7);
        Planet b = new Planet("Becca", 1, 3, 3, 7);
        
        assertEquals(-1, planet.compareTo(planet2));
        assertEquals(1, planet.compareTo(planet3));
        assertEquals(1, planet.compareTo(planet4));
        assertEquals(-1, planet.compareTo(planet5));
        assertEquals(-1, a.compareTo(b));
        assertEquals(1, b.compareTo(a));
        
    }
    /**
     * Test isFull();
     */
    public void testIsFull() {
        for (int i = 0; i < 8; i++) {
            planet.addPerson(new Person("Petrovich", 2, 3, 4, ""));
        }
        assertTrue(planet.isFull());
        assertFalse(planet.addPerson(new Person("Petrovich", 2, 3, 4, "")));
    }
    /**
     * Test all possibilities of equals method
     */
    public void testEquals() {
        assertTrue(planet.equals(planet));
        assertFalse(planet.equals(null));
        assertFalse(planet.equals(""));
        assertFalse(planet.equals(new Planet("Jo", 2, 3, 4, 8)));
        assertTrue(planet.equals(new Planet("Earth", 2, 3, 4, 8)));
        assertFalse(planet.equals(new Planet("Earth", 3, 3, 4, 8)));
        assertFalse(planet.equals(new Planet("Earth", 2, 5, 4, 8)));
        assertFalse(planet.equals(new Planet("Earth", 2, 3, 2, 8)));
        assertFalse(planet.equals(new Planet("Earth", 2, 3, 4, 7)));
        planet.addPerson(new Person("Lol", 3, 3, 4, ""));
        assertFalse(planet.equals(new Planet("Earth", 2, 3, 4, 8)));
        assertFalse(planet.equals(new Planet("Earth", 2, 3, 4, 7)));
        Planet planet2 = new Planet("Earth", 2, 3, 4, 8);
        planet2.addPerson(new Person("Lolik", 3, 3, 4, ""));
        assertFalse(planet.equals(planet2));
        
        
        
        
    }

}
