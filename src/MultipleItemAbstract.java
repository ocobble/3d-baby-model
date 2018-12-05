/**
 * Abstract class for classes with multiple object instance variables
 * @author Olivia Cobble and Huy Vu
 * @version 10/8/17
 *
 */
public abstract class MultipleItemAbstract extends SingleItemAbstract
{
    /** 
     * Abstract method to return size of object
     * @return the size of the item
     **/
    public abstract int getSize();
    
    /** Abstract method to return item reference
     * @param index the index of the item to return
     * @return the item reference
     **/
    public abstract SingleItemAbstract getItem(int index);
    
    /**
     * Return the maximum value of a specific field/subfield
     * 
     * @param fieldName The String name of the field of interest
     * @param subFieldName The String name of the subfield
     * 
     * @return The state that contains the maximum value
     */
    public State getMaxState(String fieldName, String subFieldName)
    {
        // Best value found so far
        GeneralValue maxValue = new GeneralValue();
        
        State maxState = new State();

        // Loop over all States
        for (int i = 0; i < this.getSize(); ++i) 
        {
            // Extract the value of the specific dimension and time
            State s = this.getItem(i).getMaxState(fieldName, subFieldName);
            GeneralValue v = s.getValue(fieldName, subFieldName);

            // Is this one larger?
            if (v.isGreaterThan(maxValue))            
            {
                // Yes - replace it
                maxValue = v;
                maxState = s;
            }
        }

        // 
        return maxState;
    }
    
    /**
     * Return the minimum value of a specific field/subfield
     * 
     * @param fieldName The String name of the field of interest
     * @param subFieldName The String name of the subfield
     * 
     * @return The state that contains the minimum value
     */
    public State getMinState(String fieldName, String subFieldName)
    {
        // Best value found so far
        GeneralValue minValue = new GeneralValue();
        
        State minState = new State();

        // Loop over all States
        for (int i = 0; i < this.getSize(); ++i) 
        {
            // Extract the value of the specific dimension and time
            State s = this.getItem(i).getMinState(fieldName, subFieldName);
            GeneralValue v = s.getValue(fieldName, subFieldName);

            // Is this one larger?
            if (v.isLessThan(minValue))            
            {
                // Yes - replace it
                minValue = v;
                minState = s;
            }
        }

        // 
        return minState;
    }
    
    /**
     * Method to return the average value of a field in a trial
     * @param fieldName the name of the field you want the average of
     * @param subFieldName the subField name, such as "x", "y", or "z"
     * @return the average value of a field
     */
    public GeneralValue getAverageValue(String fieldName, String subFieldName)
    {
        double sum = 0;
        double count = 0;
        
        for (int i = 0; i < this.getSize(); ++i)
        {
            if (this.getItem(i).getAverageValue(fieldName, subFieldName).isValid())
            {
                sum += this.getItem(i).getAverageValue(fieldName, subFieldName).getDoubleValue();
                count += 1;
            }
        }
        
        return new GeneralValue(sum / count);
    }
}
