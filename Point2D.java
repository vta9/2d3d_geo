
/**
 * This class represents a 2D point
 * This class extends Point
 *
 * @author Vincent Avelallemant
 */
public class Point2D extends Point
{
    /**
     * A constructor for Point2D
     * @param x the x coordinate of this point
     * @param y the y coorindate of this point
     */
    public Point2D(double x, double y)
    {
        super(x,y,0);
    }
    
    /**
     * A method that returns the String represenation of this point
     * @return (x coordinate, y coordinate)
     */
    @Override
    public String toString()
    {
        return "("+ getX() + "," + getY() + ")";
    }
}
