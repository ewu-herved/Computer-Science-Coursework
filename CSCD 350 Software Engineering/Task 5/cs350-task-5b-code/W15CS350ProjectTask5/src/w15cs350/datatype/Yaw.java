package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;
import w15cs350.support.Support;

//=============================================================================================================================================================
/**
 * Defines a yaw datatype for rotation about the z axis. It uses navigational degrees with zero at top (north) and increasing values moving clockwise.
 * 
 * @author Dan Tappan [12.01.15]
 */
public class Yaw implements I_XMLable
{
   /** a neutral yaw of zero degrees */
   public static final Yaw NEUTRAL = new Yaw(0);

   /** the minimum angle in degrees, inclusive */
   private static final double ANGLE_MIN = 0;

   /** the maximum angle in degrees, exclusive */
   private static final double ANGLE_MAX = 360;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether an angle is on the interval <tt>[ANGLE_MIN, ANGLE_MAX)</tt>.
    * 
    * @param angle - the angle in degrees
    * 
    * @return the result
    */
   public static boolean isValid(final double angle)
   {
      return ((angle >= ANGLE_MIN) && (angle < ANGLE_MAX));
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Normalizes an angle to the interval <tt>[ANGLE_MIN, ANGLE_MAX)</tt>.
    * 
    * @param angle - the angle in degrees
    * 
    * @return the normalized angle
    */
   public static double normalize(final double angle)
   {
      double angle2 = angle;

      if (angle < ANGLE_MIN)
      {
         angle2 = (ANGLE_MAX - (-angle % ANGLE_MAX));
      }
      else if (angle >= ANGLE_MAX)
      {
         angle2 %= ANGLE_MAX;
      }

      return angle2;
   }

   /** the angle in degrees */
   private final double _angle;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a yaw at zero degrees.
    */
   public Yaw()
   {
      _angle = 0;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a yaw.
    * 
    * @param angle - the angle in degrees
    */
   public Yaw(final double angle)
   {
      _angle = normalize(angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds a yaw to this one and returns a new yaw with the sum.
    * 
    * @param yaw - the yaw to add
    * 
    * @return the new yaw
    */
   public Yaw add(final Yaw yaw)
   {
      Assert.nonnull(yaw);

      double angle = normalize(_angle + yaw._angle);

      return new Yaw(angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the angle in degrees.
    * 
    * @return the angle
    */
   public double getAngleDegrees()
   {
      return _angle;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets the angle in radians.
    * 
    * @return the angle
    */
   public double getAngleRadians()
   {
      return Math.toRadians(_angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Negates the angle by flipping it 180 degrees.
    * 
    * @return the negated yaw
    */
   public Yaw negate()
   {
      double angle = normalize(_angle + 180);

      return new Yaw(angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts a yaw from this one and returns a new yaw with the difference.
    * 
    * @param yaw - the yaw to subtract
    * 
    * @return the new yaw
    */
   public Yaw subtract(final Yaw yaw)
   {
      Assert.nonnull(yaw);

      double angle = normalize(_angle - yaw._angle);

      return new Yaw(angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Yaw{" + Support.format(_angle) + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<yaw angle=\"" + _angle + "\"/>" + NEWLINE);

      return stream;
   }
}
