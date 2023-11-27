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
 * Backend Colony Calculaor Test
 * @author danila
 * @version 10.11.2022
 */
public class ColonyCalculatorTest
    extends TestCase {
    
    private ColonyCalculator c;
    private Planet[] planets;
    private ArrayQueue<Person> arr;
    
    /**
     * Gets called before each test case
     */
    public void setUp() {
        arr = new ArrayQueue<Person>();
        planets = new Planet[3];
        arr.enqueue(new Person("Kim", 4, 4, 4, "Hueco Mundo"));
        arr.enqueue(new Person("Joe", 1, 1, 1, "Hueco Mundo"));
        arr.enqueue(new Person("Uryu", 2, 2, 2, "Wandenreich"));
        arr.enqueue(new Person("Ichigo", 5, 5, 5, "Seireitei"));
        arr.enqueue(new Person("Urahara", 4, 4, 5, "Hueco Mundo"));
        arr.enqueue(new Person("Urahara", 4, 4, 5, "Neverland"));
        arr.enqueue(new Person("Gru", 4, 4, 5, ""));
        arr.enqueue(new Person("Loser", 1, 1, 1, ""));
        planets[0] = new Planet("Seireitei", 1, 1, 1, 10);
        planets[1] = new Planet("Hueco Mundo", 3, 3, 3, 3);
        planets[2] = new Planet("Wandenreich", 4, 4, 4, 5);
        c = new ColonyCalculator(arr, planets);
        
    }
    /**
     * Test Simple Getters and the constructor,
     * and catch exceptions
     */
    public void testSimpleGettersAndConstrucotr() {
        assertEquals(arr, c.getQueue());
        assertEquals(planets, c.getPlanets());
        Exception e = null;
        Exception e2 = null;
        try {
            assertNull(new ColonyCalculator(null, planets));
        }
        catch (Exception exception) {
            e = exception;
        }
        assertEquals(-1, c.getPlanetIndex("rando"));
        
        try {
            assertNull(new ColonyCalculator(arr, null));
        }
        catch (Exception exception) {
            e2 = exception;
        }
        assertTrue(e instanceof IllegalArgumentException);
        assertTrue(e2 instanceof IllegalArgumentException);
    }
    /**
     * Test getPlanetForPerson()
     */
    public void testGetPlanetForPerson() {
        assertEquals(planets[2], 
            c.getPlanetForPerson(new 
                Person("Genryusai", 5, 5, 5, "Wandenreich")));
        assertEquals(null, 
            c.getPlanetForPerson(new Person("Rookie", 1, 1, 1, "Wandenreich")));
        assertNull(c.getPlanetForPerson(null));
        assertEquals(planets[0], 
            c.getPlanetForPerson(new Person("Rookie", 1, 1, 1, "")));
        planets[1].addPerson(new Person("Arrancar", 3, 3, 3, ""));
        planets[1].addPerson(new Person("Arrancar", 3, 3, 3, ""));
        planets[1].addPerson(new Person("Arrancar", 3, 3, 3, ""));
        assertNull(c.getPlanetForPerson(new 
            Person("Arrancar", 3, 3, 3, "Wandenreich")));
        assertEquals(planets[0], 
            c.getPlanetForPerson(new Person("Hetsugaya", 4, 4, 4, "")));
        for (int i = 0; i < 10; i++) {
            planets[0].addPerson(new Person("Arrancar", 3, 3, 3, ""));
        }
        assertEquals(planets[2], 
            c.getPlanetForPerson(new Person("Hetsugaya", 4, 4, 4, "")));
        assertEquals(null, 
            c.getPlanetForPerson(new Person("Rookie", 2, 2, 2, "weepa")));
        assertEquals(0, c.getPlanetIndex("Seireitei"));
        assertEquals(2, c.getPlanetIndex("Wandenreich"));
        assertEquals(1, c.getPlanetIndex("Hueco Mundo"));
    }
    /**
     * Test accept and reject methods
     */
    public void testAcceptAndReject() {
        assertTrue(c.accept());
        assertFalse(c.accept());
        c.reject();
        for (int i = 0; i < 5; i++) {
            c.accept();
        }
        assertFalse(c.accept());
        assertFalse(c.accept());
        assertFalse(c.accept());
        c.getQueue().clear();
        assertFalse(c.accept());
        
    }
   

}
