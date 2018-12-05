import org.junit.Assert;
import org.junit.Test;
/**
 * Class to test the PointND class
 * @author Olivia Cobble
 * @version 10/18/17
 *
 */
public class PointNDTest
{
    
    /**
     * Test the add method
     */
    @Test
    public void testAdd()
    {
        PointND point1 = new PointND();
        point1.add("test_field", new GeneralValue(0));
        Assert.assertEquals("Testing add method: ", 1, point1.size());
    }
    
    /**
     * Test the getValue method
     */
    @Test
    public void testGetValue()
    {
        PointND samplePoint = new PointND();
        samplePoint.add("left_wrist_x", new GeneralValue(1));
        samplePoint.add("left_wrist_y", new GeneralValue(2));
        samplePoint.add("left_wrist_z", new GeneralValue(-1));
        Assert.assertEquals("Testing get value: ", 1.0, 
                samplePoint.getValue("left_wrist_x").getDoubleValue(), .0001);
    }
    
    /**
     * Test the size method
     */
    @Test
    public void testSize()
    {
        PointND samplePoint = new PointND();
        samplePoint.add("left_wrist_x", new GeneralValue(1));
        samplePoint.add("left_wrist_y", new GeneralValue(2));
        samplePoint.add("left_wrist_z", new GeneralValue(-1));
        Assert.assertEquals("Testing size: ", 3, 
                samplePoint.size());
    }
    
    /**
     * Test the toString method
     */
    @Test
    public void testToString()
    {
        PointND samplePoint = new PointND();
        samplePoint.add("a", new GeneralValue(1));
        samplePoint.add("b", new GeneralValue(2));
        samplePoint.add("c", new GeneralValue(-1));
        
        String info = "";
        info += "a = 1.000; ";
        info += "b = 2.000; ";
        info += "c = -1.000; ";
        
        Assert.assertEquals("Testing toString: ", info, 
                samplePoint.toString());
    }
}
