import java.util.Iterator;
import java.util.TreeMap;

/**
 * Representation of the state of a single time step
 * 
 * @author Andrew H. Fagg
 * @version 2017-09-03
 *
 */
public class State extends SingleItemAbstract implements Iterable<String>
{
    /** TreeMap containing String fields and its PointND value */
    private TreeMap<String, PointND> variable;
    
    /** Trial object associated with state */
    private Trial trial;
    
    /**
     * Default constructor initializes TreeMap
     */
    public State()
    {
        variable = new TreeMap<String, PointND>();
    }
    
    /**
     * A method that generates a state from a line from the csv file.
     * @param trial the trial object associated with the state
     * @param fieldMapper the map which organizes the fields in the trial
     * @param values the data from the csv file that is mapped to the field names
     */
    public State(Trial trial, FieldMapper fieldMapper, String values)
    {
        this();
        String fieldName;
        String[] data = values.split(",");
        PointND point = new PointND();
        this.trial = trial;
        Iterator<String> fieldIterator = fieldMapper.iterator();
        
        while (fieldIterator.hasNext())
        {
            fieldName = fieldIterator.next();
            point = fieldMapper.extractPointND(data, fieldName);
            
            variable.put(fieldName, point);
        }
    }
    
    /**
     * Retrieves the Trial associated with the State
     * @return Trial object
     */
    public Trial getTrial()
    {
        return trial;
    }
    
    /**
     * Retrieves the PointND associated with the specified field
     * @param fieldName Name of field for which the PointND is desired
     * @return PointND of the field, null if field is not part of state
     */
    public PointND getPoint(String fieldName)
    {
        if (variable.containsKey(fieldName))
        {
            return variable.get(fieldName);
        }
        else
        {
            return null;
        }
    }
    
    /**
     * Retrieves the GeneralValue associated with the field and subfield
     * @param fieldName Specified field of GeneralValue
     * @param subFieldName Specified subfield of GeneralValue
     * @return GeneralValue in specified field and subfield
     */
    public GeneralValue getValue(String fieldName, String subFieldName)
    {
        //GeneralValue value;
        if (variable.containsKey(fieldName))
        {
            if (variable.get(fieldName).getValue(subFieldName) == null)
            {
                return new GeneralValue(Double.NaN);
            }
            else
            {
                // Just use a general value constructor here
                return variable.get(fieldName).getValue(subFieldName);
            }
        }
        else
        {
            return new GeneralValue(Double.NaN);
        }
        
        // return value; fix
    }

    /**
     * Retrieve State that contains the specified max value
     * @param fieldName Specified field max value is desired from
     * @param subFieldName Specified subfield max value is desired from
     * @return State with the max value
     */
    public State getMaxState(String fieldName, String subFieldName)
    {
        return this;
    }
    
    /**
     * Retrieve State that contains the specified min value
     * @param fieldName Specified field min value is desired from
     * @param subFieldName Specified subfield min value is desired from
     * @return State with the min value
     */
    public State getMinState(String fieldName, String subFieldName)
    {
        return this;
    }
    
    /**
     * Returns the average value of the field
     * @param fieldName the name of the field
     * @param subFieldName the name of the subfield
     * @return the average value of the field
     */
    public GeneralValue getAverageValue(String fieldName, String subFieldName)
    {
        return variable.get(fieldName).getValue(subFieldName);
    }
    
    /**
     * Returns an iterator which iterates over the fields
     * @return iterator which iterates over the fields
     */
    public Iterator<String> iterator()
    {
        return variable.navigableKeySet().iterator();
    }
    
    /**
     * Returns the time and the positions of both the wrists in 
     * a single concise statement.
     * @return info a string containing all the information about
     * the baby in a single point in time.
     */
    public String toString()
    {
        String info = "";
        String fieldName;
        String pointString;
        Iterator<String> fieldIterator = this.iterator();
        
        while (fieldIterator.hasNext())
        {
            fieldName = fieldIterator.next();
            pointString = variable.get(fieldName).toString();
            info += fieldName + "(" + pointString + ")\n";
        }
        
        return info;
    }
}
