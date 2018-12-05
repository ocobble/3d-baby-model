import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;

/**
 * Project 5
 * 
 * Abstract class that aids in rendering two dimensional
 * images from three dimensional points
 * 
 * @author Huy Vu and Olivia Cobble
 * @version 11/26/17
 */
public abstract class KinematicPointAbstract
{
    /** Arraylist of children to be drawn out */
    private ArrayList<KinematicPointAbstract> children;
    /** Color of line to be drawn */
    private Color color;
    /** Stroke used for drawing line segments to its children */
    private BasicStroke stroke;
    /** Scale of pixels to meters */
    private static double scale;

    /**
     * KinematicPointAbstarct constructor
     * @param color the color of the line to be drawn from this point
     * @param width the width of the line to be drawn from this point
     */
    public KinematicPointAbstract(Color color, float width)
    {
        children = new ArrayList<KinematicPointAbstract>();
        this.color = color;
        stroke = new BasicStroke(width, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
    }

    /**
     * Add a KinematicPointAbstract as a child object
     * @param child the child of this point
     */
    public void addChild(KinematicPointAbstract child)
    {
        children.add(child);
    }

    /**
     * Draw the line from this point
     * @param g the graphics object used to draw this line
     * @param state the state associated with this line
     * @param screenXSubfield the subfield used for the x dimension in this panel
     * @param screenYSubfield the subfield used for the y dimension in this panel
     */
    public void draw(Graphics2D g, State state, String screenXSubfield, String screenYSubfield)
    {   
        GeneralValue x1 = this.getScreenCoordinate(state, screenXSubfield);
        GeneralValue y1 = this.getScreenCoordinate(state, screenYSubfield);

        for (KinematicPointAbstract child: children)
        {
            GeneralValue x2 = child.getScreenCoordinate(state, screenXSubfield);
            GeneralValue y2 = child.getScreenCoordinate(state, screenYSubfield);

            if (x1.isValid() && y1.isValid() && x2.isValid() && y2.isValid())
            {
                g.setStroke(stroke);
                g.setPaint(color);
                g.draw(new Line2D.Double(scale * x1.getDoubleValue(), scale * y1.getDoubleValue(),
                        scale * x2.getDoubleValue(), scale * y2.getDoubleValue()));
            }
            child.draw(g, state, screenXSubfield, screenYSubfield);
        }
    }

    /**
     * Set the pixels to meters scale
     * @param scale the ratio of meters to pixels
     */
    public static void setScale(double scale)
    {
        KinematicPointAbstract.scale = scale;
    }

    /**
     * Abstract method for getting the screen coordinates
     * @param state the state associated with this point
     * @param screenSubfield the subfield needed from this point
     */
    public abstract GeneralValue getScreenCoordinate(State state, String screenSubfield);
}
