package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;
import w15cs350.support.Support;

//=============================================================================================================================================================
/**
 * Defines a pitch datatype for rotation about the x axis. It uses navigational degrees with zero at top and increasing values moving clockwise.
 * 
 * @author Dan Tappan [12.01.15]
 */
public class Pitch implements I_XMLable
{
   /** a neutral pitch of zero degrees */
   public static final Pitch NEUTRAL = new Pitch(0);

   /** the minimum angle in degrees, inclusive */
   private static final double ANGLE_MIN = -180;

   /** the maximum angle in degrees, inclusive */
   private static final double ANGLE_MAX = +180;

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Gets whether an angle is on the interval <tt>[ANGLE_MIN, ANGLE_MAX]</tt>.
    * 
    * @param angle - the angle in degrees
    * 
    * @return the result
    */
   public static boolean isValid(final double angle)
   {
      return ((angle >= ANGLE_MIN) && (angle <= ANGLE_MAX));
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Normalizes an angle to the interval <tt>[ANGLE_MIN, ANGLE_MAX]</tt>.
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
    * Creates a pitch at zero degrees.
    */
   public Pitch()
   {
      _angle = 0;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a pitch.
    * 
    * @param angle - the angle in degrees
    */
   public Pitch(final double angle)
   {
      validate(angle);

      _angle = angle;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds a pitch to this one and returns a new pitch with the sum.
    * 
    * @param pitch - the pitch to add
    * 
    * @return the new pitch
    */
   public Pitch add(final Pitch pitch)
   {
      Assert.nonnull(pitch);

      return new Pitch(_angle + pitch._angle);
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
    * Gets the angle in degrees.
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
    * @return the negated pitch
    */
   public Pitch negate()
   {
      double angle = normalize(_angle + 180);

      return new Pitch(angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts a pitch from this one and returns a new pitch with the difference.
    * 
    * @param pitch - the pitch to subtract
    * 
    * @return the new pitch
    */
   public Pitch subtract(final Pitch pitch)
   {
      Assert.nonnull(pitch);

      return new Pitch(_angle - pitch._angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Pitch{" + Support.format(_angle) + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<pitch angle=\"" + _angle + "\"/>" + NEWLINE);

      return stream;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Throws an <tt>IllegalArgumentException</tt> if the angle is not on the interval <tt>[ANGLE_MIN, ANGLE_MAX]</tt>.
    * 
    * @param angle - the angle in degrees
    */
   private void validate(final double angle)
   {
      if (!isValid(angle))
      {
         throw new IllegalArgumentException("invalid pitch: " + angle);
      }
   }
}
