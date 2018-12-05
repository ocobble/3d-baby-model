import org.junit.Test;
import org.junit.Assert;

/**
 * Testing class for GeneralValue object
 * 
 * @author Huy Vu and Olivia Cobble
 * @version 09/11/17
 */
public class GeneralValueTest
{

    /**
     * Test the creation of a GeneralValue object with no parameters
     */
    @Test
    public void testGeneralValue()
    {
        GeneralValue testValue = new GeneralValue();
        
        //Check if the default constructor returns an invalid number
        Assert.assertFalse("Default GeneralValue constructor", testValue.isValid());
    }
    
    /**
     * Test the creation of a GeneralValue object with a double parameter
     */
    @Test
    public void testGeneralValueDouble()
    {
        GeneralValue test = new GeneralValue(2.0);
        
        //Check if constructor creates a valid value
        Assert.assertTrue("GeneralValue constructor with double: ", test.isValid());
        
        // Test is a value that is NaN is put in, then it will be invalid.
        test = new GeneralValue("foo");
        Assert.assertFalse("GeneralValue constructor with NaN: ", test.isValid());
        
        //Test if a value passed as a double NaN will be invalid
        test = new GeneralValue(Double.NaN);
        Assert.assertFalse("GeneralValue constructor with double NaN: ", test.isValid());
    }
    
    /**
     * Test getDoubleValue() method
     */
    @Test
    public void testGetDoubleValue()
    {
        GeneralValue test = new GeneralValue("2.0");
        
        Assert.assertEquals("Testing double value getter: ", 2.0, test.getDoubleValue(), 0.0001);
        
        test = new GeneralValue("Foo");
        try
        {
            test.getDoubleValue();
        }
        catch (InvalidValueException e)
        {
            //Do nothing, since this is the expected outcome.
        }
        catch (Exception e)
        {
            Assert.fail("Wrong exception thrown for invalid getDoubleValue");
        }
        
    }
    
    /**
     * Test various inputs for the isLessThan method
     */
    @Test
    public void testIsLessThan()
    {
        GeneralValue test = new GeneralValue(5.0);
        GeneralValue bar = new GeneralValue("bar");
        
        Assert.assertFalse("Testing isLessThan when this is less than: ", test.isLessThan(new GeneralValue(3.0)));
        Assert.assertFalse("Testing isLessThan when this is equal to: ", test.isLessThan(new GeneralValue(5.0)));
        Assert.assertTrue("Testing isLessThan when this is greater than: ", test.isLessThan(new GeneralValue(7.0)));
        Assert.assertTrue("Testing isLessThan when this is compared to NaN: ", test.isLessThan(bar));
        Assert.assertFalse("Testing isLessThan when this is invalid: ", bar.isLessThan(new GeneralValue(3.0)));
        Assert.assertFalse("Testing isLessThan when both values are invalid: ", bar.isLessThan(bar));
    }
    
    /**
     * Test various inputs for the isGreaterThan method
     */
    @Test
    public void testIsGreaterThan()
    {
        GeneralValue test = new GeneralValue(5.0);
        GeneralValue bar = new GeneralValue("bar");
        
        Assert.assertTrue("Testing isGreaterThan when this is less than: ", test.isGreaterThan(new GeneralValue(3.0)));
        Assert.assertFalse("Testing isGreaterThan when this is equal to: ", test.isGreaterThan(new GeneralValue(5.0)));
        Assert.assertFalse("Testing isGreaterThan when it this is greater than: ",
                test.isGreaterThan(new GeneralValue(7.0)));
        Assert.assertTrue("Testing isGreaterThan when this is compared to NaN: ", test.isGreaterThan(bar));
        Assert.assertFalse("Testing isGreaterThan when this is invalid: ", bar.isGreaterThan(new GeneralValue(3.0)));
        Assert.assertFalse("Testing isGreaterThan when both values are invalid: ", bar.isGreaterThan(bar));
    }

    /**
     * Test the construction of a GeneralValue object when a valid or invalid number is a parameter
     */
    @Test
    public void testGeneralValueString()
    {
        GeneralValue validNumber = new GeneralValue("12.3456");
        GeneralValue invalidNumber = new GeneralValue("NaN");
        
        //Check that the invalid number is invalid 
        //Check that the valid number is valid and holds the right value
        Assert.assertFalse("GeneralValue with invalid number", invalidNumber.isValid());
        Assert.assertTrue("GeneralValue with valid number", validNumber.isValid());
        Assert.assertEquals("Getter: doubleValue", 12.3456, validNumber.getDoubleValue(), 0.00001);
    }

    /**
     * Test that the String representation of the object is correct
     */
    @Test
    public void testToString()
    {
        GeneralValue validNumber = new GeneralValue("12.3454");
        GeneralValue invalidNumber = new GeneralValue("NaN");
        
        //Check that the valid number returns the double value with 3 decimal places
        Assert.assertEquals("GeneralValue Valid toString", "12.345", validNumber.toString());
        
        //Check that the invalid number returns "invalid"
        Assert.assertEquals("GeneralValue Invalid toString", "invalid", invalidNumber.toString());
    }

}
