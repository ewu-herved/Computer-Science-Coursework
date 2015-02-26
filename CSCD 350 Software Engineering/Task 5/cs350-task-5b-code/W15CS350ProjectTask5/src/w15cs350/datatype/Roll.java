package w15cs350.datatype;

import static w15cs350.support.Support.NEWLINE;
import w15cs350.support.Assert;
import w15cs350.support.I_XMLable;
import w15cs350.support.Support;

//=============================================================================================================================================================
/**
 * Defines a roll datatype for rotation about the y axis. It uses navigational degrees with zero at top and increasing values moving clockwise.
 * 
 * @author Dan Tappan [12.01.15]
 */
public class Roll implements I_XMLable
{
   /** a neutral roll of zero degrees */
   public static final Roll NEUTRAL = new Roll(0);

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
    * Creates a roll at zero degrees.
    */
   public Roll()
   {
      _angle = 0;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Creates a roll.
    * 
    * @param angle - the angle in degrees
    */
   public Roll(final double angle)
   {
      validate(angle);

      _angle = angle;
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Adds a roll to this one and returns a new roll with the sum.
    * 
    * @param roll - the roll to add
    * 
    * @return the new roll
    */
   public Roll add(final Roll roll)
   {
      Assert.nonnull(roll);

      return new Roll(_angle + roll._angle);
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
    * @return the negated roll
    */
   public Roll negate()
   {
      double angle = normalize(_angle + 180);

      return new Roll(angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * Subtracts a roll from this one and returns a new roll with the difference.
    * 
    * @param roll - the roll to subtract
    * 
    * @return the new roll
    */
   public Roll subtract(final Roll roll)
   {
      Assert.nonnull(roll);

      return new Roll(_angle - roll._angle);
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public String toString()
   {
      return ("Roll{" + Support.format(_angle) + "}");
   }

   // ---------------------------------------------------------------------------------------------------------------------------------------------------------
   /**
    * {@inheritDoc}
    */
   @Override
   public StringBuilder toXML_()
   {
      StringBuilder stream = new StringBuilder();

      stream.append("<roll angle=\"" + _angle + "\"/>" + NEWLINE);

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
         throw new IllegalArgumentException("invalid roll: " + angle);
      }
   }
}
