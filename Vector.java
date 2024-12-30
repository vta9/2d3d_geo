
/**
 * This class represents a Vector, a directed line segement from (0,0,0) to a point
 *
 * @author Vincent Avelallemant
 */
public class Vector
{
    //stores the end point of the vector
    private Point end;
    
    //stores the origin of the vector; defaults to (0,0,0) for eveything besides the 2nd constructor for Plane
    private Point origin;
    
    /**
     * A constructor for Vector
     * @param x the x coordinate of the end point
     * @param y the y coordinate of the end point
     * @param z the z coordinate of the end point
     */
    public Vector(double x, double y, double z)
    {
        end = new Point(x,y,z);
        origin = new Point(0,0,0);
    }
    
    /**
     * A constructor for Vector
     * @param point the end point of this vector
     */
    public Vector(Point point)
    {
        end = point;
        origin = new Point(0,0,0);
    }
    
    /**
     * A constuctor for vector
     * @param vector the input vector that has the same direction as this vector
     * @param length the length of this vector
     */
    public Vector(Vector vector, double length)
    {
        //stores the rate that the vector should be changed by
        double scale = length/vector.magnitude();
        end = new Point(vector.getEnd().getX() * scale, vector.getEnd().getY() * scale, vector.getEnd().getZ() * scale); 
        origin = new Point(0,0,0);
    }
    
    /**
     * A constructor for Vector
     * This constructor is only meant to be used by the 2nd construcor in Plane, as it requires 2 vectors that do not start at (0,0,0)
     * @param origin the origin of this vector
     * @param end the end point of the vector
     */
    public Vector(Point origin, Point end)
    {
        this.origin = origin;
        this.end = end;
    }
    
    /**
     * A method that returns the end point of this vector
     * @return end
     */
    public Point getEnd()
    {
        return end;
    }
    
    /**
     * A method that returns the origin point of this vector
     * @return origin
     */
    public Point getOrigin()
    {
        return origin;
    }
    
    /**
     * A method that returns a String representation of this vector
     * @return the x coordinate, y coordinate, and z coordinate inside angle brackets
     */
    @Override
    public String toString()
    {
        return "<" + getEnd().getX() + "," + getEnd().getY() + "," + getEnd().getZ() + ">";
    }
    
    /**
     * A method that returns true if the input vector is equal to this vector
     * @param o the input vector
     * @return if the end points are equal
     */
    @Override
    public boolean equals(Object o)
    {
        //stores o as type Vector
        Vector input = (Vector) o;
        if(input.getEnd().getX() == getEnd().getX() && input.getEnd().getY() == getEnd().getY() && input.getEnd().getZ() == getEnd().getZ())
        {
            return true;
        }
        return false;
    }
    
    /**
     * A method that returns the magnitude/length of this vector
     * @return the length of this vector
     */
    public double magnitude()
    {
        return Math.sqrt(Math.pow(getEnd().getX(),2) + Math.pow(getEnd().getY(),2) + Math.pow(getEnd().getZ(),2));
    }
    
    /**
     * A method that returns a new Vector with the same direction as this and length of 1
     * @return a new vector with the same direction and length of 1
     */
    public Vector unitVector()
    {
        return new Vector(this, 1.0);
    }
    
    /**
     * A method that adds the coordinates of two vectors
     * @param vector1 vector 1
     * @param vector2 vector 2
     * @return a new vector that is the sum of the 2 inputs
     */
    public static Vector sum(Vector vector1, Vector vector2)
    {
        return new Vector(vector1.getEnd().getX() + vector2.getEnd().getX(), vector1.getEnd().getY() + vector2.getEnd().getY(), vector1.getEnd().getZ() + vector2.getEnd().getZ());
    }
    
    /**
     * A method that returns a new vector that is the result of multiplying a vector by scale
     * @param vector input vecor
     * @param scale the number the vector is multiplied by
     * @return a new vector that is the result of multiplying a vector by scale
     */
    public static Vector scale(Vector vector, double scale)
    {
        return new Vector(vector.getEnd().getX() * scale, vector.getEnd().getY() * scale, vector.getEnd().getZ() * scale);
    }
    
    /**
     * A method that returns the dot product of 2 vectors
     * @param vector1 vector 1
     * @param vector2 vector 2
     * @ returns the sum of each of the coordinates multiplied by the corresponiding coordinate of vector 2
     */
    public static double dotProduct(Vector vector1, Vector vector2)
    {
        return ((vector1.getEnd().getX() * vector2.getEnd().getX()) + (vector1.getEnd().getY() * vector2.getEnd().getY()) + (vector1.getEnd().getZ() * vector2.getEnd().getZ()));
    }
    
    /**
     * A method that returns a vector that is the crossProduct of 2 vectors
     * @param vector1 vector 1
     * @param vector2 vector 2
     * @return a new vector that is the cross product of vectors 1 and 2
     */
    public static Vector crossProduct(Vector vector1, Vector vector2)
    {
        //stores x coordinate of the end point of the new vector
        double x = (vector1.getEnd().getY() * vector2.getEnd().getZ()) - (vector1.getEnd().getZ() * vector2.getEnd().getY());
        //stores y coordinate of the end point of the new vector
        double y = (vector1.getEnd().getZ() * vector2.getEnd().getX()) - (vector1.getEnd().getX() * vector2.getEnd().getZ());
        //stores z coordinate of the end point of the new vector
        double z = (vector1.getEnd().getX() * vector2.getEnd().getY()) - (vector1.getEnd().getY() * vector2.getEnd().getX());
        return new Vector(x,y,z);
    }
    
    /**
     * A method that returns the angle from the first to the 2nd vector
     * @param vector1 vector 1
     * @param vector2 vector 2
     * @returns the angle from the first to the second vector
     */
    public static double angle(Vector vector1, Vector vector2)
    {
        //stores angle between vector1 and vector2
        double angle = Math.acos(dotProduct(vector1, vector2)/(Math.abs(vector1.magnitude()) * Math.abs(vector2.magnitude())));
        return angle;
    }
    
    /**
     * A method that returns true if the vectors are othogonal
     * @param vector1 vector 1
     * @param vector2 vector 2
     * @return if the dot product of the two vectors is 0
     */
    public static boolean isOrthogonal(Vector vector1, Vector vector2)
    {
        return dotProduct(vector1, vector2) == 0;
    }
    
    /**
     * A method that returns true if the vectors are parallel
     * @param vector1 vector 1 
     * @param vector2 vector 2
     * @return if the cross product of the two vectors is 0
     */
    public static boolean isParallel(Vector vector1, Vector vector2)
    {
        if(crossProduct(vector1, vector2).getEnd().getX() == 0 && crossProduct(vector1, vector2).getEnd().getY() == 0 && crossProduct(vector1, vector2).getEnd().getZ() == 0)
        {
            return true;
        }
        return false;
    }
}
