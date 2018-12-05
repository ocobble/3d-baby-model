import java.awt.Color;
/**
 * Kinematic Point which is dependent on the state of the trial
 * @author Olivia Cobble and Huy Vu
 * @version 11/27/17
 */
public class KinematicPointState extends KinematicPointAbstract
{
    /** Name of the field which this point represents **/
    private String fieldName;
    
    /**
     * Creates a KinematicPointState
     * @param color The color of the line to be drawn
     * @param width The width of the line to be drawn
     * @param fieldName The field which this point represents
     */
    public KinematicPointState(Color color, float width, String fieldName)
    {
        super(color, width);
        this.fieldName = fieldName;
        
    }
    
    /**
     * Returns the screen coordinates of this point
     * @return the screen coordinates of this point
     */
    public GeneralValue getScreenCoordinate(State state, String screenSubfield)
    {
        if (state.getPoint(fieldName) == null)
        {
            System.out.println("Invalid field name, point is invalid");
            return new GeneralValue();
        }
        return state.getPoint(fieldName).getValue(screenSubfield);
    }
}
