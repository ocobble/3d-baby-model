import org.junit.Assert;

import org.junit.Test;
/**
 * Class to test the Field class
 * @author Olivia Cobble and Huy Vu
 * @version 10/19/17
 */
public class FieldTest
{
    /**
     * Test the getIndex method
     */
    @Test
    public void testGetIndex()
    {
        Field tester = new Field();
        tester.addSubField("a", 1);
        Integer index = new Integer(1);
        Assert.assertEquals("Testing getIndex: ", index, tester.getIndex("a"));
        Assert.assertNull("Testing null getIndex: ", tester.getIndex("b"));
    }
    
    /**
     * Test the size method
     */
    @Test
    public void testSize()
    {
        Field tester = new Field();
        Assert.assertEquals("Testing size of 0: ", 0, tester.size());
        
        tester.addSubField("a", 1);
        Assert.assertEquals("Testing size of 1", 1, tester.size());
    }
    
    /**
     * Test the toString method
     */
    @Test
    public void testToString()
    {
        Field tester = new Field();
        tester.addSubField("a", 1);
        tester.addSubField("b", 2);
        String sampleString = "a(1); b(2); ";
        Assert.assertEquals("Testing toString: ", sampleString, tester.toString());
    }
}
