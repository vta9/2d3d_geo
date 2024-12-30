
/**
 * This class represents a Plane that contains a point and normal vector
 * 
 * @author Vincent Avelallemant
 */
public class Plane
{
   //stores the point of the plane
    private Point point;
   //stores the normal vector of the plane
   private Vector normalVector;
   
   /** 
    * A constructor for Plane
    * @param point the Point this plane contains
    * @param vector the Vector of this plane's normalVector
    */
   public Plane(Point point, Vector vector)
   {
       this.point = point;
       normalVector = vector;
   }
   
   /** 
    * A constructor for Plane
    * @param p1 the first Point
    * @param p2 the second Point
    * @param p3 the third Point
    */
   public Plane(Point p1, Point p2, Point p3)
   {
       Vector v12 = new Vector(p1, p2);
       Vector v23 = new Vector(p2, p3);
       normalVector = Vector.crossProduct(v12,v23);
       point = p1;
   }
   
   /** 
    * A method that returns the normal vector of this Plane
    * @return the normal vector
    */
   public Vector getNormal()
   {
       return normalVector;
   }
   
   /** 
    * A method that returns the Point on this Plane
    * @return the point
    */
   public Point getPoint()
   {
       return point;
   }
   
   /**
    * A method that returns a String represensation of a plane
    * @return the linear equation of the plane in the for ax + by +cz + d = 0
    */
   @Override
   public String toString()
   {
       //stores d in the equation ax + by + cz + d = 0
       double d = -1*((getPoint().getX() * getNormal().getEnd().getX()) + (getPoint().getY() * getNormal().getEnd().getY()) + (getPoint().getZ() * getNormal().getEnd().getZ()));
       return getNormal().getEnd().getX() + "x + " + getNormal().getEnd().getY() + "y + " + getNormal().getEnd().getZ() + "z + " + d + " = 0";
   }
   
   /**
    * A method that returns true if 2 planes are equal
    * @param o the Plane that is being compared to 
    * @return if each plane's normal vectors are equal and the point for one plane contains the point for the other
    */
   @Override
   public boolean equals(Object o)
   {
       //stores o as type Plane
       Plane input = (Plane) o;
       if(Vector.isParallel(input.getNormal(), getNormal()) && contains(input.getPoint()))
       {
           return true;
       }
       return false;
   }
   
   /**
    * A method that returns true if the input point is on this plane
    * @param p the point 
    * @returns if this plane contains p
    */
   public boolean contains(Point p)
   {
       //stores d in the equation ax + by + cz + d = 0
       double d = -1*((getPoint().getX() * getNormal().getEnd().getX()) + (getPoint().getY() * getNormal().getEnd().getY()) + (getPoint().getZ() * getNormal().getEnd().getZ()));
       //stores the result of the equation with Point p
       double result = (getNormal().getEnd().getX() * p.getX()) + (getNormal().getEnd().getY() * p.getY()) + (getNormal().getEnd().getZ() * p.getZ()) + d;
       //result compared with result of equation with point defining the plane
       if(result == (getNormal().getEnd().getX() * getPoint().getX()) + (getNormal().getEnd().getY() * getPoint().getY()) + (getNormal().getEnd().getZ() * getPoint().getZ()) + d)
       {
           return true;
       }
       return false;
   }
   
   /**
    * A method that returns true if 2 planes are parallel
    * @param p1 plane 1
    * @param p2 plane 2
    * @return if the normal vectors of the two planes are parallel
    */
   public static boolean isParallel(Plane p1, Plane p2)
   {
       return Vector.isParallel(p1.getNormal(), p2.getNormal());
   }
   
   /**
    * A method that retunrs true if two planes are othogonal
    * @param p1 plane 1
    * @param p2 plane 2
    * @return if the normal vectors of the two planes are orthogonal
    */
   public static boolean isOrthogonal(Plane p1, Plane p2)
   {
       return Vector.isOrthogonal(p1.getNormal(), p2.getNormal());
   }
}
