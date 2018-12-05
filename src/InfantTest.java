import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.IOException;
/**
 * Class to test the infant class
 * @author Olivia Cobble and Huy Vu
 * @version 10/3/17
 *
 */
public class InfantTest
{
    private static Infant baby;
    
    /**
     * Set up objects to test before all tests
     * @throws IOException in case of error in finding file
     */
    @BeforeClass
    public static void setUp() throws IOException
    {
        baby = new Infant("data", "c1");
    }
    /**
     * Tests the getItem method
     * @throws IOException in case of error in finding file
     */
    @Test
    public void testGetItem() throws IOException
    {
         
         // Test that they retrieve the same trial by the number of states
        Assert.assertEquals("Testing infant getItem: ", 1, baby.getItem(0).getWeek());
    }
     
     /**
      * Tests the getSize method
      * @throws IOException in case of error in finding file
      */
    @Test
    public void testGetSize() throws IOException
    {
         
        Assert.assertEquals("Testing infant getSize: ", 5, baby.getSize());
    }
     
     /** 
      * Tests the getInfantID method
      * @throws IOException in case of error in finding file
      */
    @Test
    public void testGetInfantID() throws IOException
    {
         
        Assert.assertEquals("Testing infant getID: ", "c1", baby.getInfantID());
    }
     
     /**
      * Test getMaxState method
      * @throws IOException in case of error in finding file
      */
    @Test
    public void testGetMaxState() throws IOException
    {

        Assert.assertEquals("Testing infant getMaxState for x left wrist: ", 0.423,
                 baby.getMaxState("left_wrist", "x").getValue("left_wrist", "x").getDoubleValue(), 0.001);
    }
     
     /**
      * Test getMinState method
      * @throws IOException in case of error in finding file
      */
    @Test
    public void testGetMinState() throws IOException
    {

        Assert.assertEquals("Testing infant getMinState for x left wrist: ", 0.008,
                 baby.getMinState("left_wrist", "x").getValue("left_wrist", "x").getDoubleValue(), 0.001);
    }
     
     /**
      * Test getAverageLeftWrist method
      * @throws IOException in case of error in finding file
      */
    @Test
    public void testGetAverageValue() throws IOException
    {
         
        Assert.assertEquals("Testing infant getAverageLeftWrist", 0.185,
                 baby.getAverageValue("left_wrist", "x").getDoubleValue(), 0.001);
    }
    
    /** Test the new constructor
     * 
     */
    @Test
    public void testTheNewConstructor() throws IOException
    {
        int[] indices = {0, -1, 500000};
        baby = new Infant(baby, indices);
        Assert.assertEquals("Testing baby2 getSize: ", 1, baby.getSize());
    }
}
