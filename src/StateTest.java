import org.junit.Test;

import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * Testing class for State object
 * 
 * @author Huy Vu and Olivia Cobbler
 * @version 09/13/17
 */
public class StateTest
{
    private static String[] names;
    private static String values;
    private static FieldMapper fieldMap;
    private static Trial trial;
    private static State test;
    
    /**
     * Set up objects to test before all tests
     * @throws IOException in case of error in finding file
     */
    @BeforeClass
    public static void setUp() throws IOException
    {
        names = new String[] {"time", "left_wrist_x", "left_wrist_y"};
        values = "1.5,23.4,84.6";
        fieldMap = new FieldMapper(names);
        trial = new Trial(new Infant("mydata", "c1"), "data", "c1", 1);
        test = new State(trial, fieldMap, values);
    }
    /**
     * Test the constructor of the State object and its getters
     */
    @Test
    public void testState()
    {
        Assert.assertEquals("State getTrial", trial, test.getTrial());
        Assert.assertEquals("State getPoint valid", "x = 23.400; y = 84.600; ", 
                test.getPoint("left_wrist").toString());
        Assert.assertNull("State getPoint null", test.getPoint("NA"));
        Assert.assertEquals("State getValue", 23.400, 
                test.getValue("left_wrist", "x").getDoubleValue(), 0.0001);
        Assert.assertEquals("State getValue invalid field", "invalid", 
                test.getValue("right_wrist", "x").toString());
        Assert.assertEquals("State getValue invalid subfield", "invalid", 
                test.getValue("left_wrist", "z").toString());
    }
    
    /**
     * Test the toString method and see if it outputs the desired String
     */
    @Test
    public void testToString()
    {
        String testString = "left_wrist(x = 23.400; y = 84.600; )\n";
        testString += "time( = 1.500; )\n";
        
        Assert.assertEquals("State toString", testString, test.toString());
    }
    
    /**
     * Test the left wrist statistical methods
     */
    @Test
    public void testLeftWristStatistics()
    {
        Assert.assertEquals("State getMaxState", test, test.getMaxState("left_wrist", "x"));
        Assert.assertEquals("State getMinState", test, test.getMinState("left_wrist", "x"));
        Assert.assertEquals("State getAverageValue", 23.4, 
                test.getAverageValue("left_wrist", "x").getDoubleValue(), 0.0001);
    }
}
