// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at 
// all times.
// I will not lie, cheat, or steal, nor will I 
// accept the actions of those who do.
// -- danila

package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;
/**
 * Colony Reader. Read the output from txt files;
 * @author danila
 * @version 10.11.2022
 */
public class ColonyReader {
    
    private Planet[] planets;
    private ArrayQueue<Person> queue;
    /**
     * Constructor
     * @param applicantFileName -- file
     * with the queue.
     * @param planetFileName -- 
     * file with planets
     * @throws SpaceColonyDataException -- 
     * Invalid skill values
     * @throws ParseException --
     * wrong file format
     * @throws FileNotFoundException -- 
     * file couldn't be found 
     */
    ColonyReader(String applicantFileName, String planetFileName) 
        throws SpaceColonyDataException, ParseException, FileNotFoundException {
        
        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);
        ColonyCalculator c = new ColonyCalculator(queue, planets);
        SpaceWindow window = new SpaceWindow(c);
    }
    
    private Planet[] readPlanetFile(String fileName) 
        throws SpaceColonyDataException, ParseException, FileNotFoundException {
        
        Planet[] planetsLoc = new Planet[ColonyCalculator.NUM_PLANETS];
        File f = new File(fileName);
        Scanner file = new Scanner(f);
        int dataCount = 0;
        while (file.hasNextLine()) { 
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            String[] tokens = new String[5];
            int tokenCount = 0;
            while (currLine.hasNext()) {
                tokens[tokenCount++] = currLine.next();
            }
            if (tokenCount == 5) {
                if (!isInSkillRange(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]),
                    Integer.valueOf(tokens[3]))) {
                    throw new SpaceColonyDataException("Invalid skill value(s)");
                }
                
                planetsLoc[dataCount] = new Planet(tokens[0], Integer.valueOf(tokens[1]), 
                    Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]), Integer.valueOf(tokens[4]));
                dataCount++;
                
                if (dataCount == 3) {
                    break;
                }
            currLine.close();
            }
            else {
                throw new java.text.ParseException("parse exception", 1);
            }
        } 
        
        
        if (dataCount < ColonyCalculator.NUM_PLANETS) {
            throw new SpaceColonyDataException("Not enough planets");
        }
        file.close();
        return planetsLoc;
    }
    
    private ArrayQueue<Person> readQueueFile(String fileName) 
        throws SpaceColonyDataException, ParseException, FileNotFoundException {
        
        ArrayQueue<Person> candidates = new ArrayQueue<Person>();
        File f = new File(fileName);
        Scanner file = new Scanner(f);
        while (file.hasNextLine()) {
            String read = file.nextLine();
            Scanner currLine = new Scanner(read).useDelimiter(",\\s*");
            String[] tokens = new String[5];
            int tokenCount = 0;
            while (currLine.hasNext()) {
                tokens[tokenCount++] = currLine.next();
            }
            if (tokens.length == 4 || tokens.length == 5) {
                if (!isInSkillRange(Integer.valueOf(tokens[1]), Integer.valueOf(tokens[2]),
                    Integer.valueOf(tokens[3]))) {
                    
                    throw new SpaceColonyDataException("Invalid skill value(s)");
                }
                if (tokens.length == 5) {
                candidates.enqueue(new Person(tokens[0], Integer.valueOf(tokens[1]), 
                    Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]), tokens[4]));
                }
                else if (tokens.length == 4) {
                    candidates.enqueue(new Person(tokens[0], Integer.valueOf(tokens[1]), 
                        Integer.valueOf(tokens[2]), Integer.valueOf(tokens[3]), ""));
                }
            currLine.close();
            }
            else {
                throw new java.text.ParseException("parse exception", 1);
            }
            
        }
        file.close();
        return candidates;
    }
    /**
     * Check if the skills are in the valid range
     * @param num1 -- skill 1
     * @param num2 -- skill 2
     * @param num3 -- skill 3
     * @return true -- skills are in valid range
     *         false -- skills are in invalid range
     */
    boolean isInSkillRange(int num1, int num2, int num3) {
        return (num1 <= ColonyCalculator.MAX_SKILL_LEVEL && 
            num1 >= ColonyCalculator.MIN_SKILL_LEVEL) && 
            (num2 <= ColonyCalculator.MAX_SKILL_LEVEL && 
                num2 >= ColonyCalculator.MIN_SKILL_LEVEL) && 
            (num3 <= ColonyCalculator.MAX_SKILL_LEVEL && 
                num3 >= ColonyCalculator.MIN_SKILL_LEVEL);
            
    }

}
