/**
 * Value class
 * 
 * Captures both a double value and whether or not it is valid
 * 
 * @author Olivia Cobble and Huy Vu
 * @version 2017-09-03
 *
 */
public class GeneralValue
{
    /** Is the value valid? */
    private boolean valid;
    /** Double value stored.  */
    private double doubleValue;

    
    /**
     * A constructor that creates an invalid sample.
     */
    public GeneralValue()
    {
        valid = false;
    }
    
    /**
     * A constructor which takes in the value from the data table.
     * If not a number (NaN), sets value to invalid.
     * @param info A string representation of the data value, or 
     * the string "NaN".
     */
    public GeneralValue(String info)
    {
        try
        {
            if (info.equalsIgnoreCase("NaN"))
            {
                throw new InvalidValueException("Not a number");
            }
            else
            {
                doubleValue = Double.parseDouble(info);
                valid = true;
            }
        }
        catch (NumberFormatException e)
        {
            valid = false;
        }
        catch (InvalidValueException e)
        {
            valid = false;
        }
    }
    
    
    /**
     * A constructor which takes in the value from the data table.
     * If not a number (NaN), sets value to invalid
     * @param doubleValue containing the data value
     */
    public GeneralValue(double doubleValue)
    {
        try
        {
            if (Double.isNaN(doubleValue))
            {
                throw new InvalidValueException("Not a number");
            }
            else
            {
                valid = true;
                this.doubleValue = doubleValue;
            }
        }
        catch (InvalidValueException e)
        {
            valid = false;
        }
    }
    
    /**
     * A method that returns the validity of the value.
     * @return valid a boolean that tells whether value is 
     * a valid number or not.
     */
    public boolean isValid()
    {
        return valid;
    }
    
    /**
     * A method that returns the numerical value of the data.
     * @return doubleValue the numerical value of the data
     */
    public double getDoubleValue()
    {
        if (this.isValid())
        {
            return doubleValue;
        }
        else
        {
            throw new InvalidValueException("Not a number");
        }
    }
    
    /**
     * Compares two GeneralValue objects and returns if the first one is lesser
     * Can return false if first number is invalid, true if second is
     * @param value GeneralValue object to be compared to
     * @return if the first GeneralValue is lesser
     */
    public boolean isLessThan(GeneralValue value)
    {
        if (this.isValid())
        {
            if (!value.isValid())
            {
                return true;
            }
            else
            {
                return (this.getDoubleValue() < value.getDoubleValue());
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * Compares two GeneralValue objects and returns if the first one is greater
     * Can return false if first number is invalid, true if second is
     * @param value GeneralValue object to be compared to
     * @return if the first GeneralValue is greater
     */
    public boolean isGreaterThan(GeneralValue value)
    {
        if (this.isValid())
        {
            if (!value.isValid())
            {
                return true;
            }
            else
            {
                return (this.getDoubleValue() > value.getDoubleValue());
            }
        }
        else
        {
            return false;
        }
    }
    
    /**
     * A method that returns a string representation of the
     * numerical value of the data, or "invalid" if the
     * value is not a number.
     * @return a string representation of the double value.
     */
    @Override
    public String toString()
    {
        if (this.isValid())
        {
            return String.format("%.3f", doubleValue);
            
        }
        else
        {
            return "invalid";
        }
    }
}
