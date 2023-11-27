// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at 
// all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- danila
package spacecolonies;

import java.util.Arrays;
/**
 * Planet class
 * @author danila
 * @version 10.11.2022
 */
public class Planet implements Comparable<Planet> {
    
    private String name;
    private Skillset minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;
    
    /**
     * Constructor for planet
     * @param planetName -- name of the planet
     * @param planetAgri -- min for agricultural
     * @param planetMedi -- min for medical
     * @param planetTech -- min for tech
     * @param planetCap  -- capacity
     */
    public Planet(String planetName, int planetAgri, 
        int planetMedi, int planetTech, int planetCap) {
        name = planetName;
        minSkills = new Skillset(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        population = new Person[capacity];
        populationSize = 0;
    }
    /**
     * Change the name of a planet
     * @param newName -- new Name
     */
    public void setName(String newName) {
        name = newName;
    }
    /**
     * Getter for name
     * @return name -- name of the planet
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for minSKills
     * @return minimal skillset allowed to enter
     */
    public Skillset getSkills() {
        return minSkills;
    }
    /**
     * Getter for population array
     * @return population
     */
    public Person[] getPopulation() {
        return population;
    }
    /**
     * Getter for population
     * @return size of the population
     */
    public int getPopulationSize() {
        return populationSize;
    }
    /**
     * Capacity getter
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }
    /**
     * Get availability
     * @return availability
     */
    public int getAvailability() {
        return capacity - populationSize;
    }
    /**
     * Check if the planet is full;
     * @return true if full, false if not
     */
    public boolean isFull() {
        return getAvailability() == 0;
    }
    /**
     * Populate the planet with a person
     * @param newbie
     *          Person to be populated
     * @return true
     *          populated successfully
     *         false
     *          couldn't populate
     */
    public boolean addPerson(Person newbie) {
        if (isFull()) {
            return false;
        }
        
        if (isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        
        return false;
        
    }
    /**
     * Check if the person is qualified
     * to populate the planet 
     * 
     * @param person
     *          Person to be checked
     * @return true
     *           if qualified
     *         false
     *           if not qualified
     */
    public boolean isQualified(Person person) {
        
        return minSkills.isLessThanOrEqualTo(person.getSkills());
    }
    /**
     * Convert the class to 
     * string representation 
     * with all fields represented
     * @return string representation
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name + ", " + "population " + populationSize
                + " (cap: " + capacity + "), Requires: A >= "
                + minSkills.getAgriculture() + ", M >= " +
                minSkills.getMedicine() + ", T >= " + 
                minSkills.getTechnology());
        return str.toString();
    }
    
    
    /**
     * CompareTo method. Compare based on the
     * capacity.
     * If equal compare by greater skills reqs.
     * If equal by skill reqs, compare by name
     * in alphabetical order
     * @return 1
     *          if this planet has capacity bigger than o
     *          or is bigger by other parameters in case of
     *          equality
     *         
     *         -1
     *          if this planet has lesser capacity than o
     *          or is lesser by other parameters in case of
     *          equality
     */
    @Override
    public int compareTo(Planet o) {
        
        
        if (this.capacity > o.getCapacity()) {
            return 1;
        }
        else if (this.capacity == o.getCapacity()) {
            if (this.getAvailability() > o.getAvailability()) {
                return 1;
            }
            else if (this.getAvailability() < o.getAvailability()) {
                return -1;
            }
            else {
                if (this.getSkills().compareTo(o.getSkills()) != 0) {
                    return this.getSkills().compareTo(o.getSkills());
                }
                else {
                    return this.name.compareTo(o.getName());
                    
                }
            }
            
        }
        else {
            return -1;
        }
        
    }
    /**
     * Check that planet is equal to other
     * object.
     * The planets are considered equal,
     * when a planet is compared to itself or
     * all of the fields are equal
     * @param o to be compared to
     * @return true
     *          if equal
     *          false
     *          if comparing to null or
     *          other class, as well as
     *          if there's unmatching field
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        
        if (this.getClass() != o.getClass()) {
            return false;
        }
        
        if (this == o) {
            return true;
        }
        
        Planet p = (Planet) o;
        
        return name.equals(p.getName()) && 
            minSkills.equals(p.getSkills()) &&
            populationSize == p.getPopulationSize() &&
            capacity == p.getCapacity() &&
            Arrays.equals(population, p.getPopulation());
            
    }
    
}
