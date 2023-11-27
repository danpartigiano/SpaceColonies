// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at 
// all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- danila
package spacecolonies;

import java.util.Arrays;
import list.AList;
/**
 * Backend Colony Calculaor Test
 * @author danila
 * @version 10.11.2022
 */
public class ColonyCalculator {
    /**
     * Maximum value of planets in the interface
     */
    public static final int NUM_PLANETS = 3;
    /**
     * Min skill levels to be valid in the interface.
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * Min skill levels to be valid in the interface.
     */
    public static final int MAX_SKILL_LEVEL = 5;
    
    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private Planet[] planets;
    /**
     * Constructor
     * Initialize the field
     * @param ar Queue of immigrants
     * @param pls
     *          array of planets
     */
    public ColonyCalculator(ArrayQueue<Person> ar, Planet[] pls) {
        if (ar == null || pls == null) {
            throw new IllegalArgumentException();
        }
        applicantQueue = ar;
        planets = pls;
        rejectBus = new AList<Person>(); 
    }
    /**
     * Getter for queue
     * @return queue
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }
    /**
     * Getter for planets
     * @return planets
     */
    public Planet[] getPlanets() {
        return planets;
    } 
    /**
     * 
     * @param nextPerson
     *              immigrant
     * @return null, when ones with preference get rejected
     *         Preferred planet, or highest cap planet
     *              
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null) {
            return null;
        }
        
        String preference = nextPerson.getPlanetPreference();
        if (preference != null && preference.length() > 0) {
            Planet desired = null;
            
            if (getPlanetIndex(preference) != -1) {
                desired = planets[getPlanetIndex(preference)];
                if (canAccept(desired, nextPerson)) {
                    return desired;
                }
                else {
                    return null;
                }
                
            }
        }
        return getHighestCapacityPlanet(nextPerson); 
    }
    
    private boolean canAccept(Planet planet, Person person) {
        if (planet.isFull()) {
            return false;
        }
        
        return planet.isQualified(person);
    }
    
    private Planet getHighestCapacityPlanet(Person person) {
        Planet[] planetsSorted = planets.clone();
        Arrays.sort(planetsSorted);
        for (int i = 0; i < planetsSorted.length; i++) {
            if (canAccept(planets[i], person)) {
                return planets[i];
            }
        } 
        return null;
    }
    /**
     * Accept button logic for GUI
     * @return true
     *          can be accepted
     *         false
     *          can't be accepted
     */
    public boolean accept() {
        if (applicantQueue.isEmpty()) {
            return false;
        }
        Person p = applicantQueue.getFront();
        Planet rightPlanet = getPlanetForPerson(p);
        
        if (rightPlanet == null) {
            return false;
        }
        
        rightPlanet.addPerson(p);
        applicantQueue.dequeue();
        return true;
    }
    /**
     * Add the rejected to the 
     * rejectBus list
     */
    public void reject() {
        rejectBus.add(applicantQueue.dequeue()); 
    }
    /**
     * Get planet index of
     * a planet passed in the parameter
     * @param planet
     *          index of the planet
     *          to return
     * @return index of the planet
     *         
     */
    public int getPlanetIndex(String planet) {
        for (int i = 0; i < planets.length; i++) {
            if (planets[i].getName().equals(planet)) {
                return i;
            }
        }
        return -1;
    }

}
