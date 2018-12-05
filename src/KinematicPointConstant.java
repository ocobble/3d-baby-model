import java.awt.Color;
/**
 * A Kinematic point which does not depend on the state
 * @author Olivia Cobble and Huy Vu
 * @version 11/27/17
 *
 */
public class KinematicPointConstant extends KinematicPointAbstract
{
    /** Point on the screen, stays constant throughout trial **/
    private PointND point;
    
    /**
     * Constructor which creates the point
     * @param color the color of the line to be drawn
     * @param width the width of the line to be drawn
     * @param x the x coordinate of the point on the screen
     * @param y the y coordinate of the point on the screen
     * @param z the z coordinate of the point on the screen
     */
    public KinematicPointConstant(Color color, float width, double x, double y, double z)
    {
        super(color, width);
        point = new PointND();
        point.add("x", new GeneralValue(x));
        point.add("y", new GeneralValue(y));
        point.add("z", new GeneralValue(z));
    }
    
    /**
     * Returns the screen coordinate of the point
     * @return the screen coordinate of the point
     */
    public GeneralValue getScreenCoordinate(State state, String screenSubfield)
    {
        return point.getValue(screenSubfield);
    }
}
