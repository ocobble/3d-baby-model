import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Representation of a single trial
 * 
 * @author Andrew H. Fagg, Huy Vu, and Olivia Cobble
 * @version 2017-09-03
 *
 */
public class Trial extends MultipleItemAbstract
{
    /** Sequence of states.   */
    private ArrayList<State> stateList;
    /** ID for the infant  */
    private Infant infant;
    /** Week index.  */
    private int week;
    /** File name that was loaded.  */
    private String fileName;
    /** Fieldmapper containg all of the field */
    private FieldMapper fieldMapper;
    
    /**
     * Trial constructor
     * @param infant the infant associated with the trial
     * @param directory String representing the directory containing the data files
     * @param infantID String representing the infant ID
     * @param week int week for the data file.
     * 
     * @throws IOException If there is an error finding or loading the data file.
     */
    public Trial(Infant infant, String directory, String infantID, int week) throws IOException
    {
        this.infant = infant;
        this.week = week;
        this.fileName = String.format("%s/subject_%s_w%02d.csv", 
                directory, infantID, week);
        
        this.stateList = new ArrayList<State>();
        
        // Open the file
        BufferedReader br = new BufferedReader(new FileReader(this.fileName));
        String strg;
        
        //Read in column names
        strg = br.readLine();
        fieldMapper = new FieldMapper(strg.split(","));
        //Read the first line of data
        strg = br.readLine();
        
        while (strg != null)
        {
            stateList.add(new State(this, fieldMapper, strg));
            
            strg = br.readLine();
        }

        br.close();
    }
    
    /**
     * Retrieves the information for the State object at the specified index
     * @param index int the index of the desired State in the ArrayList
     * @return the State object at the desired index
     */
    public State getItem(int index)
    {
        return stateList.get(index);
    }
    
    /**
     * Retrieves the number of State objects in the stateList ArrayList
     * @return int containing the size of the stateList ArrayList
     */
    public int getSize()
    {
        return stateList.size();
    }
    
    /**
     * Retrieves the ID of the infant being tested
     * @return String containing the ID of the infant being tested
     */
    public String getInfantID()
    {
        return infant.getInfantID();
    }
    
    /**
     * Retrieves the week of the current trial
     * @return int containing the week of the current trial
     */
    public int getWeek()
    {
        return week;
    }
    
    /**
     * Retrieves the name of the file that trial information is being taken from
     * @return String containing the name of the file containing the trial
     */
    public String getFileName()
    {
        return fileName;
    }
    
    /**
     * Returns the infant that this trial tests
     * @return the infant that this trial tests
     * 
     */
    public Infant getInfant()
    {
        return infant;
    }
    
    /**
     * Returns a string containing the week of the trial
     * @return a string containing the week of the trial
     */
    public String toString()
    {
        return String.format("Week %02d", this.getWeek());
    }
    
    /**
     * Returns the fieldMapper object with the fields
     * @return a fieldmapper object with the fields
     */
    public FieldMapper getFieldMapper()
    {
        return fieldMapper;
    }
}
