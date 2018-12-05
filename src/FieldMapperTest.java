import org.junit.Assert;
import org.junit.Test;

/**
 * Testing class for FieldMapper object
 * 
 * @author Huy Vu
 * @version 10/21/17
 */
public class FieldMapperTest
{
    /**
     * Test the FieldMap constructor and all methods
     */
    @Test
    public void testFieldMapper()
    {
        String[] names = new String[] {"time", "left_wrist_x", "left_wrist_y"};
        String[] values = new String[] {"1.5", "23.4", "84.6"};
        FieldMapper fieldMap = new FieldMapper(names);
        
        Assert.assertEquals("FieldMapper getField time", "(0); ", 
                fieldMap.getField("time").toString());
        Assert.assertEquals("FieldMapper getField left wrist x and y", "x(1); y(2); ", 
                fieldMap.getField("left_wrist").toString());
        Assert.assertEquals("FieldMapper getSize", 2, fieldMap.size());
        Assert.assertEquals("FieldMapper extractPointND", "x = 23.400; y = 84.600; ", 
                fieldMap.extractPointND(values, "left_wrist").toString());
        Assert.assertNull("Bogus field name: ", fieldMap.extractPointND(names, "Olivia"));
    }
}
