
/**
 * This class represents a 3D point
 * This class is inherited by Point2D
 *
 * @author Vincent Avelallemant
 */
public class Point
{
    //stores x cordinate of the point
    private double x;
    //stores y cordinate of the point
    private double y;
    //stores z cordinate of the point
    private double z;
    
    /**
     * A constructor for Point
     * @param x the x coordinate of this point
     * @param y the y coordinate of this point
     * @param z the z coordinate of this point
     */
    public Point(double x, double y, double z)
    {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    /**
     * A method that returns the x cooridnate of this point
     * @return x cordinate of this point
     */
    public double getX() 
    {
        return this.x;
    }
    
    /**
     * A method that returns the y coordinate of this point
     * @return y coordiante of this point
     */
    public double getY() 
    {
        return this.y;
    }
    
    /**
     * A method that returns the z coordinate of this point
     * @return z coordiante of this point
     */
    public double getZ() 
    {
        return this.z;
    }
    
    /**
     * A method that returns a String represenation of this point
     * @return (x coordinate, y coordinate, z coordinate)
     */
    @Override
    public String toString()
    {
        return "(" + getX() + "," + getY() + "," + getZ() + ")";
    }
    
    /**
     * A method that returns true if 2 points are equal
     * @param o the point to compare to this point
     * @return if the x, y, and z coordinates of both points are equal
     */
    @Override
    public boolean equals(Object o)
    {
        //stores o as type Point
        Point input = (Point) o;
        return input.getX() == getX() && input.getY() == getY() && input.getZ() == getZ();
    }
    
    /**
     * A method that returns the distance between two points
     * @param p1 point 1
     * @param p2 point 2
     * @return the distance between these two points 
     */
    public static double distance(Point p1, Point p2)
    {
        return Math.sqrt((Math.pow(p2.getX() - p1.getX(),2))+ (Math.pow(p2.getY()-p1.getY(),2))+ (Math.pow(p2.getZ()-p1.getZ(),2)));
    }
}
