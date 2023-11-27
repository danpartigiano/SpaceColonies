// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at 
// all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- danila
package spacecolonies;
/**
 * Person Class
 * 
 * @author danila
 * @version 04.11.2022
 *
 */
public class Person {
    
    private String name;
    private Skillset skill;
    private String planetPreference;
    /**
     * Constructor for person class
     * @param name name of the Person
     * @param agri agricultural skill points
     * @param medi medical skill points
     * @param tech technology skill points
     * @param planet preferred planet
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        skill = new Skillset(agri, medi, tech);
        this.name = name;
        planetPreference = planet;
    }
    /**
     * Getter for name
     * @return name
     */
    public String getName() {
        return name;
    }
    /**
     * Getter for skill field
     * @return skil field
     */
    public Skillset getSkills() {
        return skill;
    }
    /**
     * Getter of planetPreference
     * 
     * @return planetReference
     */
    public String getPlanetPreference() {
        return planetPreference;
    }
    /**
     * Convert this class to string representation
     * @return String representation
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(name + " ");
        str.append(skill.toString());
        
        if (planetPreference != null && planetPreference.length() > 0) {
            str.append(" Wants: " + planetPreference);
        }
        else {
            str.insert(0, "No-Planet ");
        }
        return str.toString();
    }
    /**
     * Equals method
     * @param o -- object 
     * @return true when equal, false when not
     */
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        Person p = (Person) o;
        
        if (p == this) {
            return true;
        }
        
        return p.getName().equals(this.getName()) &&
            p.getSkills().equals(this.getSkills()) &&
            p.getPlanetPreference().equals(this.getPlanetPreference());
            
    }

}
