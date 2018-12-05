/**
 * Abstract SingleItemAbstract class
 * Has abstract methods for getting max, minimum, 
 * and average Generalvalues in a trial
 * @author Huy Vu and Olivia Cobbler
 * @version 10/19/17
 */
public abstract class SingleItemAbstract
{
    /**
     * Find the max value for any subfield in a state
     * @param fieldName The field you want the max value from, ex. "left_wrist"
     * @param subFieldName the subfield you want the max value from ex. "left_wrist_x"
     * @return State containing the max value in selected subfield
     */
    public abstract State getMaxState(String fieldName, String subFieldName);
    
    /**
     * Find the min value for any subfield in a state
     * @param fieldName The field you want the min value from. ex. "left_wrist"
     * @param subFieldName the subfield you want the min value from. ex. "left_wrist_x"
     * @return State containing the min value in selected subfield
     */
    public abstract State getMinState(String fieldName, String subFieldName);
    
    /**
     * Find the average value for any subfield in a state
     * @param fieldName The field you want the max value from, ex. "left_wrist"
     * @param subFieldName the subfield you want the max value from ex. "left_wrist_x"
     * @return GeneralValue containing the average value in selected subfield
     */
    public abstract GeneralValue getAverageValue(String fieldName, String subFieldName);
}
