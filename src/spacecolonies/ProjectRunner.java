package spacecolonies;

import java.io.FileNotFoundException;
import java.text.ParseException;
/**
 * Run the project
 * @author danila
 * @version 10.11.2022
 */
public class ProjectRunner {
    /**
     * 
     * @param args -- two text files
     * @throws SpaceColonyDataException invalid skill values
     * @throws ParseException wrong format
     * @throws FileNotFoundException -- No file was found with
     * given name
     */
    public static void main(String[] args) 
        throws SpaceColonyDataException, ParseException, FileNotFoundException {
        
        if (args.length == 2) {
            new ColonyReader(args[0], args[1]);
        }
        else {
            new ColonyReader("input.txt", "planets.txt");
        }

    } 

}
