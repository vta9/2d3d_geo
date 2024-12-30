
/**
 * This class represents a 3D line
 * This class extends the abstract class Linear
 *
 * @author Vincent Avelallemant
 */
public class Line extends Linear
{
    /**
     * A constructor for Line
     * @param point1 the first point of this line
     * @param point2 the 2nd point of this line
     */
    public Line(Point point1, Point point2)
    {
        super(point1, point2);
    }
    
    /**
     * A constructor for Line
     * @param point the point this line runs through
     * @vector the vector this line is parallel to 
     */
    public Line(Point point, Vector vector)
    {
        super(point,new Point(point.getX() + vector.getEnd().getX(), point.getY() + vector.getEnd().getY(), point.getZ() + vector.getEnd().getY()));
    }
    
    /**
     * A method that returns a String representation of this line
     * @return the paramentric equations of this line
     */
    @Override
    public String toString()
    {
        return "x = " + getPoint1().getX() + " + " + (getPoint2().getX() -getPoint1().getX()) + "t" + "     " + "y = " + getPoint1().getY() + " + " + (getPoint2().getY() - getPoint1().getY()) + "t" + "     "  + "z = " + getPoint1().getZ() + " + " + (getPoint2().getZ()- getPoint1().getZ()) + "t";
    }
    
    /**
     * A method that returns a vector parallel to this line
     * @return a new vector that is parallel to this line
     */
    public Vector getVector()
    {
        return new Vector(getPoint1().getX()+1, getPoint1().getY()+1, getPoint1().getZ()+1);
    }
    
}
