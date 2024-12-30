
/**
 * This class represents a linear object, either a 2D or 3D line
 *
 * @author Vincent Avelallemant
 */
public abstract class Linear
{
    //stores the first point that defines this line
    private Point point1;
    //stores the 2nd point that defines this line
    private Point point2;
    
    /**
     * A constructor for Linear
     * @param point1 the first point that defines this line
     * @param point2 the 2nd point that defines this line
     */
    public Linear(Point point1, Point point2)
    {
        this.point1 = point1;
        this.point2 = point2;
    }
    
    /**
     * A method that returns the first point
     * @return the first point of this line
     */
    public Point getPoint1()
    {
        return point1;
    }
    
    /**
     * A method that returns the 2nd point
     * @return the 2nd point of this line
     */
    public Point getPoint2()
    {
        return point2;
    }
    
    /**
     * A method that returns a String representation of this line
     * This method is implemented differenlty in the classes that extend Linear, so the method is left abstract
     */
    public abstract String toString();
    
    /**
     * A method that returns true if two lines are equal
     * @param o the Linear object compared to this Linear
     * @return if o has the same points as this
     */
    @Override
    public boolean equals(Object o)
    {
        //stores o as type Linear
        Linear input = (Linear) o;
        if(input.getPoint1().equals(getPoint1()) || input.getPoint1().equals(getPoint2()))
        {
            if(input.getPoint2().equals(getPoint2()) || input.getPoint2().equals(getPoint1()))
            {
                return true;
            }
        }
        return false;
    }
    
    /**
     * A method that returns true if 2 lines are parallel to each other
     * @param line1 line 1
     * @param line2 line 2
     * @return if the lines are parallel
     */
    public static boolean isParallel(Linear line1, Linear line2)
    {
        //stores the x direction ratio of line1
        double line1XDirectionRatio = line1.getPoint1().getX() - line1.getPoint2().getX();
        //stores the y direction ratio of line1
        double line1YDirectionRatio = line1.getPoint1().getY() - line1.getPoint2().getY();
        //stores the z direction ratio of line1
        double line1ZDirectionRatio = line1.getPoint1().getZ() - line1.getPoint2().getZ();
        if(!line1.equals(line2))
        {
            //if the x direction ratio of line1/(x coordiante 1 - x coordiante 2 of line1) is equal to y direction ratio of line1/(y1 coordinate - y2 coordiante of line2) 
            if((line1XDirectionRatio/(line2.getPoint1().getX() - line2.getPoint2().getX())) == (line1YDirectionRatio/(line2.getPoint1().getY() - line2.getPoint2().getY())))
            {
                //meant to avoid a divide by 0 error
                if(line1ZDirectionRatio != 0 && (line2.getPoint1().getZ() - line2.getPoint2().getZ()) != 0)
                {
                    //checking the same condition as the first for z and y (opposed to x and y)
                    if((line1ZDirectionRatio/(line2.getPoint1().getZ() - line2.getPoint2().getZ())) == (line1YDirectionRatio/(line2.getPoint1().getY() - line2.getPoint2().getY())))
                    {   
                        return true;
                    }
                }
                else 
                {
                    //if z direction ratio or difference of the points is 0, it is a 2D line, so only x and y need to be considered
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * A method that returns the point at which two lines intersect
     * @param line1 line 1
     * @param line2 line 2 
     * @return a Point (if at least one line is type Line) or Point2D (if both lines are type Line2D0 that the points intersect, or null if they do not intersect
     */
    public static Point intersection(Linear line1, Linear line2)
    {
        //if both are Line2D
        if(line1 instanceof Line2D && line2 instanceof Line2D)
        {
            //stores the slope of line1
            double slope1 = ((line1.getPoint2().getY()-line1.getPoint1().getY())/(line1.getPoint2().getX()-line1.getPoint1().getX()));
            //stores the y intercept of line1
            double yInt1 = line1.getPoint1().getY() - (slope1 * line1.getPoint1().getX());
            //stores the slope of line2
            double slope2 = ((line2.getPoint2().getY()-line2.getPoint1().getY())/(line2.getPoint2().getX()-line2.getPoint1().getX()));
            //stores the y intercept of line2
            double yInt2 = line2.getPoint1().getY() - (slope2 * line2.getPoint1().getX());
            //stores the x coordinate that the lines intersect
            double x = (yInt2 - yInt1)/(slope1 - slope2);
            //stores the y coorindate that the lines intersect
            double y = (slope1*x) + yInt1;
            //checking if x is in range if the 1st point is less than 2nd
            if(x >= line1.getPoint1().getX() && x<= line1.getPoint2().getX() && x >= line2.getPoint1().getX() && x<= line2.getPoint2().getX())
            {
                return new Point2D(x,y);
            }
            //checking if x is in range if the 2nd point is less than 1st
            else if(x <= line1.getPoint1().getX() && x>= line1.getPoint2().getX() && x <= line2.getPoint1().getX() && x>= line2.getPoint2().getX())
            {
                return new Point2D(x,y);
            }
        }
        else
        {
            if(line1 instanceof Line || line2 instanceof Line)
            {
                //set the x components of equation equal and solve for t
                //stores t of the equation: x = x1 - (x2-x1)t5
                double t = ((line1.getPoint1().getX() - line2.getPoint1().getX())/((line2.getPoint2().getX() - line2.getPoint1().getX())-(line1.getPoint1().getX() - line1.getPoint2().getX())));
                //stores x as a function of t
                double x = line1.getPoint1().getX() + ((line1.getPoint2().getX() - line1.getPoint1().getX())*t);
                //stores y as a function of t
                double y = line1.getPoint1().getY() + ((line1.getPoint2().getY() - line1.getPoint1().getY())*t);
                //stores z as a function of t
                double z = line1.getPoint1().getZ() + ((line1.getPoint2().getZ() - line1.getPoint1().getZ())*t);
                //checking if x is in range if the 1st point is less than 2nd
                if(x >= line1.getPoint1().getX() && x<= line1.getPoint2().getX() && x >= line2.getPoint1().getX() && x<= line2.getPoint2().getX())
                {
                    return new Point(x,y,z);
                }
                //checking if x is in range if the 2nd point less than 1st
                else if(x <= line1.getPoint1().getX() && x>= line1.getPoint2().getX() && x <= line2.getPoint1().getX() && x>= line2.getPoint2().getX())
                {
                    return new Point(x,y,z);
                }
            }
        }
        return null;
    }
}
