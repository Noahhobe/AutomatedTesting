// sin, cos, toRadians
import static java.lang.Math.*;

// Program
import acm.program.Program;
import acm.program.*;


/**
 * A program that displays a table of a cannon ball's travel from firing until
 * it hits the ground for a specified initial velocity and angle.
 *
 * Noah Hoberg and Joe Munsterteiger based on a template by CSB|SJU Computer Science
 *         faculty members
 */

public class Cannon extends Program
{
  // acceleration due to gravity at sea level on earth
  private static final double GRAVITY = -9.80665;
  //double time, vertVelocity, horizVelocity;

  /**
   * Runs the cannon simulation
   */
  
  
  public static void main (String []args)
  {
    //---
    
    int v0 = Integer.parseInt(args[0]);
    double A = 30.0;//Double.parseDouble(args[1]);
    double timeToGround = 0.0;
    double t  = 0.0;
    double distance = 0.0;
    double height = 0.0;
      
    for (int i=0; i<=20; i++)
    {
    // ez-pz
    timeToGround = timeToHit(v0, A);
    t = i * (timeToGround / 20);
    distance = distanceToHit(v0, A, t);
    height = height(v0, A, t);
    System.out.println(String.format("TIME: %7.3f   HEIGHT: %7.3f   DISTANCE: %7.3f", t, height, distance));
    }
  }


  /**
   * Computes the height of a cannon ball shot from the ground at initial
   * velocity v0, angle A at t seconds after the shot
   *
   * @param v0 the initial velocity in units/second (could be any unit of
   *           length)
   * @param A  the firing angle in degrees
   * @param t  the elapsed time since firing in seconds
   *
   * @return   the computed value of the height
   */
  
  
  
  public static double height(double v0, double A, double t)
  {
    double theHeight;
    //theHeight so the method and object have different names
    
    theHeight = (v0 * sin(toRadians(A)) * t) + ((GRAVITY * (t * t)/2));
    return theHeight; 
  }
  
  
  
  public static double distance(double v0, double A, double t)
  {
    double theDistance;
    //theDistance so the method and object have different names
    
    theDistance = (v0 * cos(toRadians(A)) * t);
    return theDistance; 
  }
  
 
  
  
  public static double timeToHit(double v0, double A)
  {
  double timeToGround = -(2 * (v0*sin(toRadians(A)) / GRAVITY));
  return timeToGround;
  }
    
  
  
  public static double distanceToHit(double v0, double A, double timeToGround)
  {
  double distanceTraveled = (v0 * cos(toRadians(A)) * timeToGround);
  return distanceTraveled;
  }

  //*** Put the remaining three specified functions here using height as a model
  //*** Be sure to include proper Javadoc comments like the one above
}
