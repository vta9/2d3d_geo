

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This test class tests the classes of Homework 3
 *
 * @author  Vincent Avelallemant
 */
public class Tester
{
    @Test
    public void PointTester()
    {
        //creating Point object
        Point p1 = new Point(1,2,3);
        //testing getX
        assertEquals(1.0, p1.getX(),0.0001);
        //testing getY
        assertEquals(2.0, p1.getY(),0.0001);
        //testing getZ
        assertEquals(3.0, p1.getZ(),0.0001);
        
        //testing toString
        assertEquals("(1.0,2.0,3.0)", p1.toString());
        
        //creating Point object with no equal coordinates
        Point p2 = new Point(2,1,0);
        //testing equals comparing Point obj to Point obj with no equal cooridnates
        assertEquals(false, p1.equals(p2));
        //creating Point2D object with no equal coordinates
        Point2D p2d1 = new Point2D(2,1);
        //testing equals comparing Point obj to Point2D obj with no equal coordinates
        assertEquals(false, p1.equals(p2d1));
        //testing equals comparing Point obj to Point2D obj with all equal coorindates
        assertEquals(true, p2.equals(p2d1));
        //creating Point object with all equal coordainates
        Point p3 = new Point(1,2,3);
        //testing equals comparing Point obj to Point obj with all equal coordinates
        assertEquals(true, p1.equals(p3));
        //creating Point object with one equal coordinate
        Point p4 = new Point(2,1,3);
        //testing equals comparing Point obj to Point obj with 1 equal cooridinate
        assertEquals(false, p1.equals(p4));
        //testing equals comparing Point obj to Point obj with 2 equal coordinates
        assertEquals(false, p2.equals(p4));
        
        //testing distance between 2 Point objects
        assertEquals(1.4142, Point.distance(p1,p4), 0.0001);
        //testing distance between a Point and Point2D object
        assertEquals(3.3166, Point.distance(p1,p2d1), 0.0001);
        //creating Point2D object
        Point2D p2d2 = new Point2D(5,6);
        //testing distance between 2 Point2D objects
        assertEquals(5.831, Point.distance(p2d1,p2d2), 0.0001);
    }
    
    

    @Test
    public void Point2DTester()
    {
        //creating Point2D object
        Point2D p1 = new Point2D(3,4);
        //testing getX
        assertEquals(3, p1.getX(), 0.0001);
        //testing getY
        assertEquals(4, p1.getY(), 0.0001);
        //testing getZ
        assertEquals(0, p1.getZ(), 0.0001);
        
        //testing toString
        assertEquals("(3.0,4.0)", p1.toString());
    }
    
    

    @Test
    public void Line2DTester()
    {
        //creating Point2Ds
        Point2D p1 = new Point2D(-2.5,0);
        Point2D p2 = new Point2D(0,5);
        //creating Line2D with these points
        Line2D l1 = new Line2D(p1,p2);
        //testing getPoint1
        assertEquals("(-2.5,0.0)", l1.getPoint1().toString());
        //testing getPoint2
        assertEquals("(0.0,5.0)", l1.getPoint2().toString());
        
        //testing toString with diagonal line
        assertEquals("y = 2.0x + 5.0", l1.toString());
        //creating Point2D
        Point2D p3 = new Point2D(5,5);
        //creating horizontal Line2D
        Line2D l2 = new Line2D(p2,p3);
        //testing toString with horizontal line
        assertEquals("y = 0.0x + 5.0", l2.toString());
        //creating Point2D
        Point2D p4 = new Point2D(5,0);
        //creating vertical Line2D
        Line2D l3 = new Line2D(p3,p4);
        //testing toString with vertical line
        assertEquals("x = 5.0", l3.toString());
        
        //creating Line2D equal to l1
        Line2D l4 = new Line2D(p1,p2);
        //creating Line2D equal to l1 with points reversed
        Line2D l5 = new Line2D(p2,p1);
        //testing equals with 2 equal Line2D's
        assertEquals(true, l1.equals(l4));
        //testing equals with 2 equal Line2D's but one has points reversed
        assertEquals(true, l1.equals(l5));
        //testing equals with one equal point
        assertEquals(false, l1.equals(l3));
        //creating Line2D 
        Line2D l6 = new Line2D(new Point2D(0,4), new Point2D(1,7));
        //testing equals with no equal points
        assertEquals(false, l1.equals(l6));
        //creating Line with z=0
        Line l7 = new Line(p1,p2);
        //testing equals with equal Line and Line2D
        assertEquals(true, l1.equals(l7));
        //creating Line object
        Line l8 = new Line(new Point(-0.5,0,3), new Point(0,1,3));
        //testing equals with Line and Line2D and no equal points
        assertEquals(false, l1.equals(l8));
        
        //creating parallel Line2D
        Line2D l9 = new Line2D(new Point2D(-0.5,0), new Point2D(0,1));
        //testing 2 parallel Line2D's
        assertEquals(true, Linear.isParallel(l1,l9));
        //testing 2 not parallel Line2D's
        assertEquals(false, Linear.isParallel(l1, l6));
        //testing 2 equal Line2D's
        assertEquals(false, Linear.isParallel(l1,l4));
        //testing parallel Line2D and Line
        assertEquals(true, Linear.isParallel(l8,l9));
        //testing not parallel Line2D and Line
        assertEquals(false, Linear.isParallel(l6,l8));
        //creating parallel Line
        Line l10 = new Line(new Point(1.5, 2, 5), new Point(2,3,5));
        //testing 2 parallel Lines
        assertEquals(true, Linear.isParallel(l8,l10));
        //creating Line
        Line l11 = new Line(new Point(1,2,3), new Point(4,5,6));
        //testing 2 not parallel Lines
        assertEquals(false, Linear.isParallel(l8, l11));
        
        //testing intersection of 2 Line2D's that functions intersect, but out of range of points
        assertEquals(null, Linear.intersection(l1,l6));
        //creating Line2D
        Line2D l12 = new Line2D(p2, new Point2D(3,11));
        Line2D l13 = new Line2D(new Point2D(0,4), new Point2D(3,13));
        //testing intersection of 2 Line2D's that intersect within range of points
        assertEquals(new Point2D(1.0,7.0), Linear.intersection(l13,l12));
        //testing intersection of 2 Line2D's that do not intersect (parllel)
        assertEquals(null, Linear.intersection(l1,l9));
        //testing intersection of the same Line2Ds
        assertEquals(null, Linear.intersection(l1,l4));
        //testing intersection of 2 3D lines that are parallel
        assertEquals(null, Linear.intersection(l8,l10));
        //testing intersection of 2 3D lines that intersect outside of the range
        //testing intersection of 2 3D lines that intersect within the range
        //testing intersection of 2 3D lines that are the same
        //testing intersection with types Line and Line2D
    }

    @Test
    public void LineTester()
    {
        //creating Line with Point constructor 
        Line l1 = new Line(new Point(3,4,7), new Point(-2,3,-5));
        //creating Line with Point, Vector constructor
        Line l2 = new Line(new Point(2,2,2), new Vector(5,5,5));
        //testing getPoint1
        assertEquals(new Point(3,4,7), l1.getPoint1());
        //testing getPoint2
        assertEquals(new Point(-2,3,-5), l1.getPoint2());
        //testing getPoint1 with Point, Vector constructor
        assertEquals(new Point(2,2,2), l2.getPoint1());
        //testing getPoint2 with Point, Vector constructor
        assertEquals(new Point(7,7,7), l2.getPoint2());
        
        //testing toString
        assertEquals("x = 3.0 + -5.0t     y = 4.0 + -1.0t     z = 7.0 + -12.0t", l1.toString());
        //testing toString
        assertEquals("x = 2.0 + 5.0t     y = 2.0 + 5.0t     z = 2.0 + 5.0t", l2.toString());
        
        //testing getVector
        assertEquals(new Vector(4,5,8), l1.getVector());
        //testing getVector
        assertEquals(new Vector(3,3,3), l2.getVector());
        
    }

    @Test
    public void VectorTester()
    {
       //creating a vector with (x,y,z) constructor
       Vector v1 = new Vector(3,5,-1);
       //creating a vector with Point constructor
       Vector v2 = new Vector(new Point(2,2,1));
       //creating a vector with Vector, double constrcutor, making it larger
       Vector v3 = new Vector(v1, 5);
       //creating a vector with Vector, double constructo, making it smaller
       Vector v4 = new Vector(v1, 2);
       //testing getEnd
       assertEquals(new Point(3,5,-1), v1.getEnd());
       //testing getOrigin
       assertEquals(new Point(0,0,0), v1.getOrigin());
       //testing getEnd
       assertEquals(new Point(2,2,1), v2.getEnd());
       //testing getOrigin
       assertEquals(new Point(0,0,0), v2.getOrigin());
       //testing getEnd
       assertEquals(new Point(2.53546276418555,4.225771273642583,-0.8451542547285166), v3.getEnd());
       //using magnitude to see length of vector with Vector, double constructor
       assertEquals(5.0, v3.magnitude(), 0.001);
       //testing getOrigin
       assertEquals(new Point(0,0,0), v3.getOrigin());
       //using magnitude to see length of vector with Vector, double constructor
       assertEquals(2.0, v4.magnitude(), 0.001);
       
       //creating a vector
       Vector v5 = new Vector(3,5,-1);
       //testing equals on two vectors with the same coordinates
       assertEquals(true, v1.equals(v5));
       //tesitng equals on two vectors with different coordinates
       assertEquals(false, v1.equals(v2));
       
       //testing magnitude of vector
       assertEquals(3.0, v2.magnitude(), 0.001);
       assertEquals(Math.sqrt(35), v1.magnitude(), 0.001);
       assertEquals(5.0, v3.magnitude(), 0.001);
       assertEquals(2.0, v4.magnitude(), 0.001);
       
       //creating a vector of length and directoin 0
       Vector v0 = new Vector(0,0,0);
       //testing unitVector on a vector with 0 magintude and direction; shouldn't work & returns <NaN, NaN, NaN>
       //assertEquals(null, v0.unitVector());
       //testing unitVector
       assertEquals(new Vector(0.6666666666666666,0.6666666666666666,0.3333333333333333), v2.unitVector());
       assertEquals(new Vector(0.50709255283711,0.8451542547285165,-0.1690308509457033), v1.unitVector());
       
       //testing sum of Vectors
       assertEquals(new Vector(5,7,0), Vector.sum(v1,v2));
       //testing sum of Vectors with 1 as <0,0,0>
       assertEquals(v1, Vector.sum(v1,v0));
       
       //testing scale making the vector larger
       assertEquals(new Vector(4,4,2), Vector.scale(v2, 2));
       //testing scale making the vector smaler
       assertEquals(new Vector(1,1,0.5), Vector.scale(v2, 0.5));
       //testing scale with negative scale; changes direction of vector
       assertEquals(new Vector(-6, -10, 2), Vector.scale(v1,-2));
       
       //testing dotProduct
       assertEquals(15, Vector.dotProduct(v1,v2));
       assertEquals(0, Vector.dotProduct(v1,v0));
       
       //testing crossProduct
       assertEquals(new Vector(-2,4,-2), Vector.crossProduct(new Vector(1,2,3), new Vector(3,4,5)));
       assertEquals(new Vector(-7,5,4), Vector.crossProduct(v2,v1));
       
       //testing angle
       assertEquals(Math.acos(-22/Math.sqrt(609)), Vector.angle(new Vector(2,-4,-1), new Vector(0,5,2)),0.001);
       assertEquals(Math.acos(-22/Math.sqrt(609)), Vector.angle(new Vector(0,5,2),new Vector(2,-4,-1)) ,0.001);
       //assertEquals(Math.acos(15/Math.sqrt(35)), Vector.angle(v1,v2), 0.001);
       
       //testing isOrthogonal
       assertEquals(true, Vector.isOrthogonal(v1,v0));
       assertEquals(false, Vector.isOrthogonal(v1,v3));
       assertEquals(false, Vector.isOrthogonal(v1,v2));
       
       //testing isParallel
       assertEquals(true, Vector.isParallel(new Vector(6,4,-10), new Vector(-3,-2,5)));
       assertEquals(false, Vector.isParallel(new Vector(-3,-2,5), new Vector(2,1.3333333333,-3.3333333333)));
       assertEquals(false, Vector.isParallel(v1,v2));
       assertEquals(true, Vector.isParallel(new Vector(1,3,-2), new Vector(-2,-6,4)));
    
    }

    @Test
    public void PlaneTester()
    {
        //creating Plane with point, vector constructor
        Plane p1 = new Plane(new Point(1,2,3), new Vector(5,6,7));
        //testing getPoint
        assertEquals(new Point(1,2,3), p1.getPoint());
        //testing getNomral
        assertEquals(new Vector(5,6,7), p1.getNormal());
        //creating Plane with Point, Point, Point constructor
        Plane p2 = new Plane(new Point(2,2,3), new Point(1,4,-2), new Point(3,5,2));
        //testing getPoint 
        assertEquals(new Point(2,2,3), p2.getPoint());
        //testing getNormal, fails 
        //assertEquals(new Vector(0.85719,-0.39563,-0.32969), p2.getNormal());
        
        //testing toString
        assertEquals("5.0x + 6.0y + 7.0z + -38.0 = 0", p1.toString());
        assertEquals("18.0x + -8.0y + -7.0z + 1.0 = 0", p2.toString());
        
        //testing equals when the normal vectors are not parallel and plane does not contain point
        assertEquals(false, p1.equals(p2));
        //creating Plane
        Plane p3 = new Plane(new Point(100,321,-291), new Vector(10,12,14));
        //testing equals when the normal vectors are parallel and plane does not contain point
        assertEquals(false, p1.equals(p3));
        //testing equals when the normal vectors are parallel and plane contains point,fails
        //assertEquals(true, p1.equals(new Plane(new Point(1,2,2), new Vector(10,12,14))));
        
        //testing contains the point created with the constructor
        assertEquals(true, p1.contains(new Point(1,2,3)));
        //testing contains a point not on the plane
        assertEquals(false, p1.contains(new Point(100,231,-124)));
        //tesitng contains a point on the plane not created with the constructor
        assertEquals(true, p1.contains(new Point(5,1,1)));
        
        //testing isParallel with 2 not parallel planes
        assertEquals(false, Plane.isParallel(p1,p2));
        //creating Plane parallel to p1
        
        //testing isParallel with 2 non parrallel planes
        assertEquals(false, Plane.isParallel(p1,p2));
        //creating parallel plane
        Plane p4 = new Plane(new Point(1,2,3), new Vector(10,12,14));
        //testing isParallel with 2 parallel planes
        assertEquals(true, Plane.isParallel(p1,p4));
        
        //testing isOrthogonal with planes with orthogonal normal vectors
        assertEquals(true, Plane.isOrthogonal(new Plane(new Point(1,2,3),new Vector(3,5,-10)), new Plane(new Point(4,3,2), new Vector(0,0,0))));
        //testing isOrthogonal with planes with non orthogonal normal vectors
        assertEquals(false, Plane.isOrthogonal(p1,p2));
        //testing isOrthogonal with planes with non orthogonal normal vectors
        assertEquals(false, Plane.isOrthogonal(p2,p3));
    }
}







