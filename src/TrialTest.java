import java.io.IOException;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * A class to test the trial class
 * @author Olivia Cobble and Huy Vu
 * @version 9/14/17
 *
 */
public class TrialTest 
{
    private static Trial test;
    /**
     * Set up objects to test before all tests
     * @throws IOException in case of error in finding file
     */
    @BeforeClass
    public static void setUp() throws IOException
    {
        test = new Trial(new Infant("data", "c1"), "data", "c1", 1);
    }
    /**
     * A test to ensure that the getItem method properly returns the correct state.
     * This is tested by checking that the time matches the correct state.
     * @throws IOException If there is an error finding or loading the data file.
     */
    @Test
    public void testGetItem() throws IOException
    {
        
        // Test to make sure correct state is returned
        Assert.assertEquals("Trial getItem", "0.000", 
                test.getItem(0).getValue("time", "").toString());
    }
    
    /**
     * A test to ensure that the getSize method properly returns the correct size
     * of the state array.
     * @throws IOException If there is an error finding or loading the data file.
     */
    @Test
    public void testGetSize() throws IOException
    {
        
        // Testing to make sure size is 4, since data contains 4 states.
        Assert.assertEquals(15000, test.getSize());
    }
    
    /**
     * A test to ensure that the getInfantID method properly returns the correct
     * infant ID.
     * @throws IOException If there is an error finding or loading the data file.
     */
    @Test
    public void testGetInfantID() throws IOException
    {
        
        // Testing to make sure "C1" is returned.
        Assert.assertEquals("c1", test.getInfantID());
    }
    
    /**
     * A test to ensure that the getWeek method properly returns the
     * week number.
     * @throws IOException If there is an error finding or loading the data file.
     */
    @Test
    public void testGetWeek() throws IOException
    {
        
        // Testing to make sure 1 is returned.
        Assert.assertEquals(1, test.getWeek());
    }
    
    /**
     * A test to ensure that the getSize method properly returns the
     * name of the file.
     * @throws IOException If there is an error finding or loading the data file.
     */
    @Test
    public void testGetFileName() throws IOException
    {
        String testFileName = "data/subject_c1_w01.csv";
        // Testing to make sure correct file name is returned.
        Assert.assertEquals(testFileName, test.getFileName());
    }
    
    /**
     * Test that the state with the max value is returned
     * @throws IOException If there is an error finding or loading the data file.
     */
    @Test
    public void testGetMaxState() throws IOException
    {
        String strg = "left_wrist(x = 0.424; y = 0.164; z = -0.063; )\n";
        strg += "right_wrist(x = 0.239; y = -0.192; z = -0.069; )\n";
        strg += "time( = 97.100; )\n";
        
        Assert.assertEquals("Trial getMaxState", strg, 
                test.getMaxState("left_wrist", "x").toString());
    }
    
    /**
     * Test that the state with the min value is returned
     * @throws IOException If there is an error finding or loading the data file.
     */
    @Test
    public void testGetMinState() throws IOException
    {
        String strg = "left_wrist(x = 0.217; y = 0.261; z = -0.162; )\n";
        strg += "right_wrist(x = 0.142; y = -0.303; z = 0.055; )\n";
        strg += "time( = 43.760; )\n";
        
        Assert.assertEquals("Trial getMinState", strg, 
                test.getMinState("right_wrist", "y").toString());
    }
    
    /**
     * Test that the average value over all states is returned
     * @throws IOException If there is an error finding or loading the data file.
     */
    @Test
    public void testGetAverageValue() throws IOException
    {
        
        Assert.assertEquals("Trial getAverageValue", 0.22656, 
                test.getAverageValue("right_wrist", "x").getDoubleValue(), 0.0001);
    }
    
    /**
     * Test the getInfant method
     */
    @Test
    public void testGetInfant() throws IOException
    {
        Assert.assertEquals("Trial getInfant: ", "c1", test.getInfant().getInfantID());
    }
    
    /**
     * Test the toString method
     */
    @Test
    public void testToString() throws IOException
    {
        Assert.assertEquals("Trial toString: ", "Week 01", test.toString());
    }

}
