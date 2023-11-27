package spacecolonies;

/**
 * Skillset class
 * @author danila
 * @version 04.11.2022
 *
 */
public class Skillset implements Comparable<Skillset> {
    
    private int agriculture;
    private int medicine;
    private int technology;
    /**
     * Constructor for the skillset
     * @param ag agriculture field
     * @param med medicine field
     * @param tech technology field
     */
    public Skillset(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }
    /**
     * Getter for agriculture
     * @return agriculture field
     */
    public int getAgriculture() {
        return agriculture;
    }
    /**
     * Getter for medicine
     * @return medicine field
     */
    public int getMedicine() {
        return medicine;
    }
    /**
     * Getter for technology
     * @return technology field
     */
    public int getTechnology() {
        return technology;
    }
    
    /**
     * Compare "this" Skillset object to a given 
     * Skillset object "other". 
     * 
     * @param other
     *          Skillset to compare with.
     * @return True 
     *              only if "this.agriculture" 
     * is less or equal to 
     * "other.agriculture" AND "this.medicine" is 
     * less or equal to "other.medicine" AND 
     * "this.technology" is less or equal to 
     * "other.technology". Otherwise false.
     * 
     * 
     */
    public boolean isLessThanOrEqualTo(Skillset other) {
        return (this.getAgriculture() <= other.getAgriculture() &&
                this.getMedicine() <= other.getMedicine() &&
                this.getTechnology() <= other.getTechnology()); 
    }
    /**
     * Equals method
     * 
     * 
     * @param o 
     *          object of comparison
     * @return True
     *          When all three fields are the same
     *         False
     *          When comparing to different class,
     *          null, or one or more fields arent's same.
     *          
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }
        
        
        Skillset other = (Skillset) o;
        
        if (other == this) {
            return true;
        }
        
        return (this.getAgriculture() == other.getAgriculture() &&
                this.getMedicine() == other.getMedicine() &&
                this.getTechnology() == other.getTechnology());
    }
    /**
     * Compare to another skillset object
     * @return 1 when this object is bigger, 0 when equal
     *         -1 when less.
     */
    @Override
    public int compareTo(Skillset o) {
        int sumOther = o.getAgriculture() + o.getMedicine() + o.getTechnology();
        int sumThis = this.getAgriculture() + this.getMedicine() + 
            this.getTechnology();
        
        if (sumThis > sumOther) {
            return 1;
        }
        else if (sumThis == sumOther) {
            return 0;
        }
        else {
            return -1;
        }
        
    }
    /**
     * Convert the class to string
     * representation
     * @return string representation
     *          of values of the skills.
     */
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("A:" + agriculture + " M:" + medicine
            + " T:" + technology);
        return str.toString();
    }

}
