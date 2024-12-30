
/**
 * This class represents a 2D line
 * This class extends the abstract class Linear
 *
 * @author Vincent Avelallemant
 */
public class Line2D extends Linear
{
    /**
     * A constructor for Line2D
     * @param point1 the first point of the line
     * @param point2 the 2nd point of the line
     */
    public Line2D(Point2D point1, Point2D point2)
    {
        super((Point2D) point1, (Point2D) point2);
    }
   
    /**
     * A method that returns the String representation of this line
     * @returns the equation of the line in the form y = mx + b
     */
    @Override
    public String toString()
    {
        if(getPoint1().getX() == getPoint2().getX())
        {
            return "x = "  + getPoint1().getX();
        }
        else
        {
            //slope of the line
            double slope = ((getPoint2().getY()-getPoint1().getY())/(getPoint2().getX()-getPoint1().getX()));
            //y intercept of the line
            double yInt = getPoint1().getY() - (slope * getPoint1().getX());
            return "y = " + slope + "x + " + yInt;
        }
    }
    
}
